package CURAM7SP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class SPElements extends testbaseforproject {
	public SPElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"page-level-action-menu\"]")
	//*[@id="page-level-action-menu"]
	public WebElement EOActionButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_6\"]")
	public WebElement newServicePlan;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement selectProgram;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement referredIn;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement SDS;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement selfInitiated;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]")
	public WebElement saveButton;
	
	@FindBy(xpath="//*[contains(@id, 'Contracts_tabLabel')]")
	public WebElement planSummaryTab;
	
	@FindBy(xpath="//*[@id=\"Curam_ServicePlanDelivery_listContracts\"]/div[1]/div/div[2]/a")
	public WebElement newPlanSummary;
	
	@FindBy(xpath="//*[@id=\"sortable_N24FAA\"]/tbody/tr/td[1]/span/a")
	public WebElement selectButton;
	
	@FindBy(xpath="//*[@id=\"Curam_ServicePlanDelivery_viewContractHome\"]/div[1]/div/div[2]/span/span")
	public WebElement planSummaryActionButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_1\"]")
	public WebElement editPlanSummary;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement dateAccepted;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]")
	public WebElement planSummarySaveButton;
	
//	@FindBy(xpath="//*[contains(@id, 'curam_ModalDialog')]")
//	public WebElement ModalDialogTxt;
	
	@FindBy(xpath="//*[@id=\"bodyTitle\"]/span")
	public WebElement HomeTxt;
	
	@FindBy(xpath="//*[@id=\"MTCUSPMGRWorkspaceSection-stc_tablist\"]/div[4]/div/div[1]/div/div/div/span[2]")
	public WebElement closeEO;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[1]/td[2]")
	public WebElement planRefNum;
	
	@FindBy(xpath="//*[@id=\"__o3.appsearch.searchText\"]")
	public WebElement ReferenceNumberSearchField;
	
	@FindBy(xpath="//*[@id=\"__o3.appsearch.search-btn\"]/img")
	public WebElement ReferenceNumberLookUpGlassButton;
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h3/span")
	public WebElement PopupWindowTextDetails;
	//*[@id="mainForm"]/div/div[1]/div/div/h3/span
	
	@FindBy(xpath="//*[@id=\"N24A19-1-1\"]/span")
	public WebElement PlanSummaryConfirmLabel;
	
}
