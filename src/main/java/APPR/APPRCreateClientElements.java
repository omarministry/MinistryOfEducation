package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRCreateClientElements extends testbaseforproject{

	public APPRCreateClientElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of Create Client page Elements ==============
	
		//--- Elements under Client Search ---
		@FindBy(xpath="//*[@id=\"sin1\"]") 
		public WebElement APPRClientSearchSIN1;
	
		@FindBy(xpath="//*[@id=\"sin2\"]") 
		public WebElement APPRClientSearchSIN2;
		
		@FindBy(xpath="//*[@id=\"sin3\"]") 
		public WebElement APPRClientSearchSIN3;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr/td[1]/input") 
		public WebElement APPRClientSearchButton;
		
		@FindBy(xpath="//*[@id=\"ctrl-next-step\"]") 
		public WebElement APPRClientNextButton;
		
		@FindBy(xpath="//*[@id=\"ctrl-show-confirmation\"]/tbody/tr[2]/td/input[1]") 
		public WebElement APPRClientYesRadioButton;
		
		@FindBy(xpath="//*[@id=\"ctrl-next-step-next\"]/a/input") 
		public WebElement APPRClientNextStepButton;
		
		//--- Elements under Choose Trade/occupation page ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[1]/tbody/tr/td") 
		public WebElement APPRClientChooseTradeTxt;
		
		@FindBy(xpath="//*[@id=\"code\"]") 
		public WebElement APPRClientTOSSCode;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/input[107]") 
		public WebElement APPRClientTradeNextStepButton;
		
		//--- Elements under Personal Information page ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientPersonalInfoTxt;
		
		@FindBy(xpath="//*[@id=\"firstname\"]") 
		public WebElement APPRClientFirstName;
		
		@FindBy(xpath="//*[@id=\"lastname\"]") 
		public WebElement APPRClientLastName;
		
		@FindBy(xpath="//*[@id=\"day\"]") 
		public WebElement APPRClientDayforDateOfBirth;
		
		@FindBy(xpath="//*[@id=\"month\"]") 
		public WebElement APPRClientMonthforDateOfBirth;
		
		@FindBy(xpath="//*[@id=\"year\"]") 
		public WebElement APPRClientYearforDateOfBirth;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[11]/tbody/tr[1]/td[3]/table/tbody/tr/td[2]/input") 
		public WebElement APPRClientPhone1;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[11]/tbody/tr[1]/td[3]/table/tbody/tr/td[4]/input") 
		public WebElement APPRClientPhone2;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[11]/tbody/tr[1]/td[3]/table/tbody/tr/td[6]/input") 
		public WebElement APPRClientPhone3;
		
		@FindBy(xpath="//*[@id=\"female\"]") 
		public WebElement APPRClientFemaleRadioButton;
		
		@FindBy(xpath="//*[@id=\"educationLevel\"]/option[4]") 
		public WebElement APPRClientEducationG12;
		
		@FindBy(xpath="//*[@id=\"pref-en\"]") 
		public WebElement APPRClientPreferredLanguageRadioButton;
		
		@FindBy(xpath="//*[@id=\"lookup\"]") 
		public WebElement APPRClientPostalCode;
		
		@FindBy(xpath="//html/body/table[8]/tbody/tr/td[4]/form/table[34]/tbody/tr/td[4]/input") 
		public WebElement APPRClientPostalCodeLookUpButton;
		
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/input[4]") 
		public WebElement APPRClientPersonalInfoNextStepButton;
		
		//--- Elements under Postal Code Look-up page ---
		@FindBy(xpath="/html/body/table[3]/tbody/tr[1]/td/div") 
		public WebElement APPRClientPostalCodePageTxt;
		
		@FindBy(xpath="/html/body/form/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]/input") 
		public WebElement APPRClientStreetNumber;
		
		@FindBy(xpath="/html/body/form/table/tbody/tr[4]/td/div/input[2]") 
		public WebElement APPRClientPostalCodeNextButton;
		
		//--- Elements under Required Documents page ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientRequiredDocTxt;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[5]/tbody/tr/td[2]/input") 
		public WebElement APPRClientProofOfAgeCheckbox;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[17]/tbody/tr/td[2]/input") 
		public WebElement APPRClientProofOfSINCheckbox;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[21]/tbody/tr/td[2]/input") 
		public WebElement APPRClientProofOfEducationCheckbox;
		
		@FindBy(xpath="//*[@id=\"next.step\"]") 
		public WebElement APPRClientRequiredDocumentNextStepButton;
		
		//--- Elements under Confirm Party Identification Page ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[1]/tbody/tr/td") 
		public WebElement APPRClientConfirmPartyTxt;
		
		@FindBy(xpath="//*[@id=\"new_client_party\"]") 
		public WebElement APPRClientConfirmRadioButton;
		
		@FindBy(xpath="//*[@id=\"yes-radio-button\"]") 
		public WebElement APPRClientConfirmYesRadioButton;
		
		@FindBy(xpath="//*[@id=\"ctrl-confirm-button\"]") 
		public WebElement APPRClientConfirmButton;
		
		//--- Elements under Confirm Application
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientConfirmApplicationTxt;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td[1]/form/input[113]") 
		public WebElement APPRClientSubmitAsApprovedButton;
		
		//--- Elements under Application summary Page ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientApplicationSummaryTxt;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[9]/tbody/tr[5]/td[2]/a") 
		public WebElement APPRClientID;
}
