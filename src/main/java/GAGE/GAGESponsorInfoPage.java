package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class GAGESponsorInfoPage extends testbaseforproject{

WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGESponsorInfoPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of Gage OneKey Login page Elements   ==============
	
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-company-profile/div/div[1]/div/h2")
			public WebElement SponsorInfoHeaderTxt;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-company-profile/div/div[2]/div[2]/div/div[2]/div/a")
			public WebElement EditMailingAdressButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-company-profile/div/div[2]/div[3]/div[2]/div/a")
			public WebElement EditBankInfoButton;
			
			@FindBy(xpath="/html/body/appr-root/appr-header/div/appr-sponsor-header/div/div/nav/ul[3]/li[2]/ul/li[1]/a")
			public WebElement SponsorInfoMenuLink;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-company-profile/div/div[2]/div[1]/div/div[2]/dl/dd[3]")
			public WebElement SponsorInfoLBNTxt;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-company-profile/div/div[2]/div[3]/div[2]/dl/dd[1]")
			public WebElement SponsorBankInfoTxt;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-company-profile/div/div[2]/div[3]/div[2]/dl/dd[2]/p")
			public WebElement SponsorAccountNumberTxt;
}
