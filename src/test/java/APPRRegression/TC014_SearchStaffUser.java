package APPRRegression;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import APPR.APPRStaffUserElements;
import testbase.testbaseforproject;

public class TC014_SearchStaffUser extends testbaseforproject{

	APPRLeftNavElements lne;
	APPRLoginPageElements lpe;
	APPRStaffUserElements sue;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifySearchStaffUser(){
		try {
			
			logger = report.startTest("Search for Staff User");
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
			lne.APPRStaffUserLeftNav.click();
			Thread.sleep(2000);
			
			//On Staff User Search page
			sue = new APPRStaffUserElements(driver);
			String staffUserSearchTxt = sue.StaffUserSearchTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(staffUserSearchTxt, "Staff User Search");
			System.out.println("On Staff User Search page");
			logger.log(LogStatus.PASS, "Land on Staff User Search page");
			
			//Search Staff User by First name and Last name
			sue.StaffUserLastName.sendKeys("Diarios");
			sue.StaffUserFirstName.sendKeys("Leo");
			sue.StaffUserSearchButton.click();
			System.out.println("Search Button clicked");
			logger.log(LogStatus.PASS, "Search button clicked");
			
			//Click on the result to go to Staff User page
			sue.StaffUserResult.click();
			String staffUserGeneralTxt = sue.StaffUserGeneralTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(staffUserGeneralTxt, "Staff User General");
			System.out.println("On Staff User General page");
			logger.log(LogStatus.PASS, "Land on Staff User General page");
			
			//Verify Name, Serial Number and Status
			String staffName = sue.StaffUserName.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(staffName, "Leo Diarios");
			logger.log(LogStatus.PASS, "Name is correct");
			
			String serialNumber = sue.StaffUserSerialNumber.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(serialNumber, "DSAP214576");
			logger.log(LogStatus.PASS, "Serial Number is correct");
			
			String status = sue.StaffUserStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(status, "Active");
			logger.log(LogStatus.PASS, "Status is: " + status);
			
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
