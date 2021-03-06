package CURAM7Regression;

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

public class CreatePDC_ACB extends testbaseforproject{
	
	LoginElements login;
	PDCElements pdc;
	String filePath = System.getProperty("user.dir") + "//TestData";
	ReadWriteDataToExcel data;
	CreatePDC createPDC;
	RegisterPerson register;
	RegisterPersonElements rpe;
	
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void createPDC() throws InterruptedException, AWTException {
	
		try {
	
		logger = report.startTest("Create ACB PDC");
		
		//Login
		login = new LoginElements(driver);
		
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		
		Thread.sleep(2000);
		
		String username = config.getProperty("userCURAM7CaseWorker");
		String password = config.getProperty("pwdCURAM7CaseWorker");
		System.out.println("User Name from Config file...." + username);
		login.curam7Login(username, password);
		
		Thread.sleep(2000);
		
		String header = login.Header.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(header, "CASE MANAGEMENT SYSTEM - MINISTRY CASEWORKER APPLICATION");
		System.out.println("Login Successfully");
		
		register = new RegisterPerson();
		rpe = new RegisterPersonElements(driver);
		
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
		
		register.registerAPerson(rpe);
		
		createPDC = new CreatePDC();
		pdc = new PDCElements(driver);
		data = new ReadWriteDataToExcel();
		
		//Search Case
		createPDC.globalLoookupByCaseID("EOCaseID");
		
		//Create Apprenticeship
		createPDC.createNewProduct("ACB", "EFT");
		
		//Switch back to main window
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		System.out.println("Switch back to main window");
		
		
		//Switch to frame
		driver.switchTo().frame(4);
		String homeTxt = pdc.HomeTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(homeTxt, "Apprenticeship Completion Bonus Program Home:");
		System.out.println("ACB Program home is opened");
		logger.log(LogStatus.PASS, "ACB Program home is opened");
		
		//Get ACB Case Reference
		String ACBCaseRef = pdc.PDCCaseReference.getText().trim();
		System.out.println("ACB case Ref: " + ACBCaseRef);
		
		//Write the ACB Case ID into file
		data.writeExcel(filePath, "CaseID.xlsx", "PDC_ACBCaseID", Integer.parseInt(ACBCaseRef));
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
		
		
		//Create Lumnp Sum Benefit Type
		Thread.sleep(1000);
		createPDC.createNewBenefit("Lump Sum", "", "", "ACB");
		
																										
		//Switch back to Main window
		mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		
		//Add a Supervisor
		createPDC.addSupervisor("ACB");
		
		//Go back to Site Map
		createPDC.goToSiteMap();
		
		//Click on Site Map action menu
		driver.switchTo().frame(4);

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
			
			register.addBankAccount(rpe);
			//change Nominees bank account
			createPDC.changeNominee();
		}
		

		//Activate the case
		createPDC.activateCase("ACB");
	
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
