package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class GAGEAddNewSponsor extends testbaseforproject{

	WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGEAddNewSponsor (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of Gage OneKey Login page Elements   ==============
	
			@FindBy(xpath="//*[@id=\"0-party-id\"]")
			public WebElement SponsorIDField;
			
			@FindBy(xpath="//*[@id=\"0-pin\"]")
			public WebElement PINField;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-session-boot/div[2]/div/div/appr-sponsor-mapping/div/form/div[3]/div/button")
			public WebElement SubmitButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-session-boot/div[2]/div/div/appr-sponsor-mapping/div/form/div[3]/div/a")
			public WebElement CancelButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-session-boot/div[2]/div/div/appr-sponsor-mapping/div/p")
			public WebElement EnterSponsorIDPINtxt;
}
