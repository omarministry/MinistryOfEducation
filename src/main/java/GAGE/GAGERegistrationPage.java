package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class GAGERegistrationPage extends testbaseforproject{
	WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGERegistrationPage(WebDriver webdriver) {
		PageFactory.initElements(driver, this);
	}
	

	//============= xPaths of Gage OneKey Login page Elements   ==============
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/div/div/h2")
	public WebElement RegistrationHeaderTxt;
	
	@FindBy(xpath="//*[@id=\"legalBusinessName\"]")
	public WebElement RegistrationLegalBusinessName;
	
	@FindBy(xpath="//div[@class='form-group']/input")
	public WebElement RegistrationLegalBusinessName1;
	
	@FindBy(xpath="//*[@id=\"federalBusinessNumber\"]")
	public WebElement RegistrationFederalBusinessNumber;
	
	@FindBy(xpath="//*[@id=\"branchNumber\"]")
	public WebElement RegistrationBranchNumber;
	
	@FindBy(xpath="//*[@id=\"bankNumber\"]")
	public WebElement RegistrationInstitutionNumber;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[8]/div/div/button")
	public WebElement RegistrationBankSearchButton;
	
	@FindBy(xpath="//*[@id=\"bankName\"]")
	public WebElement RegistrationBankName;
	
	@FindBy(xpath="//*[@id=\"bankAddress\"]")
	public WebElement RegistrationBankAddress;
	
	@FindBy(xpath="//*[@id=\"accountNumber\"]")
	public WebElement RegistrationAccountNumber;
	
	@FindBy(xpath="//*[@id=\"agreementTermConditionInd\"]")
	public WebElement RegistrationAgreeTerm;
	
	@FindBy(xpath="//*[@id=\"confirmAccountNumber\"]")
	public WebElement RegistrationConfirmAccountNumber;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[15]/div/div/div[1]/button")
	public WebElement RegistrationNextButton;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[15]/div/div/div[2]/a")
	public WebElement RegistrationBackToHomeButton;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[2]/div/p")
	public WebElement ConfirmPageTxt;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[3]/div/div/p")
	public WebElement ConfirmPageLBNTxt;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[4]/div/div/p")
	public WebElement ConfirmPageFBNTxt;

	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[5]/div/div/p")
	public WebElement ConfirmPageInstitutionNumberTxt;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[6]/div/div/p")
	public WebElement ConfirmPageBranchNumberTxt;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[7]/div/div/p")
	public WebElement ConfirmPageBankNameTxt;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[8]/div/div/p")
	public WebElement ConfirmPageBankAddressTxt;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[9]/div/div/p")
	public WebElement ConfirmPageAccountNumberTxt;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[10]/div/div/div[1]/button")
	public WebElement ConfirmPageSubmitButton;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[10]/div/div/div[2]/button")
	public WebElement ConfirmPagePreviousPageButton;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-gage-registration-complete/div/div/div[2]/div/p[1]")
	public WebElement SubmittedTxt;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-gage-registration-complete/div/div/div[2]/div/p[3]/a")
	public WebElement ContinueButton;
}
