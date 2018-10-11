package CURAM7Regression;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import CURAM7.LoginElements;
import CURAM7.PDCElements;
import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class ReApplyEvidence extends testbaseforproject{

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
	public void reApplyEvidence() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Register Multiple Person");
		
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
		
		pdc = new PDCElements(driver);
		createPDC = new CreatePDC();
		data = new ReadWriteDataToExcel();
		
		//Search case
		createPDC.globalLoookupByCaseID("PDC_ACBCaseID");
		
		//Call reApplyEvidence
		createPDC.reApplyEvidence();

		
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
