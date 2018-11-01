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


public class CreateSP_YJCS extends testbaseforproject{
	LoginElements login;
	RegisterPersonElements register;
	CreateSP createSP;
	RegisterPerson registerPerson;
	SPElements sp;
	SP_YJCSElements yjce;
		
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void createPlanItem() throws InterruptedException, AWTException {
		
		try {
			
			logger = report.startTest("Create Youth Job Connection Summer service plan");
			
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
			createSP.createNewServicePlan("Youth Job Connection Summer", "EO - Action Center", "3898O - QA_SPC_NewSDS", "Yes");

			//Switch driver to SP_YJCElements
			yjce = new SP_YJCSElements(driver);
			
			//Switch back to main window
			String mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on client summary tab
			yjce.ClientSummaryTab.click();
			System.out.println("Client Summary Tab clicked");
			logger.log(LogStatus.INFO, "Client Summary Tab clicked");
			
			//Click on New client summary
			driver.switchTo().frame(2);
			yjce.NewClientSummary.click();
			
			//Verify that Client Summary tab opened
			Thread.sleep(2000);
			String selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Create Client Summary popup window");
			logger.log(LogStatus.INFO, "Switch to Create Client Summary popup window");
			driver.switchTo().frame(3);
			String selectProductTypeTxt = yjce.ClientSummaryTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(selectProductTypeTxt, "Details");
			System.out.println("Create Client Summary popup window is opened successfully");
			
			//*******Create new Client Summary
			yjce.SchoolFactors.sendKeys("Yes");
			yjce.LabourForce.sendKeys("Employed Full Time");
			yjce.PoorWorkHistory.sendKeys("No");
			yjce.EmploymentExperience.sendKeys("No Work Experience");
			yjce.TimeOutOfSchool.sendKeys("3 to 6 Months");
			yjce.TimeOutOfWork.sendKeys("3 to 6 Months");
			yjce.SourceOfIncome.sendKeys("Employment Insurance");
			yjce.HighestLevelOfEducation.sendKeys("Grade 12 or Equivalent");
			yjce.CountryHighestLevelOfEduCompleted.sendKeys("In Canada");
			yjce.JobSearch.sendKeys("Needs Development");
			yjce.EmploymentSkills.sendKeys("Needs Development");
			yjce.ValidationOfOW.sendKeys("Yes");
			yjce.FamilyHouseHold.sendKeys("Yes");
			yjce.MentalHealth.sendKeys("No");
			yjce.HardshipBased.sendKeys("No");
			yjce.HomelessAndHousing.sendKeys("No");
			yjce.LeavingCare.sendKeys("Yes");
			yjce.DiscriminationBased.sendKeys("Yes");
			yjce.LoneParent.sendKeys("Yes");
			yjce.Reading.sendKeys("Needs Development");
			yjce.Writing.sendKeys("Needs Development");
			yjce.Thinking.sendKeys("Needs Development");
			yjce.OralComunication.sendKeys("Needs Development");
			yjce.DocumentUse.sendKeys("Needs Development");
			yjce.Numeracy.sendKeys("Needs Development");
			yjce.ComputerUse.sendKeys("Needs Development");
			yjce.WorkingWithOthers.sendKeys("Needs Development");
			yjce.ContinuousLearning.sendKeys("Needs Development");
			
			System.out.println("All required fields are entered");
			logger.log(LogStatus.PASS, "All required fields are entered");
			
			yjce.ContinueAndSaveButton.click();
			System.out.println("Client Summary Save button is clicked");
			logger.log(LogStatus.PASS, "Client Summary Save button is clicked");
			
			Thread.sleep(2000);
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on Plan Content tab
			yjce.PlanContentTab.click();
			
			//******Add Client Service Planning plan item
			driver.switchTo().frame(2);
			yjce.ClientSevicePlaningActionButton.click();
			yjce.SubGoalAddPlanItem.click();
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Select plan item
			driver.switchTo().frame(3);
			yjce.AttendJobInterviewCheckbox.click();
			yjce.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			yjce.ContinueAndSaveButton.click();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			
			//******Edit Attend Job Interview plan item
			driver.switchTo().frame(2);
			yjce.ClientSevicePlaningExpand.click();
			System.out.println("Client Service Planning Sub Goal expand is clicked");
			logger.log(LogStatus.PASS, "Client Service Planning Sub Goal expand is clicked");
			
			
			driver.switchTo().frame(0);
			yjce.AttendJobInterviewActionButton.click();
			System.out.println("Attend Job Interview Action button is clicked");
			logger.log(LogStatus.PASS, "Attend Job Interview Action button is clicked");
			
			yjce.EditPlanItemButton.click();
			System.out.println("Attend Job Interview Add Plan item is clicked");
			logger.log(LogStatus.PASS, "Attend Job Interview Add Plan item is clicked");

			Thread.sleep(1000);
			//Get today's date
			String date = setDate(0);
			
			//Verify that modify plan item tab opened
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Modify Plan Item Type Summary popup window");
			
			//Fill out the fields
			driver.switchTo().frame(3);
			yjce.AttendJobInterviewOutcome.sendKeys("Attained");
			yjce.AttendJobInterviewActualStartDate.sendKeys(date);
			yjce.AttendJobInterviewActualEndDate.sendKeys(date);
			yjce.AttendJobInterviewActualCost.sendKeys("10");
			yjce.ContinueAndSaveButton.click();
			System.out.println("Plan item fields filled out");
			logger.log(LogStatus.PASS, "Plan item fields filled out");
			
			
			//*******Edit Career Development plan item
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to main window");
			logger.log(LogStatus.INFO, "Switch to main window");
			
			//Check Status of Client Service Planning
			driver.switchTo().frame(2);
			yjce.ClientSevicePlaningExpand.click();
			Thread.sleep(1000);
			yjce.RefreshButton.click();
			Thread.sleep(1000);
			
			String status = yjce.ClientSevicePlaningStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(status, "Completed");
			if(status.equals("Completed")) {
				System.out.println("Client Service Planning and Coordination is Completed");
			}else {
				System.out.println("The status of Client Service Planning and Coordination is: " + status);
			}
		
			
			//******Add Pre-Employment Services plan item
			yjce.PreEmploymentServicesActionButton.click();
			yjce.SubGoalAddPlanItem.click();
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Select plan item
			driver.switchTo().frame(3);
			yjce.CareerDevelopmentCheckbox.click();
			yjce.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			yjce.ContinueAndSaveButton.click();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");

			//******Edit Career Development plan Item
			driver.switchTo().frame(2);
			yjce.PreEmploymentExpand.click();
			System.out.println("Pre-Employment Sub Goal expand is clicked");
			logger.log(LogStatus.PASS, "Pre-Employment Sub Goal expand is clicked");
			Thread.sleep(1000);
			
			driver.switchTo().frame(0);
			Thread.sleep(1000);
			yjce.CareerDevelopmentActionButton.click();
			System.out.println("Career Development Action button is clicked");
			logger.log(LogStatus.PASS, "Career Development Action button is clicked");
			
			yjce.EditPlanItemButton.click();
			System.out.println("Career Development Add Plan item is clicked");
			logger.log(LogStatus.PASS, "Career Development Add Plan item is clicked");

			Thread.sleep(1000);
			
			//Verify that modify plan item tab opened
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Modify Plan Item Type Summary popup window");
			
			//Fill out the fields
			driver.switchTo().frame(3);
			yjce.CareerDevelopmentOutcome.sendKeys("Attained");
			yjce.CareerDevelopmentActualStartDate.sendKeys(date);
			yjce.CareerDevelopmentActualEndDate.sendKeys(date);
			yjce.CareerDevelopmentActualCost.sendKeys("10");
			yjce.CareerDevelopmentPESHours.sendKeys("60");
			yjce.ContinueAndSaveButton.click();
			System.out.println("Plan item fields filled out");
			logger.log(LogStatus.PASS, "Plan item fields filled out");
			
			//Edit Job Matching plan item
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to main window");
			logger.log(LogStatus.INFO, "Switch to main window");

			//Check Status of Pre-Employment Services
			driver.switchTo().frame(2);
			yjce.PreEmploymentExpand.click();
			Thread.sleep(1000);
			yjce.RefreshButton.click();
			Thread.sleep(1000);
			
			status = yjce.PreEmploymentStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(status, "Completed");
			if(status.equals("Completed")) {
				System.out.println("Pre-Employment Services is Completed");
			}else {
				System.out.println("The status of Pre-Employment Services is: " + status);
			}
			

			//******Add Job Matching, placements and Incentives plan item
			yjce.JobMatchingActionButton.click();
			yjce.SubGoalAddPlanItem.click();
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Select plan item
			driver.switchTo().frame(3);
			yjce.PlacementWithIncentiveCheckbox.click();
			yjce.ContinueAndSaveButton.click();
			Thread.sleep(1000);
			
			//Enter details of plan items

			yjce.StartDate.sendKeys(date);
			yjce.EndDate.sendKeys(date);
			yjce.JobTitle.sendKeys("Test");
			yjce.PlacementCategory.sendKeys("Apprenticeship");
			yjce.HoursPerWeek.sendKeys("37");
			yjce.Wage.clear();
			yjce.Wage.sendKeys("20");
			yjce.WagePer.sendKeys("Hour");
			yjce.NOC.sendKeys("0213");
			yjce.NAICS.sendKeys("443144");
			yjce.EmployerLookupGlass.click();
			
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(4);
			yjce.EmployerTradingName.sendKeys("MENTOR COMPUTERS");
			yjce.SearchButton.click();
			Thread.sleep(2000);
			yjce.SelectButton.click();
			System.out.println("Done employer lookup");
			
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(3);
			yjce.ContinueAndSaveButton.click();
			System.out.println("Plan item added");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//******Edit Placement With Incentive plan item
			driver.switchTo().frame(2);
			yjce.JobMatchingExpand.click();
			System.out.println("Job Matching Sub Goal expand is clicked");
			logger.log(LogStatus.PASS, "Job Matching Sub Goal expand is clicked");
			Thread.sleep(1000);
			
			driver.switchTo().frame(0);
			Thread.sleep(1000);
			yjce.PlacementWithIncentiveActionButton.click();
			System.out.println("Placement with Incentive Action button is clicked");
			logger.log(LogStatus.PASS, "Placement with Incentive Action button is clicked");
			
			yjce.EditPlanItemButton.click();
			System.out.println("Placement with Incentive Add Plan item is clicked");
			logger.log(LogStatus.PASS, "Placement with Incentive Add Plan item is clicked");

			Thread.sleep(1000);
			
			//Verify that modify plan item tab opened
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Modify Plan Item Type Summary popup window");
			
			//Fill out the fields
			driver.switchTo().frame(3);
			yjce.PlacementWithIncentiveOutcome.sendKeys("Attained");
			yjce.PlacementWithIncentiveActualStartDate.sendKeys(date);
			yjce.PlacementWithIncentiveActualEndDate.sendKeys(date);
			yjce.PlacementWithIncentiveActualCost.sendKeys("10");
			yjce.PlacementWithIncentiveEmployerSatisfaction.sendKeys("5");
			yjce.ContinueAndSaveButton.click();
			System.out.println("Plan item fields filled out");
			logger.log(LogStatus.PASS, "Plan item fields filled out");

			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Verify the status of Job Matching, Placements and Incentives
			driver.switchTo().frame(2);
			yjce.JobMatchingExpand.click();
			Thread.sleep(1000);
			yjce.RefreshButton.click();
			Thread.sleep(1000);
			
			status = yjce.JobMatchingStatus.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(status, "Completed");
			if(status.equals("Completed")) {
				System.out.println("Job Matching, Placements and Incentives is Completed");
			}else {
				System.out.println("The status of Job Matching, Placements and Incentives is: " + status);
			}
			

			//******Edit sub goal for Client Service Planning
			yjce.ClientSevicePlaningActionButton.click();
			yjce.EditSubGoalButton.click();
			
			//Verify that modify plan item tab opened
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-Goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-Goal Type Summary popup window");
			
			//Enter outcome
			driver.switchTo().frame(3);
			yjce.SubGoalOutcome.sendKeys("Attained");
			System.out.println("Outcome is set to be Attained");
			logger.log(LogStatus.PASS, "Outcome is set to be Attained");

			//Click Save button
			yjce.ContinueAndSaveButton.click();
			System.out.println("Save button is clicked");
			logger.log(LogStatus.PASS, "Save button is clicked");
			
			Thread.sleep(1000);
			
			//Verify the Outcome status of Client Servie Planning
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			String outcome = yjce.ClientSevicePlaningOutcome.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(outcome, "Attained");
			if(outcome.equals("Attained")) {
				System.out.println("Client Service Planning and Coordination outcome is Attained");
				logger.log(LogStatus.PASS, "Client Service Planning and Coordination outcome is Attained");
			}else {
				System.out.println("Client Service Planning and Coordination outcome is: " + outcome);
			}
			
			
			//*****Edit sub goal for Pre-Employment Services
			yjce.PreEmploymentServicesActionButton.click();
			yjce.EditSubGoalButton.click();
			
			//Verify that modify plan item tab opened
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-Goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-Goal Type Summary popup window");
			
			//Enter outcome
			driver.switchTo().frame(3);
			yjce.SubGoalOutcome.sendKeys("Attained");
			System.out.println("Outcome is set to be Attained");
			logger.log(LogStatus.PASS, "Outcome is set to be Attained");

			//Click Save button
			yjce.ContinueAndSaveButton.click();
			System.out.println("Save button is clicked");
			logger.log(LogStatus.PASS, "Save button is clicked");
			
			Thread.sleep(1000);
			
			//Verify the Outcome status of Client Servie Planning
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			outcome = yjce.PreEmploymentOutcome.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(outcome, "Attained");
			if(outcome.equals("Attained")) {
				System.out.println("Pre-Employment Services outcome is Attained");
				logger.log(LogStatus.PASS, "Pre-Employment Services outcome is Attained");
			}else {
				System.out.println("Pre-Employment Services outcome is: " + outcome);
			}
			
			
			//*****Edit sub goal for Job Matching, Placements and Incentives
			yjce.JobMatchingActionButton.click();
			yjce.EditSubGoalButton.click();
			
			//Verify that modify plan item tab opened
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub-Goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub-Goal Type Summary popup window");
			
			//Enter outcome
			driver.switchTo().frame(3);
			yjce.SubGoalOutcome.sendKeys("Attained");
			System.out.println("Outcome is set to be Attained");
			logger.log(LogStatus.PASS, "Outcome is set to be Attained");

			//Click Save button
			yjce.ContinueAndSaveButton.click();
			System.out.println("Save button is clicked");
			logger.log(LogStatus.PASS, "Save button is clicked");
			
			Thread.sleep(1000);
			//Verify the Outcome status of Client Servie Planning
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			outcome = yjce.JobMatchingOutcome.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(outcome, "Attained");
			if(outcome.equals("Attained")) {
				System.out.println("Job Matching, Placements and Incentives outcome is Attained");
				logger.log(LogStatus.PASS, "Job Matching, Placements and Incentives outcome is Attained");
			}else {
				System.out.println("Job Matching, Placements and Incentives outcome is: " + outcome);
			}
			

			//Submit service plan for approval
			driver.switchTo().window(driver.getWindowHandle());
			yjce.homeTab.click();
			driver.switchTo().frame(2);
			yjce.HomeActionButton.click();
			yjce.SubmitForApproval.click();
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			driver.switchTo().frame(3);
			yjce.ContinueAndSaveButton.click();
			System.out.println("Service plan submitted for approval");
			logger.log(LogStatus.PASS, "Service plan submitted for approval");
			
			//Create plan summary
			createSP.planSummary();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//close service plan
			yjce.homeTab.click();
			driver.switchTo().frame(2);
			yjce.HomeActionButton.click();
			yjce.ClosePlan.click();
			Thread.sleep(2000);
			
			//enter closure details
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			driver.switchTo().frame(3);
			yjce.Reason.sendKeys("Completion");
			yjce.CustomerSatisfaction.sendKeys("3 -  No general opinion");
			yjce.CaseOutcome.sendKeys("Both employed and in education");
			yjce.ClientEmployedQuestion1.sendKeys("5 - Strongly agree");
			yjce.ClientEmployedQuestion2.sendKeys("4 - Somewhat agree");
			yjce.ClientEmployedQuestion3.sendKeys("3 - Neither agree nor disagree");
			yjce.ClientEmployedQuestion4.sendKeys("No Response");
			yjce.ContinueAndSaveButton.click();
			Thread.sleep(500);
			
			//Confirm case closure
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(3);
			yjce.ContinueAndSaveButton.click();
			
			//Verify the status of Service Plan
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(2);
			Thread.sleep(1000);
			status = yjce.ServicePlanStatus.getText().trim();
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
