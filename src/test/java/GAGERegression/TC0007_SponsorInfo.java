package GAGERegression;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GAGE.GAGEHomePage;
import GAGE.GAGELoginPage;
import GAGE.GAGESponsorInfoPage;
import testbase.testbaseforproject;

public class TC0007_SponsorInfo extends testbaseforproject{

	GAGELoginPage glp;
	GAGEHomePage ghp;
	GAGESponsorInfoPage gsi;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Sponsor Info");
		
		glp = new GAGELoginPage(driver);
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		
		glp.gageOneKeyLogin(config.getProperty("userNameGage"), "Poiuyu123!");
		
		glp.handleSecurityAnswer();		
		
		//*** Go to home page
		Thread.sleep(2000);
		ghp = new GAGEHomePage(driver);
		ghp.HomeTopNav.click();
		System.out.println("Home Link clicked");
		
		//*** Navigate to Sponsor Info
		Thread.sleep(2000);
		ghp.SponsorNameTopNav.click();
		Thread.sleep(2000);
		ghp.SponsorInfoInMenu.click();
		
		gsi = new GAGESponsorInfoPage(driver);
		String SponsorTxt = gsi.SponsorInfoHeaderTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(SponsorTxt, "Sponsor information");
		logger.log(LogStatus.PASS, "On Sponsor Information Page");
		
		//***Compare LBN
		String LBNTxt = gsi.SponsorInfoLBNTxt.getText().trim();
		String HeaderLBNTxt = ghp.SponsorNameTopNav.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(LBNTxt, HeaderLBNTxt);
		logger.log(LogStatus.PASS, "LBN is correct");
		
		//Thread.sleep(10000);
		
		
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
