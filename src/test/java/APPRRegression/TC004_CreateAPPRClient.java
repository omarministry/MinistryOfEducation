package APPRRegression;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRCreateClientElements;
import APPR.APPRCreateSponsorElements;
import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import testbase.testbaseforproject;

public class TC004_CreateAPPRClient extends testbaseforproject{
	APPRLoginPageElements alpe;
	APPRLeftNavElements alne;
	APPRCreateClientElements acce;
	
	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifyLoginWithValidCredentials() throws Throwable {
		
		try {
	
		logger = report.startTest("Successful Login");
		
		alpe = new APPRLoginPageElements(driver);
		
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
	
		Thread.sleep(2000);
		String username = config.getProperty("userNameAPPR");
		String password = config.getProperty("PasswordAPPR");
		System.out.println("User Name from Config file...." + username);
		alpe.apprLogin(username, password);
		
		//Thread.sleep(10000);
		
		String workQueTxt = alpe.ApprSuccessWorkQuesText.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(workQueTxt, "Work Queues");
		
		//Start the Process of creating Client in APPR
		alne = new APPRLeftNavElements(driver);
		alne.APPRClientEntry.click();
		Thread.sleep(1000);
		//test
		
		//Start entering SIN number
		acce = new APPRCreateClientElements(driver);
		acce.APPRClientSearchSIN1.sendKeys(randomNumber());
		acce.APPRClientSearchSIN2.sendKeys(randomNumber());
		acce.APPRClientSearchSIN3.sendKeys(randomNumber());
		System.out.println("SIN number entered");
		
		}catch (Exception e) {
			
		
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

