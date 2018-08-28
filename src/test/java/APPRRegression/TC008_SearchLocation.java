package APPRRegression;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRLocationElements;
import APPR.APPRLoginPageElements;
import testbase.testbaseforproject;

public class TC008_SearchLocation extends testbaseforproject{
	
	APPRLeftNavElements lne;
	APPRLoginPageElements lpe;
	APPRLocationElements ale;
	
	
	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifyLocationSearch() throws InterruptedException, AWTException {
		
		try {
	
			logger = report.startTest("Search for Locations");
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
			lne.APPRLocationLeftNav.click();
			Thread.sleep(1000);
			
			ale = new APPRLocationElements(driver);
			String locationTxt = ale.APPRLocationSearchTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationTxt, "Location Search");
			System.out.println("On Location Search page");
			logger.log(LogStatus.PASS, "Land on Location Search page");
			
			//Search Root Location
			ale.APPRLocationRootName.click();
			ale.APPRLocationSearchButton.click();
			ale.APPRLocationSearchResult.click();
			System.out.println("Search result clicked");
			Thread.sleep(1000);
			
			//Go to Location General Tab
			String generalTxt = ale.APPRLocationGeneralTabTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(generalTxt, "General");
			System.out.println("On Location General page");
			logger.log(LogStatus.PASS, "Land on Location General page");
			
			//Validate the root location name
			String locationName = ale.APPRLocationName.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationName, "Director of Apprenticeship (Service Delivery Branch)");
			String locationStatus = ale.APPRLocationRegionStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationStatus, "Active");
			
			//go to Central region and check status
			ale.APPRLocationCentralLink.click();
			Thread.sleep(1000);
			System.out.println("On Central Region");
			locationName = ale.APPRLocationName.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationName, "Central Regional Director's Office");
			locationStatus = ale.APPRLocationRegionStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationStatus, "Active");
			ale.APPRLocationRootLink.click();
			Thread.sleep(1000);
			
			//go to Eastern region and check status
			ale.APPRLocationEasternLink.click();
			Thread.sleep(1000);
			System.out.println("On Estern Region");
			locationName = ale.APPRLocationName.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationName, "Eastern Regional Director's Office");
			locationStatus = ale.APPRLocationRegionStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationStatus, "Active");
			ale.APPRLocationRootLink.click();
			Thread.sleep(1000);
			
			//go to Northern region and check status
			ale.APPRLocationNorthernLink.click();
			Thread.sleep(1000);
			System.out.println("On Northern Region");
			locationName = ale.APPRLocationName.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationName, "Northern Regional Director's Office");
			locationStatus = ale.APPRLocationRegionStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationStatus, "Active");
			ale.APPRLocationRootLink.click();
			Thread.sleep(1000);
			
			//go to Western region and check status
			ale.APPRLocationWesternLink.click();
			Thread.sleep(1000);
			System.out.println("On Western Region");
			locationName = ale.APPRLocationName.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationName, "Western Regional Director's Office");
			locationStatus = ale.APPRLocationRegionStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(locationStatus, "Active");
			ale.APPRLocationRootLink.click();
			Thread.sleep(1000);
			
			
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
