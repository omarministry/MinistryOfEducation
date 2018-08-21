package APPRRegression;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRFormDocument;
import APPR.APPRLoginPageElements;

import testbase.testbaseforproject;

public class TC007_SearchFormDocument extends testbaseforproject {

	
	APPRLeftNavElements lne;
	APPRFormDocument fd;
	APPRLoginPageElements lpe;
	
	
	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifySearchFormDocument() throws InterruptedException, AWTException {
		
		try {
	
			logger = report.startTest("Search for Examination/Test");
			lpe = new APPRLoginPageElements(driver);
			
			//logging into APPR
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			Thread.sleep(5000);
			String username = config.getProperty("userNameAPPR");
			String password = config.getProperty("PasswordAPPR");
			System.out.println("Username from Config file...." + username);
			lpe.apprLogin(username, password);
			Thread.sleep(5000);
			
			//Clicking on the left nav element
			lne = new APPRLeftNavElements(driver);
			lne.APPRFormDocumentLeftNav.click();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Clicked on Form/Document tab");
			
			fd = new APPRFormDocument(driver);
			
			//Search for a form/document
			fd.tossCode.sendKeys("415A");
			fd.searchButton.click();
			Thread.sleep(2000);
			
			//Selecting first search result
			fd.firstResult.click();
			
			//Checking if the page loaded correctly
			String formDocument = fd.formDocument.getText();
			AssertTextPresentmethodWithExtendPassFail(formDocument, "Form/Document ID:");
			
			
			
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