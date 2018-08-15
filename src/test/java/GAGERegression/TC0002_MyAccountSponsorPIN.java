package GAGERegression;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;


import GAGE.GAGEOneKeySignUpElements;
import GAGE.MyAccountSponsorAndPIN;
import testbase.testbaseforproject;

public class TC0002_MyAccountSponsorPIN extends testbaseforproject {
	
	GAGEOneKeySignUpElements gokelmts;
	MyAccountSponsorAndPIN masap;

	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("MyAccount With SponsorID & PIN Mapping");
		
		gokelmts = new GAGEOneKeySignUpElements(driver);
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		gokelmts.SignUpNowLink.click();
		
		Thread.sleep(5000);
		Faker f = new Faker();
		String firstName=f.name().firstName();
		if(firstName.contains("'"))
		{
			
			System.out.println("Text has Single Quote");
			System.out.println("Text with Single Quote:  "+firstName);
			firstName = firstName.replaceAll("'","");
		}
		String lastName=f.name().lastName();
		if(lastName.contains("'"))
		{
			
			System.out.println("Text has Single Quote");
			System.out.println("Text with Single Quote:  "+lastName);
			lastName = lastName.replaceAll("'","");
		}
		String OneKeyfullname = firstName+lastName;
		OneKeyfullname = OneKeyfullname.toLowerCase();
		System.out.println("One key User name: " + OneKeyfullname );
		
		//String ChooseOneKeyUserStr = "GageAutoOneky4";
		gokelmts.ChooseOneKeyID.sendKeys(OneKeyfullname);
		System.out.println("Entered User name....");
		logger.log(LogStatus.PASS, "User Name Entered:  " + OneKeyfullname);
		
		gokelmts.OneKeyPwd.sendKeys("Poiuyu123!");
		logger.log(LogStatus.PASS, "Password Entered");
		gokelmts.ConfirmOneKeyPwd.sendKeys("Poiuyu123!");
		logger.log(LogStatus.PASS, "Confirm Password Entered");
		gokelmts.IAcceptOneKey.click();
		logger.log(LogStatus.PASS, "Accept Terms & Conditions");
		System.out.println("I Accept is done....");
		
		gokelmts.SecurityQ1.sendKeys("What was the first and last name of my first boyfriend/girlfriend?");
		logger.log(LogStatus.PASS, "Select Security Question 1");
		gokelmts.SecurityQ1Answer.sendKeys("test1");
		logger.log(LogStatus.PASS, "Entered Security Answer 1");
		
		gokelmts.SecurityQ2.sendKeys("What was the name of the first school I attended?");
		logger.log(LogStatus.PASS, "Select Security Question 2");
		gokelmts.SecurityQ2Answer.sendKeys("test2");
		logger.log(LogStatus.PASS, "Entered Security Answer 2");
		
		
		gokelmts.SecurityQ3.sendKeys("What is my child's middle name?");
		logger.log(LogStatus.PASS, "Select Security Question 3");
		gokelmts.SecurityQ3Answer.sendKeys("test3");
		logger.log(LogStatus.PASS, "Entered Security Answer 3");
		
		System.out.println("All Question & Answers Done....");
		
		gokelmts.OneKeySignUpButton.click();
		logger.log(LogStatus.PASS, "Clicked Sign Up Button");
		System.out.println("Sign Up Button clicked....");
		
		String OneKeyUserStr = gokelmts.ConfirmOneKeyUserFinalStep.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(OneKeyUserStr, OneKeyfullname );
		
		gokelmts.ConfirmOneKeySignUp.click();
		logger.log(LogStatus.PASS, "Clicked Confirm Button");
		
		System.out.println("End of One Key Signup... ");
		
		//**************My Account Stuff Strarts****************
		
		masap = new MyAccountSponsorAndPIN(driver);
		
		//masap.DevLinkOnServiceListPage.click();
		//logger.log(LogStatus.PASS, "Clicked Dev link on Service Page");
		
		masap.MyAccountFirstName.sendKeys("First Name");
		logger.log(LogStatus.PASS, "First Name entered");
		
		masap.MyAccountLastName.sendKeys("Last Name");
		logger.log(LogStatus.PASS, "Last Name entered");
		
		masap.MyAccountEmail.sendKeys(OneKeyfullname+"@email.com");
		logger.log(LogStatus.PASS, "Email entered -----> " + OneKeyfullname+"@email.com" );
		
		masap.MyAccountQ1.sendKeys("What was your favourite childhood cartoon?");
		masap.MyAccountAnswer1.sendKeys("cartoon");
		
		masap.MyAccountQ2.sendKeys("What is your grandmother's (on your mother's side) maiden name?");
		masap.MyAccountAnswer2.sendKeys("name");
		
		masap.MyAccountQ3.sendKeys("What was the name of the street you lived on as a child?");
		masap.MyAccountAnswer3.sendKeys("child");
		
		masap.MyAccountNextButton.click();
		logger.log(LogStatus.PASS, "My Account Submit button");
		System.out.println("End of My Account... ");
		Thread.sleep(5000);
		
		//************** PIN & ID Mapping ****************
		
		if(config.getProperty("url").contains("apprenticeshiponlineDev"))
		{
			
			masap.SponsorIDMappingPage.sendKeys("1015289");
			System.out.println("DEV Sponsor Entered....");
			logger.log(LogStatus.PASS, "DEV Sponsor ID Entered");
			
			masap.SponsorPINMappingPage.sendKeys("yOWTseAS");
			logger.log(LogStatus.PASS, "Sponsor PIN Entered");
			Thread.sleep(2000);
		}
		else if(config.getProperty("url").contains("apprenticeshiponlineUAT"))
		{
			masap.SponsorIDMappingPage.sendKeys("1045181"); 
			System.out.println("UAT Sponsor Entered....");
			logger.log(LogStatus.PASS, "UAT Sponsor ID Entered");
			
			masap.SponsorPINMappingPage.sendKeys("fmCSHo2N");
			logger.log(LogStatus.PASS, "Sponsor PIN Entered");
			Thread.sleep(2000);
		}
		
		masap.SubmitIDPINMapping.click();
		logger.log(LogStatus.PASS, "Submit Clicked....");
		
		
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
