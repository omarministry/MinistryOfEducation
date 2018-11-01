package CURAM7SP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class COJGOnlineElements extends testbaseforproject {
	public COJGOnlineElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-splash/div/div[2]/ul/li[1]/button")
	public WebElement ApplyNowButton;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-introduction/div/form/fieldset[1]/div[1]/label/input")
	public WebElement TrainingRequestLassThan25RadioButton;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-introduction/div/form/fieldset[2]/div[1]/button")
	public WebElement EligibilityCheckAllButton;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-introduction/div/form/fieldset[2]/div[10]/div/div[2]/div/label/input")
	public WebElement WSIBRadioButton;
	
	@FindBy(xpath="//*[@id=\"attestationFirstName\"]")
	public WebElement AttestationFirstName;
	
	@FindBy(xpath="//*[@id=\"attestationLastName\"]")
	public WebElement AttestationLastName;
	
	@FindBy(xpath="//*[@id=\"attestationTitle\"]")
	public WebElement AttestationTitle;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-introduction/div/form/cojg-form-buttons/div/ul/li[1]/button")
	public WebElement ProceedNextStepButton1;
	
	@FindBy(xpath="//*[@id=\"legalName\"]")
	public WebElement EmployerLegalName;
	
	@FindBy(xpath="//*[@id=\"businessName\"]")
	public WebElement EmployerBusinessName;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-employer-information/div/form/fieldset[1]/div[3]/div[1]/div[1]/label/input")
	public WebElement PreferLanguageEnglishRadioButton;
	
	@FindBy(xpath="//*[@id=\"craNumber\"]")
	public WebElement CRANumber;
	
	@FindBy(xpath="//*[@id=\"firstName\"]")
	public WebElement EmployerFirstName;
	
	@FindBy(xpath="//*[@id=\"lastName\"]")
	public WebElement EmployerLastName;
	
	@FindBy(xpath="//*[@id=\"title\"]")
	public WebElement EmployerTitle;
	
	@FindBy(xpath="//*[@id=\"phoneNumber\"]")
	public WebElement EmployerPhoneNumber;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	public WebElement EmployerEmail;
	
	@FindBy(xpath="//*[@id=\"corporateStreetNumber\"]")
	public WebElement CorporateStreetNumber;
	
	@FindBy(xpath="//*[@id=\"corporateStreetName\"]")
	public WebElement CorporateStreetName;
	
	@FindBy(xpath="//*[@id=\"corporateCityOrTown\"]")
	public WebElement CorporateCity;
	
	@FindBy(xpath="//*[@id=\"corporateProvince\"]/option[10]")
	public WebElement CorporateProvince;
	
	@FindBy(xpath="//*[@id=\"corporatePostalCode\"]")
	public WebElement CorporatePostalCode;
	
	@FindBy(xpath="//*[@id=\"closestIntersection\"]")
	public WebElement CorporateClosestIntersection;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-employer-information/div/form/fieldset[5]/div[1]/label/input")
	public WebElement SameAddressCheckbox;
	
	@FindBy(xpath="//*[@id=\"businessPhone\"]")
	public WebElement BusinessPhoneNumber;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-employer-information/div/form/fieldset[7]/div/div[1]/div[1]/label/input")
	public WebElement TypeOfBusinessPrivate;
	
	@FindBy(xpath="//*[@id=\"yearRegistered\"]")
	public WebElement YearBusinessRegistered;
	
	@FindBy(xpath="//*[@id=\"employeesCompany\"]")
	public WebElement NumberOfEmployeesInCompany;
	
	@FindBy(xpath="//*[@id=\"employeesBranchLocation\"]")
	public WebElement NumberOfEmployeesInBranch;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-employer-information/div/form/fieldset[7]/div/div[7]/div/div[1]/div[1]/label/input")
	public WebElement TypeOfSector;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-employer-information/div/form/cojg-form-buttons/div/ul/li[1]/button")
	public WebElement ProceedNextStepButton2;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-details/div/form/fieldset[1]/ul/li[1]/fieldset/div[1]/label/input")
	public WebElement CompanySpecificTrainingYesRadioButton;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-details/div/form/fieldset[1]/ul/li[2]/fieldset/div[1]/label/input")
	public WebElement TrainingCategories;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-details/div/form/fieldset[1]/ul/li[3]/fieldset/div[1]/label/input")
	public WebElement TypeOfSkillsGained;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-details/div/form/fieldset[1]/ul/li[4]/fieldset/div[1]/label/input")
	public WebElement PaidDuringTraining;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-details/div/form/fieldset[1]/ul/li[5]/fieldset/div[1]/label/input")
	public WebElement StaffPaidDuringTraining;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-details/div/form/fieldset[1]/ul/li[6]/fieldset/div[2]/label/input")
	public WebElement ExpectedCredentialEarned;
	
	@FindBy(xpath="//*[@id=\"currentEmployees0\"]")
	public WebElement IncumbentCurrentNumberOfEmployees;
	
	@FindBy(xpath="//*[@id=\"currentTitle0\"]")
	public WebElement IncumbentCurrentPositionTitle;
	
	@FindBy(xpath="//*[@id=\"currentSalary0\"]")
	public WebElement IncumbentCurrentSalary;
	
	@FindBy(xpath="//*[@id=\"currentHoursWeekly0\"]")
	public WebElement IncumbentCurrentNumberOfHour;
	
	@FindBy(xpath="//*[@id=\"postTrainingEmployees0\"]")
	public WebElement IncumbentPostTrainingNumberOfEmployees;
	
	@FindBy(xpath="//*[@id=\"postTrainingTitle0\"]")
	public WebElement IncumbentPostTrainingPositionTitle;
	
	@FindBy(xpath="//*[@id=\"postTrainingSalary0\"]")
	public WebElement IncumbentPostTrainingSalary;
	
	@FindBy(xpath="//*[@id=\"postTrainingHoursWeekly0\"]")
	public WebElement IncumbentPostTrainingNumberOfHour;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-details/div/form/fieldset[3]/div/div[2]/div/div/div/button")
	public WebElement AddNewHiresButton;
	
	@FindBy(xpath="//*[@id=\"employees0\"]")
	public WebElement NumberOfNewHires;
	
	@FindBy(xpath="//*[@id=\"title0\"]")
	public WebElement NewHirePositionTitle;
	
	@FindBy(xpath="//*[@id=\"salary0\"]")
	public WebElement NewHireSalary;
	
	@FindBy(xpath="//*[@id=\"hoursWeekly0\"]")
	public WebElement NewHireHoursWeekly;
	
	@FindBy(xpath="//*[@id=\"positionsPartTimeToFullTime\"]")
	public WebElement PositionPartimeToFullTime;
	
	@FindBy(xpath="//*[@id=\"seasonalPositions\"]")
	public WebElement SeasonalPositions;
	
	@FindBy(xpath="//*[@id=\"remainAtCurrentJob\"]")
	public WebElement RemainAtcurrentJob;
	
	@FindBy(xpath="//*[@id=\"layoffsAvoided\"]")
	public WebElement LayoffAdvoided;
	
	@FindBy(xpath="//*[@id=\"advancedOccupation\"]")
	public WebElement AdvanceOccupation;
	
	@FindBy(xpath="//*[@id=\"wageIncreased\"]")
	public WebElement WageIncreased;
	
	@FindBy(xpath="//*[@id=\"traineeHires\"]")
	public WebElement TraineeHires;
	
	@FindBy(xpath="//*[@id=\"unemployedToFullTime\"]")
	public WebElement UnemployedToFullTime;
	
	@FindBy(xpath="//*[@id=\"seasonalToYearRound\"]")
	public WebElement SeasonalToYearRound;
	
	@FindBy(xpath="//*[@id=\"unemployedToPartTime\"]")
	public WebElement UnemployedToPartTime;
	
	@FindBy(xpath="//*[@id=\"certificationFromTraining\"]")
	public WebElement CertificationFromTraining;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-details/div/form/cojg-form-buttons/div/ul/li[1]/button")
	public WebElement ProceedNextStepButton3;
	
	@FindBy(xpath="//*[@id=\"firstProviderName\"]")
	public WebElement FirstProviderName;
	
	@FindBy(xpath="//*[@id=\"firstProviderCRANumber\"]")
	public WebElement FirstProviderCRANumber;
	
	@FindBy(xpath="//*[@id=\"firstProviderContactFirstName\"]")
	public WebElement FirstProviderContactFirstName;
	
	@FindBy(xpath="//*[@id=\"firstProviderContactLastName\"]")
	public WebElement FirstProviderContactLastName;
	
	@FindBy(xpath="//*[@id=\"firstProviderContactPhone\"]")
	public WebElement FirstProviderContactPhone;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-provider/div/form/fieldset[2]/div[4]/div[3]/div[2]/label/input")
	public WebElement FirstProviderType;
	
	@FindBy(xpath="//*[@id=\"firstProviderStreetNumber\"]")
	public WebElement FirstProviderStreetNumber;
	
	@FindBy(xpath="//*[@id=\"firstProviderStreetName\"]")
	public WebElement FirstProviderStreetName;
	
	@FindBy(xpath="//*[@id=\"firstProviderCityOrTown\"]")
	public WebElement FirstProviderCityOrTown;
	
	@FindBy(xpath="//*[@id=\"firstProviderProvince\"]/option[10]")
	public WebElement FirstProviderProvince;
	
	@FindBy(xpath="//*[@id=\"firstProviderPostalCode\"]")
	public WebElement FirstProviderPostalCode;
	
	@FindBy(xpath="//*[@id=\"firstProviderPhone\"]")
	public WebElement FirstProviderPhone;
	
	@FindBy(xpath="//*[@id=\"firstProviderEmail\"]")
	public WebElement FirstProviderEmail;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-provider/div/form/fieldset[2]/div[6]/div[1]/div/div[1]/label/input")
	public WebElement FirstProviderLocationOfTraining;
	
	@FindBy(xpath="//*[@id=\"firstProviderCourseTitle\"]")
	public WebElement FirstProviderCourseTitle;
	
	@FindBy(xpath="//*[@id=\"firstProviderCourseDescription\"]")
	public WebElement FrstProviderCourseDescription;
	
	@FindBy(xpath="//*[@id=\"firstProviderCredential\"]")
	public WebElement FirstProviderCredential;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-provider/div/form/fieldset[2]/div[7]/div[4]/div/div[1]/label/input")
	public WebElement MethodOfTraining;
	
	@FindBy(xpath="//*[@id=\"firstProviderCost\"]")
	public WebElement FirstProviderCost;
	
	@FindBy(xpath="//*[@id=\"startDate0\"]/div/input")
	public WebElement StartDate;
	
	@FindBy(xpath="//*[@id=\"endDate0\"]/div/input")
	public WebElement EndDate;
	
	@FindBy(xpath="//*[@id=\"hoursWeekly0\"]")
	public WebElement TrainingHour;
	
	@FindBy(xpath="/html/body/cojg-root/div/div/div/cojg-router/cojg-router/cojg-training-provider/div/form/cojg-form-buttons/div/ul/li[1]/button")
	public WebElement ProceedNextStepButton4;

}
