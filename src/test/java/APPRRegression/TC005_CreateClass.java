package APPRRegression;

import java.awt.AWTException;

//import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRCreateClass;
import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;

import testbase.testbaseforproject;

public class TC005_CreateClass extends testbaseforproject {
	
	APPRCreateClass cc;
	APPRLeftNavElements lne;
	APPRLoginPageElements lpe;
	
	
	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void CreateClass() throws InterruptedException, AWTException {
		
		try {

			logger = report.startTest("Create a class");
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
			
			//clicking on vendor/TDA on left nav bar
			lne = new APPRLeftNavElements(driver);
			lne.APPRVendorTDALeftNav.click();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Clicked on vendor/TDA tab");
			
			cc = new APPRCreateClass(driver);
			
			//Search for class
			cc.TOSScode.sendKeys("415A");
			cc.searchButton.click();
			Thread.sleep(500);
			logger.log(LogStatus.PASS, "Searched for class");
			
			//Select first option
			cc.selectOption1.click();
			Thread.sleep(5000);
			logger.log(LogStatus.PASS, "Selected first option");
			
			//Go to course offering tab
			cc.courseOfferingButton.click();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Clicked on offering tab");
			
			//Select "Add Class" from the second dropdown menu
			cc.selecting415A.click();
			Thread.sleep(2000); //pause for 2 seconds
			cc.selectAddClass.click();
			cc.pressGo.click();
			Thread.sleep(5000);
			logger.log(LogStatus.PASS, "Selected 'Add Class' from second dropdown menu.");
			
			//Fill out forms for class details
			cc.fullTimeClassType.click();
			cc.deliveryModeAlternativeBlock.click();
			cc.campusOption2.click();
			cc.instructionLanguageEnglish.click();
			cc.instructionMediumClassroom.click();
			cc.paymentActualMax.click();
			cc.plannedSeats.sendKeys("15");
			cc.maxSeats.sendKeys("15");
			cc.startDay.sendKeys("06");
			cc.startMonth.sendKeys("05");
			cc.startYear.sendKeys("2018");
			cc.endDay.sendKeys("18");
			cc.endMonth.sendKeys("08");
			cc.endYear.sendKeys("2018");
			cc.hoursInClass.sendKeys("2");
			cc.daysInClass.sendKeys("2");
			cc.calculate.click();
			Thread.sleep(1000);
			cc.selectAllLevelOne.click();
			Thread.sleep(500);
			cc.save.click();
			logger.log(LogStatus.PASS, "Filled out form for a new class");
			
			//Save the class number in a variable
			String classNum = cc.classNumber.getText();
			System.out.println(classNum);
			
			//Go back to Course Offerings page
			cc.tdaCourseOffering.click();
			Thread.sleep(2000);
			
			//Check if the class you created exists on page
			if (driver.getPageSource().contains(classNum)) {
				//Activate class if found
				logger.log(LogStatus.PASS, "Class number found");
				cc.selecting415A.click();
				cc.selectingClassToActivate.click();
				Thread.sleep(2000); //pause to see if the correct class was selected
				cc.activateTheSelectedClass.click();
				cc.pressGo.click();
			}
			else {
				logger.log(LogStatus.FAIL, "Class number not found");
			}
			
			//Save the class details
			cc.finalSave.click();
			
			//Make sure update was applied successfully
			String finalConfirmation = cc.updateAppliedMessage.getText();
			AssertTextPresentmethodWithExtendPassFail(finalConfirmation, "Update Applied");
			
			
			/*if (finalConfirmation.equalsIgnoreCase("Update Applied")) {
				logger.log(LogStatus.PASS,  "Class did not save successfully");
			} 
			else {
				logger.log(LogStatus.FAIL,  "Class did not save successfully");
			}
			*/
					
			
		
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