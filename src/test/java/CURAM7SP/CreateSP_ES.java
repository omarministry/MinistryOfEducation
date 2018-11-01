package CURAM7SP;

import java.awt.AWTException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CURAM7.LoginElements;
import CURAM7.RegisterPersonElements;
import CURAM7Regression.RegisterPerson;
import testbase.testbaseforproject;


public class CreateSP_ES extends testbaseforproject{
	LoginElements login;
	RegisterPersonElements register;
	CreateSP createSP;
	RegisterPerson registerPerson;
	SPElements sp;
	SP_ESElements ese;
		
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void createPlanItem() throws InterruptedException, AWTException {
		
		try {
			
			logger = report.startTest("Create Employment Services service plan");
			
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
			createSP.createNewServicePlan("Employment Service", "EO - Action Center", "3898A - TDSB - Next Steps (Meadowvale) -  6435 Erin Mills Parkway, C-02 and C-03, Mississauga, ON L5N 4H4", "Yes");

			//Switch driver to SP_ESElements
			ese = new SP_ESElements(driver);
			
			//Switch back to main window
			String mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on client summary tab
			ese.ClientSummaryTab.click();
			System.out.println("Client Summary Tab clicked");
			logger.log(LogStatus.INFO, "Client Summary Tab clicked");
			
			//Click on New client summary
			driver.switchTo().frame(2);
			ese.NewClientSummary.click();
			
			//Verify that Client Summary tab opened
			Thread.sleep(2000);
			String selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Create Client Summary popup window");
			logger.log(LogStatus.INFO, "Switch to Create Client Summary popup window");
			driver.switchTo().frame(3);
			String selectProductTypeTxt = ese.ClientSummaryConfirmLabel.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(selectProductTypeTxt, "Internationally Trained Professional");
			System.out.println("Create Client Summary popup window is opened successfully");
			
			//Create new Client Summary
			ese.InternationallyTrainedProfessional.sendKeys("Yes");
			ese.LabourForce.sendKeys("Employed Full Time");
			ese.CredentialsNotRecognized.sendKeys("Regulated Trade Certificate");
			ese.PoorWorkHistory.sendKeys("Yes");
			ese.JobSearch.sendKeys("Unknown");
			ese.EmploymentSkills.sendKeys("Unknown");
			ese.LanguageSkills.sendKeys("Unknown");
			ese.LabourMarket.sendKeys("Yes");
			ese.EmploymentExp.sendKeys("No Work Experience");
			ese.IncomeSource.sendKeys("Employment Insurance");
			ese.LevelEdu.sendKeys("Grade 12 or Equivalent");
			ese.EduCountry.sendKeys("In Canada");
			ese.TimeOutOfSchoolWork.sendKeys("Less than 3 Months");
			ese.Save.click();		
			Thread.sleep(2000);
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Click on Plan Content tab
			ese.PlanContentTab.click();
			
			//Add plan item
			driver.switchTo().frame(2);
			ese.FirstSubGoalActionButton.click();
			ese.AddPlanItem.click();
			
			//Verify that Select plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Select Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Select Plan Item Type Summary popup window");
			
			//Select plan item
			driver.switchTo().frame(3);
			ese.AttendJobInterview.click();
			ese.Save.click();
			Thread.sleep(1000);
			ese.Save.click();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Get today's date
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDateTime now = LocalDateTime.now();
			String date = format.format(now);
			
			//Edit plan item
			driver.switchTo().frame(2);
			ese.SubgoalExpand.click();		
			driver.switchTo().frame(0);
			ese.PlanItemActionButton.click();
			ese.EditPlanItem.click();
			
			Thread.sleep(2000);
			
			//Verify that modify plan item tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Plan Item Type popup window");
			logger.log(LogStatus.INFO, "Modify Plan Item Type Summary popup window");
			driver.switchTo().frame(3);
			Thread.sleep(1000);
			selectProductTypeTxt = ese.ModifyPlanItemConfirmLabel.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(selectProductTypeTxt, "Actual Start Date");
			System.out.println("Modify Plan Item Type popup window is opened successfully");
			
			//Fill out the fields
			ese.Outcome.sendKeys("Attained");
			ese.StartDate.sendKeys(date);
			ese.EndDate.sendKeys(date);
			ese.Cost.sendKeys("10");
			ese.Save.click();
			System.out.println("Plan item fields filled out");
			logger.log(LogStatus.PASS, "Plan item fields filled out");
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Edit sub goal
			driver.switchTo().frame(2);
			ese.FirstSubGoalActionButton.click();
			ese.EditSubgoal.click();
			
			Thread.sleep(2000);
			
			//Verify that modify sub goal tab opened
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			System.out.println("Switch to Modify Sub Goal popup window");
			logger.log(LogStatus.INFO, "Modify Sub Goal Summary popup window");
			driver.switchTo().frame(3);
			selectProductTypeTxt = ese.ModifySubGoalConfirmLabel.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(selectProductTypeTxt, "Outcome");
			System.out.println("Modify Sub Goal popup window is opened successfully");
			
			//Complete sub-goal
			ese.Outcome.sendKeys("Attained");
			ese.Save.click();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//Submit service plan for approval
			ese.homeTab.click();
			driver.switchTo().frame(2);
			ese.HomeActionButton.click();
			ese.SubmitForApproval.click();
			Thread.sleep(2000);
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			driver.switchTo().frame(3);
			ese.Save.click();
			System.out.println("Service plan submitted for approval");
			logger.log(LogStatus.PASS, "Service plan submitted for approval");
			
			//Create plan summary
			createSP.planSummary();
			
			//Switch back to main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			//close service plan
			ese.homeTab.click();
			driver.switchTo().frame(2);
			ese.HomeActionButton.click();
			ese.ClosePlan.click();
			Thread.sleep(2000);
			
			//enter closure details
			selectProductTypeWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(selectProductTypeWindowHandle);
			driver.switchTo().frame(3);
			ese.Reason.sendKeys("Completion");
			ese.CustomerSatisfaction.sendKeys("5");
			ese.CaseOutcome.sendKeys("Both employed and in education");
			ese.ClientEmployedQuestion.sendKeys("Yes");
			ese.Save.click();
			Thread.sleep(500);
			
			//Confirm case closure
			ese.Save.click();
			System.out.println("Service Plan closed");
			logger.log(LogStatus.PASS, "Service Plan closed");
			
			
		} catch (Exception e) {
			
			logger.log(LogStatus.FAIL, " Test is NOT successful due to the following exception " + logger.addScreenCapture(testbaseforproject.screenshot()));
			logger.log(LogStatus.INFO, e);
			
		}
	}
	
	@AfterClass
	public void endTest() {
		report.endTest(logger);
		report.flush();
//		driver.quit();
	}
	
}
