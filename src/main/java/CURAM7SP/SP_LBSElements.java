package CURAM7SP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class SP_LBSElements extends testbaseforproject {
	public SP_LBSElements (WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"mainForm\"]/div/div[1]/div/div/h3/span")
	public WebElement ClientSummaryTxt;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement LanguageSpokenAtHome;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement ServiceProvisionLanguage;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement LanguageSponkenAtLastWorkplace;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement SourceOfIncome;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement HighestLevelOfEducation;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement CountryHighestLevelOfEduCompleted;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement TimeOutOfFormalEducation;
	
	@FindBy(xpath="//*[@id=\"__o3id8\"]")
	public WebElement HistoryOfInterruptedEducation;
	
	@FindBy(xpath="//*[@id=\"__o3id7\"]")
	public WebElement TimeOutOfTraining;
	
	@FindBy(xpath="//*[@id=\"__o3id9\"]")
	public WebElement LabourForceAttachment;
	
	@FindBy(xpath="//*[@id=\"__o3idb\"]")
	public WebElement RegisteredApprentice;
	
	@FindBy(xpath="//*[@id=\"__o3ida\"]")
	public WebElement EmploymentExperience;
	
	@FindBy(xpath="//*[@id=\"__o3idc\"]")
	public WebElement TimeOutOfWork;
	
	@FindBy(xpath="//*[@id=\"__o3idd\"]")
	public WebElement EntryAssessmentTool;
	
	@FindBy(xpath="//*[@id=\"__o3ide\"]")
	public WebElement EstimatedLearnerWeeklyTimeCommitment;
	
	@FindBy(xpath="//*[@id=\"__o3id10\"]")
	public WebElement DateOfAssessment;
	
	@FindBy(xpath="//*[@id=\"__o3id15\"]")
	public WebElement Speaking;
	
	@FindBy(xpath="//*[@id=\"__o3id17\"]")
	public WebElement Listening;
	
	@FindBy(xpath="//*[@id=\"__o3id16\"]")
	public WebElement Reading;
	
	@FindBy(xpath="//*[@id=\"__o3id18\"]")
	public WebElement Writing;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCUServicePlanDelivery_listPlanContent\"]/div[1]/div/div[2]/a")
	public WebElement NewSubGoalButton;
	
	@FindBy(xpath="//div[@class='list list-with-header is-uncollapsed']/div/table/tbody/tr[td='Training Supports']/td[1]/span")
	public WebElement TrainingSupportSelectButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Training Supports']/td[7]")
	public WebElement TrainingSupportsActionButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0_text\"]")
	public WebElement SubGoalAddPlanItem;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_1_text\"]")
	public WebElement EditSubGoalButton;
	
	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @class=\"curam-checkbox\" and @title=\"Plan Items - Select this row - Custom Basic Plan Item\"]/parent::span")
	public WebElement CustomeBasicPlanItemCheckbox;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement ContinueAndSaveButton;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement EstimatedCost;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement ExpectedOutcome;
	
	@FindBy(xpath="//*[@id=\"__o3id9\"]")
	public WebElement DeliveryMethod;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Training Supports']/td[1]")
	public WebElement TrainingSupportsExpand;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Training Supports']/td[5]")
	public WebElement TrainingSupportsStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Training Supports']/td[6]")
	public WebElement TrainingSupportsOutcome;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Custom Basic Plan Item']/td[9]")
	public WebElement CustomBasicPlanItemActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Placement with Incentives - General']/td[8]")//*[@id="sortable_N20A4F"]/tbody/tr[1]/td[8]
	public WebElement PlacementWithIncentiveActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Career development/career exploration']/td[8]")//*[@id="sortable_N20A4F"]/tbody/tr[1]/td[8]
	public WebElement CareerDevelopmentActionButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0_text\"]")
	public WebElement EditPlanItemButton;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement CustomBasicActualStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement CustomBasicActualEndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id7\"]")
	public WebElement CustomBasicActualCost;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement CustomBasicOutcome;
	
	@FindBy(xpath="//div[@class='page-header']/div/div[3]/a")
	public WebElement RefreshButton;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement SubGoalOutcome;

	
	

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
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement HasTheGoalPathCompleted;
	
	@FindBy(xpath="//*[@id=\"__o3idc\"]")
	public WebElement HasLearnerSuccessfulCompleted;
	
	@FindBy(xpath="//*[@id=\"__o3idd\"]")
	public WebElement EmploymentSituationImproved;
	
	@FindBy(xpath="//*[@id=\"__o3idf\"]")
	public WebElement BetterPrepareToFindEmployment;
	
	@FindBy(xpath="//*[@id=\"__o3id11\"]")
	public WebElement DevelopedIncreasedSkills;
	
	@FindBy(xpath="//*[@id=\"__o3ide\"]")
	public WebElement CloseHourPerWeek;
	
	@FindBy(xpath="//*[@id=\"__o3id10\"]")
	public WebElement CloseWage;
	
	@FindBy(xpath="//*[@id=\"__o3id12\"]")
	public WebElement CloseWagePer;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_2\"]")
	public WebElement SubmitForApproval;

	@FindBy(xpath="//*[@id=\"N211E3-1-1\"]/span")
	public WebElement ClientSummaryConfirmLabel;
	
	@FindBy(xpath="//*[@id=\"N2775F-3-1\"]/span")
	public WebElement ModifyPlanItemConfirmLabel;
	
	@FindBy(xpath="//*[@id=\"N26BD2-2-1\"]/span")
	public WebElement ModifySubGoalConfirmLabel;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td[2]")
	public WebElement ServicePlanStatus;
}



