package CURAM7Regression;

import java.awt.AWTException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CURAM7.LoginElements;
import CURAM7.PDCElements;
import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class CreatePDC_JCP extends testbaseforproject{
	
	LoginElements login;
	PDCElements pdc;
	String filePath = System.getProperty("user.dir") + "//TestData";
	ReadWriteDataToExcel data;
	CreatePDC createPDC;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void createPDC() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Create PDC");
		
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
		
		createPDC = new CreatePDC();
		pdc = new PDCElements(driver);
		data = new ReadWriteDataToExcel();
		
		//Search Case
		createPDC.globalLoookupByCaseID("EOCaseID", "Employment Ontario Home");
		
		//Create Apprenticeship
		createPDC.createNewProduct("JCP", "EFT");
		
		//Switch back to main window
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		System.out.println("Switch back to main window");
		
		
		//Switch to frame
		driver.switchTo().frame(4);
		String homeTxt = pdc.HomeTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(homeTxt, "Job Creation Partnership Program Home:");
		System.out.println("JCP Program home is opened");
		logger.log(LogStatus.PASS, "JCP Program home is opened");
		
		//Get JCP Case Reference
		String JCPCaseRef = pdc.PDCCaseReference.getText().trim();
		System.out.println("JCP case Ref: " + JCPCaseRef);
		
		//Write the APPR Case ID into file
		data.writeExcel(filePath, "CaseID.xlsx", "PDC_JCPCaseID", Integer.parseInt(JCPCaseRef));
		System.out.println("JCP Case Reference ID is written to the file");
		
		
		//Go to Evidence Tab
		driver.switchTo().window(driver.getWindowHandle());
		pdc.EvidenceTab.click();
		System.out.println("Evidence tab clicked"); 
		logger.log(LogStatus.PASS, "Evidence tab clicked");
		
		
		//Verify Site Map title
		driver.switchTo().frame(4);
		String siteMapTxt = pdc.SiteMapTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(siteMapTxt, "Site Map: Job Creation Partnership");
		System.out.println("Site Map is opened");
		logger.log(LogStatus.PASS, "Site Map is opened");
		
		//Add New Employment Insurance
		createPDC.addNewEmploymentInsurance();
		
		//Click on Site Map
		createPDC.goToSiteMap();
		
		Thread.sleep(1000);
		
		//Click on Training link
		driver.switchTo().frame(4);
		System.out.println("Switch to Frame 4");
		
		//Create Lumnp Sum Benefit Type
		Thread.sleep(1000);
		createPDC.createNewBenefit("Lump Sum", "Basic Living Allowance on Claim", "2000", "JCP");
		System.out.println("Lump Sum benefit is created");
		
		//Switch back to main window
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(4);
		
		//Create Weekly benefit type
		Thread.sleep(1000);
		createPDC.createNewBenefit("Weekly", "Disability Expenses", "100", "JCP");
		System.out.println("Weekly benefit is created");
		
		//Go to Site Map
		createPDC.goToSiteMap();
		
		Thread.sleep(1000);
		
		//Switch to Frame 4
		driver.switchTo().frame(4);
		System.out.println("Switch to Frame 4");
		
		Thread.sleep(1000);
		
	    //Create JCP Evidence
		createPDC.addJobCreationPartnership();
		
		//Switch back to Main window
		mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		
		//Add a Supervisor
		createPDC.addSupervisor("JCP");
		
		//Go back to Site Map
		createPDC.goToSiteMap();
		
		//Click on Site Map action menu
		driver.switchTo().frame(4);

		//Apply Evidence
		createPDC.applyEvidence();
	
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
