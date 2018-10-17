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

public class ApproveEvidence extends testbaseforproject{

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
	public void approveEvidence() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Register Multiple Person");
		
		//Login
		login = new LoginElements(driver);
		
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		

		Thread.sleep(2000);
		
		String username = config.getProperty("userCURAM7RegionalLead");
		String password = config.getProperty("pwdCURAM7RegionalLead");
		System.out.println("User Name from Config file...." + username);
		login.curam7Login(username, password);
		
		Thread.sleep(2000);
		
		String header = login.Header.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(header, "CASE MANAGEMENT SYSTEM - Ministry Manager Application");
		System.out.println("Login Successfully");
		
		pdc = new PDCElements(driver);
		createPDC = new CreatePDC();
		data = new ReadWriteDataToExcel();
		
		//Search case
		createPDC.globalLoookupByCaseID("PDC_ECBCaseID");
		
		//Approve Evidence
		createPDC.approveEvidence();

		
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
