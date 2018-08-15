package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class GAGEHomePage extends testbaseforproject{

	WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGEHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of Gage OneKey Login page Elements   ==============
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-dashboard/div/div/div/h2")
	public WebElement HomePageHeaderTxt;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-dashboard/div/div/nav/ul/li[1]/a/img")
	public WebElement HomePageSponsorInforImg;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-dashboard/div/div/nav/ul/li[2]/a/img")
	public WebElement HomePageGrantsAndBonusesImg;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-dashboard/div/div/nav/ul/li[3]/a/img")
	public WebElement HomePageMessageCentreImg;
	
	@FindBy(xpath="/html/body/appr-root/appr-header/div/appr-sponsor-header/div/div/nav/ul[3]/li[1]/a/span")
	public WebElement MessageIconTopNav;
	
	@FindBy(xpath="/html/body/appr-root/appr-header/div/appr-sponsor-header/div/div/nav/ul[1]/li[1]/a")
	public WebElement HomeTopNav;
	
	
	@FindBy(xpath="/html/body/appr-root/appr-header/div/appr-sponsor-header/div/div/nav/ul[1]/li[2]/a")
	public WebElement GrantsAndBonusesTopNav;
	
	@FindBy(xpath="/html/body/appr-root/appr-header/div/appr-sponsor-header/div/div/nav/ul[3]/li[3]/a/div")
	public WebElement SponsorNameTopNav;
	
	@FindBy(xpath="/html/body/appr-root/appr-header/div/appr-sponsor-header/div/div/nav/ul[3]/li[3]/ul/li[1]/aS")
	public WebElement SponsorInfoInMenu;
	
	
	
}
