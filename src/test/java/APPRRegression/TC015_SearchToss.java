package APPRRegression;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import APPR.APPRTOSSElements;
import testbase.testbaseforproject;

public class TC015_SearchToss extends testbaseforproject{

	APPRLeftNavElements lne;
	APPRLoginPageElements lpe;
	APPRTOSSElements te;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifySearchToss(){
		try {
			
			logger = report.startTest("Search for Toss");
			lpe = new APPRLoginPageElements(driver);
			
			//logging into APPR
			String browser = config.getProperty("browser");
			if (browser.equalsIgnoreCase("IE")){
				driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			}
			
			Thread.sleep(5000);
			String username = config.getProperty("userNameAPPR");
			String password = config.getProperty("PasswordAPPR");
			System.out.println("Username from Config file...." + username);
			lpe.apprLogin(username, password);
			Thread.sleep(5000);
			
			//Clicking on the left nav element
			lne = new APPRLeftNavElements(driver);
			lne.APPRTOSSLeftNav.click();
			Thread.sleep(2000);
			
			//On TOSS Search page
			te = new APPRTOSSElements(driver);
			String tossSearchTxt = te.TossSearchTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(tossSearchTxt, "TOSS Search");
			System.out.println("On TOSS Search page");
			logger.log(LogStatus.PASS, "Land on TOSS Search page");
			
			//Search TOSS by code
			te.TossCodeField.sendKeys("268R");
			te.TossSearchButton.click();
			System.out.println("Search Button clicked");
			logger.log(LogStatus.PASS, "Search button clicked");
			
			//Click on the result to go to TOSS page
			te.TossSearchResult.click();
			Thread.sleep(1000);
			String tossGeneralTxt = te.TossGeneralTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(tossGeneralTxt, "TOSS General");
			System.out.println("On TOSS General page");
			logger.log(LogStatus.PASS, "Land on TOSS General page");
			
			//Verify TOSS name and Status
			String tossName = te.TossName.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(tossName, "Railway Car Technician");
			logger.log(LogStatus.PASS, "TOSS name is correct");
			
			String tossStatus = te.TossStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(tossStatus, "Active");
			logger.log(LogStatus.PASS, "TOSS status is: " + tossStatus);
			
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
