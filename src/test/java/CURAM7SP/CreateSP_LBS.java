package CURAM7SP;

import java.awt.AWTException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CURAM7.LoginElements;
import CURAM7.RegisterPersonElements;
import CURAM7Regression.RegisterPerson;
import testbase.testbaseforproject;


public class CreateSP_LBS extends testbaseforproject{
	LoginElements login;
	RegisterPersonElements register;
	CreateSP createSP;
	RegisterPerson registerPerson;
	SPElements sp;
	SP_LBSElements lbse;
		
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void createPlanItem() throws InterruptedException, AWTException {
		
		try {
			
			logger = report.startTest("Create Literacy and Basic Skills service plan");
			
			//Login as Joan Gardener (IAAP102052)
			login = new LoginElements(driver);
			String browser = config.getProperty("browser");
			if (browser.equalsIgnoreCase("IE")){
				driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			}
			Thread.sleep(2000);
			String username = "IAAP102052";
			String password = "password";
			System.out.println("User Name from Config file...." + username);
			login.curam7Login(username, password);
			Thread.sleep(2000);
			
			//Verify login
			String header = login.Header.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(header, "CASE MANAGEMENT SYSTEM - SERVICE PROVIDER MANAGER APPLICATION");
			System.out.println("Login successful");
			logger.log(LogStatus.PASS, "Login successful");
			
			Thread.sleep(1000);
			
			registerPerson = new RegisterPerson();
			register = new RegisterPersonElements(driver);
			
			//Click on Cases and Outcomes tab
			register.CasesAndOutComesTab.click();
			System.out.println("Cases and Outcomes tab clicked");
			logger.log(LogStatus.PASS, "Cases and Outcomes tab clicked");
			
			//Click on Expand Arrow
			register.ExpandArrow.click();
			System.out.println("Expand Arror clicked");
			logger.log(LogStatus.PASS, "Expand Arrow clicked");
			Thread.sleep(1000);
			
			//Register a person
			registerPerson.registerAPerson(register);
			
			//Create Employment Service
			createSP = new CreateSP();
			createSP.globalLookupByCaseID("EOCaseID");
			createSP.createNewServicePlan("Literacy and Basic Skills", "EO - Action Center", "3898H - TDSB - Scarborough - 1641 PHARMACY AVE", "Yes");

			//Switch driver to SP_YJCElements
			lbse = new SP_LBSElements(driver);
			
			//Switch back to main window
			String mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on client summary tab
			lbse.ClientSummaryTab.click();
			System.out.println("Client Summary Tab clicked");
			logger.log(LogStatus.INFO, "Client Summary Tab clicked");
			
			//Click on New client summary
			driver.switchTo().frame(2);
			lbse.NewClientSummary.click();
			
			//Verify that Client Summary tab opened
			Thread.sleep(2000);
			String selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Create Client Summary popup window");
			logger.log(LogStatus.INFO, "Switch to Create Client Summary popup window");
			driver.switchTo().frame(3);
			Thread.sleep(1000);
			String selectProductTypeTxt = lbse.ClientSummaryTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(selectProductTypeTxt, "Language");
			System.out.println("Create Client Summary popup window is opened successfully");
			
			String date = setDate(0);
			//*******Create new Client Summary
			lbse.LanguageSpokenAtHome.sendKeys("English");
			lbse.ServiceProvisionLanguage.sendKeys("English");
			lbse.LanguageSponkenAtLastWorkplace.sendKeys("English");
			lbse.SourceOfIncome.sendKeys("Employment Insurance");
			lbse.HighestLevelOfEducation.sendKeys("Grade 12 or Equivalent");
			lbse.CountryHighestLevelOfEduCompleted.sendKeys("In Canada");
			lbse.TimeOutOfFormalEducation.sendKeys("Less than 3 Months");
			lbse.HistoryOfInterruptedEducation.sendKeys("Yes");
			lbse.TimeOutOfTraining.sendKeys("Less than 3 Months");
			lbse.LabourForceAttachment.sendKeys("Employed Full Time");
			lbse.RegisteredApprentice.sendKeys("Yes");
			lbse.EmploymentExperience.sendKeys("No Work Experience");
			lbse.TimeOutOfWork.sendKeys("Less than 3 Months");
			lbse.EntryAssessmentTool.sendKeys("CABS");
			lbse.EstimatedLearnerWeeklyTimeCommitment.sendKeys("20");
			lbse.DateOfAssessment.sendKeys(date);
			
			System.out.println("All required fields are entered");
			logger.log(LogStatus.PASS, "All required fields are entered");
			
			lbse.ContinueAndSaveButton.click();
			System.out.println("Client Summary Save button is clicked");
			logger.log(LogStatus.PASS, "Client Summary Save button is clicked");
			
			Thread.sleep(2000);
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on Plan Content tab
			lbse.PlanContentTab.click();
			
			//******Add New Sub-Goal
			driver.switchTo().frame(2);
			lbse.NewSubGoalButton.click();
			Thread.sleep(1000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			driver.switchTo().frame(3);
			lbse.TrainingSupportSelectButton.click();
			Thread.sleep(1000);
			lbse.ContinueAndSaveButton.click();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			
			//******Add Training Supports plan item
			driver.switchTo().frame(2);
			lbse.TrainingSupportsActionButton.click();
			lbse.SubGoalAddPlanItem.click();
			
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Select plan item
			driver.switchTo().frame(3);
			lbse.CustomeBasicPlanItemCheckbox.click();
			lbse.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			
			//Enter Details
			lbse.ExpectedOutcome.sendKeys("Performance Demonstrated");
			lbse.EstimatedCost.sendKeys("500");
			lbse.DeliveryMethod.sendKeys("One on One");
			lbse.ContinueAndSaveButton.click();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			
			//******Edit Training Supports plan item
			driver.switchTo().frame(2);
			lbse.TrainingSupportsExpand.click();
			System.out.println("Training Supports Sub Goal expand is clicked");
			logger.log(LogStatus.PASS, "Training Supports Sub Goal expand is clicked");
			
			
			driver.switchTo().frame(0);
			lbse.CustomBasicPlanItemActionButton.click();
			System.out.println("Custom Basic Plan Item Action button is clicked");
			logger.log(LogStatus.PASS, "Custom Basic Plan Item Action button is clicked");
			
			lbse.EditPlanItemButton.click();
			System.out.println("Custom Basic Plan Item Edit Plan item is clicked");
			logger.log(LogStatus.PASS, "Custom Basic Plan Item AdEditd Plan item is clicked");

			Thread.sleep(1000);
			
			//Verify that modify plan item tab opened
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Modify Plan Item Type Summary popup window");
			
			//Fill out the fields
			driver.switchTo().frame(3);
			lbse.CustomBasicActualStartDate.sendKeys(date);
			lbse.CustomBasicOutcome.sendKeys("Attained");
			lbse.CustomBasicActualEndDate.sendKeys(date);
			lbse.CustomBasicActualCost.sendKeys("500");
			lbse.ContinueAndSaveButton.click();
			System.out.println("Plan item fields filled out");
			logger.log(LogStatus.PASS, "Plan item fields filled out");
			
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Check Status of Training Supports sub-goal
			driver.switchTo().frame(2);
			lbse.RefreshButton.click();
			Thread.sleep(1000);
			
			String status = lbse.TrainingSupportsStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(status, "Completed");
			if(status.equals("Completed")) {
				System.out.println("Training Supports sub-goal status is Completed");
				logger.log(LogStatus.PASS, "Training Supports sub-goal status is Completed");
			}else {
				System.out.println("Training Supports sub-goal status is: " + status);
			}
			

			//******Edit sub goal for Training Supports
			lbse.TrainingSupportsActionButton.click();
			lbse.EditSubGoalButton.click();
			
			//Verify that modify plan item tab opened
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-Goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-Goal Type Summary popup window");
			
			//Enter outcome
			driver.switchTo().frame(3);
			lbse.SubGoalOutcome.sendKeys("Attained");
			System.out.println("Outcome is set to be Attained");
			logger.log(LogStatus.PASS, "Outcome is set to be Attained");

			//Click Save button
			lbse.ContinueAndSaveButton.click();
			System.out.println("Save button is clicked");
			logger.log(LogStatus.PASS, "Save button is clicked");
			
			Thread.sleep(1000);
			
			//Verify the Outcome status of Training Supports
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			String outcome = lbse.TrainingSupportsOutcome.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(outcome, "Attained");
			if(outcome.equals("Attained")) {
				System.out.println("Training Supports outcome is Attained");
				logger.log(LogStatus.PASS, "Training Supports outcome is Attained");
			}else {
				System.out.println("Training Supports outcome is: " + outcome);
			}
			
			

			//Submit service plan for approval
			driver.switchTo().window(driver.getWindowHandle());
			lbse.homeTab.click();
			driver.switchTo().frame(2);
			lbse.HomeActionButton.click();
			lbse.SubmitForApproval.click();
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			driver.switchTo().frame(3);
			lbse.ContinueAndSaveButton.click();
			System.out.println("Service plan submitted for approval");
			logger.log(LogStatus.PASS, "Service plan submitted for approval");
			
			//Create plan summary
			createSP.planSummary();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//close service plan
			lbse.homeTab.click();
			driver.switchTo().frame(2);
			lbse.HomeActionButton.click();
			lbse.ClosePlan.click();
			Thread.sleep(2000);
			
			//enter closure details
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			driver.switchTo().frame(3);
			lbse.Reason.sendKeys("Completion");
			lbse.CustomerSatisfaction.sendKeys("5");
			lbse.CaseOutcome.sendKeys("Both employed and in education");
			lbse.HasTheGoalPathCompleted.sendKeys("Yes");
			lbse.HasLearnerSuccessfulCompleted.sendKeys("Yes");
			lbse.EmploymentSituationImproved.sendKeys("4 - Agree");
			lbse.BetterPrepareToFindEmployment.sendKeys("3 - Neither agree nor disagree");
			lbse.DevelopedIncreasedSkills.sendKeys("5 - Strongly agree");
			lbse.CloseHourPerWeek.clear();
			lbse.CloseHourPerWeek.sendKeys("37");
			lbse.CloseWage.clear();
			lbse.CloseWage.sendKeys("30.00");
			lbse.CloseWagePer.sendKeys("Hour");
			lbse.ContinueAndSaveButton.click();
			Thread.sleep(500);
			
			//Confirm case closure
			lbse.ContinueAndSaveButton.click();
			
			//Verify the status of Service Plan
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			Thread.sleep(1000);
			status = lbse.ServicePlanStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(status, "Closed");
			if(status.equals("Closed")) {
				System.out.println("Service Plan closed");
				logger.log(LogStatus.PASS, "Service Plan closed");
			}else {
				System.out.println("Service Plan status is: " + status);
			}

			
			
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
