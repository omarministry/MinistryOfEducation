package CAMSRegression;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CAMS.LoginPageElements;
import testbase.homepage;
import testbase.testbaseforproject;

public class TC001_verifyLoginCamps extends testbaseforproject {
	
	homepage homepage;
	LoginPageElements lpe;
	
	
	@BeforeClass
	public void setup() {
		init();
	}

	//@SuppressWarnings("unchecked")
	@Test
	public void verifyLoginCamps() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Verify Successful CAMPS Login");
		lpe = new LoginPageElements(driver);
		
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		Thread.sleep(10000);
		String username = config.getProperty("userCAMPSAdmin");
		String password = config.getProperty("pwdCAMPSAdmin");
		System.out.println("User Name from Config file...." + username);
		lpe.campsLogin(username, password);
		Thread.sleep(5000);
		System.out.println("Back into main class...." );
		
		
		//AssertTextPresentmethodWithExtendPassFail(workQueTxt, "Work Queues123");
		
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
