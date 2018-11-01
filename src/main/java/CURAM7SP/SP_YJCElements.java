package CURAM7SP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class SP_YJCElements extends testbaseforproject {
	public SP_YJCElements (WebDriver driver) {
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
	public WebElement InternationallyTrainedProfessional;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement LabourForce;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement CredentialsNotRecognized;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement PoorWorkHistory;
	
	@FindBy(xpath="//*[@id=\"__o3id8\"]")
	public WebElement EmploymentExperience;
	
	@FindBy(xpath="//*[@id=\"__o3ida\"]")
	public WebElement TimeOutOfSchool;
	
	@FindBy(xpath="//*[@id=\"__o3idc\"]")
	public WebElement TimeOutOfWork;
	
	@FindBy(xpath="//*[@id=\"__o3ide\"]")
	public WebElement TimeOutOfTraining;
	
	@FindBy(xpath="//*[@id=\"__o3id10\"]")
	public WebElement SourceOfIncome;
	
	@FindBy(xpath="//*[@id=\"__o3id12\"]")
	public WebElement HighestLevelOfEducation;
	
	@FindBy(xpath="//*[@id=\"__o3id14\"]")
	public WebElement CountryHighestLevelOfEduCompleted;
	
	@FindBy(xpath="//*[@id=\"__o3id1\"]")
	public WebElement JobSearch;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement EmploymentSkills;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement ValidationOfOW;
	
	@FindBy(xpath="//*[@id=\"__o3id7\"]")
	public WebElement FamilyHouseHold;
	
	@FindBy(xpath="//*[@id=\"__o3id9\"]")
	public WebElement MentalHealth;
	
	@FindBy(xpath="//*[@id=\"__o3idb\"]")
	public WebElement HardshipBased;
	
	@FindBy(xpath="//*[@id=\"__o3idd\"]")
	public WebElement HomelessAndHousing;
	
	@FindBy(xpath="//*[@id=\"__o3idf\"]")
	public WebElement LeavingCare;
	
	@FindBy(xpath="//*[@id=\"__o3id11\"]")
	public WebElement DiscriminationBased;
	
	@FindBy(xpath="//*[@id=\"__o3id13\"]")
	public WebElement LoneParent;
	
	@FindBy(xpath="//*[@id=\"__o3id15\"]")
	public WebElement Reading;
	
	@FindBy(xpath="//*[@id=\"__o3id17\"]")
	public WebElement Writing;
	
	@FindBy(xpath="//*[@id=\"__o3id19\"]")
	public WebElement DocumentUse;
	
	@FindBy(xpath="//*[@id=\"__o3id1b\"]")
	public WebElement Numeracy;
	
	@FindBy(xpath="//*[@id=\"__o3id1d\"]")
	public WebElement ComputerUse;
	
	@FindBy(xpath="//*[@id=\"__o3id16\"]")
	public WebElement Thinking;
	
	@FindBy(xpath="//*[@id=\"__o3id18\"]")
	public WebElement OralComunication;
	
	@FindBy(xpath="//*[@id=\"__o3id1a\"]")
	public WebElement WorkingWithOthers;
	
	@FindBy(xpath="//*[@id=\"__o3id1c\"]")
	public WebElement ContinuousLearning;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]")
	public WebElement SaveButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Client Service Planning and Coordination\"]/td[7]")
	public WebElement ClientSevicePlaningActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Job Matching, Placements and Incentives\"]/td[7]")
	public WebElement JobMatchingActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Pre-Employment Services\"]/td[7]")
	public WebElement PreEmploymentServicesActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Client Service Planning and Coordination\"]/td[5]")
	public WebElement ClientSevicePlaningStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Job Matching, Placements and Incentives\"]/td[5]")
	public WebElement JobMatchingStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Pre-Employment Services\"]/td[5]")
	public WebElement PreEmploymentStatus;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Client Service Planning and Coordination\"]/td[6]")
	public WebElement ClientSevicePlaningOutcome;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Job Matching, Placements and Incentives\"]/td[6]")
	public WebElement JobMatchingOutcome;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Pre-Employment Services\"]/td[6]")
	public WebElement PreEmploymentOutcome;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0_text\"]")
	public WebElement SubGoalAddPlanItem;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_1_text\"]")
	public WebElement EditSubGoalButton;
	
	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @class=\"curam-checkbox\" and @title=\"Plan Items - Select this row - Attend Job Interview\"]/parent::span")
	public WebElement AttendJobInterviewCheckbox;
	
	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @class=\"curam-checkbox\" and @title=\"Plan Items - Select this row - Career development/career exploration\"]/parent::span")
	public WebElement CareerDevelopmentCheckbox;
	
	@FindBy(xpath="//input[contains(@id,\"__o3uid\") and @class=\"curam-checkbox\" and @title=\"Plan Items - Select this row - Placement with Incentives - General\"]/parent::span")
	public WebElement PlacementWithIncentiveCheckbox;
	
	@FindBy(xpath="//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")
	public WebElement ContinueAndSaveButton;
	
	@FindBy(xpath="//*[contains(@title,\"Estimated Cost\")]")
	public WebElement EstimatedCost;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Client Service Planning and Coordination\"]/td[1]")
	public WebElement ClientSevicePlaningExpand;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Job Matching, Placements and Incentives\"]/td[1]")
	public WebElement JobMatchingExpand;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td=\"Pre-Employment Services\"]/td[1]")
	public WebElement PreEmploymentExpand;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Attend Job Interview']/td[8]")
	public WebElement AttendJobInterviewActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Placement with Incentives - General']/td[8]")//*[@id="sortable_N20A4F"]/tbody/tr[1]/td[8]
	public WebElement PlacementWithIncentiveActionButton;
	
	@FindBy(xpath="//div[@class='list']/div/table/tbody/tr[td='Career development/career exploration']/td[8]")//*[@id="sortable_N20A4F"]/tbody/tr[1]/td[8]
	public WebElement CareerDevelopmentActionButton;
	
	@FindBy(xpath="//*[@id=\"dijit_MenuItem_0_text\"]")
	public WebElement EditPlanItemButton;
		
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement AttendJobInterviewOutcome;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement AttendJobInterviewActualStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement AttendJobInterviewActualEndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement AttendJobInterviewActualCost;
	
	@FindBy(xpath="//*[@id=\"__o3id8\"]")
	public WebElement PlacementWithIncentiveOutcome;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement PlacementWithIncentiveActualStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement PlacementWithIncentiveActualEndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement PlacementWithIncentiveActualCost;
	
	@FindBy(xpath="//*[@id=\"__o3id7\"]")
	public WebElement PlacementWithIncentiveEmployerSatisfaction;
	
	@FindBy(xpath="//*[@id=\"__o3id8\"]")
	public WebElement CareerDevelopmentPESHours;
	
	@FindBy(xpath="//*[@id=\"__o3id0\"]")
	public WebElement CareerDevelopmentOutcome;
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement CareerDevelopmentActualStartDate;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement CareerDevelopmentActualEndDate;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement CareerDevelopmentActualCost;
	
	@FindBy(xpath="//*[contains(@title,\"Expected Start Date Mandatory dd/MM/yyyy\")]")
	public WebElement StartDate;
	
	@FindBy(xpath="//*[contains(@title,\"Expected End Date Mandatory dd/MM/yyyy\")]")
	public WebElement EndDate;
	
	@FindBy(xpath="//*[contains(@title,\"Actual Cost\")]")
	public WebElement ActualCost;
		
	@FindBy(xpath="//*[@title=\"Employer\"]")
	public WebElement Employer;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement JobTitle;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement PlacementCategory;
	
	@FindBy(xpath="//*[@id=\"__o3id8\"]")
	public WebElement HoursPerWeek;
	
	@FindBy(xpath="//*[@id=\"__o3ida\"]")
	public WebElement NOC;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement Wage;
	
	@FindBy(xpath="//*[@id=\"__o3id7\"]")
	public WebElement WagePer;
	
	@FindBy(xpath="//*[@id=\"__o3id9\"]")
	public WebElement NAICS;
	
	@FindBy(xpath="//*[@id=\"__o3fwp.ACTION.details$createPlannedItemDetailsStruct$plannedItemDtls$employerConcernRoleID_a\"]/img")
	public WebElement EmployerLookupGlass;
	
	@FindBy(xpath="//*[@id=\"__o3id2\"]")
	public WebElement EmployerTradingName;
	
	@FindBy(xpath="//*[contains(@id,\"sortable_N\")]/tbody/tr/td[1]/span/a/span/span/span")
	public WebElement SelectButton;
	
	@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]")
	public WebElement SearchButton;
	
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
	
	@FindBy(xpath="//*[@id=\"__o3id3\"]")
	public WebElement ClientEmployedQuestion1;
	
	@FindBy(xpath="//*[@id=\"__o3id4\"]")
	public WebElement ClientEmployedQuestion2;
	
	@FindBy(xpath="//*[@id=\"__o3id5\"]")
	public WebElement ClientEmployedQuestion3;
	
	@FindBy(xpath="//*[@id=\"__o3id6\"]")
	public WebElement ClientEmployedQuestion4;
	
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



