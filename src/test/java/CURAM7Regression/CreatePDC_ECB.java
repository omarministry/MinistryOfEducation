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

public class CreatePDC_ECB extends testbaseforproject{
	
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
	
		logger = report.startTest("Create ECB PDC");
		
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
		createPDC.createNewProduct("ECB", "");
		
		//Switch back to main window
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		System.out.println("Switch back to main window");
		
		
		//Switch to frame
		driver.switchTo().frame(4);
		String homeTxt = pdc.HomeTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(homeTxt, "Employer Bonus Program Home:");
		System.out.println("Employer Bonus Program home is opened");
		logger.log(LogStatus.PASS, "Employer Bonus Program home is opened");
		
		//Get ECB Case Reference
		String ECBCaseRef = pdc.PDCCaseReference.getText().trim();
		System.out.println("ACB case Ref: " + ECBCaseRef);
		
		//Write the ECB Case ID into file
		data.writeExcel(filePath, "CaseID.xlsx", "PDC_ECBCaseID", Integer.parseInt(ECBCaseRef));
		System.out.println("ECB Case Reference ID is written to the file");
		
		
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
		
		
		//Click on Apprenticeship Link
		createPDC.addApprenticeship();
		
		//Switch back to Main window
		mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		
		//Go back to Site Map
		createPDC.goToSiteMap();
		
		//Click on Site Map action menu
		driver.switchTo().frame(4);
		
		//Create Lumnp Sum Benefit Type
		Thread.sleep(1000);
		createPDC.createNewBenefit("Lump Sum", "", "", "ECB");
		
																										
		//Switch back to Main window
		mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		
		//Add a Supervisor
		createPDC.addSupervisor("ECB");
		
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
		createPDC.reloginAsManager(login, "ECB");
		
		//Search case
		createPDC.globalLoookupByCaseID("PDC_ECBCaseID");
		
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
		createPDC.globalLoookupByCaseID("PDC_ECBCaseID");

		//Activate the case
		createPDC.activateCase("ECB");
	
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
