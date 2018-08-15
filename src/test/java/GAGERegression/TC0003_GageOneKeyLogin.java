package GAGERegression;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;

import GAGE.GAGELoginPage;
import GAGE.GAGEOneKeySignUpElements;
import testbase.testbaseforproject;

public class TC0003_GageOneKeyLogin extends testbaseforproject{
	
	GAGELoginPage glp;

	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Gage OneKey Login");
		
		glp = new GAGELoginPage(driver);
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		
		glp.gageOneKeyLogin("automationuseruat", "Poiuyu123!");
		
		glp.handleSecurityAnswer();		
		
		String BusInfoAfterLoginTxt = glp.BusInfoAfterLoginTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(BusInfoAfterLoginTxt, "Business information" );
		
		
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
