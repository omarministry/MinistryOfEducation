package CAMS6;

import java.awt.AWTException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CURAM7.LoginElements;
import CURAM7.PDCElements;
import CURAM7.RegisterPersonElements;
import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class CAMS6_CreatePDC_Feepayer extends testbaseforproject{
	
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
	
		logger = report.startTest("Create Feepayer PDC");
		
		//Login
		login = new CAMS6_LoginElements(driver);
		
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		

		Thread.sleep(2000);
		
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
		
		
		report.endTest(logger);
		logger = report.startTest("Feepayer: Register Person");
		register.registerAPerson(rpe);

		
		createPDC = new CAMS6_CreatePDC();
		pdc = new CAMS6_PDCElements(driver);
		
		//Search Case
		createPDC.globalLoookupByCaseID("EOCaseID");
		
		report.endTest(logger);
		logger = report.startTest("Feepayer: Create FeePayer PDC");
		//Create Apprenticeship
		createPDC.createNewProduct("Feepayer", "");
		
		//Switch back to main window
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		System.out.println("Switch back to main window");
		
		//Switch to frame
		driver.switchTo().frame(4);
		String homeTxt = pdc.ProgramHomeTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(homeTxt, "Feepayer Program Home:");
		System.out.println("Feepayer Program home is opened");
		logger.log(LogStatus.PASS, "Feepayer Program home is opened");
		
		//Get Feepayer Case Reference
		String FeepayerCaseRef = pdc.PDCCaseReference.getText().trim();
		System.out.println("APPR case Ref: " + FeepayerCaseRef);
		
		//Write the Feepayer Case ID into file
		data.writeExcel(filePath, "CaseID_CAMS6.xlsx", "PDC_FeepayerCaseID", Integer.parseInt(FeepayerCaseRef));
		System.out.println("Feepayer Case Reference ID is written to the file");
		
		
		//Go to Evidence Tab
		driver.switchTo().window(driver.getWindowHandle());
		pdc.EvidenceTab.click();
		System.out.println("Evidence tab clicked"); 
		logger.log(LogStatus.PASS, "Evidence tab clicked");
		
		
		//Verify Site Map title
		driver.switchTo().frame(4);
		String siteMapTxt = pdc.SiteMapTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(siteMapTxt, "Site Map:");
		System.out.println("Site Map is opened");
		logger.log(LogStatus.PASS, "Site Map is opened");
		
		report.endTest(logger);
		logger = report.startTest("Feepayer: Add Employer Insurance Evidence");
		//Add New Employment Insurance
		createPDC.addNewEmploymentInsurance();
		
		//Click on Site Map
		createPDC.goToSiteMap();
		
		Thread.sleep(1000);
		
		report.endTest(logger);
		logger = report.startTest("Feepayer: Add Training Evidence");
		//Click on Training link
		driver.switchTo().frame(4);
		createPDC.addNewTrainingEvidence();	
		
		//Switch back to Main window
		mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		
		report.endTest(logger);
		logger = report.startTest("Feepayer: Add Supervisor");
		//Add a Supervisor
		createPDC.addSupervisor("Feepayer");
		
		//Go back to Site Map
		createPDC.goToSiteMap();
		
		//Click on Site Map action menu
		driver.switchTo().frame(4);

		report.endTest(logger);
		logger = report.startTest("Feepayer: Submit and approve evidence");
		//Apply Evidence
		createPDC.applyEvidence();
		
		//Switch back to Main window
		mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		
		//Click on logout
		createPDC.logoutCAMS();
		
		Thread.sleep(1000);
		//Re-login
		createPDC.reloginAsManager(login, "Feepayer");
		
		Thread.sleep(1000);
		//Search case
		createPDC.globalLoookupByCaseID("PDC_FeepayerCaseID");
		
		Thread.sleep(1000);
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
		createPDC.globalLoookupByCaseID("PDC_FeepayerCaseID");
		
		report.endTest(logger);
		logger = report.startTest("Feepayer: Add Contract");
		//Add Contracts
		createPDC.addContracts();
		
		report.endTest(logger);
		logger = report.startTest("Feepayer: Add Monitors");
		//Add Monitors
		createPDC.addMonitors();
		
		report.endTest(logger);
		logger = report.startTest("Feepayer: Submit for approval and activate case");
		//Submit for Approval
		createPDC.submitForApproval();
		
		//Activate the case
		createPDC.activateCase("Feepayer");
	
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
