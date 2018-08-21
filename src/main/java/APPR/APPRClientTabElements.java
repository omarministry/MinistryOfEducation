package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRClientTabElements extends testbaseforproject{

	public APPRClientTabElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of Client Tabs Elements ==============
	
		//--- Elements under tabs navigation bar---
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[2]/form/input[5]") 
		public WebElement APPRClientGeneralTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[3]/form/input[5]") 
		public WebElement APPRClientProgramParticipationTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[4]/form/input[5]") 
		public WebElement APPRClientTATab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[5]/form/input[5]") 
		public WebElement APPRClientSkillsTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[6]/form/input[5]") 
		public WebElement APPRClientSchoolingTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[7]/form/input[5]") 
		public WebElement APPRClientReportableSubjectsTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[8]/form/input[5]") 
		public WebElement APPRClientReviewNotesTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[9]/form/input[5]") 
		public WebElement APPRClientRecognitionsTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[10]/form/input[5]") 
		public WebElement APPRClientMonitorTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[11]/form/input[5]") 
		public WebElement APPRClientExamsTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[12]/form/input[5]") 
		public WebElement APPRClientDocsTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[13]/form/input[5]") 
		public WebElement APPRClientFeeTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[14]/form/input[5]") 
		public WebElement APPRClientWorkItemTab;
		
		@FindBy(xpath="//*[@id=\"tabBarcontent\"]/tbody/tr/td[15]/form/input[5]") 
		public WebElement APPRClientCompletionTab;
		
		
		//============= xPaths of Client Tabs Elements ==============
		
		//--- Elements under General Tab ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td") 
		public WebElement APPRClientGeneralTxt;
		
		//--- Elements under Program Participation tab---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientProgramParticipationTxt;
		
		@FindBy(xpath="//*[@id=\"select2\"]") 
		public WebElement APPRClientProgramParticipationCheckbox;
		
		@FindBy(xpath="//*[@id=\"what\"]/option[5]") 
		public WebElement APPRClientProgramParticipationAddTAOption;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[4]/tbody/tr/td[3]/input") 
		public WebElement APPRClientProgramParticipationGoButton;
		
		//--- Elements under Add New Training Agreement ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/fieldset/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientPPAddNewTATxt;
		
		@FindBy(xpath="//*[@id=\"generatePrintableTA_yes\"]") 
		public WebElement APPRClientPPAddNewTAYesRadioButton;
		
		@FindBy(xpath="//*[@id=\"new\"]") 
		public WebElement APPRClientPPAddNewTANumber;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/fieldset/form/table[6]/tbody/tr[3]/td[4]/input") 
		public WebElement APPRClientPPAddNewTASearchSponsorButton;
		
		@FindBy(xpath="//*[@name=\"employedDate.day\"]") 
		public WebElement APPRClientPPAddNewTADayofEmployed;
		
		@FindBy(xpath="//*[@name=\"employedDate.month\"]") 
		public WebElement APPRClientPPAddNewTAMonthofEmployed;
		
		@FindBy(xpath="//*[@name=\"employedDate.year\"]") 
		public WebElement APPRClientPPAddNewTAYearofEmployed;
		
		@FindBy(xpath="//*[@name=\"registrationDate.day\"]") 
		public WebElement APPRClientPPAddNewTADayofReg;
		
		@FindBy(xpath="//*[@name=\"registrationDate.month\"]") 
		public WebElement APPRClientPPAddNewTAMonthofReg;
		
		@FindBy(xpath="//*[@name=\"registrationDate.year\"]") 
		public WebElement APPRClientPPAddNewTAYearofReg;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/input") 
		public WebElement APPRClientPPAddNewTASaveButton;
		
		@FindBy(xpath="/html/body/table[4]/tbody/tr/td[3]/a[3]") 
		public WebElement APPRClientPPNav;
		
		//--- Elements under Search Sponsor ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td") 
		public WebElement APPRClientPPAddNewTASponsorTxt;		
		
		@FindBy(xpath="//*[@id=\"id\"]") 
		public WebElement APPRClientPPAddNewTASponsorIDField;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr/td[1]/input") 
		public WebElement APPRClientPPAddNewTASponsorSearchButton;//1013563
		
		@FindBy(xpath="//*[@id=\"0\"]") 
		public WebElement APPRClientPPAddNewTASponsorSearchRadioButton;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr/td/input") 
		public WebElement APPRClientPPAddNewTASponsorSearchReturnButton;
		
		//--- Elements under TA tab ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientTATxt;
		
		@FindBy(xpath="//*[@id=\"select2\"]") 
		public WebElement APPRClientTACheckbox;
		
		@FindBy(xpath="//*[@id=\"what\"]/option[10]") 
		public WebElement APPRClientTARegisterOption;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[4]/tbody/tr/td[3]/input") 
		public WebElement APPRClientTAGoButton;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[4]/tbody/tr[11]/td[2]/select/option[2]") 
		public WebElement APPRClientTAConsultantSelection;
		
		@FindBy(xpath="//*[@id=\"saveButton\"]") 
		public WebElement APPRClientTASaveButton;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[8]/tbody/tr[3]/td[3]/a") 
		public WebElement APPRClientTAStatus;
		
		@FindBy(xpath="/html/body/table[4]/tbody/tr/td[3]/a[3]") 
		public WebElement APPRClientTANav;
		
}
