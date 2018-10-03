package CURAM7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class PDCElements extends testbaseforproject{
	
	public PDCElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"__o3.appsearch.searchText\"]")
	public WebElement ReferenceNumberSearchField;
	
	@FindBy(xpath="//*[@id=\"__o3.appsearch.search-btn\"]/img")
	public WebElement ReferenceNumberLookUpGlassButton;
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement HomeTxt;
	
	@FindBy(xpath="//*[@id=\"page-level-action-menu\"]")
	public WebElement EoEditActionButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_3_text\"]")
	public WebElement EONewProductOption;
	
	@FindBy(xpath="//*[@id=\"sortable_N24447\"]/tbody/tr[1]/td[1]/span/a")
	public WebElement ApprenticeshipSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N24447\"]/tbody/tr[2]/td[1]/span/a")
	public WebElement FeepayerSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N24447\"]/tbody/tr[3]/td[1]/span/a")
	public WebElement SecondCareerSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N24447\"]/tbody/tr[4]/td[1]/span/a")
	public WebElement JCPSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N24447\"]/tbody/tr[5]/td[1]/span/a")
	public WebElement ACBSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N24447\"]/tbody/tr[6]/td[1]/span/a")
	public WebElement ECBSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N24447\"]/tbody/tr[7]/td[1]/span/a")
	public WebElement SNEBSelectButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N244C3\"]/tbody/tr[1]/td[1]/span/a[2]")
	public WebElement EFTSelectActionButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N244C3\"]/tbody/tr[2]/td[1]/span/a[2]")
	public WebElement CheqSelectActionButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N244C3\"]/tbody/tr/td[1]/span/a[2]")
	public WebElement ECBCheqSelectActionButton;
	
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
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]")
	public WebElement SiteMapTxt;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[1]/td[2]/span/a")
	public WebElement EmploymentInsuranceEvidence;
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement EmploymentInsuranceEvidenceWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listEmploymentInsuranceProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement EmploymentInsuranceNewButton;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement EmploymentInsuranceVerificationDate;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement EmploymentInsuranceClaimStatus;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement EmploymentInsuranceClaimStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement EmploymentInsuranceGrossAmount;
	
	@FindBy(xpath="//*[@for=\"__o3id1\" and @class=\"checkbox-touchable-area\" and @title=\"Section 25 Referral Complete?\"]")
	public WebElement EmploymentInsuranceSection25;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement EmploymentInsuranceSaveButton;
	
	@FindBy(xpath="//*[@id=\"Evidence-MTCU_Evidence_resolveSiteMap\"]/div")
	public WebElement EmploymentInsuranceSiteMap;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[3]/td[2]/span/a")
	public WebElement TrainingEvidence;
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement TrainingEvidenceWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMTCUTrainingProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement TrainingEvidenceNewButton;
	
	@FindBy(xpath="//*[@id=\"__o3fwp.ACTION.dtls$dtls$concernRoleID_a\"]/img")
	public WebElement TrainingInstitteLookupGlass;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement EducationalInstituteName;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement EducationalInstituteSearchButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N24AB7\"]/tbody/tr/td[1]/span/a/span/span/span")
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
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement BenefitWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMTCUBenefitProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement BenefitNewButton;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement BenefitType;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement BenefitPaymentType;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement BenefitAmount;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement BenefitStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement BenefitStartDateLumpSum;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement BenefitEndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement BenefitEndDateLumpSum;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement BenefitSaveButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[7]/td[2]/span/a")
	public WebElement MultiYearForecastingLink;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[9]/td[2]/span/a")
	public WebElement MultiYearForecastingLinkSC;
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement MultiYearForecastingWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listMultiYearForecastingProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement MultiYearForecastingNewButton;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement MultiYearForecastingAmount;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement MultiYearForecastingSaveButton;
	
	@FindBy(xpath="//*[@id=\"Evidence-ICSportingGrantSample_listUserRole\"]/div")
	public WebElement UserRolesLink;
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
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
	
	@FindBy(xpath="//*[@id=\"sortable_N203F1\"]/tbody/tr[2]/td[1]/span/a/span/span/span")
	public WebElement SupervisorSelectButtonSecondOption;
	
	@FindBy(xpath="//*[@id=\"sortable_N203F1\"]/tbody/tr[1]/td[1]/span/a/span/span/span")
	public WebElement SupervisorSelectButtonFirstOption;
	
	@FindBy(xpath="//*[@id=\"sortable_N203F1\"]/tbody/tr/td[1]/span/a/span/span/span")
	public WebElement SupervisorSelectButtonSingle;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement SupervisorSaveButton;
	
	@FindBy(xpath="//*[@id=\"page-level-action-menu\"]")
	public WebElement SiteMapActionMenu;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0_text\"]")
	public WebElement ApplyEvidenceOption;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_1_text\"]")
	public WebElement ApproveEvidenceOption;
	
	@FindBy(xpath="//*[contains(@id, \"curam_ModalDialog_\")]")
	public WebElement ModalDialogTxt;
	
	@FindBy(xpath="//*[@class=\"checkbox-touchable-area\" and @title=\"Select/Deselect all rows\"]")
	public WebElement AllEvidenceCheckbox;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement ApplyApproveEvidenceButton;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[7]/td[2]/span/a")
	public WebElement ClientContributionLink;
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement ClientContributionWorkspaceTxt;
	
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
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement JCPWorkspaceTxt;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCU_listJobCreationPartnershipProductEvidence\"]/div[1]/div/div[2]/a")
	public WebElement JCPNewButton;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement JCPContractNumber;
	
	@FindBy(xpath="//*[@id=\"__o3fwp.ACTION.dtls$dtls$seCoordinator_a\"]/img")
	public WebElement JCPEmployer;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement ServiceDeliverySiteRefNum;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement ServiceDeliverySiteSearchButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N230A0\"]/tbody/tr/td[1]/span/a/span/span/span")
	public WebElement ServiceDeliverySiteSelectButton;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
	public WebElement JCPSaveButton;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement TOSSCode;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[1]/td[2]/span/a")
	public WebElement ApprenticeshipLink;
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement ApprenticeshipWorkspaceTxt;
	
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
	
	@FindBy(xpath="//*[@id=\"sortable_N201C6\"]/tbody/tr/td[1]/span/a/span/span/span")
	public WebElement AAPPREmployerSelectButton;
}
