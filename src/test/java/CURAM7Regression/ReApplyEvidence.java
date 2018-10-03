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
		createPDC.globalLoookupByCaseID("PDC_ACBCaseID", "Apprenticeship Program Home:");
		
		//Click on Evidence tab
		driver.switchTo().window(driver.getWindowHandle());
		pdc.EvidenceTab.click();
		System.out.println("Evidence Tab is clicked");
		logger.log(LogStatus.PASS, "Evidence Tab is clicked");
		
		//Verify Site Map title
		driver.switchTo().frame(2);
		String siteMapTxt = pdc.SiteMapTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(siteMapTxt, "Site Map: Apprenticeship");
		System.out.println("Site Map is opened");
		logger.log(LogStatus.PASS, "Site Map is opened");
		
		//Click on Site Map action menu
		pdc.SiteMapActionMenu.click();
		System.out.println("Site Map action menu is clicked");
		logger.log(LogStatus.PASS, "Site Map action menu is clicked");
		
		//CLick on Apply Evidence Option
		pdc.ApplyEvidenceOption.click();
		System.out.println("Apply Evidence Option is clicked");
		logger.log(LogStatus.PASS, "Apply Evidence Option is clicked");
		
		//Switch to Apply Evidence window
		String applyEvidenceWindow = driver.getWindowHandle();
		driver.switchTo().window(applyEvidenceWindow);
		System.out.println("Switch to Apply Evidence window");
		
		//Verify Apply Evidence window is opened
		String applyEvidenceTxt = pdc.ModalDialogTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(applyEvidenceTxt, "Apply Evidence Changes:");
		System.out.println("Apply Evidence window is opened");
		logger.log(LogStatus.PASS, "Apply Evidence window is opened");
		
		//Click on select all Evidence check box
		driver.switchTo().frame(3);
		pdc.AllEvidenceCheckbox.click();
		System.out.println("All Evidence check box is clicked");
		logger.log(LogStatus.PASS, "All Evidence check box is clicked");
		
		//Click on Apply Evidence button
		pdc.ApplyApproveEvidenceButton.click();
		System.out.println("Apply Evidence button is clicked");
		logger.log(LogStatus.PASS, "Apply Evidence button is clicked");		

		
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
