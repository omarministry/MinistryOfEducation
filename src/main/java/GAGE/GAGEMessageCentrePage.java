package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class GAGEMessageCentrePage extends testbaseforproject{

	WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGEMessageCentrePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of Gage OneKey Messages page Elements   ==============
	
		@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-message-centre/div[1]/h2")
		public WebElement MessageCentrePageHeaderTxt;
		
		@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-message-centre/div[2]/div[1]/p/a[1]")
		public WebElement MessageCentreMessageLink;
		
		@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-message-centre/div[2]/div[1]/p/a[2]")
		public WebElement MessageCentreHistoryLink;
		
		@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-message-centre/div[2]/div[2]/h3")
		public WebElement HistoryTxt;
		
		@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-message-centre/div[2]/div[2]/h3")
		public WebElement MessagesTxt;
}
