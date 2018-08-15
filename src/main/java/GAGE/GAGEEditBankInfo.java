package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class GAGEEditBankInfo extends testbaseforproject{

WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGEEditBankInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of Gage OneKey Login page Elements   ==============
	
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-banking-information-edit/div[1]/h2")
			public WebElement EditBankInfoPageHeaderTxt;
			
			@FindBy(xpath="//*[@id=\"account-transit-number\"]")
			public WebElement EditBankInfoBranchNumber;
			
			@FindBy(xpath="//*[@id=\"institution-number\"]")
			public WebElement EditBankInfoInstitutionNumber;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-banking-information-edit/div[2]/div/form/div[3]/button")
			public WebElement EditBankInfoSearchBranchButton;
			
			@FindBy(xpath="//input[@formcontrolname='bankName']")
			public WebElement EditBankInfoBankNameField;
			
			@FindBy(xpath="//input[@formcontrolname='bankAddress']")
			public WebElement EditBankInfoBankAddressField;
			
			@FindBy(xpath="//*[@id=\"accountNumber\"]")
			public WebElement EditBankInfoAccountNumber;
			
			@FindBy(xpath="//*[@id=\"confirmAccountNumber\"]")
			public WebElement EditBankInfoConfirmAccountNumber;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-banking-information-edit/div[2]/div/form/div[8]/button")
			public WebElement EditBankInfoSaveButton;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-banking-information-edit/div[2]/div/form/div[8]/a")
			public WebElement EditBankInfoCancelButton;
			
}
