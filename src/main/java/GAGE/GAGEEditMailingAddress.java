package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class GAGEEditMailingAddress extends testbaseforproject{

WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGEEditMailingAddress(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of Gage OneKey Login page Elements   ==============
	
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-mailing-address-edit/div[1]/h2")
			public WebElement EditMailStep1Txt;
			
			@FindBy(xpath="//*[@id=\"postal-code\"]")
			public WebElement PostalCode;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-mailing-address-edit/div[2]/div/form/div[2]/button")
			public WebElement Step1NextButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-mailing-address-edit/div[2]/div/form/div[2]/a")
			public WebElement Step1CancelButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-mailing-address-edit/div[1]/h2")
			public WebElement EditMailStep2Txt;
			
			@FindBy(xpath="//*[@id=\"address-range0\"]")
			public WebElement RadioButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-mailing-address-edit/div[2]/div/form/div[3]/button")
			public WebElement Step2NextButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-mailing-address-edit/div[2]/div/form/div[3]/a")
			public WebElement Step2BackButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-mailing-address-edit/div[1]/h2")
			public WebElement EditMailStep3Txt;
			
			@FindBy(xpath="//*[@id=\"civic-number\"]")
			public WebElement StreetNumber;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-mailing-address-edit/div[2]/div/form/div[6]/button")
			public WebElement SaveButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-company-profile/div/div[2]/div[2]/div/div[2]/p")
			public WebElement PostalCodeTxt;
}
