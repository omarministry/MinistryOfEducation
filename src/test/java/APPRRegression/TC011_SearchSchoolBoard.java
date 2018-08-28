package APPRRegression;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import APPR.APPRSchoolBoardElements;
import testbase.testbaseforproject;

public class TC011_SearchSchoolBoard extends testbaseforproject{

	APPRLeftNavElements lne;
	APPRLoginPageElements lpe;
	APPRSchoolBoardElements sbe;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifySearchSchoolBoard(){
		try {
			
			logger = report.startTest("Search for School Board");
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
			lne.APPRSchoolBoardLeftNav.click();
			Thread.sleep(2000);
			
			//On School Board Search page
			sbe = new APPRSchoolBoardElements(driver);
			String schoolBoardSearchTxt = sbe.SchoolBoardSearchTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(schoolBoardSearchTxt, "School Board Search");
			System.out.println("On School Board Search page");
			logger.log(LogStatus.PASS, "Land on School Board search page");
			
			//Search School Board with Active status
			sbe.SchoolBoardStatusActive.click();
			sbe.SchoolBoardSearchButton.click();
			System.out.println("Search button clicked");
			logger.log(LogStatus.PASS, "Search button clicked");
			
			//Click on the first School board
			sbe.SchoolBoardFirstResult.click();
			Thread.sleep(1000);
			System.out.println("First Result clicked");
			logger.log(LogStatus.PASS, "First Result clicked");
			
			//On School Board General page
			String schoolBoardGeneralTxt = sbe.SchoolBoardGeneralTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(schoolBoardGeneralTxt, "School Board General");
			System.out.println("On School Board General page");
			logger.log(LogStatus.PASS, "Land on School Board General page");
			
			
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
