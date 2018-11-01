package CAMS6;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class CAMS6_CreatePDC_ACB extends testbaseforproject{
	
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
	

		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		
		Thread.sleep(2000);

		createACBPDC();
	
		} catch (Exception e) {
			
			
			logger.log(LogStatus.FAIL, " Test is NOT successful due to the following exception " + logger.addScreenCapture(testbaseforproject.screenshot()));
			logger.log(LogStatus.INFO, e);
			
			
		}
		
		}
public void createACBPDC() throws InterruptedException, IOException {
		
		try {
			logger = report.startTest("***** Start ACB PDC *****");

			
			//Login
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
			
			Thread.sleep(1000);
			//click on Expand Arrow
			rpe.ExpandArrow.click();
			System.out.println("Expand Arror clicked");
			logger.log(LogStatus.PASS, "Expand Arrow clicked");
			Thread.sleep(1000);
			
			report.endTest(logger);
			logger = report.startTest("ACB: Register Person");
			register.registerAPerson(rpe);
			
			createPDC = new CAMS6_CreatePDC();
			pdc = new CAMS6_PDCElements(driver);
			data = new ReadWriteDataToExcel();
			
			//Search Case
			createPDC.globalLoookupByCaseID("EOCaseID");
			
			report.endTest(logger);
			logger = report.startTest("ACB: Create ACB PDC");
			//Create Apprenticeship
			createPDC.createNewProduct("ACB", "EFT");
			
			//Switch back to main window
			String mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println("Switch back to main window");
			
			
			//Switch to frame
			driver.switchTo().frame(4);
			String homeTxt = pdc.APPRProgramHomeTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(homeTxt, "Apprenticeship Completion Bonus Program Home:");
			System.out.println("ACB Program home is opened");
			logger.log(LogStatus.PASS, "ACB Program home is opened");
			
			//Get ACB Case Reference
			String ACBCaseRef = pdc.PDCCaseReference.getText().trim();
			System.out.println("ACB case Ref: " + ACBCaseRef);
			
			//Write the ACB Case ID into file
			data.writeExcel(filePath, "CaseID_CAMS6.xlsx", "PDC_ACBCaseID", Integer.parseInt(ACBCaseRef));
			System.out.println("ACB Case Reference ID is written to the file");
			
			
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
			logger = report.startTest("ACB: ADD Benefit");
			//Create Lumnp Sum Benefit Type
			Thread.sleep(1000);
			createPDC.createNewBenefit("Lump Sum", "", "", "ACB");
			
																											
			//Switch back to Main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			
			report.endTest(logger);
			logger = report.startTest("ACB: Add Supervisor");
			//Add a Supervisor
			createPDC.addSupervisor("ACB");
			
			//Go back to Site Map
			createPDC.goToSiteMap();
			
			//Click on Site Map action menu
			driver.switchTo().frame(4);

			report.endTest(logger);
			logger = report.startTest("ACB: Submit and approve evidence");
			
			//Apply Evidence
			createPDC.applyEvidence();
			
			//Switch back to Main window
			mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			
			Thread.sleep(1000);
			//Click on logout
			createPDC.logoutCAMS();
			
			//Re-login
			createPDC.reloginAsManager(login, "ACB");
			
			//Search case
			createPDC.globalLoookupByCaseID("PDC_ACBCaseID");
			
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
			createPDC.globalLoookupByCaseID("PDC_ACBCaseID");
			
			//Check EFT
			boolean EFT = createPDC.checkEFT(rpe);
			if(EFT) {
				report.endTest(logger);
				logger = report.startTest("ACB: Add Bank account");
				
				register.addBankAccount(rpe);
				//change Nominees bank account
				createPDC.changeNominee();
			}
			
			report.endTest(logger);
			logger = report.startTest("ACB: Activate case");
			
			//Activate the case
			createPDC.activateCase("ACB");
		} catch (Exception e) {
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
