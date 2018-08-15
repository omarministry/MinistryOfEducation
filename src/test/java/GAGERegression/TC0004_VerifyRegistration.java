package GAGERegression;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GAGE.GAGEHomePage;
import GAGE.GAGELoginPage;
import GAGE.GAGERegistrationPage;
import testbase.testbaseforproject;

public class TC0004_VerifyRegistration extends testbaseforproject{
	
	GAGELoginPage glp;
	GAGERegistrationPage grp;
	GAGEHomePage ghp;

	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Verify Gage Registration page");
		
		glp = new GAGELoginPage(driver);
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		
		glp.gageOneKeyLogin(config.getProperty("userNameGage"), "Poiuyu123!");
		
		Thread.sleep(7000);
		
		glp.handleSecurityAnswer();		
		
		String BusInfoAfterLoginTxt = glp.BusInfoAfterLoginTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(BusInfoAfterLoginTxt, "Business information" );
		
		grp = new GAGERegistrationPage(driver);
		
		//*** Enter Legal Business Name and Number 
	
		String LBNTxt = grp.RegistrationLegalBusinessName1.getText().trim();

		if(grp.RegistrationLegalBusinessName.isEnabled()){
			grp.RegistrationLegalBusinessName.sendKeys("test automation LBN");
			logger.log(LogStatus.INFO, "Enter LBN: " + "test automation LBN");
		}
		else {
			System.out.println("Read only LBN: " + LBNTxt);
			logger.log(LogStatus.INFO, "Read only LBN: " + LBNTxt);
		}
		
		
		
		grp.RegistrationFederalBusinessNumber.sendKeys("123456789");
		logger.log(LogStatus.INFO, "Enter FBN: " + "123456789");
		
		//*** Enter Bank Information
		grp.RegistrationBranchNumber.sendKeys("00616");
		grp.RegistrationInstitutionNumber.sendKeys("003");
		grp.RegistrationBankSearchButton.click();
		logger.log(LogStatus.PASS, "Bank search complete");
		
		//*** Enter Account Number
		grp.RegistrationAccountNumber.sendKeys("1234567");
		grp.RegistrationConfirmAccountNumber.sendKeys("1234567");
		grp.RegistrationAgreeTerm.click();
		logger.log(LogStatus.PASS, "Agree Term clicked");
		
		grp.RegistrationNextButton.click();
		logger.log(LogStatus.PASS, "Click Next button");
		
		//*** Verify Confirm Page information
		System.out.println("Verify Confirm page");
		String ConfirmPageAfterNextTxt = grp.ConfirmPageTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(ConfirmPageAfterNextTxt, "You are applying for the Graduated Apprenticeship Grant for Employers (GAGE) with the following details.");
		
//		String ConfirmPageLBNTxt = grp.ConfirmPageLBNTxt.getText().trim();
//		AssertTextPresentmethodWithExtendPassFail(ConfirmPageLBNTxt, "test automation LBN");
		
		String ConfirmPageFBNTxt = grp.ConfirmPageFBNTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(ConfirmPageFBNTxt, "123456789");
		
		String ConfirmPageInstitutionTxt = grp.ConfirmPageInstitutionNumberTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(ConfirmPageInstitutionTxt, "003");
		
		String ConfirmPageBranchTxt = grp.ConfirmPageBranchNumberTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(ConfirmPageBranchTxt, "00616");
		
		String ConfirmPageAccountTxt = grp.ConfirmPageAccountNumberTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(ConfirmPageAccountTxt, "1234567");
		
		grp.ConfirmPageSubmitButton.click();
		
		//*** Application Submitted page
		System.out.println("Application Submitted page");
		String SubmittedTxt = grp.SubmittedTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(SubmittedTxt, "You will be notified via email when there is a new message about GAGE payments in your message centre.");
		
		grp.ContinueButton.click();
		logger.log(LogStatus.PASS, "Click Continue button");
		//Thread.sleep(10000);
		
		//***Home Page
		System.out.println("Home page");
		ghp = new GAGEHomePage(driver);
		ghp.HomeTopNav.click();
		String HomeTxt = ghp.HomePageHeaderTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(HomeTxt, "ApprenticeshipON home");
		
		
		
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
