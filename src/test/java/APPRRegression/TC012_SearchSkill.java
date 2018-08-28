package APPRRegression;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import APPR.APPRSkillElements;
import testbase.testbaseforproject;

public class TC012_SearchSkill extends testbaseforproject{
	APPRLeftNavElements lne;
	APPRLoginPageElements lpe;
	APPRSkillElements se;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifySearchSkill(){
		try {
			
			logger = report.startTest("Search for Skill");
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
			lne.APPRSkillLeftNav.click();
			Thread.sleep(2000);
			
			//On Skill Search page
			se = new APPRSkillElements(driver);
			String skillSearchTxt = se.SkillSearchTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(skillSearchTxt, "Skill Search");
			System.out.println("On Skill Search page");
			logger.log(LogStatus.PASS, "Land on Skill Search page");
			
			//Search Skill by TOSS code and program
			se.SkillTOSSField.sendKeys("268R");
			se.SkillProgramOption.click();
			se.SkillSearchButton.click();
			System.out.println("Search Button clicked");
			logger.log(LogStatus.PASS, "Search button clicked");
			
			//Click on the first result to go to skill page
			se.SkillFirstResult.click();
			String skillTxt = se.SkillTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(skillTxt, "Skill");
			System.out.println("On Skill page");
			logger.log(LogStatus.PASS, "Land on Skill page");
			
			
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
