package APPRRegression;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import APPR.APPRVenderSearch;
import testbase.testbaseforproject;

public class TC016_SearchVender extends testbaseforproject{

	APPRLeftNavElements lne;
	APPRLoginPageElements lpe;
	APPRVenderSearch vse;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifySearchVender(){
		try {
			
			logger = report.startTest("Search for Vender");
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
			lne.APPRVendorTDALeftNav.click();
			Thread.sleep(2000);
			
			//On Vender/TDA Search page
			vse = new APPRVenderSearch(driver);
			String venderSearchTxt = vse.VenderSearchTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(venderSearchTxt, "Vendor/TDA Search");
			System.out.println("On Vender/TDA Search page");
			logger.log(LogStatus.PASS, "Land on Vender/TDA Search page");
			
			//Search TOSS by code
			vse.VenderTossField.sendKeys("268R");
			vse.VenderProgramParticipationStatus.click();
			vse.VenderSearchButton.click();
			System.out.println("Search Button clicked");
			logger.log(LogStatus.PASS, "Search button clicked");
			
			//Click on the result to go to Vender/TDA page
			vse.VenderFirstResult.click();
			Thread.sleep(1000);
			String venderGeneralTxt = vse.TDAGeneralTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(venderGeneralTxt, "TDA General");
			System.out.println("On TDA General page");
			logger.log(LogStatus.PASS, "Land on TDA General page");
			
			//Verify TDA name and status
			String venderName = vse.TDAName.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(venderName, "Canadore College of Applied Arts & Tech.");
			logger.log(LogStatus.PASS, "TDA name is correct");
			
			String venderStatus = vse.TDAStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(venderStatus, "Active");
			logger.log(LogStatus.PASS, "TDa status is: " + venderStatus);
			
			//Go to Program Participation and check status of the Program
			vse.ProgramParticipationTab.click();
			vse.ProgramOption.click();
			String programName = vse.ProgramName.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(programName, "268R - Railway Car Technician Apprenticeship");
			
			String programStatus = vse.ProgramStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(programStatus, "Active");
			logger.log(LogStatus.PASS, programName + " is " + programStatus);
			
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
