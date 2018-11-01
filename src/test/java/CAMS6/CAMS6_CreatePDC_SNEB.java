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

public class CAMS6_CreatePDC_SNEB extends testbaseforproject{
	
	CAMS6_LoginElements login;
	CAMS6_PDCElements pdc;
	String filePath = System.getProperty("user.dir") + "//TestData";
	ReadWriteDataToExcel data;
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
	
		logger = report.startTest("Create SNEB PDC");
		
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
		
		register.registerAPerson(rpe);
		
		createPDC = new CAMS6_CreatePDC();
		pdc = new CAMS6_PDCElements(driver);
		data = new ReadWriteDataToExcel();
		
		//Search Case
		createPDC.globalLoookupByCaseID("EOCaseID");
		
		//Create SNEB
		createPDC.createNewProduct("SNEB", "EFT");
		
		//Switch back to main window
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		System.out.println("Switch back to main window");
		
		
		//Switch to frame
		driver.switchTo().frame(4);
		String homeTxt = pdc.APPRProgramHomeTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(homeTxt, "Support to Non-EI Eligible Apprentices Program Home:");
		System.out.println("SNEB Program home is opened");
		logger.log(LogStatus.PASS, "SNEB Program home is opened");
		
		//Get SNEB Case Reference
		String SNEBCaseRef = pdc.PDCCaseReference.getText().trim();
		System.out.println("SNEB case Ref: " + SNEBCaseRef);
		
		//Write the SNEB Case ID into file
		data.writeExcel(filePath, "CaseID_CAMS6.xlsx", "PDC_SNEBCaseID", Integer.parseInt(SNEBCaseRef));
		System.out.println("SNEB Case Reference ID is written to the file");
		
		
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
		
		
		//Create Lumnp Sum Benefit Type
		Thread.sleep(1000);
		createPDC.createNewBenefit("Lump Sum", "Bonus Level 4", "1500", "SNEB");
		
																										
		//Switch back to Main window
		mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		
		//Add a Supervisor
		createPDC.addSupervisor("SNEB");
		
		//Go back to Site Map
		createPDC.goToSiteMap();
		
		//Click on Site Map action menu
		driver.switchTo().frame(4);

		//Apply Evidence
		createPDC.applyEvidence();
		
		//Switch back to Main window
		mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		
		//Click on logout
		createPDC.logoutCAMS();
		
		//Re-login
		createPDC.reloginAsManager(login, "SNEB");
		
		//Search case
		createPDC.globalLoookupByCaseID("PDC_SNEBCaseID");
		
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
		createPDC.globalLoookupByCaseID("PDC_SNEBCaseID");
		
		//Check EFT
		boolean EFT = createPDC.checkEFT(rpe);
		if(EFT) {
			
			register.addBankAccount(rpe);
			
			//change Nominees bank account
			createPDC.changeNominee();
		}
		

		//Activate the case
		createPDC.activateCase("SNEB");
	
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