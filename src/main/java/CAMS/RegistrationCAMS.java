package CAMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class RegistrationCAMS extends testbaseforproject {
	
	WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public RegistrationCAMS(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of Register Person page Elements ==============
	
	
		//***** Name Section ***** 
		@FindBy(xpath="//*[@id=\"__o3id0\"]")
		public WebElement FirstNameRegisterPerson;
		
		//***** Details Section ***** 
		//---Identity As ---
		@FindBy(xpath="//*[@id=\"widget___o3id9\"]/div[1]/input")
		public WebElement IdentityAsRegisterPerson;
		
		//---DOB ---
		@FindBy(xpath="//*[@id=\"__o3ida\"]")
		public WebElement DOBRegisterPerson;
		
		//---Status in Canada ---
		@FindBy(xpath="//*[@id=\"__o3idf\"]")
		public WebElement StatusRegisterPerson;
		
		//---Preferred Language ---
		@FindBy(xpath="//*[@id=\"__o3id11\"]")
		public WebElement PLangRegisterPerson;
		
		//---Marital Status ---
		@FindBy(xpath="//*[@id=\"__o3id13\"]")
		public WebElement MaritalStatusRegisterPerson;
		
		
				
		//***** Primary Mailing Address Section ***** 
		@FindBy(xpath="//*[@id=\"__o3id1e\"]")
		public WebElement PostalCodeRegisterPerson;
		
		@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[5]/div/table/tbody/tr/td[2]/span/a")
		public WebElement SearchPCodeRegisterPerson;
		
		//***** Address Detail Child Window Section ***** 
		//---Street Address ---
		@FindBy(xpath="//form[@id='mainForm']//input[@id='__o3id0']")
		public WebElement EnterStAddressRegisterPerson;
		
		//---Continue after street address ---
		@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
		public WebElement ContinueStAddressRegisterPerson;
		
		//*****Register and success ***** 
		//---Register Link ---
		@FindBy(xpath="//*[@id=\"Curam_Person_register\"]/div[1]/div[1]/div[2]/a[1]/span/span/span")
		public WebElement RegisterLinkRegisterPerson;
		
		//---Success Message and Reference number ---
		@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/table/tbody/tr[2]/td/span")
		public WebElement RefNoSuccessRegisterPerson;


}
