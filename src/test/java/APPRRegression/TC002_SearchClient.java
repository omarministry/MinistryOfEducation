package APPRRegression;

import java.awt.AWTException;

//import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.ClientSearchElementsOnRight;

import testbase.homepage;
import testbase.testbaseforproject;

public class TC002_SearchClient extends testbaseforproject {
	
	homepage homepage;
	//LeftNavElementsUnderSearch lne;
	ClientSearchElementsOnRight cse;
	
	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifySearchClient() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Search a Client");
		homepage = new homepage(driver);
				
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		Thread.sleep(5000);
		homepage.apprLogin("DSAH10047", "Password");
		
		Thread.sleep(5000);
		
		//lne = new LeftNavElementsUnderSearch(driver);
		//lne.client.click();
		logger.log(LogStatus.PASS, "Clicked on Client");
		Thread.sleep(10000);
		cse = new ClientSearchElementsOnRight(driver);
		cse.clientID.sendKeys("2896451");
		logger.log(LogStatus.PASS, "Entered on Client ID");
		
		cse.SearchButtonClientSearch.click();
		logger.log(LogStatus.PASS, "Clicked Search");
		
		Thread.sleep(5000);
		
		String clientSearchResults = cse.clientSearchResultsBottom.getText();
		AssertTextPresentmethod(clientSearchResults, "286451");
		
		logger.log(LogStatus.PASS, "Assert pass for Client ID: " + clientSearchResults );
		
		//AssertTextPresentmethod(ElementText, testToVerify)
		
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
