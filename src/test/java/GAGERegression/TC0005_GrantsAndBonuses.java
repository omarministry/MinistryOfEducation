package GAGERegression;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GAGE.GAGEGrantsAndBonusesPage;
import GAGE.GAGEHomePage;
import GAGE.GAGELoginPage;
import testbase.testbaseforproject;

public class TC0005_GrantsAndBonuses extends testbaseforproject{
	
	GAGELoginPage glp;
	GAGEGrantsAndBonusesPage ggnb;
	GAGEHomePage ghp;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Gage Grants and Bonuses page");
		
		glp = new GAGELoginPage(driver);
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		
		glp.gageOneKeyLogin("automationuser", "Poiuyu123!");
		
		glp.handleSecurityAnswer();	
		
		
		ghp = new GAGEHomePage(driver);
//		ghp.GrantsAndBonusesTopNav.click();
		//ghp.HomeTopNav.click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(@href, 'apprenticeshiponlineUAT/en/sponsor/grant')]")).click();
		logger.log(LogStatus.PASS, "Grants and Bonuses link clicked");
		
		Thread.sleep(4000);
		ggnb = new GAGEGrantsAndBonusesPage(driver);

		String GrantsAndBonusesTxt = ggnb.GrantsAndBunusesPageHeaderTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(GrantsAndBonusesTxt, "Grants and bonuses" );
		logger.log(LogStatus.PASS, "On Grants and Bonuses page");
		
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
