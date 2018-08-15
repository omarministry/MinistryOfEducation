package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class GAGEAttestationPage extends testbaseforproject{

WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGEAttestationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of Gage OneKey Login page Elements   ==============
	
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-attestations/div/div/div/h2")
			public WebElement AttestationPageHeaderTxt;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-attestations/div/div/div/h2")
			public WebElement BasePaymentTxt;
}
