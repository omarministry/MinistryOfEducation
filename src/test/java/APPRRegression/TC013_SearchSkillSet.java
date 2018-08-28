package APPRRegression;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import APPR.APPRSkillSetElements;
import testbase.testbaseforproject;

public class TC013_SearchSkillSet extends testbaseforproject{

	APPRLeftNavElements lne;
	APPRLoginPageElements lpe;
	APPRSkillSetElements sse;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifySearchSkillSet(){
		try {
			
			logger = report.startTest("Search for Skill Set");
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
			lne.APPRSkillSetLeftNav.click();
			Thread.sleep(2000);
			
			//On Skill Set Search page
			sse = new APPRSkillSetElements(driver);
			String skillSetSearchTxt = sse.SkillSetSearchTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(skillSetSearchTxt, "Skill Set Search");
			System.out.println("On Skill Set Search page");
			logger.log(LogStatus.PASS, "Land on Skill Set Search page");
			
			//Search Skill Set by TOSS code and program
			sse.SkillSetTOSSCodeField.sendKeys("268R");
			sse.SkillSetProgramOption.click();
			sse.SkillSetSearchButton.click();
			System.out.println("Search Button clicked");
			logger.log(LogStatus.PASS, "Search button clicked");
			
			//Click on the first result to go to skill Set page
			sse.SkillSetFirstResult.click();
			String skillTxt = sse.SkillSetTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(skillTxt, "Skill Set");
			System.out.println("On Skill Set page");
			logger.log(LogStatus.PASS, "Land on Skill Set page");
			
			
		}catch (Exception e) {
			
			
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
