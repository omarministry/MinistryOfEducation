package CURAM7SP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class SP_SEElements extends testbaseforproject {
	public SP_SEElements (WebDriver driver) {
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
	public WebElement OneOnOneOnSite;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement LongTermMonitoring;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement WorksiteAccommodation;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement Motivation;
	
	@FindBy(xpath="//*[@id=\"__o3id8\"]")
	public WebElement HighestLevelOfEducation;
	
	@FindBy(xpath="//*[@id=\"__o3ida\"]")
	public WebElement HistoryOfInterruptedEducation;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement EmploymentExperience;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement TimeOutOfWork;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement NoRelavantWorkExperience;
	
	@FindBy(xpath="//*[@id=\"__o3id7\"]")
	public WebElement LabourForceAttachment;
	
	@FindBy(xpath="//*[@id=\"__o3idc\"]")
	public WebElement FamilyHouseHoldCircumstance;
	
	@FindBy(xpath="//*[@id=\"__o3idd\"]")
	public WebElement Reading;
	
	@FindBy(xpath="//*[@id=\"__o3ide\"]")
	public WebElement Thinking;
	
	@FindBy(xpath="//*[@id=\"__o3idf\"]")
	public WebElement Writing;
	
	@FindBy(xpath="//*[@id=\"__o3id10\"]")
	public WebElement OralCommunication;
	
	@FindBy(xpath="//*[@id=\"__o3id11\"]")
	public WebElement DocumentUse;
	
	@FindBy(xpath="//*[@id=\"__o3id12\"]")
	public WebElement WorkingWithOthers;
	
	@FindBy(xpath="//*[@id=\"__o3id13\"]")
	public WebElement Numeracy;
	
	@FindBy(xpath="//*[@id=\"__o3id14\"]")
	public WebElement ContinuousLearning;
	
	@FindBy(xpath="//*[@id=\"__o3id15\"]")
	public WebElement ComputerUse;
	
	@FindBy(xpath="//*[@id=\"Curam_MTCUServicePlanDelivery_listPlanContent\"]/div[1]/div/div[2]/a")
	public WebElement NewSubGoalButton;
	
	@FindBy(xpath="//*[@id=\"sortable_N21115\"]/tbody/tr[6]/td[1]/span/a")
	public WebElement EmployabilitySkillsSelectButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Client Service Planning and Coordination']/td[7]")
	public WebElement ClientServicePlanningActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Employability Skills']/td[7]")
	public WebElement EmployabilitySkillsActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Retention']/td[7]")
	public WebElement JobRetentionActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Coaching']/td[7]")
	public WebElement JobCoachingActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Search']/td[7]")
	public WebElement JobSearchActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Matching and Development']/td[7]")
	public WebElement JobMatchingAndDevelopmentActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Client Service Planning and Coordination']/td[5]")
	public WebElement ClientServicePlanningStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Employability Skills']/td[5]")
	public WebElement EmployabilitySkillsStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Retention']/td[5]")
	public WebElement JobRetentionStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Coaching']/td[5]")
	public WebElement JobCoachingStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Search']/td[5]")
	public WebElement JobSearchStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Matching and Development']/td[5]")
	public WebElement JobMatchingAndDevelopmentStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Client Service Planning and Coordination']/td[6]")
	public WebElement ClientServicePlanningOutcome;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Employability Skills']/td[6]")
	public WebElement EmployabilitySkillsOutcome;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Retention']/td[6]")
	public WebElement JobRetentionOutcome;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Coaching']/td[6]")
	public WebElement JobCoachingOutcome;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Search']/td[6]")
	public WebElement JobSearchOutcome;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Matching and Development']/td[6]")
	public WebElement JobMatchingAndDevelopmentOutcome;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Client Service Planning and Coordination']/td[1]")
	public WebElement ClientServicePlanningExpand;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Employability Skills']/td[1]")
	public WebElement EmployabilitySkillsExpand;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Retention']/td[1]")
	public WebElement JobRetentionExpand;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Coaching']/td[1]")
	public WebElement JobCoachingExpand;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Search']/td[1]")
	public WebElement JobSearchExpand;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Matching and Development']/td[1]")
	public WebElement JobMatchingAndDevelopmenExpand;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0_text\"]")
	public WebElement SubGoalAddPlanItem;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_1_text\"]")
	public WebElement EditSubGoalButton;
	
	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @class=\"curam-checkbox\" and @title=\"Plan Items - Select this row - Service Needs Assessment\"]/parent::span")
	public WebElement ServiceNeedsPlanItemCheckbox;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement ContinueAndSaveButton;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement EstimatedCost;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement ExpectedOutcome;
	
	@FindBy(xpath="//*[@id=\"__o3id9\"]")
	public WebElement DeliveryMethod;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Service Needs Assessment']/td[8]")
	public WebElement ServiceNeedsPlanItemActionButton;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement ActualStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement PlanItemOutcome;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement ActualEndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement ActualCost;

	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @title=\"Plan Items - Select this row - Fundamental job readiness skills\"]/parent::span")
	public WebElement FundamentalJobReadinessSkillsPlanItemCheckbox;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Fundamental job readiness skills']/td[8]")
	public WebElement FundamentalJobReadinessSkillsPlanItemActionButton;
	
	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @title=\"Plan Items - Select this row - Job Coaching for Participants - General\"]/parent::span")
	public WebElement JobCoachingforParticipantsGeneralPlanItemCheckbox;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Coaching for Participants - General']/td[8]")
	public WebElement JobCoachingforParticipantsGeneralPlanItemActionButton;
	
	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @title=\"Plan Items - Select this row - Job Trials\"]/parent::span")
	public WebElement JobTrialsPlanItemCheckbox;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Job Trials']/td[8]")
	public WebElement JobTrialsPlanItemActionButton;
	
	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @title=\"Plan Items - Select this row - Develop Support Plan\"]/parent::span")
	public WebElement DevelopSupportPlanItemCheckbox;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Develop Support Plan']/td[8]")
	public WebElement DevelopSupportPlanItemActionButton;
	
	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @title=\"Plan Items - Select this row - Income Support\"]/parent::span")
	public WebElement IncomeSupportPlanItemCheckbox;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Income Support']/td[8]")
	public WebElement IncomeSupportPlanItemActionButton;
	

	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Placement with Incentives - General']/td[8]")
	public WebElement PlacementWithIncentiveActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Career development/career exploration']/td[8]")
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
	public WebElement CaseOutcome;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement IsClientStillEmployed;
	
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
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_2_text\"]")
	public WebElement DeleteSubgoal;
}



