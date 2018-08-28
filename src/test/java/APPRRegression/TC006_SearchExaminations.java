package APPRRegression;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRExaminationTest;
import APPR.APPRLoginPageElements;

import testbase.testbaseforproject;

public class TC006_SearchExaminations extends testbaseforproject {

	
	APPRLeftNavElements lne;
	APPRExaminationTest et;
	APPRLoginPageElements lpe;
	
	
	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifySearchExaminations() throws InterruptedException, AWTException {
		
		try {
	
			logger = report.startTest("Search for Examination/Test");
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
			lne.APPRExaminationTestLeftNav.click();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Clicked on Examination/Test tab");
			
			et = new APPRExaminationTest(driver);
			
			//Search for an examination
			et.typeExam.click();
			et.statusActive.click();
			et.tossCode.sendKeys("415A");
			et.searchButton.click();
			Thread.sleep(2000);
			
			//Selecting first search result
			et.firstResult.click();
			
			//Checking if the page loaded correctly
			String programAssociations = et.programAssociates.getText();
			AssertTextPresentmethodWithExtendPassFail(programAssociations, "Program Associations");
			
			
			
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