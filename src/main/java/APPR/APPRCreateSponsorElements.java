package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRCreateSponsorElements extends testbaseforproject {
	
	public APPRCreateSponsorElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of Create Sponsor page (Sponsor/Employer Search) Elements ==============
	
		//--- Elements under Sponsor/Employer Search ---
		@FindBy(xpath=".//*[@id='sponsorName']") 
		public WebElement APPRSponsorNameCreateSponsor;
		
		@FindBy(xpath="html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr/td[1]/input") 
		public WebElement APPRSearchCreateSponsor;
		
		@FindBy(xpath=".//*[@id='ctrl-next-step']") 
		public WebElement APPRNextStepCreateSponsor;
		
		@FindBy(xpath=".//*[@id='ctrl-show-confirmation']/tbody/tr[2]/td/input[1]") 
		public WebElement APPRYesRdBtnCreateSponsor;
		
		@FindBy(xpath=".//*[@id='ctrl-next-step-next']/a/input") 
		public WebElement APPRNextStepAfterYesCreateSponsor;
		
		//--- Elements under Choose a trade/occupation ---
		@FindBy(xpath=".//*[@id='code']") 
		public WebElement APPRTossCodeCreateSponsor;
		
		@FindBy(xpath="html/body/table[8]/tbody/tr/td[4]/input[23]") 
		public WebElement APPRNextAfterTossCodeCreateSponsor;
		
		//--- Elements under Program Questions ---
		@FindBy(xpath=".//*[@id='firstyes']") 
		public WebElement APPRRBtnLocaionOntCreateSponsor;
		
		@FindBy(xpath=".//*[@id='secondyes']") 
		public WebElement APPRRBtnTrainersCreateSponsor;
		
		@FindBy(xpath="//form[@class='ng-pristine ng-valid']//input[109]") 
		////html/body/table[8]/tbody/tr/td[4]/form/input[317]
		public WebElement APPRNextOnPrQuestionsCreateSponsor;
		
		//--- Elements under Sponsor/Employer Information ---
		@FindBy(xpath=".//*[@id='LTEE']") 
		public WebElement APPRRBtnTypeEmployerCreateSponsor;
		
		@FindBy(xpath=".//fieldset//input[@name='sponsorName']") 
		public WebElement APPREmployerNameTwoCreateSponsor;
		
		@FindBy(xpath=".//*[@id='owner']") 
		public WebElement APPROwnerCreateSponsor;
		
		@FindBy(xpath=".//*[@id='en']") 
		public WebElement APPRPlangEngCreateSponsor;
		
		@FindBy(xpath=".//*[@id='lookup']") 
		public WebElement APPRPostalCreateSponsor;
		
		@FindBy(xpath="html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[9]/tbody/tr/td[4]/input") 
		public WebElement APPRAddrLookUpCreateSponsor;
		
		@FindBy(xpath="html/body/form/table/tbody/tr[3]/td/table/tbody/tr[3]/td[1]/input") 
		public WebElement APPRStNoCreateSponsor;
		
		@FindBy(xpath="html/body/form/table/tbody/tr[1]/td/div/input[2]") 
		public WebElement APPRNextAfterStNoCreateSponsor;
		
		@FindBy(xpath=".//*[@id='contactname']") 
		public WebElement APPRContactNameCreateSponsor;
		
		@FindBy(xpath=".//*[@id='phone']") 
		public WebElement APPRPhoneOneCreateSponsor;
		
		@FindBy(xpath="html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[13]/tbody/tr[4]/td[3]/table/tbody/tr/td[4]/input") 
		public WebElement APPRPhoneTwoCreateSponsor;
		
		@FindBy(xpath="html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[13]/tbody/tr[4]/td[3]/table/tbody/tr/td[6]/input") 
		public WebElement APPRPhoneThreeCreateSponsor;
		
		@FindBy(xpath="//form[@class='ng-pristine ng-valid']//input[@value='Next Step' and @title='Next Step button']") 
		public WebElement APPRNextStepSpInfoCreateSponsor;
		
		
		//--- Confirm Party Identification ---
		
		@FindBy(xpath=".//*[@id='new_sponsor_party']") 
		public WebElement APPRRdBtnUseSpCreateSponsor;
		
		@FindBy(xpath=".//*[@id='yesCheck']") 
		public WebElement APPRCkhYesIWantCreateSponsor;
	
		@FindBy(xpath=".//*[@id='ctrl-confirm-button']") 
		public WebElement APPRConfirmInfoCreateSponsor;
	
			
		//--- Confirm Application ---
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[8]/tbody/tr[5]/td[2]/a") 
		public WebElement APPRSponsorID;
				
		
		
		@FindBy(xpath="//form[@class='ng-pristine ng-valid']//input[@value='Submit as approved' and @title='Submit application as approved button']") 
		public WebElement APPRSubmitCreateSponsor;
				
		
		

}




