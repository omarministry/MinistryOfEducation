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


public class CreateSP_SE extends testbaseforproject{
	LoginElements login;
	RegisterPersonElements register;
	CreateSP createSP;
	RegisterPerson registerPerson;
	SPElements sp;
	SP_SEElements se;
		
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void createPlanItem() throws InterruptedException, AWTException {
		
		try {
			
			logger = report.startTest("Create Supported Employment service plan");
			
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
			createSP.createNewServicePlan("Supported Employment", "EO - Action Center", "3898N - Testing site", "No");

			//Switch driver to SP_YJCElements
			se = new SP_SEElements(driver);
			
			//Switch back to main window
			String mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on client summary tab
			se.ClientSummaryTab.click();
			System.out.println("Client Summary Tab clicked");
			logger.log(LogStatus.INFO, "Client Summary Tab clicked");
			
			//Click on New client summary
			driver.switchTo().frame(2);
			se.NewClientSummary.click();
			
			//Verify that Client Summary tab opened
			Thread.sleep(2000);
			String selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Create Client Summary popup window");
			logger.log(LogStatus.INFO, "Switch to Create Client Summary popup window");
			driver.switchTo().frame(3);
			String selectProductTypeTxt = se.ClientSummaryTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(selectProductTypeTxt, "Details");
			System.out.println("Create Client Summary popup window is opened successfully");
			
			String date = setDate(0);
			//*******Create new Client Summary
			se.OneOnOneOnSite.sendKeys("Yes");
			se.LongTermMonitoring.sendKeys("Yes");
			se.WorksiteAccommodation.sendKeys("Yes");
			se.Motivation.sendKeys("Yes");
			se.HighestLevelOfEducation.sendKeys("Grade 12 or Equivalent");
			se.HistoryOfInterruptedEducation.sendKeys("No");
			se.FamilyHouseHoldCircumstance.sendKeys("Yes");
			se.EmploymentExperience.sendKeys("No Work Experience");
			se.TimeOutOfWork.sendKeys("Less than 3 Months");
			se.NoRelavantWorkExperience.sendKeys("Yes");
			se.LabourForceAttachment.sendKeys("Employed Full Time");
			se.Reading.sendKeys("Needs Development");
			se.Writing.sendKeys("Needs Development");
			se.DocumentUse.sendKeys("Needs Development");
			se.Numeracy.sendKeys("Needs Development");
			se.ComputerUse.sendKeys("Needs Development");
			se.Thinking.sendKeys("Needs Development");
			se.OralCommunication.sendKeys("Needs Development");
			se.WorkingWithOthers.sendKeys("Needs Development");
			se.ContinuousLearning.sendKeys("Needs Development");
			
			
			System.out.println("All required fields are entered");
			logger.log(LogStatus.PASS, "All required fields are entered");
			
			se.ContinueAndSaveButton.click();
			System.out.println("Client Summary Save button is clicked");
			logger.log(LogStatus.PASS, "Client Summary Save button is clicked");
			
			Thread.sleep(2000);
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on Plan Content tab
			se.PlanContentTab.click();
			
			String status = "";
			
			//******Add Plan Item for Employabilibty Skills
			driver.switchTo().frame(2);
			se.EmployabilitySkillsActionButton.click();
			se.SubGoalAddPlanItem.click();
			Thread.sleep(1000);
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			driver.switchTo().frame(3);
			se.FundamentalJobReadinessSkillsPlanItemCheckbox.click();
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			se.ContinueAndSaveButton.click();
			System.out.println("Fundamental job readiness skills is selected");
			logger.log(LogStatus.PASS, "Fundamental job readiness skills is selecte");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on Employability Skills expand
			driver.switchTo().frame(2);
			se.EmployabilitySkillsExpand.click();
			
			//*****Modify the plan item
			driver.switchTo().frame(0);
			se.FundamentalJobReadinessSkillsPlanItemActionButton.click();
			se.EditPlanItemButton.click();
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Enter Plan Item details
			driver.switchTo().frame(3);
			se.ActualStartDate.sendKeys(date);
			se.PlanItemOutcome.sendKeys("Attained");
			se.ActualEndDate.sendKeys(date);
			se.ActualCost.sendKeys("100");
			se.ContinueAndSaveButton.click();
			System.out.println("Plan Item Fundamental job readiness skills is Attained");
			logger.log(LogStatus.PASS, "Plan Item Fundamental job readiness skills is Attained");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			driver.switchTo().frame(2);
			se.EmployabilitySkillsExpand.click();
			se.RefreshButton.click();
			Thread.sleep(1000);
			
			//Verify the Sub-goal status is Completed
			status = se.EmployabilitySkillsStatus.getText().trim();
			if(status.equalsIgnoreCase("Completed")) {
				System.out.println("Employability Skills Sub-goal is completed");
				logger.log(LogStatus.PASS, "Employability Skills Sub-goal is completed");
			}else {
				System.out.println("Employability Skills Sub-goal is: " + status);
			}
			
			//******Add Plan Item for Job Coaching
			se.JobCoachingActionButton.click();
			se.SubGoalAddPlanItem.click();
			Thread.sleep(1000);
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			driver.switchTo().frame(3);
			se.JobCoachingforParticipantsGeneralPlanItemCheckbox.click();
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			se.ContinueAndSaveButton.click();
			System.out.println("Job Coaching for Participants - General is selected");
			logger.log(LogStatus.PASS, "Job Coaching for Participants - General is selecte");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on Employability Skills expand
			driver.switchTo().frame(2);
			se.JobCoachingExpand.click();
			
			//*****Modify the plan item
			driver.switchTo().frame(0);
			se.JobCoachingforParticipantsGeneralPlanItemActionButton.click();
			se.EditPlanItemButton.click();
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Enter Plan Item details
			driver.switchTo().frame(3);
			se.ActualStartDate.sendKeys(date);
			se.PlanItemOutcome.sendKeys("Attained");
			se.ActualEndDate.sendKeys(date);
			se.ActualCost.sendKeys("100");
			se.ContinueAndSaveButton.click();
			System.out.println("Plan Item Job Coaching is Attained");
			logger.log(LogStatus.PASS, "Plan Item Job Coaching is Attained");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			driver.switchTo().frame(2);
			se.EmployabilitySkillsExpand.click();
			se.RefreshButton.click();
			Thread.sleep(1000);
			
			
			//Verify the Sub-goal status is Completed
			status = se.JobCoachingStatus.getText().trim();
			if(status.equalsIgnoreCase("Completed")) {
				System.out.println("Job Coaching Sub-goal is completed");
				logger.log(LogStatus.PASS, "Job Coaching Sub-goal is completed");
			}else {
				System.out.println("Job Coaching Sub-goal is: " + status);
			}
			
			//******Add Plan Item for Job Search
			se.JobSearchActionButton.click();
			se.SubGoalAddPlanItem.click();
			Thread.sleep(1000);
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			driver.switchTo().frame(3);
			se.JobTrialsPlanItemCheckbox.click();
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			se.ContinueAndSaveButton.click();
			System.out.println("Job Trials is selected");
			logger.log(LogStatus.PASS, "Job Trials is selecte");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on Job Search expand
			driver.switchTo().frame(2);
			se.JobSearchExpand.click();
			
			//*****Modify the plan item
			driver.switchTo().frame(0);
			se.JobTrialsPlanItemActionButton.click();
			se.EditPlanItemButton.click();
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Enter Plan Item details
			driver.switchTo().frame(3);
			se.ActualStartDate.sendKeys(date);
			se.PlanItemOutcome.sendKeys("Attained");
			se.ActualEndDate.sendKeys(date);
			se.ActualCost.sendKeys("100");
			se.ContinueAndSaveButton.click();
			System.out.println("Plan Item Job Trials is Attained");
			logger.log(LogStatus.PASS, "Plan Item Job Trials is Attained");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			driver.switchTo().frame(2);
			se.JobSearchExpand.click();
			se.RefreshButton.click();
			Thread.sleep(1000);
			
			//Verify the Sub-goal status is Completed
			status = se.JobSearchStatus.getText().trim();
			if(status.equalsIgnoreCase("Completed")) {
				System.out.println("Job Search Sub-goal is completed");
				logger.log(LogStatus.PASS, "Job Search Sub-goal is completed");
			}else {
				System.out.println("Job Search Sub-goal is: " + status);
			}
			
			
			//******Add Plan Item for Job Retention
			se.JobRetentionActionButton.click();
			se.SubGoalAddPlanItem.click();
			Thread.sleep(1000);
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			driver.switchTo().frame(3);
			se.DevelopSupportPlanItemCheckbox.click();
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			se.ContinueAndSaveButton.click();
			System.out.println("Develop Support Plan is selected");
			logger.log(LogStatus.PASS, "Develop Support Plan is selecte");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on Job Search expand
			driver.switchTo().frame(2);
			se.JobRetentionExpand.click();
			
			//*****Modify the plan item
			driver.switchTo().frame(0);
			se.DevelopSupportPlanItemActionButton.click();
			se.EditPlanItemButton.click();
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Enter Plan Item details
			driver.switchTo().frame(3);
			se.ActualStartDate.sendKeys(date);
			se.PlanItemOutcome.sendKeys("Attained");
			se.ActualEndDate.sendKeys(date);
			se.ActualCost.sendKeys("100");
			se.ContinueAndSaveButton.click();
			System.out.println("Plan Item Develop Support Plan is Attained");
			logger.log(LogStatus.PASS, "Plan Item Develop Support Plan is Attained");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			driver.switchTo().frame(2);
			se.JobRetentionExpand.click();
			se.RefreshButton.click();
			Thread.sleep(1000);
			
			//Verify the Sub-goal status is Completed
			status = se.JobRetentionStatus.getText().trim();
			if(status.equalsIgnoreCase("Completed")) {
				System.out.println("Job Retention Sub-goal is completed");
				logger.log(LogStatus.PASS, "Job Retention Sub-goal is completed");
			}else {
				System.out.println("Job Retention Sub-goal is: " + status);
			}
			
			
			//******Add Plan Item for Job Matching and Development
			se.JobMatchingAndDevelopmentActionButton.click();
			se.SubGoalAddPlanItem.click();
			Thread.sleep(1000);
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			driver.switchTo().frame(3);
			se.IncomeSupportPlanItemCheckbox.click();
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			se.ContinueAndSaveButton.click();
			System.out.println("Income Support is selected");
			logger.log(LogStatus.PASS, "Income Support is selected");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on Job Search expand
			driver.switchTo().frame(2);
			se.JobMatchingAndDevelopmenExpand.click();
			
			Thread.sleep(1000);
			//*****Modify the plan item
			driver.switchTo().frame(0);
			se.IncomeSupportPlanItemActionButton.click();
			se.EditPlanItemButton.click();
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Enter Plan Item details
			driver.switchTo().frame(3);
			se.ActualStartDate.sendKeys(date);
			se.PlanItemOutcome.sendKeys("Attained");
			se.ActualEndDate.sendKeys(date);
			se.ActualCost.sendKeys("100");
			se.ContinueAndSaveButton.click();
			System.out.println("Plan Item Income Support is Attained");
			logger.log(LogStatus.PASS, "Plan Item Income Support is Attained");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			driver.switchTo().frame(2);
			se.JobMatchingAndDevelopmenExpand.click();
			se.RefreshButton.click();
			Thread.sleep(1000);
			
			//Verify the Sub-goal status is Completed
			status = se.JobMatchingAndDevelopmentStatus.getText().trim();
			if(status.equalsIgnoreCase("Completed")) {
				System.out.println("Job Matching and Development Sub-goal is completed");
				logger.log(LogStatus.PASS, "Job Matching and Development Sub-goal is completed");
			}else {
				System.out.println("Job Matching and Development Sub-goal is: " + status);
			}
			
			//******Add Plan Item for Client Service Planning and Coordination
			se.ClientServicePlanningActionButton.click();
			se.SubGoalAddPlanItem.click();
			Thread.sleep(1000);
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			driver.switchTo().frame(3);
			se.ServiceNeedsPlanItemCheckbox.click();
			Thread.sleep(1000);
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			se.ContinueAndSaveButton.click();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
				
			//******Modify Service Needs plan item
			driver.switchTo().frame(2);
			se.ClientServicePlanningExpand.click();
			Thread.sleep(2000);
			
			driver.switchTo().frame(0);
			se.ServiceNeedsPlanItemActionButton.click();
			se.EditPlanItemButton.click();
			
			//Verify that Select plan item tab opened
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Enter Plan Item details
			driver.switchTo().frame(3);
			se.ActualStartDate.sendKeys(date);
			se.PlanItemOutcome.sendKeys("Attained");
			se.ActualEndDate.sendKeys(date);
			se.ActualCost.sendKeys("100");
			se.ContinueAndSaveButton.click();
			System.out.println("Plan Item Arrange For Personal Supports is Attained");
			logger.log(LogStatus.PASS, "Plan Item Arrange For Personal Supports is Attained");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			driver.switchTo().frame(2);
			se.ClientServicePlanningExpand.click();
			se.RefreshButton.click();
			Thread.sleep(1000);
			
			//Verify the Sub-goal status is Completed
			status = se.ClientServicePlanningStatus.getText().trim();
			if(status.equalsIgnoreCase("Completed")) {
				System.out.println("Client Service Planning and Coordination Sub-goal is completed");
				logger.log(LogStatus.PASS, "Client Service Planning and Coordination Sub-goal is completed");
			}else {
				System.out.println("Client Service Planning and Coordination Sub-goal is: " + status);
			}
			
			//******Edit Sub-goal
			//Client Service Planning and Coordination
			se.ClientServicePlanningActionButton.click();
			se.EditSubGoalButton.click();
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-goal popup window");
			
			driver.switchTo().frame(3);
			se.SubGoalOutcome.sendKeys("Attained");
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			status = se.ClientServicePlanningOutcome.getText().trim();
			if(status.equalsIgnoreCase("Attained")) {
				System.out.println("Client Service Planning and Coordination outcome is attained");
				logger.log(LogStatus.PASS, "Client Service Planning and Coordination outcome is attained");
			}else {
				System.out.println("Client Service Planning and Coordination outcome is " + status);
				logger.log(LogStatus.PASS, "Client Service Planning and Coordination outcome is " + status);
			}
			
			//Employability Skills
			se.EmployabilitySkillsActionButton.click();
			se.EditSubGoalButton.click();
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-goal popup window");
			
			driver.switchTo().frame(3);
			se.SubGoalOutcome.sendKeys("Attained");
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			status = se.EmployabilitySkillsOutcome.getText().trim();
			if(status.equalsIgnoreCase("Attained")) {
				System.out.println("Employability Skills outcome is attained");
				logger.log(LogStatus.PASS, "Employability Skills outcome is attained");
			}else {
				System.out.println("Employability Skills outcome is " + status);
				logger.log(LogStatus.PASS, "Employability Skills outcome is " + status);
			}
			
			//Job Matching and Development
			se.JobMatchingAndDevelopmentActionButton.click();
			se.EditSubGoalButton.click();
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-goal popup window");
			
			driver.switchTo().frame(3);
			se.SubGoalOutcome.sendKeys("Attained");
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			status = se.JobMatchingAndDevelopmentOutcome.getText().trim();
			if(status.equalsIgnoreCase("Attained")) {
				System.out.println("Job Matching and Development outcome is attained");
				logger.log(LogStatus.PASS, "Job Matching and Development outcome is attained");
			}else {
				System.out.println("Job Matching and Development outcome is " + status);
				logger.log(LogStatus.PASS, "Job Matching and Development outcome is " + status);
			}
			
			//Job Coaching
			se.JobCoachingActionButton.click();
			se.EditSubGoalButton.click();
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-goal popup window");
			
			driver.switchTo().frame(3);
			se.SubGoalOutcome.sendKeys("Attained");
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			status = se.JobCoachingOutcome.getText().trim();
			if(status.equalsIgnoreCase("Attained")) {
				System.out.println("Job Coaching outcome is attained");
				logger.log(LogStatus.PASS, "Job Coaching outcome is attained");
			}else {
				System.out.println("Job Coaching outcome is " + status);
				logger.log(LogStatus.PASS, "Job Coaching outcome is " + status);
			}
			
			//Job Search
			se.JobSearchActionButton.click();
			se.EditSubGoalButton.click();
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-goal popup window");
			
			driver.switchTo().frame(3);
			se.SubGoalOutcome.sendKeys("Attained");
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			status = se.JobSearchOutcome.getText().trim();
			if(status.equalsIgnoreCase("Attained")) {
				System.out.println("Job Search outcome is attained");
				logger.log(LogStatus.PASS, "Job Search outcome is attained");
			}else {
				System.out.println("Job Search outcome is " + status);
				logger.log(LogStatus.PASS, "Job Search outcome is " + status);
			}
			
			//Job Retention
			se.JobRetentionActionButton.click();
			se.EditSubGoalButton.click();
			
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-goal popup window");
			
			driver.switchTo().frame(3);
			se.SubGoalOutcome.sendKeys("Attained");
			se.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			status = se.JobRetentionOutcome.getText().trim();
			if(status.equalsIgnoreCase("Attained")) {
				System.out.println("Job Retention outcome is attained");
				logger.log(LogStatus.PASS, "Job Retention outcome is attained");
			}else {
				System.out.println("Job Retention outcome is " + status);
				logger.log(LogStatus.PASS, "Job Retention outcome is " + status);
			}
			

			//Submit service plan for approval
			driver.switchTo().window(driver.getWindowHandle());
			se.homeTab.click();
			driver.switchTo().frame(2);
			se.HomeActionButton.click();
			se.SubmitForApproval.click();
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			driver.switchTo().frame(3);
			se.ContinueAndSaveButton.click();
			System.out.println("Service plan submitted for approval");
			logger.log(LogStatus.PASS, "Service plan submitted for approval");
			
			//Create plan summary
			createSP.planSummary();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//close service plan
			se.homeTab.click();
			driver.switchTo().frame(2);
			se.HomeActionButton.click();
			se.ClosePlan.click();
			Thread.sleep(2000);
			
			//enter closure details
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			driver.switchTo().frame(3);
			se.Reason.sendKeys("Completion");
			se.CaseOutcome.sendKeys("Both employed and in education");
			se.IsClientStillEmployed.sendKeys("Yes");
			se.ContinueAndSaveButton.click();
			Thread.sleep(500);
			
			//Confirm case closure
			se.ContinueAndSaveButton.click();
			
			//Verify the status of Service Plan
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			Thread.sleep(1000);
			status = se.ServicePlanStatus.getText().trim();
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
