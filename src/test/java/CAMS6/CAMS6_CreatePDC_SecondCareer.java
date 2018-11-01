package CAMS6;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class CAMS6_CreatePDC_SecondCareer extends testbaseforproject{
	
	CAMS6_LoginElements login;
	CAMS6_PDCElements pdc;
	String filePath = System.getProperty("user.dir") + "//TestData";
	ReadWriteDataToExcel data = new ReadWriteDataToExcel();
	CAMS6_CreatePDC createPDC;
	CAMS6_RegisterPerson register;
	CAMS6_RegisterPersonElements rpe;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void createPDC() throws InterruptedException, AWTException {
		
		try {
	
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		
		Thread.sleep(2000);
		
		createSecondCareerPDC();
		
	
		} catch (Exception e) {
			
			
			logger.log(LogStatus.FAIL, " Test is NOT successful due to the following exception " + logger.addScreenCapture(testbaseforproject.screenshot()));
			logger.log(LogStatus.INFO, e);
			
			
		}
		
		}
	
	public void createSecondCareerPDC() throws InterruptedException, IOException {
		try {
			logger = report.startTest("***** Start Second Career PDC *****");
			

			login = new CAMS6_LoginElements(driver);
			
			String username = config.getProperty("userCAMPSAdmin");
			String password = config.getProperty("pwdCAMPSAdmin");
			System.out.println("User Name from Config file...." + username);
			login.curam7Login(username, password);
			
			Thread.sleep(2000);
			
			String header = login.Header.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(header, "CASE MANAGEMENT SYSTEM - MINISTRY CASEWORKER APPLICATION");
			System.out.println("Login Successfully");
			
			register = new CAMS6_RegisterPerson();
			rpe = new CAMS6_RegisterPersonElements(driver);
			
			//Click on Cases and Outcomes tab
			rpe.CasesAndOutComesTab.click();
			System.out.println("Cases and Outcomes tab clicked");
			logger.log(LogStatus.PASS, "Cases and Outcomes tab clicked");
			
			//click on Expand Arrow
			rpe.ExpandArrow.click();
			System.out.println("Expand Arror clicked");
			logger.log(LogStatus.PASS, "Expand Arrow clicked");
			Thread.sleep(1000);
			
			logger = report.startTest("Second Career: Register Person");
			register.registerAPerson(rpe);
			
			createPDC = new CAMS6_CreatePDC();
			pdc = new CAMS6_PDCElements(driver);
			
			//Search Case
			createPDC.globalLoookupByCaseID("EOCaseID");
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Create Second Career PDC");
			
			//Create Apprenticeship
			createPDC.createNewProduct("Second Career", "Cheque");
			
			//Switch back to main window
			String mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			
			//Switch to frame
			driver.switchTo().frame(4);
			String homeTxt = pdc.ProgramHomeTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(homeTxt, "Second Career Program Home:");
			System.out.println("Second Career Program home is opened");
			logger.log(LogStatus.PASS, "Second Career Program home is opened");
			
			//Get Second Career Case Reference
			String secondCareerCaseRef = pdc.PDCCaseReference.getText().trim();
			System.out.println("Second Career case Ref: " + secondCareerCaseRef);
			
			//Write the APPR Case ID into file
			data.writeExcel(filePath, "CaseID_CAMS6.xlsx", "PDC_SecondCareerCaseID", Integer.parseInt(secondCareerCaseRef));
			System.out.println("Second Career Case Reference ID is written to the file");
			
			
			//Go to Evidence Tab
			driver.switchTo().window(driver.getWindowHandle());
			pdc.EvidenceTab.click();
			System.out.println("Evidence tab clicked"); 
			logger.log(LogStatus.PASS, "Evidence tab clicked");
			
			
			//Verify Site Map title
			driver.switchTo().frame(4);
			String siteMapTxt = pdc.SiteMapTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(siteMapTxt, "Site Map");
			System.out.println("Site Map is opened");
			logger.log(LogStatus.PASS, "Site Map is opened");
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Add Employment Insurance");
			//Add New Employment Insurance
			createPDC.addNewEmploymentInsurance();
			
			//Click on Site Map
			createPDC.goToSiteMap();
			
			Thread.sleep(1000);
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Add Training Evidence");
			
			//Click on Training link
			driver.switchTo().frame(4);
			createPDC.addNewTrainingEvidence();
			
			//Click on Site Map
			createPDC.goToSiteMap();
			
			Thread.sleep(1000);
			
			//Switch to Frame 4
			driver.switchTo().frame(4);
			System.out.println("Switch to Frame 4");
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Add 2 benefits");
			
			//Create Lumnp Sum Benefit Type
			Thread.sleep(1000);
			createPDC.createNewBenefit("Lump Sum", "Basic Living Allowance not on Claim", "500", "Second Career");
			System.out.println("Lump Sum benefit is created");
			
			//Switch back to main window
			driver.switchTo().window(driver.getWindowHandle());
			driver.switchTo().frame(4);
			
			//Create Lumnp Sum Benefit Type
			Thread.sleep(1000);
			createPDC.createNewBenefit("Weekly", "Books", "150", "Second Career");
			System.out.println("Weekly benefit is created");
			
			//Go to Site Map
			createPDC.goToSiteMap();
			
			Thread.sleep(1000);
			
			//Switch to Frame 4
			driver.switchTo().frame(4);
			System.out.println("Switch to Frame 4");
			
			Thread.sleep(1000);
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Add Client Contribution Evidence");
			
		    //Create Multi Year Forecasting Evidence
			createPDC.addClientContribution();
			
			//Go to Site Map
			createPDC.goToSiteMap();
			
			Thread.sleep(1000);
			
			//Switch to Frame 4
			driver.switchTo().frame(4);
			System.out.println("Switch to Frame 4");
			
			Thread.sleep(1000);
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Add Multi Year Forcasting Evidence");
			
		    //Create Multi Year Forecasting Evidence
			createPDC.addMultiYearForecasting("Second Career");
			
			//Switch back to Main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Add Supervisor");
			
			//Add a Supervisor
			createPDC.addSupervisor("Second Career");
			
			//Go back to Site Map
			createPDC.goToSiteMap();
			
			//Click on Site Map action menu
			driver.switchTo().frame(4);

			report.endTest(logger);
			logger = report.startTest("Second Career: Submit and approve evidence");
			
			//Apply Evidence
			createPDC.applyEvidence();
			
			//Switch back to Main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			
			//Click on logout
			createPDC.logoutCAMS();
			
			//Re-login
			createPDC.reloginAsManager(login, "SC");
			
			//Search case
			createPDC.globalLoookupByCaseID("PDC_SecondCareerCaseID");
			
			//Approve Evidence
			createPDC.approveEvidence();
			
			//Re-Apply Evidence
			createPDC.reApplyEvidence();
			
			//Switch back to Main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			
			//Click on logout
			createPDC.logoutCAMS();
			
			//Re-login as Caseworker
			createPDC.reloginAsCaseWorker(login);
			
			//Search case
			createPDC.globalLoookupByCaseID("PDC_SecondCareerCaseID");
					
			//Check EFT
			boolean EFT = createPDC.checkEFT(rpe);
			if(EFT) {
				logger = report.startTest("Second Career: Add Bank if it's EFT");
				register.addBankAccount(rpe);
				//change Nominees bank account
				createPDC.changeNominee();
				report.endTest(logger);
			}
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Add Contracts");
			
			//Add Contracts
			createPDC.addContracts();
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Add Monitors");
			
			//Add Monitors
			createPDC.addMonitors();
			
			report.endTest(logger);
			logger = report.startTest("Second Career: Submit for Approval and activate case");
			
			//Submit for approval
			createPDC.submitForApproval();
			
			//Activate the case
			createPDC.activateCase("SecondCareer");
		} catch(Exception e){
			System.out.println("Error occurs");
			System.out.println(e);
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
