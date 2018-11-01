package CAMS6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class CAMS6_PDCElements extends testbaseforproject{
	
	public CAMS6_PDCElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"__o3.appsearch.searchText\"]")
	public WebElement ReferenceNumberSearchField;
	
	@FindBy(xpath="//*[@id=\"__o3.appsearch.search-btn\"]")
	public WebElement ReferenceNumberLookUpGlassButton;
	
	@FindBy(xpath="//*[@id=\"Curam_ICSample_home\"]/div[1]/div/div[1]/h1/span")
	public WebElement HomeTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_Program_home\"]/div[1]/div/div[1]/h1/span")
	public WebElement ProgramHomeTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_APPRProgram_home\"]/div[1]/div/div[1]/h1/span")
	public WebElement APPRProgramHomeTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_ICSample_home\"]/div[1]/div/div[2]/span/span")
	public WebElement EoEditActionButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_3_text\"]")
	public WebElement EONewProductOption;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/div/h2/span")
	public WebElement ProductTxt;
	
	@FindBy(xpath="//*[@id=\"sortable_N22F4D\"]/tbody/tr[1]/td[1]/span/a")
	public WebElement ApprenticeshipSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N22F4D\"]/tbody/tr[2]/td[1]/span/a")
	public WebElement FeepayerSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N22F4D\"]/tbody/tr[3]/td[1]/span/a")
	public WebElement SecondCareerSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N22F4D\"]/tbody/tr[4]/td[1]/span/a")
	public WebElement JCPSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N22F4D\"]/tbody/tr[5]/td[1]/span/a")
	public WebElement ACBSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N22F4D\"]/tbody/tr[6]/td[1]/span/a")
	public WebElement ECBSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N22F4D\"]/tbody/tr[7]/td[1]/span/a")
	public WebElement SNEBSelectButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr/td/div/div/div/h2/span")
	public WebElement DeliveryPatternTxt;
	
	@FindBy(xpath="//*[@id=\"sortable_N22FC9\"]/tbody/tr[1]/td[1]/span/a[2]")
	public WebElement EFTSelectActionButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N22FC9\"]/tbody/tr[2]/td[1]/span/a[2]")
	public WebElement CheqSelectActionButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N22FC9\"]/tbody/tr/td[1]/span/a[2]")
	public WebElement ECBCheqSelectActionButton;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement CreateDeliveryTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement CreateDeliveryStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement CreateDeliveryDateReceived;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement CreateDeliveryExpectedEndDate;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[2]/span/span/span")
	public WebElement CreateDeliveryButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td[2]")
	public WebElement PDCCaseReference;
	
	@FindBy(xpath="//*[contains(@id, 'Evidence_tabLabel')]")
	public WebElement EvidenceTab;
	
	@FindBy(xpath="//*[contains(@id,\"evidenceSiteMap\")]/div[1]/div[1]/div[1]/h1/span")
	public WebElement SiteMapTxt;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[1]/td[2]/span/a")
	public WebElement EmploymentInsuranceEvidence;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listEmploymentInsuranceProductEvidence\"]/div[1]/div/div[1]/h1/span")
	public WebElement EmploymentInsuranceEvidenceWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listEmploymentInsuranceProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement EmploymentInsuranceNewButton;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement EmploymentInsuranceTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement EmploymentInsuranceVerificationDate;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement EmploymentInsuranceClaimStatus;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement EmploymentInsuranceClaimStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement EmploymentInsuranceClaimEndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement EmploymentInsuranceGrossAmount;
	
	@FindBy(xpath="//*[@id=\"__o3id1\" and @title=\"Section 25 Referral Complete?\"]")
	public WebElement EmploymentInsuranceSection25;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement EmploymentInsuranceSaveButton;
	
	@FindBy(xpath="//*[@id=\"Evidence-MTCU_Evidence_resolveSiteMap\"]/div")
	public WebElement EmploymentInsuranceSiteMap;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[3]/td[2]/span/a")
	public WebElement TrainingEvidence;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMTCUTrainingProductEvidence\"]/div[1]/div/div[1]/h1/span")
	public WebElement TrainingEvidenceWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMTCUTrainingProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement TrainingEvidenceNewButton;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement TrainingEvidenceTxt;
	
	@FindBy(xpath="//*[@id=\"__o3fwp.ACTION.dtls$dtls$concernRoleID_a\"]/img")
	public WebElement TrainingInstitteLookupGlass;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement EducationalInstituteTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement EducationalInstituteName;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement EducationalInstituteSearchButton;
	
	@FindBy(xpath="//*[contains(@id, \"sortable_N\")]/tbody/tr/td[1]/span/a/span/span/span")
	public WebElement EducationalInstituteSelectButton;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement TrainingEvidenceProgramStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement TrainingEvidenceFullTime;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement TrainingEvidenceNOC;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement TrainingEvidenceProgramName;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement TrainingEvidenceProgramEndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement TrainingEvidenceProgramLanguage;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement TrainingEvidenceProgramDescription;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement TrainingEvidenceSaveButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[5]/td[2]/span/a")
	public WebElement BenefitLink;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[3]/td[2]/span/a")
	public WebElement BenefitLinkJCP;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr/td[2]/span/a")
	public WebElement BenefitLinkACB;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]/td[2]/span/a")
	public WebElement BenefitLinkECB;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMTCUBenefitProductEvidence\"]/div[1]/div/div[1]/h1/span")
	public WebElement BenefitWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMTCUBenefitProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement BenefitNewButton;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[2]/div/div/h2/span")
	public WebElement BenefitTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement BenefitType;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement BenefitPaymentType;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement BenefitAmount;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement BenefitStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement BenefitStartDateSNEB;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement BenefitStartDateLumpSum;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement BenefitEndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement BenefitEndDateSNEB;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement BenefitEndDateLumpSum;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement BenefitSaveButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[7]/td[2]/span/a")
	public WebElement MultiYearForecastingLink;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[9]/td[2]/span/a")
	public WebElement MultiYearForecastingLinkSC;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMultiYearForecastingProductEvidence\"]/div[1]/div/div[1]/h1/span")
	public WebElement MultiYearForecastingWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement MultiYearForecastingTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMultiYearForecastingProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement MultiYearForecastingNewButton;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement MultiYearForecastingAmount;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement MultiYearForecastingSaveButton;
	
	@FindBy(xpath="//*[@id=\"Evidence-ICSportingGrantSample_listUserRole\"]/div")
	public WebElement UserRolesLink;
	
	@FindBy(xpath="//*[@id=\"Curam_ICSportingGrantSample_listUserRole\"]/div[1]/div/div[1]/h1/span")
	public WebElement UserRolesTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_ICSportingGrantSample_listUserRole\"]/div[1]/div/div[2]/a")
	public WebElement NewSupervisorButton;
	
	@FindBy(xpath="//*[@id=\"__o3fwp.ACTION.details$mtcuUserName$mtcuUserName_a\"]/img")
	public WebElement NewSupervisorLoopupGlass;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement SupervisorFirstname;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement SupervisorLastname;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement SupervisorSearchButton;
	
	@FindBy(xpath="//*[contains(@id, \"sortable_N\")]/tbody/tr[2]/td[1]/span/a/span/span/span")
	public WebElement SupervisorSelectButtonSecondOption;
	
	@FindBy(xpath="//*[contains(@id, \"sortable_N\")]/tbody/tr[1]/td[1]/span/a/span/span/span")
	public WebElement SupervisorSelectButtonFirstOption;
	
	@FindBy(xpath="//*[contains(@id, \"sortable_N\")]/tbody/tr/td[1]/span/a/span/span/span")
	public WebElement SupervisorSelectButtonSingle;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement SupervisorSaveButton;
	
	@FindBy(xpath="//*[contains(@id,\"_evidenceSiteMap\")]/div[1]/div[1]/div[2]/span/span")
	public WebElement SiteMapActionMenu;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0_text\"]")
	public WebElement ApplyEvidenceOption;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_1_text\"]")
	public WebElement ApproveEvidenceOption;
	
	@FindBy(xpath="//*[contains(@id, \"curam_ModalDialog_\")]")
	public WebElement ModalDialogTxt;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[2]/div/div/h2/span")
	public WebElement EvidenceTxt;
	
	@FindBy(xpath="//*[@id=\"__o3mswa.ACTION.tabbedList$details$newAndUpdateList\"]")
//	@FindBy(xpath="//input[@class=\"curam-checkbox\" and @title=\"Select/Deselect all rows\"]")
	public WebElement AllEvidenceCheckbox;
	
	@FindBy(xpath="//*[@id=\"__o3mswa.ACTION.details$details$pendingApprovalList\"]")
	public WebElement PendingApprovalEvidenceCheckbox;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement ApplyApproveEvidenceButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[7]/td[2]/span/a")
	public WebElement ClientContributionLink;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listClientContributionProductEvidence\"]/div[1]/div/div[1]/h1/span")
	public WebElement ClientContributionWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement ClientContributionTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listClientContributionProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement ClientContributionNewButton;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement ClientContributionType;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement ClientContributionAmount;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement ClientContributionSaveButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[5]/td[2]/span/a")
	public WebElement JCPLink;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listJobCreationPartnershipProductEvidence\"]/div[1]/div/div[1]/h1/span")
	public WebElement JCPWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement JCPTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listJobCreationPartnershipProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement JCPNewButton;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement JCPContractNumber;
	
	@FindBy(xpath="//*[@id=\"__o3fwp.ACTION.dtls$dtls$seCoordinator_a\"]/img")
	public WebElement JCPEmployer;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement ServiceDeliverySiteTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement ServiceDeliverySiteRefNum;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement ServiceDeliverySiteSearchButton;
	
	@FindBy(xpath="//*[contains(@id, \"sortable_N\")]/tbody/tr/td[1]/span/a/span/span/span")
	public WebElement ServiceDeliverySiteSelectButton;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement JCPSaveButton;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement TOSSCode;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[1]/td[2]/span/a")
	public WebElement ApprenticeshipLink;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMTCUAPPREmployerProductEvidence\"]/div[1]/div/div[1]/h1/span")
	public WebElement ApprenticeshipWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[2]/div/div/h2/span")
	public WebElement ApprenticeshipTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMTCUAPPREmployerProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement ApprenticeshipNewButton;
	
	@FindBy(xpath="//*[@id=\"__o3fwp.ACTION.dtls$dtls$employerConcernRoleID_a\"]/img")
	public WebElement ApprenticeshipEmployerLookupGlass;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement ApprenticeshipCertificationDate;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement ApprenticeshipTANumber;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement ApprenticeshipReceivedDate;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement ApprenticeshipSaveButton;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement AAPPREmployerPartyID;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement AAPPREmployerSearchButton;
	
	@FindBy(xpath="//*[contains(@id, \"sortable_N\")]/tbody/tr/td[1]/span/a/span/span/span")
	public WebElement AAPPREmployerSelectButton;
	
	@FindBy(xpath="//*[@id=\"curam_widget_DropDownButton_0_label\"]/img")
	public WebElement PersonMenu;
	
	@FindBy(xpath="//*[@id=\"app-banner\"]/div[2]/div[2]/ul/li[2]/a")
	public WebElement LogoutButton;
	
	@FindBy(xpath="//*[contains(@id,\"Financials_tabLabel\")]")
	public WebElement FinancialTab;
	
	@FindBy(xpath="//*[@id=\"Financials-ICProduct_listNominee\"]/div")
	public WebElement NomineesTab;
	
	@FindBy(xpath="//*[@id=\"Curam_ICProduct_listNominee\"]/div[1]/div/div[1]/h1/span")
	public WebElement NomineesTxt;
	
	@FindBy(xpath="//*[contains(@id,\"list-actions-menu-N\")]")
	public WebElement NomineesActionMenu;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_1_text\"]")
	public WebElement NomineesChangeBankAccountAction;
	
	@FindBy(xpath="//*[contains(@id, \"sortable_N\")]/tbody/tr[1]/td[2]/span/a")
	public WebElement NomineesChangeBankAccountSelectButton;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement NomineesChangeBankAccountConfirmButton;
	
	@FindBy(xpath="//*[contains(@id,\"Home_tabLabel\")]")
	public WebElement HomeTab;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_APPRProgram_home\"]/div[1]/div/div[2]/span/span")
	public WebElement HomeActionMenu;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_Program_home\"]/div[1]/div/div[2]/span/span")
	public WebElement HomePageAction;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_2_text\"]")
	public WebElement ActivateButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_3_text\"]")
	public WebElement ActivateButton2;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_2_text\"]")
	public WebElement SubmitApprovealButton;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/table/tbody/tr/td")
	public WebElement ActivateTxt;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement ActivateYesButton;
	
	@FindBy(xpath="//*[@class=\"refresh enabled\"]")
	public WebElement RefreshButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[1]/td[2]")
	public WebElement CaseStatus;
	
	@FindBy(xpath="//*[contains(@id,\"Contracts_tabLabel\")]")
	public WebElement ContractsTab;
	
	@FindBy(xpath="//*[@id=\"Curam_ProductDelivery_listContracts\"]/div[1]/div/div[1]/h1/span")
	public WebElement ContractsTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_ProductDelivery_listContracts\"]/div[1]/div/div[2]/a")
	public WebElement ContractsNewButton;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h2/span")
	public WebElement ContractsDetailsTxt;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement ContractsSaveButton;
	
	@FindBy(xpath="//*[contains(@id,\"list-actions-menu-N\")]")
	public WebElement ContractsActionMenu;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0_text\"]")
	public WebElement ContractsEditOption;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement ContractsDateSigned;
	
	@FindBy(xpath="//*[contains(@id,\"sortable_N\")]/tbody/tr[1]/td[5]")
	public WebElement ContractsStatus;
	
	@FindBy(xpath="//*[contains(@id,\"ListMonitors_tabLabel\")]")
	public WebElement MonitorsTab;
	
	@FindBy(xpath="//*[contains(@id,\"_ListMonitors\")]/div[1]/div/div[1]/h1/span")
	public WebElement MonitorsText;
	
	@FindBy(xpath="//div[@class='title-exists  action-exists']/div[3]/div/table/tbody/tr[1]/td[6]")
	public WebElement MonitorsActionInitial;
	
	@FindBy(xpath="//div[@class='title-exists  action-exists']/div[3]/div/table/tbody/tr[3]/td[6]")
	public WebElement MonitorsActionFinal;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0_text\"]")
	public WebElement MonitorsInitalRecordOption;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_1_text\"]")
	public WebElement MonitorsFinalRecordOption;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[2]/div/div/h2/span")
	public WebElement MonitorsClientInfoTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement MonitorsScheduleDate;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement MonitorsSaveButton;
	
	@FindBy(xpath="//*[contains(@id,\"__o3uid\") and @class='refresh enabled']")
	public WebElement MonitorRefreshButton;

}
