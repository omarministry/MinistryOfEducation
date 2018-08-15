package GAGERegression;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GAGE.GAGEEditMailingAddress;
import GAGE.GAGEHomePage;
import GAGE.GAGELoginPage;
import GAGE.GAGESponsorInfoPage;
import testbase.testbaseforproject;

public class TC0008_EditMailingAddress extends testbaseforproject{
	
	GAGELoginPage glp;
	GAGESponsorInfoPage gsi;
	GAGEHomePage ghp;
	GAGEEditMailingAddress gem;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Edit Mailing Address");
		
		glp = new GAGELoginPage(driver);
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		
		glp.gageOneKeyLogin(config.getProperty("userNameGage"), "Poiuyu123!");
		
		glp.handleSecurityAnswer();		
		
		//*** Go to home page
		Thread.sleep(7000);
		ghp = new GAGEHomePage(driver);
		ghp.HomeTopNav.click();
		System.out.println("Home Link clicked");
		
		//*** Navigate to Sponsor Info
		Thread.sleep(2000);
		ghp.SponsorNameTopNav.click();
		Thread.sleep(2000);
		ghp.SponsorInfoInMenu.click();
		
		gsi = new GAGESponsorInfoPage(driver);
		String SponsorTxt = gsi.SponsorInfoHeaderTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(SponsorTxt, "Sponsor information");
		logger.log(LogStatus.PASS, "On Sponsor Information Page");
		
		//*** Edit Mailing Address
		gsi.EditMailingAdressButton.click();
		gem = new GAGEEditMailingAddress(driver);
		String EditMailStep1Txt = gem.EditMailStep1Txt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(EditMailStep1Txt, "Edit mailing address - step 1 of 3");
		String PostalCode = "M1M1M1";
		gem.PostalCode.sendKeys(PostalCode);
		logger.log(LogStatus.PASS, "Postal code entered");
		
		gem.Step1NextButton.click();
		
		Thread.sleep(5000);
		String EditMailStep2Txt = gem.EditMailStep2Txt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(EditMailStep2Txt, "Edit mailing address - step 2 of 3");
		gem.RadioButton.click();
		gem.Step2NextButton.click();
		logger.log(LogStatus.PASS, "Step 2 Next button Clicked");
		
		Thread.sleep(5000);
		String EditMailStep3Txt = gem.EditMailStep3Txt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(EditMailStep3Txt, "Edit mailing address - step 3 of 3");
		gem.StreetNumber.sendKeys("2559");
		gem.SaveButton.click();
		logger.log(LogStatus.PASS, "Step 3 Save button Clicked");
		
		String PostalCodeTxt = gem.PostalCodeTxt.getText().trim();
		if(PostalCodeTxt.contains(PostalCode)) {
			logger.log(LogStatus.PASS, "Postal code is correct");
		}
//		AssertTextPresentmethodWithExtendPassFail(PostalCodeTxt, PostalCode);
		
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
