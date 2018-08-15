package CAMSRegression;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CAMS.LoginPageElements;
import support.DeleteFile;
import support.FindFile;
import support.SelfServeSupport;
import support.SmartRobot;
import support.Xls_Reader;
import testbase.homepage;
import testbase.testbaseforproject;

public class TC001_LoginwithValidCredentials extends testbaseforproject {

	homepage homepage;
	LoginPageElements lpe;
	SmartRobot robot;
	SelfServeSupport sss;
	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Successful Login");
		homepage = new homepage(driver);
		
		lpe = new LoginPageElements(driver);
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		Thread.sleep(10000);
		//homepage.apprLogin("DSAH10047", "Password");
		Thread.sleep(2000);
		String username = config.getProperty("userCAMPSAdmin");
		String password = config.getProperty("pwdCAMPSAdmin");
		lpe.campsLogin(username, password);
		Thread.sleep(10000);
		
		
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
