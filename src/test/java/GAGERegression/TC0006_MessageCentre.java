package GAGERegression;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import GAGE.GAGEHomePage;
import GAGE.GAGELoginPage;
import GAGE.GAGEMessageCentrePage;
import testbase.testbaseforproject;

public class TC0006_MessageCentre extends testbaseforproject{
	
	GAGELoginPage glp;
	GAGEHomePage ghp;
	GAGEMessageCentrePage gmc;

	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void verifyLoginWithValidCredentials() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Message Centre");
		
		glp = new GAGELoginPage(driver);
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		
		//*** Need to delete the Sponsor ID 1015289 before starting the Registration Flow
		glp.gageOneKeyLogin("automationuser", "Poiuyu123!");
		
		glp.handleSecurityAnswer();		
		
		Thread.sleep(5000);
		ghp = new GAGEHomePage(driver);
		ghp.HomeTopNav.click();
		ghp.HomePageMessageCentreImg.click();
//		ghp.MessageIconTopNav.click();
//		driver.findElement(By.xpath("//a[contains(@href, 'apprenticeshiponlineDev/en/sponsor/messages')]")).click();
		System.out.println("Message Icon clicked");
		logger.log(LogStatus.PASS, "Message Icon clicked");
		
		//*** Go to Message Centre
		Thread.sleep(7000);
		gmc = new GAGEMessageCentrePage(driver);
		String MessageCentreTxt = gmc.MessageCentrePageHeaderTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(MessageCentreTxt, "Message Centre");
		logger.log(LogStatus.PASS, "On Message Centre Page");
		
		//*** Go to History page
		gmc.MessageCentreHistoryLink.click();
		Thread.sleep(2000);
		System.out.println("History link clicked");
		String HistoryTxt = gmc.HistoryTxt.getText().trim();
		System.out.println(HistoryTxt);
		AssertTextPresentmethodWithExtendPassFail(HistoryTxt, "History");
		logger.log(LogStatus.PASS, "On Message Centre History page");
		
		//*** Back to Massages page
		gmc.MessageCentreMessageLink.click();
		Thread.sleep(2000);
		System.out.println("Message link clicked");
		String MessageTxt = gmc.MessagesTxt.getText().trim();
		System.out.println("Messages Text ---> "+ MessageTxt);
		
		String messageTextMessagesPage []=MessageTxt.split("1");
		System.out.println("Bank Address First Part ===>> " + messageTextMessagesPage[0]);
		System.out.println("Bank Address First Part ===>> " + messageTextMessagesPage[1]);
		
		String firstPartOfmessageTextMessagesPage = messageTextMessagesPage[0].trim();
		System.out.println("First part of Messages text: "+firstPartOfmessageTextMessagesPage);
		AssertTextPresentmethodWithExtendPassFail(firstPartOfmessageTextMessagesPage, "Messages");
		logger.log(LogStatus.PASS, "Back to Message Centre Message page");
		
		//Thread.sleep(10000);
		//Testing...
		//Testing 2.....
		
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
