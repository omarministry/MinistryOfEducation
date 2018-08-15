package GAGERegression;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GAGE.GAGEEditBankInfo;
import GAGE.GAGEHomePage;
import GAGE.GAGELoginPage;
import GAGE.GAGESponsorInfoPage;
import testbase.testbaseforproject;

public class TC0009_EditBankInfo extends testbaseforproject{

	GAGELoginPage glp;
	GAGEHomePage ghp;
	GAGESponsorInfoPage gsi;
	GAGEEditBankInfo gebi;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Edit Bank Info");
		
		glp = new GAGELoginPage(driver);
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		
		glp.gageOneKeyLogin(config.getProperty("userNameGage"), "Poiuyu123!");
		
		glp.handleSecurityAnswer();		
		
		Thread.sleep(2000);
		
		//*** Go to Home page
		ghp = new GAGEHomePage(driver);
		ghp.HomeTopNav.click();
		System.out.println("Home Link clicked");
		Thread.sleep(2000);
		
		//*** Go to Sponsor Info Page
		ghp.SponsorNameTopNav.click();
		Thread.sleep(2000);
		ghp.SponsorInfoInMenu.click();
		Thread.sleep(2000);
		
		gsi = new GAGESponsorInfoPage(driver);
		String SponsorTxt = gsi.SponsorInfoHeaderTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(SponsorTxt, "Sponsor information");
		logger.log(LogStatus.PASS, "On Sponsor Information Page");
		
		//*** Go to Edit Bank Info
		gsi.EditBankInfoButton.click();
		System.out.println("Edit Bank Info Link clicked");
		
		gebi = new GAGEEditBankInfo(driver);
		String EditBankInfoTxt = gebi.EditBankInfoPageHeaderTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(EditBankInfoTxt, "Edit banking information");
		logger.log(LogStatus.PASS, "On Edit Banking Information Page");
		
		gebi.EditBankInfoBranchNumber.sendKeys("01398"); 
		gebi.EditBankInfoInstitutionNumber.sendKeys("003");
		gebi.EditBankInfoSearchBranchButton.click();
		logger.log(LogStatus.PASS, "Search Button clicked");
		Thread.sleep(2000);
		String BankNameTxt = gebi.EditBankInfoBankNameField.getAttribute("value");
		System.out.println(BankNameTxt);
		
		String BankAddressTxt = gebi.EditBankInfoBankAddressField.getAttribute("value");
		System.out.println("Bank Address Text ===>> " + BankAddressTxt);
		
		//String y="$1100";
		String bankAddressSplit []=BankAddressTxt.split("CALGARY");
		System.out.println("Bank Address First Part ===>> " + bankAddressSplit[0]);
		System.out.println("Bank Address First Part ===>> " + bankAddressSplit[1]);
		
		String firstPartOfBankAddressSplit = bankAddressSplit[0].trim();
//		System.out.println(ynew[1]);
//		int v2=Integer.parseInt(ynew[1]);
		
		
		gebi.EditBankInfoAccountNumber.sendKeys("78945612");
		gebi.EditBankInfoConfirmAccountNumber.sendKeys("78945612");
		String accountNumberLast3Digits = "612";
		gebi.EditBankInfoSaveButton.click();
		System.out.println("Save button clicked");
		logger.log(LogStatus.PASS, "Bank info Saved");
		
		//***Back to Sponsor Infor
		String BankInfoTxt = gsi.SponsorBankInfoTxt.getText().trim();
		System.out.println(BankInfoTxt);
		if(BankInfoTxt.contains(BankNameTxt)) {
			logger.log(LogStatus.PASS, "Updated Bank Name verification passed");
		}else {
			logger.log(LogStatus.FAIL, "Bank Name does not match");
		}
		
		if(BankInfoTxt.contains(firstPartOfBankAddressSplit)) {
			logger.log(LogStatus.PASS, "Updated Bank Address verification passed");
		}else {
			logger.log(LogStatus.FAIL, "Bank Address does not match");
		}
		
		String AccountNumberTxt = gsi.SponsorAccountNumberTxt.getText().trim();
		if(AccountNumberTxt.contains(accountNumberLast3Digits)) {
			logger.log(LogStatus.PASS, "Updated Account Number verification passed");
		}else {
			logger.log(LogStatus.FAIL, "Account Number does not match");
		}
		
		
		//Thread.sleep(10000);
		
		
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, " Test is NOT successful due to the following exception " + logger.addScreenCapture(testbaseforproject.screenshot()));
			logger.log(LogStatus.INFO, e);
		}
		
		}
	
	@AfterClass
	public void endTest() {
		report.endTest(logger);
		report.flush();
		driver.quit();
	}
}
