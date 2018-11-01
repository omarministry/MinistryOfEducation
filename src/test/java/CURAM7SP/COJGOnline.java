package CURAM7SP;

import java.awt.AWTException;
import java.text.SimpleDateFormat;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;
import testbase.testbaseforproject;


public class COJGOnline extends testbaseforproject{
	
	COJGOnlineElements cojg;
	
	@BeforeClass
	public void setup() {
		selectBrowser(config.getProperty("browser"));
		getUrl("https://cscgiqdcapwsa01.cihs.gov.on.ca:9445/COJG_Online/");
	}
	
	@Test
	public void createPlanItem() throws InterruptedException, AWTException {
		
		try {
			
			logger = report.startTest("Canada-Ontario Job Grant Employer/Consortium Application Form");
			
			cojg = new COJGOnlineElements(driver);
			
			//Click on Apply Now button
			cojg.ApplyNowButton.click();
			System.out.println("Apply Now button is clicked");
			logger.log(LogStatus.PASS, "Apply Now button is clicked");
			
			Thread.sleep(1000);
			
			//******Introduction*******
			cojg.TrainingRequestLassThan25RadioButton.click();
			System.out.println("25 or fewer training participants Radio button is selected");
			logger.log(LogStatus.PASS, "25 or fewer training participants Radio button is selected");
			
			cojg.EligibilityCheckAllButton.click();
			System.out.println("Check All Eligibility is clicked");
			logger.log(LogStatus.PASS, "Check All Eligibility is clicked");
			
			cojg.WSIBRadioButton.click();
			System.out.println("Click on WSIB Radio button");
			logger.log(LogStatus.PASS, "Click on WSIB Radio button");
			
			//create fake firstName and lastName 
			Faker faker = new Faker();
			String firstName = faker.name().firstName();
			if(firstName.contains("'")) {
				System.out.println("Text has Single Quote: " + firstName);
				firstName.replace("'", "");
			}
			
			String lastName = faker.name().lastName();
			if(lastName.contains("'")) {
				System.out.println("Text has Single Quote: " + lastName);
				lastName.replace("'", "");
			}
			
			String name = firstName + lastName;
			
			cojg.AttestationFirstName.sendKeys(name);
			cojg.AttestationLastName.sendKeys("AutomationAttestation");
			cojg.AttestationTitle.sendKeys("Mr.");
			System.out.println("Attestation details is entered");
			logger.log(LogStatus.PASS, "Attestation details is entered");
			
			cojg.ProceedNextStepButton1.click();
			System.out.println("1. Introduction - Proceed button is clicked");
			logger.log(LogStatus.PASS, "1. Introduction - Proceed button is clicked");
			
			Thread.sleep(1000);
			
			//******Employer Information*******

			firstName = faker.name().firstName();
			if(firstName.contains("'")) {
				System.out.println("Text has Single Quote: " + firstName);
				firstName.replace("'", "");
			}
			
			lastName = faker.name().lastName();
			if(lastName.contains("'")) {
				System.out.println("Text has Single Quote: " + lastName);
				lastName.replace("'", "");
			}
			name = firstName + lastName;
			String email = name + "@test.ca";
			String craNumber = generalRandomNumber(100000000, 999999999);
			
			//Enter General Information
			cojg.EmployerLegalName.sendKeys(name);
			cojg.EmployerBusinessName.sendKeys(name);
			cojg.PreferLanguageEnglishRadioButton.click();
			cojg.CRANumber.sendKeys(craNumber);
			System.out.println("Employer General Information is entered");
			logger.log(LogStatus.PASS, "Employer General Information is entered");
			
			//Enter Contact Information
			cojg.EmployerFirstName.sendKeys(name);
			cojg.EmployerLastName.sendKeys("AutomationEmployer");
			cojg.EmployerTitle.sendKeys("Mr.");
			cojg.EmployerPhoneNumber.sendKeys("416-212-0012");
			cojg.EmployerEmail.sendKeys(email);
			System.out.println("Employer Contact Information is entered");
			logger.log(LogStatus.PASS, "Employer Contact Information is entered");
			
			//Enter Corporate Address
			cojg.CorporateStreetNumber.sendKeys("13");
			cojg.CorporateStreetName.sendKeys("Richbourne Crt");
			cojg.CorporateCity.sendKeys("Toronto");
			cojg.CorporateProvince.click();
			cojg.CorporatePostalCode.sendKeys("M1T1T5");
			cojg.CorporateClosestIntersection.sendKeys("Warden-Sheppard");
			System.out.println("Corporate Address is entered");
			logger.log(LogStatus.PASS, "Corporate Address is entered");
			
			//Enter Business Address
			cojg.SameAddressCheckbox.click();
			System.out.println("Address same as Corporate address checkbox is clicked");
			logger.log(LogStatus.PASS, "Address same as Corporate address checkbox is clicked");
			
			//Enter Business Communication
			cojg.BusinessPhoneNumber.sendKeys("416-212-0012");
			System.out.println("Business communication phone number is entered");
			logger.log(LogStatus.PASS, "Business communication phone number is entered");
			
			//Employer Details
			cojg.TypeOfBusinessPrivate.click();
			cojg.YearBusinessRegistered.sendKeys("2010");
			cojg.NumberOfEmployeesInCompany.sendKeys("50");
			cojg.NumberOfEmployeesInBranch.sendKeys("10");
			System.out.println("Employer Details are entered");
			logger.log(LogStatus.PASS, "Employer Details are entered");
			
			
			//Type of Sector
			cojg.TypeOfSector.click();
			System.out.println("Type of sector is selected");
			logger.log(LogStatus.PASS, "Type of sector is selected");
			
			cojg.ProceedNextStepButton2.click();
			System.out.println("2. Employer Information - Proceed button is clicked");
			logger.log(LogStatus.PASS, "2. Employer Information - Proceed button is clicked");
			
			Thread.sleep(1000);
			
			//******Training Details*******
			//Training Questions
			cojg.CompanySpecificTrainingYesRadioButton.click();
			cojg.TrainingCategories.click();
			cojg.TypeOfSkillsGained.click();
			cojg.PaidDuringTraining.click();
			cojg.StaffPaidDuringTraining.click();
			cojg.ExpectedCredentialEarned.click();
			System.out.println("Training Questions are answered");
			logger.log(LogStatus.PASS, "Training Questions are answered");
			
			//Incumbents
			cojg.IncumbentCurrentNumberOfEmployees.sendKeys("5");
			cojg.IncumbentCurrentPositionTitle.sendKeys("Staff");
			cojg.IncumbentCurrentSalary.sendKeys("30");
			cojg.IncumbentCurrentNumberOfHour.sendKeys("35");
			cojg.IncumbentPostTrainingNumberOfEmployees.sendKeys("5");
			cojg.IncumbentPostTrainingPositionTitle.sendKeys("Supervisor");
			cojg.IncumbentPostTrainingSalary.sendKeys("35");
			cojg.IncumbentPostTrainingNumberOfHour.sendKeys("36");
			System.out.println("Incumbents are completed");
			logger.log(LogStatus.PASS, "Incumbents are completed");
			
			//New Hires
			cojg.AddNewHiresButton.click();
			Thread.sleep(1000);
			cojg.NumberOfNewHires.sendKeys("5");
			cojg.NewHirePositionTitle.sendKeys("Staff");
			cojg.NewHireSalary.sendKeys("25");
			cojg.NewHireHoursWeekly.sendKeys("30");
			System.out.println("New Hires are completed");
			
			//Impact of Training
			cojg.PositionPartimeToFullTime.sendKeys("5");
			cojg.SeasonalPositions.sendKeys("10");
			cojg.RemainAtcurrentJob.sendKeys("5");
			cojg.LayoffAdvoided.sendKeys("10");
			cojg.AdvanceOccupation.sendKeys("5");
			cojg.WageIncreased.sendKeys("5");
			cojg.TraineeHires.sendKeys("10");
			cojg.UnemployedToFullTime.sendKeys("5");
			cojg.SeasonalToYearRound.sendKeys("5");
			cojg.UnemployedToPartTime.sendKeys("5");
			cojg.CertificationFromTraining.sendKeys("10");
			System.out.println("Impact of Training questions are completed");
			logger.log(LogStatus.PASS, "Impact of Training questions are completed");
			
			cojg.ProceedNextStepButton3.click();
			Thread.sleep(1000);
			
			//*******Training Provider*******
			//1st choice Training provider Details
			String firstProviderCRA = generalRandomNumber(100000000, 999999999);
			String startDate = setDate(15);
			String endDate = setDate(135);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
			startDate = formatter.format(startDate);
			endDate = formatter.format(endDate);
			
			firstName = faker.name().firstName();
			if(firstName.contains("'")) {
				System.out.println("Text has Single Quote: " + firstName);
				firstName.replace("'", "");
			}
			
			lastName = faker.name().lastName();
			if(lastName.contains("'")) {
				System.out.println("Text has Single Quote: " + lastName);
				lastName.replace("'", "");
			}
			name = firstName + lastName;
			
			cojg.FirstProviderName.sendKeys("Centennial College - Progress Campus");
			cojg.FirstProviderCRANumber.sendKeys(firstProviderCRA);
			cojg.FirstProviderContactFirstName.sendKeys(name);
			cojg.FirstProviderContactLastName.sendKeys("AutomationTrainingProvider");
			cojg.FirstProviderContactPhone.sendKeys("416-625-4521");
			cojg.FirstProviderType.click();
			cojg.FirstProviderStreetNumber.sendKeys("981");
			cojg.FirstProviderStreetName.sendKeys("Progress Ave");
			cojg.FirstProviderCityOrTown.sendKeys("Scarborough");
			cojg.FirstProviderProvince.click();
			cojg.FirstProviderPostalCode.sendKeys("M1G3T8");
			cojg.FirstProviderPhone.sendKeys("416-289-5000");
			cojg.FirstProviderLocationOfTraining.click();
			cojg.FirstProviderCourseTitle.sendKeys("Food Supply");
			cojg.FrstProviderCourseDescription.sendKeys("Food Supply");
			cojg.FirstProviderCredential.sendKeys("Certificate");
			cojg.MethodOfTraining.click();
			cojg.FirstProviderCost.sendKeys("28000");
			cojg.StartDate.sendKeys(startDate);
			cojg.EndDate.sendKeys(endDate);
			cojg.TrainingHour.sendKeys("10");
			
		} catch (Exception e) {
			
			logger.log(LogStatus.FAIL, " Test is NOT successful due to the following exception " + logger.addScreenCapture(testbaseforproject.screenshot()));
			logger.log(LogStatus.INFO, e);
			
		}
	}
	
	@AfterClass
	public void endTest() {
		report.endTest(logger);
		report.flush();
//		driver.quit();
	}
	
}
