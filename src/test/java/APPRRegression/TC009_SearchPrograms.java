package APPRRegression;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import APPR.APPRProgramsElements;
import testbase.testbaseforproject;

public class TC009_SearchPrograms extends testbaseforproject{

	APPRLeftNavElements lne;
	APPRProgramsElements ape;
	APPRLoginPageElements lpe;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifySearchPrograms(){
		try {
			
			logger = report.startTest("Search for Programs");
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
			lne.APPRProgramsLeftNav.click();
			Thread.sleep(1000);
			
			ape = new APPRProgramsElements(driver);
			String programTxt = ape.APPRProgramsSearchTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(programTxt, "Program Search");
			System.out.println("On Program Search page");
			logger.log(LogStatus.PASS, "Land on Program Search page");
			
			//Search a program
			ape.APPRProgramsTOSS.sendKeys("268R");
			ape.APPRProgramsSearchButton.click();
			
			//Verify the search result
			String result = ape.APPRProgramsSearchFirstResult.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(result, "268R - Railway Car Technician Certification");
			System.out.println("First Result: " + result);
			logger.log(LogStatus.PASS, "First reuslt: " + result);
			
			result = ape.APPRProgramsSearchSecondResult.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(result, "268R - Railway Car Technician Apprenticeship");
			System.out.println("Second Result: " + result);
			logger.log(LogStatus.PASS, "Second reuslt: " + result);
			
			//Go to second result
			ape.APPRProgramsSearchSecondResult.click();
			String programGeneralTxt = ape.APPRProgramsGeneralTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(programGeneralTxt, "Program General");
			System.out.println("On Program Gereral page");
			logger.log(LogStatus.PASS, "On Program Gereral page");
			
			String programStatus = ape.APPRProgramsStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(programStatus, "Active");
			System.out.println("Program is: " + programStatus);
			logger.log(LogStatus.PASS, "Program is: " + programStatus);
			
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
