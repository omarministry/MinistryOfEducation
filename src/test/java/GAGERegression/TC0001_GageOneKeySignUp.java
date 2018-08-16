package GAGERegression;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLoginPageElements;
import GAGE.GAGEOneKeySignUpElements;
import testbase.testbaseforproject;

public class TC0001_GageOneKeySignUp extends testbaseforproject {
	
	GAGEOneKeySignUpElements gokelmts;
	

	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Gage OneKey SignUp");
		
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
		//String OneKeyfullname = "AutomationUser";
		OneKeyfullname = OneKeyfullname.toLowerCase();
		System.out.println("One key User name: " + OneKeyfullname );
		
		
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
		logger.log(LogStatus.PASS, "Entered Security Answer 1");
		
		
		gokelmts.SecurityQ3.sendKeys("What is my child's middle name?");
		logger.log(LogStatus.PASS, "Select Security Question 3");
		gokelmts.SecurityQ3Answer.sendKeys("test3");
		logger.log(LogStatus.PASS, "Entered Security Answer 1");
		
		System.out.println("All Question & Answers Done....");
		
		gokelmts.OneKeySignUpButton.click();
		logger.log(LogStatus.PASS, "Clicked Sign Up Button");
		System.out.println("Sign Up Button clicked....");
		
		String OneKeyUserStr = gokelmts.ConfirmOneKeyUserFinalStep.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(OneKeyUserStr, OneKeyfullname );
		
		gokelmts.ConfirmOneKeySignUp.click();
		logger.log(LogStatus.PASS, "Clicked Confirm Button");
		//Test Commit....
		
		
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
