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
		
		//============= xPaths of Schooling Tabs Elements ==============
		
		//--- Elements under Schooling page ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientSchoolingTxt;
		
		@FindBy(xpath="//*[@id=\"what\"]/option[3]") 
		public WebElement APPRClientSchoolingScheduleClassOption;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[4]/tbody/tr/td[3]/input") 
		public WebElement APPRClientSchoolingGoButton;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[14]/tbody/tr[3]/td[2]/a") 
		public WebElement APPRClientSchoolingClassLink;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[14]/tbody/tr[11]/td[3]/a") 
		public WebElement APPRClientSchoolingStatusOffered;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[12]/tbody/tr[11]/td[3]/a") 
		public WebElement APPRClientSchoolingStatusCompleted;
		
		//--- Elements under Class Search page ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td") 
		public WebElement APPRClientSchoolingClassSearchTxt;
		
		@FindBy(xpath="//*[@id=\"class\"]") 
		public WebElement APPRClientSchoolingClassIDField;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr[2]/td[1]/input") 
		public WebElement APPRClientSchoolingClassSearchButton;
		
		@FindBy(xpath="//*[@id=\"0\"]") 
		public WebElement APPRClientSchoolingClassRadioButton;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[9]/tbody/tr/td/input") 
		public WebElement APPRClientSchoolingClassReturnButton;
		
		//--- Elements under View Class list page ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[1]/table[1]/tbody/tr/td") 
		public WebElement APPRClientSchoolingClassListTxt;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[1]/table[4]/tbody/tr/td[2]/select/option[5]") 
		public WebElement APPRClientSchoolingClassStatusOffered;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[1]/table[4]/tbody/tr/td[2]/select/option[4]") 
		public WebElement APPRClientSchoolingClassStatusConfirmed;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[1]/table[4]/tbody/tr/td[2]/select/option[8]") 
		public WebElement APPRClientSchoolingClassStatusEnrolled;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[1]/table[4]/tbody/tr/td[2]/select/option[9]") 
		public WebElement APPRClientSchoolingClassStatusValidated;
		
		@FindBy(xpath="//*[@id=\"what\"]/option[3]") 
		public WebElement APPRClientSchoolingClassConfirmOption;
		
		@FindBy(xpath="//*[@id=\"what\"]/option[4]") 
		public WebElement APPRClientSchoolingClassEnrollOption;
		
		@FindBy(xpath="//*[@id=\"what\"]/option[16]") 
		public WebElement APPRClientSchoolingClassValidateOption;
		
		@FindBy(xpath="//*[@id=\"what\"]/option[11]") 
		public WebElement APPRClientSchoolingClassPassOption;
		
		@FindBy(xpath="//*[@id=\"participant0\"]") 
		public WebElement APPRClientSchoolingClassClientSelectCheckbox;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[1]/table[3]/tbody/tr/td[3]/input") 
		public WebElement APPRClientSchoolingClassListGoButton;

		//--- Elements under Class Change Status page ---
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td") 
		public WebElement APPRClientSchoolingClassChangeStatusTxt;
		
		@FindBy(xpath="//*[@id=\"saveButton\"]") 
		public WebElement APPRClientSchoolingClassChangeStatusSaveButton;
		
		@FindBy(xpath="/html/body/table[4]/tbody/tr/td[3]/a[4]") 
		public WebElement APPRClientSchoolingClassListNav;
		
		@FindBy(xpath="/html/body/table[4]/tbody/tr/td[3]/a[3]") 
		public WebElement APPRClientSchoolingNav;
		
		//============= xPaths of Reportable Subjects Tabs Elements ==============
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientReportableSubjectTxt;
		
		//--- Elements under Reportable Subjects Level 1 ---
		@FindBy(xpath="//*[@id=\"menu\"]/table[3]/tbody/tr/th[1]/h5/a") 
		public WebElement APPRClientRSExpandLevel1;
		
		@FindBy(xpath="//*[@id=\"foo0\"]") 
		public WebElement APPRClientRSTableLevel1;
		
		//--- Elements under Reportable Subjects Level 2 ---
		@FindBy(xpath="//*[@id=\"menu\"]/table[5]/tbody/tr/th[1]/h5/a") 
		public WebElement APPRClientRSExpandLevel2;
		
		@FindBy(xpath="//*[@id=\"foo1\"]") 
		public WebElement APPRClientRSTableLevel2;
		
		//--- Elements under Reportable Subjects Level 3 ---
		@FindBy(xpath="//*[@id=\"menu\"]/table[7]/tbody/tr/th[1]/h5/a") 
		public WebElement APPRClientRSExpandLevel3;
		
		@FindBy(xpath="//*[@id=\"foo2\"]") 
		public WebElement APPRClientRSTableLevel3;
		
		//============= xPaths of Skills Tabs Elements ==============
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
		public WebElement APPRClientSkillsTxt;
		
		@FindBy(xpath="//*[@id=\"menu\"]/table[2]/tbody/tr[2]/th/a") 
		public WebElement APPRClientSkillsSelectAll;
		
		@FindBy(xpath="//*[@id=\"what\"]/option[2]") 
		public WebElement APPRClientSkillsCompleteSkillOption;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[4]/tbody/tr/td[3]/input") 
		public WebElement APPRClientSkillsGoButton;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td") 
		public WebElement APPRClientSkillsChangeStatusTxt;
		
		@FindBy(xpath="//*[@id=\"saveButton\"]") 
		public WebElement APPRClientSkillsChangeStatusSaveButton;
		
		@FindBy(xpath="/html/body/table[4]/tbody/tr/td[3]/a[3]") 
		public WebElement APPRClientSkillsNav;
		
		@FindBy(xpath="//*[@id=\"menu\"]/table[2]/tbody/tr/td[1]") 
		public WebElement APPRClientSkillsNoneTxt;
		
		//============= xPaths of Completion Tabs Elements ==============

		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td") 
		public WebElement APPRClientCompletionTxt;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[2]/table[2]/tbody/tr[3]/td[2]/input") 
		public WebElement APPRClientCompletionTSSignedOffCheckbox;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[2]/table[2]/tbody/tr[5]/td[2]/input") 
		public WebElement APPRClientCompletionDurationMetRadioButton;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[2]/table[2]/tbody/tr[9]/td[2]/select/option[2]") 
		public WebElement APPRClientCompletionProofOfCompletionSelection;
		
		@FindBy(xpath="//*[@id=\"file\"]") 
		public WebElement APPRClientCompletionUploadButton;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[2]/table[2]/tbody/tr[11]/td[2]/input") 
		public WebElement APPRClientCompletionReviewer;
		
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form[2]/input[5]") 
		public WebElement APPRClientCompletionSaveButton;
		
}
