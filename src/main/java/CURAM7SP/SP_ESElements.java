package CURAM7SP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class SP_ESElements extends testbaseforproject {
	public SP_ESElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(@id, 'ClientSummary_tabLabel')]")
	public WebElement ClientSummaryTab;
	
	@FindBy(xpath="//*[contains(@id, 'PlanContent_tabLabel')]")
	public WebElement PlanContentTab;
	
	@FindBy(xpath="//*[contains(@id, 'home_tabLabel')]")
	public WebElement homeTab;
	
	@FindBy(xpath="//*[@id=\"Curam_ServicePlanDelivery_listClientSummary\"]/div[1]/div/div[2]/a")
	public WebElement NewClientSummary;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement InternationallyTrainedProfessional;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement LabourForce;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement CredentialsNotRecognized;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement PoorWorkHistory;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement JobSearch;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement EmploymentSkills;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement LanguageSkills;
	
	@FindBy(xpath="//*[@id=\"__o3id7\"]")
	public WebElement LabourMarket;
	
	@FindBy(xpath="//*[@id=\"__o3id8\"]")
	public WebElement EmploymentExp;
	
	@FindBy(xpath="//*[@id=\"__o3id9\"]")
	public WebElement IncomeSource;
	
	@FindBy(xpath="//*[@id=\"__o3ida\"]")
	public WebElement LevelEdu;
	
	@FindBy(xpath="//*[@id=\"__o3idb\"]")
	public WebElement EduCountry;
	
	@FindBy(xpath="//*[@id=\"__o3idc\"]")
	public WebElement TimeOutOfSchoolWork;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]")
	public WebElement Save;
	//*[@id="modal-actions-panel"]/div/a[1]
	
	@FindBy(xpath="//*[@id=\"sortable_N24072\"]/tbody/tr[1]/td[7]/span/span")
	public WebElement FirstSubGoalActionButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0\"]")
	public WebElement AddPlanItem;
	
	@FindBy(xpath="//*[@id=\"sortable_N20FEC\"]/tbody/tr[4]/td[1]/span/label[2]")
	public WebElement AttendJobInterview;
	
	@FindBy(xpath="//*[@id=\"sortable_N24072\"]/tbody/tr[1]/td[1]/a")
	public WebElement SubgoalExpand;
	
	@FindBy(xpath="//*[@id=\"sortable_N20A4F\"]/tbody/tr[1]/td[8]/span/span")
	public WebElement PlanItemActionButton;
	//*[@id="sortable_N20A4F"]/tbody/tr[1]/td[8]/span/span
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0\"]")
	public WebElement EditPlanItem;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement Outcome;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement StartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement EndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement Cost;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_2\"]")
	public WebElement EditSubgoal;

	@FindBy(xpath="//*[@id=\"Curam_MTCUServicePlanDelivery_home\"]/div[1]/div/div[2]/span/span")
	public WebElement HomeActionButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_2\"]")
	public WebElement Approval;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_2\"]")
	public WebElement ClosePlan;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement Reason;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement CustomerSatisfaction;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement CaseOutcome;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement ClientEmployedQuestion;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_2\"]")
	public WebElement SubmitForApproval;

	@FindBy(xpath="//*[@id=\"N211E3-1-1\"]/span")
	public WebElement ClientSummaryConfirmLabel;
	
	@FindBy(xpath="//*[@id=\"N2775F-3-1\"]/span")//*[@id="N2775F-3-1"]/span
	public WebElement ModifyPlanItemConfirmLabel;
	
	@FindBy(xpath="//*[@id=\"N26BD2-2-1\"]/span")
	public WebElement ModifySubGoalConfirmLabel;
}
