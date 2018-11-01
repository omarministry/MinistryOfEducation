package CAMS6;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLoginPageElements;
import CURAM7.LoginElements;
import testbase.testbaseforproject;

public class CAMS6_Login extends testbaseforproject{
	
	LoginElements login;

	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifyLogin() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Successful Login");
		
		login = new LoginElements(driver);
		
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		Thread.sleep(2000);
		
		String username = config.getProperty("userCAMPSAdmin");
		String password = config.getProperty("pwdCAMPSAdmin");
		System.out.println("User Name from Config file...." + username);
		login.curam7Login(username, password);
		
		Thread.sleep(2000);
		
		String header = login.Header.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(header, "CASE MANAGEMENT SYSTEM - MINISTRY CASEWORKER APPLICATION");
		
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
