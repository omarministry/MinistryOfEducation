package APPRRegression;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import APPR.APPRReportableSubjectElements;
import testbase.testbaseforproject;

public class TC010_SearchReportableSubjects extends testbaseforproject{

	APPRLeftNavElements lne;
	APPRLoginPageElements lpe;
	APPRReportableSubjectElements arse;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifySearchReportableSubject(){
		try {
			
			logger = report.startTest("Search for Examination/Test");
			lpe = new APPRLoginPageElements(driver);
			
			//logging into APPR
			String browser = config.getProperty("browser");
			if (browser.equalsIgnoreCase("IE")){
				driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			}
			
			Thread.sleep(5000);
			String username = config.getProperty("userNameAPPR");
			String password = config.getProperty("PasswordAPPR");
			System.out.println("Username from Config file...." + username);
			lpe.apprLogin(username, password);
			Thread.sleep(5000);
			
			//Clicking on the left nav element
			lne = new APPRLeftNavElements(driver);
			lne.APPRReportableSubjectsLeftNav.click();
			Thread.sleep(1000);
			
			arse = new APPRReportableSubjectElements(driver);
			String RSTxt = arse.APPRRRTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(RSTxt, "Reportable Subject Search");
			System.out.println("On Reportable Subject Search page");
			logger.log(LogStatus.PASS, "Land on Reportable Subject Search page");
			
			//Input TOSS code and Apprenticeship program
			arse.APPRRSTOSScode.sendKeys("268R");
			arse.APPRRSProgramOption.click();
			arse.APPRRSSearchButton.click();
			Thread.sleep(1000);
			System.out.println("Search button clicked");
			logger.log(LogStatus.PASS, "Search button clicked");
			
			//get the number of page it returned
			List<WebElement> pages = arse.APPRRSPage.findElements(By.tagName("option"));
			System.out.println(pages.size());
			
			//Verify the number of reportable subjects for TOSS 268R
			List<WebElement> subjects = arse.APPRRSSearchResultTable.findElements(By.tagName("tr"));
//			System.out.println(subjects.size());
			
			int i = 1;
			int count = 0;
			int j = 0;
			
			do {
				if (i >= subjects.size()) {
					if(j == 1) {
						arse.APPRRSNextButton.click();
					}else {
						arse.APPRRSSecondNextButton.click();
					}

					Thread.sleep(1000);
					subjects = arse.APPRRSSearchResultTable.findElements(By.tagName("tr"));
					System.out.println("On the next page of results");
					i = 1;
				}else {
					while(i < subjects.size()) {
						count ++;
						i += 3;
					}	
				}
				j++;
			}while(j <= pages.size()+2);
			
			
			if(count == 35) {
				System.out.println("Toss 268R has " + count + " Reportable Subjects");
				logger.log(LogStatus.PASS, "Toss 268R has " + count + " Reportable Subjects");
			}
			
			
			
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
