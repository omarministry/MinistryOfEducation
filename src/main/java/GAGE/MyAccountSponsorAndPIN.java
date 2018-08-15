package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class MyAccountSponsorAndPIN extends testbaseforproject {
	
WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public MyAccountSponsorAndPIN(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of Gage My Account page Elements   ==============
	
		@FindBy(xpath="//*[@id='MYACCOUNTDEVENROL']/a")
		public WebElement DevLinkOnServiceListPage;
				
		@FindBy(xpath="//*[@id=\"firstName\"]")
		public WebElement MyAccountFirstName;
		
		@FindBy(xpath="//*[@id=\"lastName\"]")
		public WebElement MyAccountLastName;
		
		@FindBy(xpath="//*[@id=\"emailAddress\"]")
		public WebElement MyAccountEmail;
		
		@FindBy(xpath="//*[@id=\"questiona\"]")
		public WebElement MyAccountQ1;
		
		@FindBy(xpath="//*[@id=\"answera\"]")
		public WebElement MyAccountAnswer1;
		
		@FindBy(xpath="//*[@id=\"questionb\"]")
		public WebElement MyAccountQ2;
		
		@FindBy(xpath="//*[@id=\"answerb\"]")
		public WebElement MyAccountAnswer2;
		
		@FindBy(xpath="//*[@id=\"questionc\"]")
		public WebElement MyAccountQ3;
		
		@FindBy(xpath="//*[@id=\"answerc\"]")
		public WebElement MyAccountAnswer3;
		
		@FindBy(xpath="/html/body/app-root/app-create-account/form/div[34]/div[2]/button")
		public WebElement MyAccountNextButton;
		
		//======================Sponsor ID & PIN Mapping Page Elements================
		
		@FindBy(xpath="//*[@id='0-party-id']")
		public WebElement SponsorIDMappingPage;
		
		@FindBy(xpath="//*[@id='0-pin']")
		public WebElement SponsorPINMappingPage;
		
		//@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-add-sponsor/div/form/div[3]/div/button")
		@FindBy(xpath="//button[@class='btn btn-primary']")
		public WebElement SubmitIDPINMapping;
		
		
		@FindBy(xpath="/html/body/appr-root/appr-header/div/appr-sponsor-header/div/div/nav/ul[1]/li[2]/a")
		public WebElement GrantsAndBonusesAfterMapping;
		
		

}
