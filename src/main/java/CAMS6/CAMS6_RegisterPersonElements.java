package CAMS6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class CAMS6_RegisterPersonElements extends testbaseforproject{

	public CAMS6_RegisterPersonElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of the Elements to Register a Person ==============
	
	@FindBy(xpath="//*[@id=\"app-sections-container-dc_tablist\"]/div[4]/div/div[2]")
	public WebElement CasesAndOutComesTab;
	
	@FindBy(xpath="//*[@id=\"curam_layout_ExpandoPane_0\"]/div[1]")
	public WebElement ExpandArrow;
	
	@FindBy(xpath="//*[@id=\"dijit_layout_AccordionPane_0\"]/ul/li[1]/a")
	public WebElement RegisterPersonLeftPanelButton;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_searchPerson\"]/div[1]/div[1]/div[1]/h1/span")
	public WebElement RegisterPersonTabOpenText;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement LastnameField;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement FirstnameField;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]")
	public WebElement SearchButton;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[3]") 
	public WebElement ContinueButton;
	
	@FindBy(xpath="//*[@id=\"Curam_Person_register\"]/div[1]/div[1]/div[1]/h1/span") 
	public WebElement RegisterPersonTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id9\"]")
	public WebElement IdentityField;
	
	@FindBy(xpath="//*[@id=\"__o3idd\"]")
	public WebElement RegistrationDate;
	
	@FindBy(xpath="//*[@id=\"__o3idf\"]")
	public WebElement StatusInCanadaField;
	
	@FindBy(xpath="//*[@id=\"__o3id11\"]")
	public WebElement PreferLanguageField;
	
	@FindBy(xpath="//*[@id=\"__o3id13\"]")
	public WebElement MaritalStatusField;
	
	@FindBy(xpath="//*[@id=\"__o3id7\"]")
	public WebElement APPRID;
	
	@FindBy(xpath="//*[@id=\"__o3ida\"]")
	public WebElement DateOfBirthField;
	
	@FindBy(xpath="//*[@id=\"__o3id12\"]")
	public WebElement SINField;
	
	@FindBy(xpath="//*[@id=\"__o3id1e\"]")
	public WebElement PostalCodeLookUpField;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[5]/div/table/tbody/tr/td[2]/span/a")
	public WebElement PostalCodeSearchButton;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement StreetNumberField;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement AddressDetailsContinueButton;
	
	@FindBy(xpath="//*[@id=\"Curam_Person_register\"]/div[1]/div[1]/div[2]/a[1]/span/span/span")
	public WebElement RegisterButton;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCUPerson_registrationComplete\"]/div[1]/div/div[1]/h1/span")
	public WebElement RegistrationCompletedTxt;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr/td/span/a")
	public WebElement EmploymentOntarioLink;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/table/tbody/tr[2]/td/span")
	public WebElement CLientReferenceNum;
	
	@FindBy(xpath="//*[contains(@id,\"WorkspaceSection-stc_tablist_dojox_layout_ContentPane_2_tabLabel\")]")
	public WebElement EmploymentOntarioTab;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[1]/td[1]")
	public WebElement EmploymentOntarioCaseReference;
	
	@FindBy(xpath="//*[contains(@id,\"WorkspaceSection-stc_tablist\")]/div[4]/div/div[2]/div/div/div/span[2]")
	public WebElement CloseEO;
	
	@FindBy(xpath="//*[contains(@id,\"WorkspaceSection-stc_tablist\")]/div[4]/div/div/div/div/div/span[2]")
	public WebElement CloseRegisterPerson;
	
	@FindBy(xpath="//*[@id=\"error-messages\"]/li/div")
	public WebElement ErrorMessageAPPRPartyIDExsits;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td[1]/a")
	public WebElement ClientCaseLink;
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement PersonHomeTxt;
	
	@FindBy(xpath="//*[contains(@id,\"FinancialGroup_tabLabel\")]")
	public WebElement FinancialsTab;
	
	@FindBy(xpath="//*[@id=\"FinancialGroup-BankAccounts\"]/div")
	public WebElement BankAccountsTab;
	
	@FindBy(xpath="//*[@id=\"Curam_Person_listBankAccount\"]/div[1]/div/div[1]/h1/span")
	public WebElement BankAccountsTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_Person_listBankAccount\"]/div[1]/div/div[2]/a")
	public WebElement BankAccountsNewButton;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[2]/div/div")
	public WebElement BankAccountsDetailsTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement BankAccountsName;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement BankAccountsNumber;
	
	@FindBy(xpath="//*[@id=\"__o3fwp.ACTION.details$participantBankAccountDetails$bankBranchID_a\"]/img")
	public WebElement BankBranchLookupGlass;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement BankFrom;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement BankSaveButton;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement BankSearchTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement BankInstitutionNumber;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement BankNumber;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement BankSearchButton;
	
	@FindBy(xpath="//*[contains(@id,\"sortable_N\")]/tbody/tr/td[1]/span/a/span/span/span")
	public WebElement BankSelectButton;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement ReEnterAccountNumber;
	
	@FindBy(xpath="//*[@id=\"Curam_Participant_reEnterBankAccount\"]/div[1]/div[1]/div[2]/a[1]/span/span/span")
	public WebElement SaveAccountButton;
	
	@FindBy(xpath="//*[@id=\"dijit_layout_AccordionPane_0\"]/ul/li[7]/a")
	public WebElement FindPersonLeftPanel;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement PersonReferenceNumber;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement PersonSearchButton;
	
	@FindBy(xpath="//*[contains(id,\"sortable_N\")]/tbody/tr/td[1]/a")
	public WebElement PersonSelectButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[7]/td[1]/span")
	public WebElement HomeDeliveryPatternTxt;
	
	@FindBy(xpath="//*[contains(id,\"Home_tabLabel\")]")
	public WebElement HomeTab;
}
