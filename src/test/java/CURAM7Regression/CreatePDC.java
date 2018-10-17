package CURAM7Regression;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import CURAM7.LoginElements;
import CURAM7.PDCElements;
import CURAM7.RegisterPersonElements;
import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class CreatePDC extends testbaseforproject{
	
	LoginElements login;
	PDCElements pdc;
	String filePath = System.getProperty("user.dir") + "//TestData";
	ReadWriteDataToExcel data = new ReadWriteDataToExcel();
	
	
	public void globalLoookupByCaseID(String sheetName) throws InterruptedException, IOException {
		//Get EOCaseID from the file
		String CaseID = Integer.toString(data.readExcel(filePath, "CaseID.xlsx", sheetName));
		
		//Search EOCaseID by global search
		pdc = new PDCElements(driver);
		pdc.ReferenceNumberSearchField.clear();
		pdc.ReferenceNumberSearchField.sendKeys(CaseID);
		
		System.out.println("Case Reference Number " + CaseID + " is entered");
		logger.log(LogStatus.PASS, "Case Reference Number " + CaseID + " is entered");
		
		//Click on Lookup glass
		pdc.ReferenceNumberLookUpGlassButton.click();
		System.out.println("Lookup glass is clicked");
		logger.log(LogStatus.PASS, "Lookup glass is clicked");
		
		Thread.sleep(2000);
		
		//Switch frame
		driver.switchTo().frame(2);
		System.out.println("Switch to Frame 2");
		
	}

	public void createNewProduct(String selectProductType, String deliveryPattern) throws InterruptedException {
		//Click on Edit Action (...)
		pdc.EoEditActionButton.click();
		System.out.println("EO Edit Action clicked");
		logger.log(LogStatus.PASS, "EO Edit Action clicked");
		
		Thread.sleep(1000);
		//Create New Product
		pdc.EONewProductOption.click();
		System.out.println("New Product option clicked");
		logger.log(LogStatus.PASS, "New Product option clicked");
		
		Thread.sleep(2000);
		
		//Switch to popup window
		String selectProductTypeWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(selectProductTypeWindowHandle);
		System.out.println("Switch to select Product type popup window");
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(3);
		
		//Verify Select Product Type popup windown is opened
		String selectProductTypeTxt = pdc.ProductTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(selectProductTypeTxt, "Products");
		System.out.println("Select Product Type popup window is opened");
		
		//Click on Select button of Apprenticeship

		
		if(selectProductType.equalsIgnoreCase("Apprenticeship")) {
			pdc.ApprenticeshipSelectButton.click();
			System.out.println("Apprenticehsip Select button is clicked");
			logger.log(LogStatus.PASS, "Apprenticehsip Select button is clicked");
		}else if(selectProductType.equalsIgnoreCase("Feepayer")) {
			pdc.FeepayerSelectButton.click();
			System.out.println("Feepayer Select button is clicked");
			logger.log(LogStatus.PASS, "Feepayer Select button is clicked");
		}else if(selectProductType.equalsIgnoreCase("Second Career")) {
			pdc.SecondCareerSelectButton.click();
			System.out.println("Second Career Select button is clicked");
			logger.log(LogStatus.PASS, "Second Career Select button is clicked");
		}else if(selectProductType.equalsIgnoreCase("JCP")) {
			pdc.JCPSelectButton.click();
			System.out.println("JCP Select button is clicked");
			logger.log(LogStatus.PASS, "JCP Select button is clicked");
		}else if(selectProductType.equalsIgnoreCase("ACB")) {
			pdc.ACBSelectButton.click();
			System.out.println("ACB Select button is clicked");
			logger.log(LogStatus.PASS, "ACB Select button is clicked");
		}else if(selectProductType.equalsIgnoreCase("ECB")) {
			pdc.ECBSelectButton.click();
			System.out.println("ECB Select button is clicked");
			logger.log(LogStatus.PASS, "ECB Select button is clicked");
		}else if(selectProductType.equalsIgnoreCase("SNEB")) {
			pdc.SNEBSelectButton.click();
			System.out.println("SNEB Select button is clicked");
			logger.log(LogStatus.PASS, "SNEB Select button is clicked");
		}
		
		
		Thread.sleep(2000);
		
		if(selectProductType.equalsIgnoreCase("Feepayer") == false) {
			//Verify Select Delivery Pattern window is navigated
			String selectDeliveryPatternWindow = driver.getWindowHandle();
			driver.switchTo().window(selectDeliveryPatternWindow);
			System.out.println("Switch to select Delivery pattern popup window");
			
			driver.switchTo().frame(3);
			
			String selectDeliveryPatternTxt = pdc.DeliveryPatternTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(selectDeliveryPatternTxt, "Available Delivery Patterns");
			System.out.println("Select Delivery Pattern window is navigated");
			

		}
		

		
		//Click on Select button of Delivery pattern
		if(selectProductType.equalsIgnoreCase("ECB")) {
			pdc.ECBCheqSelectActionButton.click();
			System.out.println("Cheque Select button is clicked");
			logger.log(LogStatus.PASS, "Cheque Select button is clicked");
		}else if(selectProductType.equalsIgnoreCase("ACB") == false && selectProductType.equalsIgnoreCase("SNEB") == false) {
			if(deliveryPattern.equalsIgnoreCase("EFT")) {
				pdc.EFTSelectActionButton.click();
				System.out.println("EFT Select button is clicked");
				logger.log(LogStatus.PASS, "EFT Select button is clicked");
			}else if(deliveryPattern.equalsIgnoreCase("Cheque")) {
				pdc.CheqSelectActionButton.click();
				System.out.println("Cheque Select button is clicked");
				logger.log(LogStatus.PASS, "Cheque Select button is clicked");
			}
		}else {
			if(deliveryPattern.equalsIgnoreCase("Cheque")) {
				pdc.EFTSelectActionButton.click();
				System.out.println("Cheque Select button is clicked");
				logger.log(LogStatus.PASS, "Cheque Select button is clicked");
			}else if(deliveryPattern.equalsIgnoreCase("EFT")) {
				pdc.CheqSelectActionButton.click();
				System.out.println("EFT Select button is clicked");
				logger.log(LogStatus.PASS, "EFT Select button is clicked");
			}
		}

		
		
		//Verify Create Delivery window is navigated
		String createDeliveryWindow = driver.getWindowHandle();
		driver.switchTo().window(createDeliveryWindow);
		driver.switchTo().frame(3);
		
		String createDeliveryTxt = pdc.CreateDeliveryTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(createDeliveryTxt, "Details");
		System.out.println("Create Delivery window is navigated");
		
		//Enter Start Date field
		String createDeliveryStartDate = setDate(-9);
		pdc.CreateDeliveryStartDate.clear();
		pdc.CreateDeliveryStartDate.sendKeys(createDeliveryStartDate);
		System.out.println("Start Date is entered: " + createDeliveryStartDate);
		logger.log(LogStatus.PASS, "Start Date is entered: " + createDeliveryStartDate);
		
		//Enter Date Received field
		pdc.CreateDeliveryDateReceived.clear();
		pdc.CreateDeliveryDateReceived.sendKeys(createDeliveryStartDate);
		System.out.println("Date  Receive is entered: " + createDeliveryStartDate);
		logger.log(LogStatus.PASS, "Date  Receive is entered: " + createDeliveryStartDate);
		
		//Enter Expected End Date filed
		String exptectedEndDate = setSunday(105);
		pdc.CreateDeliveryExpectedEndDate.sendKeys(exptectedEndDate);
		System.out.println("Expected End Date is entered: " + exptectedEndDate);
		logger.log(LogStatus.PASS, "Expected End Date is entered: " + exptectedEndDate);
		
		//Enter TOSS code
		if(selectProductType.equalsIgnoreCase("ACB") || selectProductType.equalsIgnoreCase("ECB") || selectProductType.equalsIgnoreCase("SNEB")) {
			pdc.TOSSCode.sendKeys("415A");
			System.out.println("TOSS code 415A is entered");
			logger.log(LogStatus.PASS, "TOSS code 415A is entered");
		}
		
		//Click on Create Delivery button
		pdc.CreateDeliveryButton.click();
		System.out.println("Create Delivery Button is clicked");
		logger.log(LogStatus.PASS, "Create Delivery Button is clicked");
		
		Thread.sleep(2000);
	}
	
	public void goToSiteMap() {
		driver.switchTo().window(driver.getWindowHandle());
		pdc.EmploymentInsuranceSiteMap.click();
		System.out.println("Site Map link is clicked");
		logger.log(LogStatus.PASS, "Site Map link is clicked");
	}
	
	public void addNewEmploymentInsurance() throws InterruptedException {
		//Click on Employment Insurance link
		pdc.EmploymentInsuranceEvidence.click();
		System.out.println("Employment Insurance Link is clicked");
		logger.log(LogStatus.PASS, "Employment Insurance Link is clicked");
		
		Thread.sleep(1000);
		
		//Verify Employment Insurance workspace is opened
		String EmploymentInsuranceTxt = pdc.EmploymentInsuranceEvidenceWorkspaceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(EmploymentInsuranceTxt, "Employment Insurance Evidence Workspace");
		System.out.println("Employment Insurance Workspace is opened");
		logger.log(LogStatus.PASS, "Employment Insurance Workspace is opened");
		
		Thread.sleep(1000);
		
		//Click New Button to create Employment Insurance
		pdc.EmploymentInsuranceNewButton.click();
		System.out.println("Employment Insurance Create New button is clicked");
		logger.log(LogStatus.PASS, "Employment Insurance Create New button is clicked");
		
		//Switch to New Employment Insurance Evidence Details popup window
		String employmentInsurancePopupWindow = driver.getWindowHandle();
		driver.switchTo().window(employmentInsurancePopupWindow);
		System.out.println("Switch to New Employment Insurance Evidence Details popup window");
		logger.log(LogStatus.PASS, "Switch to New Employment Insurance Evidence Details popup window");
		
		Thread.sleep(2000);
		
		//Switch the frame
		driver.switchTo().frame(5);
		System.out.println("Switch to Frame 5");
		
		//Verify New Employment Insurance Evidence Details popup window is opened
		String employmentInsuranceDetailsTxt = pdc.EmploymentInsuranceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(employmentInsuranceDetailsTxt, "Employment Insurance Details");
		System.out.println("New Employment Insurance Evidence Details popup window is opened");
		logger.log(LogStatus.PASS, "New Employment Insurance Evidence Details popup window is opened");
		
		
		//Enter value to Verification Date
		pdc.EmploymentInsuranceVerificationDate.clear();
		pdc.EmploymentInsuranceVerificationDate.sendKeys(setDate(-9));
		System.out.println("Verification Date is entered");
		logger.log(LogStatus.PASS, "Verification Date is entered");
		
		//Enter value to Claim Status
		pdc.EmploymentInsuranceClaimStatus.sendKeys("Active Claim");
		System.out.println("Claim Status is set to Active Claim");
		logger.log(LogStatus.PASS, "Claim Status is set to Active Claim");
		
		//Enter value to Claim Start Date
		pdc.EmploymentInsuranceClaimStartDate.clear();
		pdc.EmploymentInsuranceClaimStartDate.sendKeys(setDate(-9));
		System.out.println("Claim Start Date is entered");
		logger.log(LogStatus.PASS, "Claim Start Date is entered");
		
		//Enter value to Claim Start Date
		String endDate = setSunday(35);
		pdc.EmploymentInsuranceClaimEndDate.clear();
		pdc.EmploymentInsuranceClaimEndDate.sendKeys(endDate);
		System.out.println("Claim Start Date is entered");
		logger.log(LogStatus.PASS, "Claim Start Date is entered");
		
		//Enter value to Gross Amount
		pdc.EmploymentInsuranceGrossAmount.clear();
		pdc.EmploymentInsuranceGrossAmount.sendKeys("100");
		System.out.println("Gross Amount is entered");
		logger.log(LogStatus.PASS, "Gross Amount is entered");
		
		//Check on Section 25 Referral Complete checkbox
		pdc.EmploymentInsuranceSection25.click();
		System.out.println("Section 25 Referral Complete checkbox is checked");
		logger.log(LogStatus.PASS, "Section 25 Referral Complete checkbox is checked");
		
		//Click on Save button
		pdc.EmploymentInsuranceSaveButton.click();
		System.out.println("Save button is clicked");
		logger.log(LogStatus.PASS, "Save button is clicked");
	}
	
	public void addNewTrainingEvidence() throws InterruptedException {
		pdc.TrainingEvidence.click();
		System.out.println("Training Evidence link is clicked");
		logger.log(LogStatus.PASS, "Training Evidence link is clicked");
		
		Thread.sleep(1000);
		
		//Verify the Training Evidence Workspace is opened
		String trainingEvidenceWorkspaceTxt = pdc.TrainingEvidenceWorkspaceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(trainingEvidenceWorkspaceTxt, "Training Evidence Workspace");
		System.out.println("Training Evidence Workspace is opened");
		logger.log(LogStatus.PASS, "Training Evidence Workspace is opened");
		
		//Click on New Button to create New Training Evidence
		pdc.TrainingEvidenceNewButton.click();
		System.out.println("New Button to create New Training Evidence is clicked");
		logger.log(LogStatus.PASS, "New Button to create New Training Evidence is clicked");
		
		//Switch to New Training Evidence Detail Window
		String newTrainingEvidencePopupWindow = driver.getWindowHandle();
		driver.switchTo().window(newTrainingEvidencePopupWindow);
		System.out.println("Switch to New Training Evidence Details popup window");
		
		//Click on Training Institute lookup glass
		driver.switchTo().frame(5);
		
		String trainingEvidenceTxt = pdc.TrainingEvidenceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(trainingEvidenceTxt, "MTCU Training");
		System.out.println("New Training Evidence window is opened");
		
		pdc.TrainingInstitteLookupGlass.click();
		System.out.println("Training Institute lookup glass is clicked");
		logger.log(LogStatus.PASS, "Training Institute lookup glass is clicked");
		
		//Switch to Educational Institute Search window
		String educationalInstituteWindow = driver.getWindowHandle();
		driver.switchTo().window(educationalInstituteWindow);
		System.out.println("Switch to Educational Institute Search window");
		
		Thread.sleep(1000);
		
		//Switch to frame 6
		driver.switchTo().frame(6);
		System.out.println("Switch to Frame 6");
		
		//Verify Educational Institute Search window is opened
		String educationInstituteTxt = pdc.EducationalInstituteTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(educationInstituteTxt, "Search Criteria");
		System.out.println("Educational Institute Search window is opened");
		logger.log(LogStatus.PASS, "Educational Institute Search window is opened");
		

		
		//Enter Educational Institute Name
		pdc.EducationalInstituteName.sendKeys("Algonquin College - Pembroke Campus");
		System.out.println("Educational Institute Name is entered");
		logger.log(LogStatus.PASS, "Educational Institute Name is entered");
		
		//Click on Educational Institute Search button
		pdc.EducationalInstituteSearchButton.click();
		System.out.println("Educational Institute Search button is clicked");
		logger.log(LogStatus.PASS, "Educational Institute Search button is clicked");
		
		//Click on Educational Institute Select button
		pdc.EducationalInstituteSelectButton.click();
		System.out.println("Educational Institute Select button is clicked");
		logger.log(LogStatus.PASS, "Educational Institute Select button is clicked");
		
		//Switch to New Training Evidence Detail Window
		newTrainingEvidencePopupWindow = driver.getWindowHandle();
		driver.switchTo().window(newTrainingEvidencePopupWindow);
		System.out.println("Switch to New Training Evidence Details popup window");
		
		//Enter Program Start Date
		driver.switchTo().frame(5);
		pdc.TrainingEvidenceProgramStartDate.sendKeys("08/01/2018");
		System.out.println("Program start date is entered");
		logger.log(LogStatus.PASS, "Program start date is entered");
		
		//Enter Full-time
		pdc.TrainingEvidenceFullTime.sendKeys("Full Time");
		System.out.println("Full time is entered");
		logger.log(LogStatus.PASS, "Full time is entered");
		
		//Enter NOC
		pdc.TrainingEvidenceNOC.sendKeys("0213");
		System.out.println("NOC is entered");
		logger.log(LogStatus.PASS, "NOC is entered");
		
		//Enter Program name
		pdc.TrainingEvidenceProgramName.sendKeys("computer");
		System.out.println("Program name is entered");
		logger.log(LogStatus.PASS, "Program name is entered");
		
		//Enter Program End Date
		pdc.TrainingEvidenceProgramEndDate.sendKeys("25/04/2018");
		System.out.println("Program End Date is entered");
		logger.log(LogStatus.PASS, "Program End Date is entered");
		
		//Enter Program Language
		pdc.TrainingEvidenceProgramLanguage.sendKeys("English");
		System.out.println("Program Language is entered");
		logger.log(LogStatus.PASS, "Program Language is entered");
		
		//Enter Program Description
		pdc.TrainingEvidenceProgramDescription.sendKeys("computer");
		System.out.println("Program description is entered");
		logger.log(LogStatus.PASS, "Program description is entered");
		
		//Click on Save button
		pdc.TrainingEvidenceSaveButton.click();
		System.out.println("Training Evidence Save button is clicked");
		logger.log(LogStatus.PASS, "Training Evidence Save button is clicked");
	}
	
	public void createNewBenefit(String benefitPaymentType, String benefitType, String benefitAmount, String type) throws InterruptedException {
		String endDate = "";
		if(benefitPaymentType.equalsIgnoreCase("Lump Sum")) {
			endDate = setDate(-9);
		}else {
			endDate = setSunday(35);
		}
		
		//Click on Benefit link
		if(type.equalsIgnoreCase("JCP")) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			if(driver.findElements(By.xpath("//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[3]/td[2]/span/a")).size() != 0) {
				//Click on Benefit link
				pdc.BenefitLinkJCP.click();
				System.out.println("Benefit link is clicked");
				logger.log(LogStatus.PASS, "Benefit link is clicked");
				
				Thread.sleep(2000);
				//Verify Benefit Evidence Workspace is opened
				String benefitEvidenceWorkspaceTxt = pdc.BenefitWorkspaceTxt.getText().trim();
				AssertTextPresentmethodWithExtendPassFail(benefitEvidenceWorkspaceTxt, "Benefit Evidence Workspace");
				System.out.println("Benefit Evidence workspace is opened");
				logger.log(LogStatus.PASS, "Benefit Evidence workspace is opened");
			}
		}else if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("SNEB")) {
			pdc.BenefitLinkACB.click();
			System.out.println("Benefit link is clicked");
			logger.log(LogStatus.PASS, "Benefit link is clicked");
			
			Thread.sleep(2000);
			//Verify Benefit Evidence Workspace is opened
			String benefitEvidenceWorkspaceTxt = pdc.BenefitWorkspaceTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(benefitEvidenceWorkspaceTxt, "Benefit Evidence Workspace");
			System.out.println("Benefit Evidence workspace is opened");
			logger.log(LogStatus.PASS, "Benefit Evidence workspace is opened");
		}else if(type.equalsIgnoreCase("ECB")) {
			pdc.BenefitLinkECB.click();
			System.out.println("Benefit link is clicked");
			logger.log(LogStatus.PASS, "Benefit link is clicked");
			
			Thread.sleep(2000);
			//Verify Benefit Evidence Workspace is opened
			String benefitEvidenceWorkspaceTxt = pdc.BenefitWorkspaceTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(benefitEvidenceWorkspaceTxt, "Benefit Evidence Workspace");
			System.out.println("Benefit Evidence workspace is opened");
			logger.log(LogStatus.PASS, "Benefit Evidence workspace is opened");
		}else {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
			if(driver.findElements(By.xpath("//*[@id=\"content\"]/div[3]/div/table/tbody/tr[2]/td/div/div/table/tbody/tr[3]/td[2]/span/a")).size() != 0) {
				//Click on Benefit link
				pdc.BenefitLink.click();
				System.out.println("Benefit link is clicked");
				logger.log(LogStatus.PASS, "Benefit link is clicked");
				
				Thread.sleep(2000);
				//Verify Benefit Evidence Workspace is opened
				String benefitEvidenceWorkspaceTxt = pdc.BenefitWorkspaceTxt.getText().trim();
				AssertTextPresentmethodWithExtendPassFail(benefitEvidenceWorkspaceTxt, "Benefit Evidence Workspace");
				System.out.println("Benefit Evidence workspace is opened");
				logger.log(LogStatus.PASS, "Benefit Evidence workspace is opened");
			}
		}
		
		Thread.sleep(2000);
		//Click on New button
		pdc.BenefitNewButton.click();
		System.out.println("Benefit create New button is clicked");
		logger.log(LogStatus.PASS, "Benefit create New button is clicked");
		
		//Switch to Benefit Detail popup window
		String newBenefitWindow = driver.getWindowHandle();
		driver.switchTo().window(newBenefitWindow);
		System.out.println("switch to New Benefit Window");
		
		Thread.sleep(1000);
		driver.switchTo().frame(5);
		//Verify the New Benefit window is opened
		String newbenefitDetailsTxt = pdc.BenefitTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(newbenefitDetailsTxt, "Benefit Evidence Details");
		System.out.println("New Benefit Evidence Details window is opened");
		logger.log(LogStatus.PASS, "New Benefit Evidence Details window is opened");
		
		//Enter Benefit Type

		//Enter Benefit Payment Type
		if(type.equalsIgnoreCase("ACB") == false && type.equalsIgnoreCase("ECB") == false && type.equalsIgnoreCase("SNEB") == false) {
			
			pdc.BenefitType.clear();
			pdc.BenefitType.sendKeys(benefitType);
			System.out.println("Benefit Type: " + benefitType + " is entered");
			logger.log(LogStatus.PASS, "Benefit Type: " + benefitType + " is entered");
			
			pdc.BenefitPaymentType.sendKeys(benefitPaymentType);
			System.out.println("Benefit Payment type: " + benefitPaymentType + " is entered");
			logger.log(LogStatus.PASS, "Benefit Payment type: " + benefitPaymentType + " is entered");
			
			//Enter Benefit Start date
			pdc.BenefitStartDate.sendKeys(setDate(-9));
			System.out.println("Benefit Start Date is entered");
			logger.log(LogStatus.PASS, "Benefit Start Date is entered");
		}else if(type.equalsIgnoreCase("SNEB")) {
			pdc.BenefitType.clear();
			pdc.BenefitType.sendKeys(benefitType);
			System.out.println("Benefit Type: " + benefitType + " is entered");
			logger.log(LogStatus.PASS, "Benefit Type: " + benefitType + " is entered");
			
			pdc.BenefitStartDateSNEB.clear();
			pdc.BenefitStartDateSNEB.sendKeys(setDate(-9));
			System.out.println("SNEB Benefit Start Date is entered");
			logger.log(LogStatus.PASS, "SNEB Benefit Start Date is entered");
			
		}else {
			pdc.BenefitStartDateLumpSum.clear();
			pdc.BenefitStartDateLumpSum.sendKeys(setDate(-9));
			System.out.println("Benefit Start Date is entered");
			logger.log(LogStatus.PASS, "Benefit Start Date is entered");
		}

		
		//Enter Benefit Amount
		if(type.equalsIgnoreCase("ACB") == false && type.equalsIgnoreCase("ECB") == false && type.equalsIgnoreCase("SNEB") == false) {
			pdc.BenefitAmount.clear();
			pdc.BenefitAmount.sendKeys(benefitAmount);
			System.out.println("Benefit Amount is entered");
			logger.log(LogStatus.PASS, "Benefit Amount is entered");
			
			//Enter Benefit End Date
			pdc.BenefitEndDate.clear();
			pdc.BenefitEndDate.sendKeys(endDate);
			System.out.println("Benefit End Date is entered");
			logger.log(LogStatus.PASS, "Benefit End Date is entered");
		}else if(type.equalsIgnoreCase("SNEB")) {
			pdc.BenefitAmount.clear();
			pdc.BenefitAmount.sendKeys(benefitAmount);
			System.out.println("Benefit Amount is entered");
			logger.log(LogStatus.PASS, "Benefit Amount is entered");
			
			pdc.BenefitEndDateSNEB.clear();
			pdc.BenefitEndDateSNEB.sendKeys(setDate(-9));
			System.out.println("SNEB Benefit End Date is entered");
			logger.log(LogStatus.PASS, "SNEBBenefit End Date is entered");
		}else {
			pdc.BenefitEndDateLumpSum.clear();
			pdc.BenefitEndDateLumpSum.sendKeys(endDate);
			System.out.println("Benefit End Date is entered");
			logger.log(LogStatus.PASS, "Benefit End Date is entered");
		}
		
		//Click on Save Button
		pdc.BenefitSaveButton.click();
		System.out.println("Benefit Save button is clicked");
		logger.log(LogStatus.PASS, "Benefit Save button is clicked");
	}
	
	public void addMultiYearForecasting(String type) throws InterruptedException {
		 //Click on Multi Year Forcasting link
		if(type.equalsIgnoreCase("Second Career")) {
			pdc.MultiYearForecastingLinkSC.click();
		}else {
			pdc.MultiYearForecastingLink.click();
		}

		System.out.println("Multi Year Forcasting link is clicked");
		logger.log(LogStatus.PASS, "Multi Year Forcasting link is clicked");
		
		Thread.sleep(2000);
		//Verify Multi Year Forecasting Evidence Workspace is opened
		String multiYearTxt = pdc.MultiYearForecastingWorkspaceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(multiYearTxt, "Multi Year Forecasting Evidence Workspace");
		System.out.println("Multi Year Forecasting Evidence Workspace is opened");
		logger.log(LogStatus.PASS, "Multi Year Forecasting Evidence Workspace is opened");
		
		Thread.sleep(1000);
		//Click on New button
		pdc.MultiYearForecastingNewButton.click();
		System.out.println("Multi Year Forecasting New button is clicked");
		logger.log(LogStatus.PASS, "Multi Year Forecasting New button is clicked");
		
		//Switch to New Multi Year Forecasting Evidence Details window
		String newMultiYearWindow = driver.getWindowHandle();
		driver.switchTo().window(newMultiYearWindow);
		System.out.println("Switch to New Multi Year Forecasting Evidence Details window");
		
		driver.switchTo().frame(5);
		
		//Verify New Multi Year Forecasting Evidence Details window is opened
		String newMultiYearTxt = pdc.MultiYearForecastingTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(newMultiYearTxt, "Multi Year Forecasting");
		System.out.println("New Multi Year Forecasting Evidence Details window is opened");
		logger.log(LogStatus.PASS, "New Multi Year Forecasting Evidence Details window is opened");
		
		//Enter Multi Year Forecasting Amount

		pdc.MultiYearForecastingAmount.clear();
		pdc.MultiYearForecastingAmount.sendKeys("5000");
		System.out.println("Multi Year Forecasting Amount is entered");
		logger.log(LogStatus.PASS, "Multi Year Forecasting Amount is entered");
		
		//Click Save button
		pdc.MultiYearForecastingSaveButton.click();
		System.out.println("Multi Year Forecasting Save button is clicked");
		logger.log(LogStatus.PASS, "Multi Year Forecasting Save button is clicked");
	}
	
	public void addClientContribution() throws InterruptedException {
		
		//Click on Client Contribution Link
		pdc.ClientContributionLink.click();
		System.out.println("Client Contribution Link is clicked");
		logger.log(LogStatus.PASS, "Client Contribution Link is clicked");
		
		Thread.sleep(2000);
		//Verify Client Contribution Evidence Workspace is opened
		String clientContributionWorkspaceTxt = pdc.ClientContributionWorkspaceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(clientContributionWorkspaceTxt, "Client Contribution Evidence Workspace");
		System.out.println("Client Contribution Evidence Workspace is opened");
		logger.log(LogStatus.PASS, "Client Contribution Evidence Workspace is opened");
		
		Thread.sleep(1000);
		
		//Click on New button
		pdc.ClientContributionNewButton.click();
		System.out.println("Client Contribution New button is clicked");
		logger.log(LogStatus.PASS, "Client Contribution New button is clicked");
		
		Thread.sleep(1000);
		
		//Switch to popup window
		String newClientContributionWindow = driver.getWindowHandle();
		driver.switchTo().window(newClientContributionWindow);
		System.out.println("Switch to New client Contribution Evidence Details popup window");
		
		driver.switchTo().frame(5);
		
		//Verify the New client Contribution Evidence Details popup window is opened
		String clientContributionDetailsTxt = pdc.ClientContributionTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(clientContributionDetailsTxt, "Client Contribution Details");
		System.out.println("New client Contribution Evidence Details popup window is opened");
		logger.log(LogStatus.PASS, "New client Contribution Evidence Details popup window is opened");
		
		//Enter Contribution Type

		pdc.ClientContributionType.sendKeys("Tuition");
		System.out.println("Contribution Type is entered");
		logger.log(LogStatus.PASS, "Contribution Type is entered");
		
		//Enter Contribution Amount
		pdc.ClientContributionAmount.clear();
		pdc.ClientContributionAmount.sendKeys("1000");
		System.out.println("Contribution Amount is entered");
		logger.log(LogStatus.PASS, "Contribution Amount is entered");
		
		//Click on Save button
		pdc.ClientContributionSaveButton.click();
		System.out.println("Contribution Save button is clicked");
		logger.log(LogStatus.PASS, "Contribution Save button is clicked");
	}
	
	public void addJobCreationPartnership() throws InterruptedException {
		
		//Click on Job Creation Partnership link
		pdc.JCPLink.click();
		System.out.println("Job Creation Partnership link is clicked");
		logger.log(LogStatus.PASS, "Job Creation Partnership link is clicked");
		
		//Verify Job Creation Partnership link is opened
//		String JCPWorkspaceTxt = pdc.JCPWorkspaceTxt.getText().trim();
//		AssertTextPresentmethodWithExtendPassFail(JCPWorkspaceTxt, "Job Creation Partnership Evidence Workspace:");
//		System.out.println("Job Creation Partnership link is opened");
//		logger.log(LogStatus.PASS, "Job Creation Partnership link is opened");
		
		Thread.sleep(1000);
		//Click on New button
		pdc.JCPNewButton.click();
		System.out.println("JCP New button is clicked");
		logger.log(LogStatus.PASS, "JCP New button is clicked");
		
		Thread.sleep(1000);
		//Switch to JCP Evidence Details popup window
		String JCPPopupWindow = driver.getWindowHandle();
		driver.switchTo().window(JCPPopupWindow);
		System.out.println("Switch to JCP Evidence Details popup window");
		
		driver.switchTo().frame(5);
		
		//Verify JCP Evidence Details popup window is opened
		String JCPDetailsTxt = pdc.JCPTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(JCPDetailsTxt, "Job Creation Partnership");
		System.out.println("JCP Evidence Details popup window is opened");
		logger.log(LogStatus.PASS, "JCP Evidence Details popup window is opened");
		
		//Enter JCP Contract Number
		pdc.JCPContractNumber.sendKeys(generalRandomNumber(1000000, 9000000));
		System.out.println("JCP contract Number is entered");
		logger.log(LogStatus.PASS, "JCP contract Number is entered");
		
		//Click on JCP Employer Lookup Glass
		pdc.JCPEmployer.click();
		System.out.println("JCP Employer lookup glass is clicked");
		logger.log(LogStatus.PASS, "JCP Employer lookup glass is clicked");
		
		Thread.sleep(1000);
		//Switch to Service Delivery Site Search window
		String serviceDeliveryWindow = driver.getWindowHandle();
		driver.switchTo().window(serviceDeliveryWindow);
		System.out.println("Switch to Service Delivery Site Search window");
		
		driver.switchTo().frame(6);
		
		//Verify Service Delivery Site window is opened
		String serviceDeliverySiteTxt = pdc.ServiceDeliverySiteTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(serviceDeliverySiteTxt, "Search Criteria");
		System.out.println("Service Delivery Site window is opened");
		logger.log(LogStatus.PASS, "Service Delivery Site window is opened");
		
		//Enter Reference Number

		pdc.ServiceDeliverySiteRefNum.sendKeys("3002B");
		System.out.println("Reference number 3002B is entered");
		logger.log(LogStatus.PASS, "Reference number 3002B is entered");
		
		//Click on Search Button
		pdc.ServiceDeliverySiteSearchButton.click();
		System.out.println("Service Delivery Site Search button is clicked");
		logger.log(LogStatus.PASS, "Service Delivery Site Search button is clicked");
		
		Thread.sleep(1000);
		//Click on Select button
		pdc.ServiceDeliverySiteSelectButton.click();
		System.out.println("Service Delivery Site Select button is clicked");
		logger.log(LogStatus.PASS, "Service Delivery Site Select button is clicked");
		
		//Back to New JCP Detail window
		JCPPopupWindow = driver.getWindowHandle();
		driver.switchTo().window(JCPPopupWindow);
		System.out.println("Switch to JCP Evidence Details popup window");
		
		//Click on Save button
		driver.switchTo().frame(5);
		pdc.JCPSaveButton.click();
		System.out.println("New JCP Save button is clicked");
		logger.log(LogStatus.PASS, "New JCP Save button is clicked");
	}
	
	public void addApprenticeship() throws InterruptedException {
		
		//Click on Apprenticeship Link
		pdc.ApprenticeshipLink.click();
		System.out.println("Aprrenticeship Link is clicked");
		logger.log(LogStatus.PASS, "Aprrenticeship Link is clicked");
		
		Thread.sleep(2000);
		//Verify Apprenticeship Employer Evidence Workspace is opened
		String apprEvidenceWorkspaceTxt = pdc.ApprenticeshipWorkspaceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(apprEvidenceWorkspaceTxt, "Apprenticeship Employer Evidence Workspace");
		System.out.println("Apprenticeship Employer Evidence Workspace is opened");
		logger.log(LogStatus.PASS, "Apprenticeship Employer Evidence Workspace is opened");
		
		Thread.sleep(1000);
		//Click on New button
		pdc.ApprenticeshipNewButton.click();
		System.out.println("Apprenticeship New Button is clicked");
		logger.log(LogStatus.PASS, "Apprenticeship New Button is clicked");
		
		//Switch to the Apprenticeship Employer Evidence Details window
		String apprEvidenceWindow = driver.getWindowHandle();
		driver.switchTo().window(apprEvidenceWindow);
		System.out.println("Switch to the Apprenticeship Employer Evidence Details window");
		logger.log(LogStatus.PASS, "Switch to the Apprenticeship Employer Evidence Details window");
		
		driver.switchTo().frame(5);
		
		Thread.sleep(1000);
		//Verify Apprenticeship Employer Evidence Details window is opened
		String apprEvidenceDetailsTxt = pdc.ApprenticeshipTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(apprEvidenceDetailsTxt, "Apprenticeship Employer");
		System.out.println("Apprenticeship Employer Evidence Details window is opened");
		logger.log(LogStatus.PASS, "Apprenticeship Employer Evidence Details window is opened");
		
		//Click on APPR Employer Lookup Glass
		pdc.ApprenticeshipEmployerLookupGlass.click();
		System.out.println("Employer Lookup glass is clicked");
		logger.log(LogStatus.PASS, "Employer Lookup glass is clicked");
		
		//Switch to Employer Search Window
		String employerSearchWindow = driver.getWindowHandle();
		driver.switchTo().window(employerSearchWindow);
		System.out.println("Switch to Employer Search Window");
		
		//Enter Employer Party ID
		driver.switchTo().frame(6);
		pdc.AAPPREmployerPartyID.sendKeys("1002930");
		System.out.println("Employer Party ID 1002930 is entered");
		logger.log(LogStatus.PASS, "Employer Party ID 1002930 is entered");
		
		//Click on Search button
		pdc.AAPPREmployerSearchButton.click();
		System.out.println("Employer Search button is clicked");
		logger.log(LogStatus.PASS, "Employer Search button is clicked");
		
		Thread.sleep(1000);
		
		//Click on Employer Select button
		pdc.AAPPREmployerSelectButton.click();
		System.out.println("Employer Select button is clicked");
		logger.log(LogStatus.PASS, "Employer Select button is clicked");
		
		Thread.sleep(1000);
		//Switch back to APPR Evidence window
		apprEvidenceWindow = driver.getWindowHandle();
		driver.switchTo().window(apprEvidenceWindow);
		System.out.println("Switch back to APPR Evidence window");
		logger.log(LogStatus.PASS, "Switch back to APPR Evidence window");
		
		//Enter APPR Training Agreement Number
		driver.switchTo().frame(5);
		String APPRTANum = generalRandomNumber(1000000, 9999999);
		pdc.ApprenticeshipTANumber.sendKeys(APPRTANum);
		System.out.println("APPR Training Agreement Number " + APPRTANum + " is entered");
		logger.log(LogStatus.PASS, "APPR Training Agreement Number " + APPRTANum + " is entered");
		
		//Enter APPR Certification Date
		pdc.ApprenticeshipCertificationDate.sendKeys(setDate(-9));
		System.out.println("APPR Certification Date is entered");
		logger.log(LogStatus.PASS, "APPR Certification Date is entered");
		
		//Enter Received Date
		pdc.ApprenticeshipReceivedDate.clear();
		pdc.ApprenticeshipReceivedDate.sendKeys(setDate(-9));
		System.out.println("Received Date is entered");
		logger.log(LogStatus.PASS, "Received Date is entered");
		
		//Click on Save button
		pdc.ApprenticeshipSaveButton.click();
		System.out.println("Apprenticeship Evidence Save button is clicked");
		logger.log(LogStatus.PASS, "Apprenticeship Evidence Save button is clicked");
	}
	
	public void addSupervisor(String type) throws InterruptedException {
		//Click on User Roles
		pdc.UserRolesLink.click();
		System.out.println("User Roles link is clicked");
		logger.log(LogStatus.PASS, "User Roles link is clicked");
		
		//Verify User Roles is opened
		driver.switchTo().frame(4);
		String userRolesTxt = pdc.UserRolesTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(userRolesTxt, "User Roles");
		System.out.println("User Roles is opened");
		logger.log(LogStatus.PASS, "User Roles is opened");
		
		//Click on New Supervisor button
		pdc.NewSupervisorButton.click();
		System.out.println("New Supervisor button is clicked");
		logger.log(LogStatus.PASS, "New Supervisor button is clicked");
		
		Thread.sleep(1000);
		
		//Switch to Set Case SuperVisor window
		String setCaseSupervisorWindow = driver.getWindowHandle();
		driver.switchTo().window(setCaseSupervisorWindow);
		System.out.println("Switch to Set Case SuperVisor window");
		
		Thread.sleep(1000);
		//Verify the Set Case SuperVisor window is opened
//		String setCaseSupervisorTxt = pdc.ModalDialogTxt.getText().trim();
//		AssertTextPresentmethodWithExtendPassFail(setCaseSupervisorTxt, "Set Case Supervisor");
//		System.out.println("Set Case Suprvisor window is opened");
//		logger.log(LogStatus.PASS, "Set Case Suprvisor window is opened");
		
		//Click on New Supervisor lookup glass
		driver.switchTo().frame(5);
		pdc.NewSupervisorLoopupGlass.click();
		System.out.println("New Supervisor lookup glass is clicked");
		logger.log(LogStatus.PASS, "New Supervisor lookup glass is clicked");
		
		//Switch to Select a User window
		String selectAUserWindow = driver.getWindowHandle();
		driver.switchTo().window(selectAUserWindow);
		System.out.println("Switch to Select a User window");
		
		Thread.sleep(1000);
		//Verify select a user window is opened
//		String selectAUserTxt = pdc.ModalDialogTxt.getText().trim();
//		AssertTextPresentmethodWithExtendPassFail(selectAUserTxt, "Select a user:");
//		System.out.println("Select a user window is opened");
//		logger.log(LogStatus.PASS, "Select a user window is opened");
		
		//Enter Supervisor First Name
		driver.switchTo().frame(6);
		String supervisorFirstName = "";
		String supervisorLastName = "";
		String username = config.getProperty("userCURAM7CaseWorker");
		
		if(username.equals("DSAP194591")) {
			if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("ECB") || type.equalsIgnoreCase("SNEB")) {
				supervisorFirstName = "Lise";
				supervisorLastName = "Mackevicius";
			}else {
				supervisorFirstName = "Luc";
				supervisorLastName = "Desbiens";
			}
		}else if(username.equals("DSAP173975")) {
			if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("ECB") || type.equalsIgnoreCase("SNEB")) {
				supervisorFirstName = "Oxana";
				supervisorLastName = "Golovkina";
			}else {
				supervisorFirstName = "Mark";
				supervisorLastName = "Glenen";
			}
		}else if(username.equals("DSAP120470")) {
			if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("ECB") || type.equalsIgnoreCase("SNEB")) {
				supervisorFirstName = "Kremena";
				supervisorLastName = "Puhleva";
			}else {
				supervisorFirstName = "BRENDA";
				supervisorLastName = "HENDERSON";
			}
		}else if(username.equals("DSAP156201")) {
			if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("ECB") || type.equalsIgnoreCase("SNEB")) {
				supervisorFirstName = "Michele";
				supervisorLastName = "Henderson";
			}else {
				supervisorFirstName = "Louann";
				supervisorLastName = "Cornacchio";
			}
		}
		
		pdc.SupervisorFirstname.sendKeys(supervisorFirstName);
		System.out.println("Supervisor First Name is entered as: " + supervisorFirstName);
		logger.log(LogStatus.PASS, "Supervisor First Name is entered as: " + supervisorFirstName);
		
		//Enter Supervisor Last Name
		pdc.SupervisorLastname.sendKeys(supervisorLastName);
		System.out.println("Supervisor Last Name is entered as: " + supervisorLastName);
		logger.log(LogStatus.PASS, "Supervisor Last Name is entered as: " + supervisorLastName);
		
		//Click on Search button
		pdc.SupervisorSearchButton.click();
		System.out.println("Supervisor Search button is clicked");
		logger.log(LogStatus.PASS, "Supervisor Search button is clicked");
		
		//Click on Select supervisor button
		if(username.equals("DSAP194591")) {
			if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("ECB") || type.equalsIgnoreCase("SNEB")) {
				pdc.SupervisorSelectButtonSingle.click();
			}else {
				pdc.SupervisorSelectButtonSecondOption.click();
			}
		}else if(username.equals("DSAP173975")) {
			if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("ECB") || type.equalsIgnoreCase("SNEB")) {
				pdc.SupervisorSelectButtonSingle.click();
			}else {
				pdc.SupervisorSelectButtonSingle.click();
			}
		}else if(username.equals("DSAP120470")) {
			if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("ECB") || type.equalsIgnoreCase("SNEB")) {
				pdc.SupervisorSelectButtonFirstOption.click();
			}else {
				pdc.SupervisorSelectButtonSingle.click();
			}
		}else if(username.equals("DSAP156201")) {
			if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("ECB") || type.equalsIgnoreCase("SNEB")) {
				pdc.SupervisorSelectButtonFirstOption.click();
			}else {
				pdc.SupervisorSelectButtonSingle.click();
			}
		}
		
		System.out.println("Supervisor Select button is clicked");
		logger.log(LogStatus.PASS, "Supervisor Select button is clicked");
		
		//Back to Set Case supervisor window
		setCaseSupervisorWindow = driver.getWindowHandle();
		driver.switchTo().window(setCaseSupervisorWindow);
		driver.switchTo().frame(5);
		System.out.println("Back to Set Case supervisor window and switch to frame 5 ");
		
		//Click on Save button
		pdc.SupervisorSaveButton.click();
		System.out.println("Supervisor Save button is clicked");
		logger.log(LogStatus.PASS, "Supervisor Save button is clicked");
	}
	
	public void applyEvidence() throws InterruptedException {
		
		//Click on Site Map Action menu
		pdc.SiteMapActionMenu.click();
		System.out.println("Site Map action menu is clicked");
		logger.log(LogStatus.PASS, "Site Map action menu is clicked");
		
		//CLick on Apply Evidence Option
		pdc.ApplyEvidenceOption.click();
		System.out.println("Apply Evidence Option is clicked");
		logger.log(LogStatus.PASS, "Apply Evidence Option is clicked");
		
		//Switch to Apply Evidence window
		String applyEvidenceWindow = driver.getWindowHandle();
		driver.switchTo().window(applyEvidenceWindow);
		System.out.println("Switch to Apply Evidence window");
		
		Thread.sleep(1000);
		
		driver.switchTo().frame(5);
		//Verify Apply Evidence window is opened
		String applyEvidenceTxt = pdc.EvidenceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(applyEvidenceTxt, "List of New and Updated Evidence");
		System.out.println("Apply Evidence window is opened");
		logger.log(LogStatus.PASS, "Apply Evidence window is opened");
		
		//Click on select all Evidence check box
		pdc.AllEvidenceCheckbox.click();
		System.out.println("All Evidence check box is clicked");
		logger.log(LogStatus.PASS, "All Evidence check box is clicked");
		
		//Click on Apply Evidence button
		pdc.ApplyApproveEvidenceButton.click();
		System.out.println("Apply Evidence button is clicked");
		logger.log(LogStatus.PASS, "Apply Evidence button is clicked");
	}
	
	public void approveEvidence() throws InterruptedException {	
		Thread.sleep(1000);
		//Click on Evidence tab
		driver.switchTo().window(driver.getWindowHandle());
		pdc.EvidenceTab.click();
		System.out.println("Evidence Tab is clicked");
		logger.log(LogStatus.PASS, "Evidence Tab is clicked");
		
		//Verify Site Map title
		driver.switchTo().frame(2);
//		String siteMapTxt = pdc.SiteMapTxt.getText().trim();
//		AssertTextPresentmethodWithExtendPassFail(siteMapTxt, "Site Map: Apprenticeship");
//		System.out.println("Site Map is opened");
//		logger.log(LogStatus.PASS, "Site Map is opened");
		
		//Click on Site Map action menu
		pdc.SiteMapActionMenu.click();
		System.out.println("Site Map action menu is clicked");
		logger.log(LogStatus.PASS, "Site Map action menu is clicked");
		
		//CLick on Approve Evidence Option
		pdc.ApproveEvidenceOption.click();
		System.out.println("Approve Evidence Option is clicked");
		logger.log(LogStatus.PASS, "Approve Evidence Option is clicked");
		
		//Switch to Approve Evidence window
		String approveEvidenceWindow = driver.getWindowHandle();
		driver.switchTo().window(approveEvidenceWindow);
		System.out.println("Switch to Approve Evidence window");
		
		driver.switchTo().frame(3);
		
		//Verify Approve Evidence window is opened
		String applyEvidenceTxt = pdc.EvidenceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(applyEvidenceTxt, "List of Evidence for Approval");
		System.out.println("Approve Evidence window is opened");
		logger.log(LogStatus.PASS, "Approve Evidence window is opened");
		
		//Click on select all Evidence check box
		pdc.AllEvidenceCheckbox.click();
		System.out.println("All Evidence check box is clicked");
		logger.log(LogStatus.PASS, "All Evidence check box is clicked");
		
		//Click on Approve Evidence button
		pdc.ApplyApproveEvidenceButton.click();
		System.out.println("Approve Evidence button is clicked");
		logger.log(LogStatus.PASS, "Approve Evidence button is clicked");
		
		//Click on alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void reApplyEvidence() {
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(2);
		
		//Click on Site Map action menu
		pdc.SiteMapActionMenu.click();
		System.out.println("Site Map action menu is clicked");
		logger.log(LogStatus.PASS, "Site Map action menu is clicked");
		
		//CLick on Apply Evidence Option
		pdc.ApplyEvidenceOption.click();
		System.out.println("Apply Evidence Option is clicked");
		logger.log(LogStatus.PASS, "Apply Evidence Option is clicked");
		
		//Switch to Apply Evidence window
		String applyEvidenceWindow = driver.getWindowHandle();
		driver.switchTo().window(applyEvidenceWindow);
		System.out.println("Switch to Apply Evidence window");
		
		driver.switchTo().frame(3);
		
		//Verify Apply Evidence window is opened
		String applyEvidenceTxt = pdc.EvidenceTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(applyEvidenceTxt, "List of New and Updated Evidence");
		System.out.println("Apply Evidence window is opened");
		logger.log(LogStatus.PASS, "Apply Evidence window is opened");
		
		//Click on select all Evidence check box

		pdc.AllEvidenceCheckbox.click();
		System.out.println("All Evidence check box is clicked");
		logger.log(LogStatus.PASS, "All Evidence check box is clicked");
		
		//Click on Apply Evidence button
		pdc.ApplyApproveEvidenceButton.click();
		System.out.println("Apply Evidence button is clicked");
		logger.log(LogStatus.PASS, "Apply Evidence button is clicked");	
	}
	
	public void logoutCAMS() throws InterruptedException {
		//Click on person menu
		pdc.PersonMenu.click();
		System.out.println("Person Menu is clicked");
		logger.log(LogStatus.PASS, "Person Menu is clicked");
		
		
		Thread.sleep(1000);
		//click on logout option
		pdc.LogoutButton.click();
		System.out.println("Logout option is clicked");
		logger.log(LogStatus.PASS, "Logout option is clicked");
	}
	
	public void reloginAsManager(LoginElements login, String caseName) throws InterruptedException {
		//get the url
		String url = config.getProperty("url");
		getUrl(url);
		
		String username = config.getProperty("userCURAM7Manager");
		String password = config.getProperty("pwdCURAM7Manager");
		String usernameRL = config.getProperty("userCURAM7RegionalLead");
		String passwordRL = config.getProperty("pwdCURAM7RegionalLead");
		
		if(caseName.equalsIgnoreCase("ACB") || caseName.equalsIgnoreCase("ECB") || caseName.equalsIgnoreCase("SNEB")) {
			login.curam7Login(usernameRL, passwordRL);
		}else {
			login.curam7Login(username, password);
		}

	}
	
	public void reloginAsCaseWorker(LoginElements login) throws InterruptedException {
		//get the url
		String url = config.getProperty("url");
		getUrl(url);
		
		String username = config.getProperty("userCURAM7CaseWorker");
		String password = config.getProperty("pwdCURAM7CaseWorker");
		
		login.curam7Login(username, password);
	}
	
	public boolean checkEFT(RegisterPersonElements rpe) {
		boolean EFT = false;
		//Check Deliver Pattern
		String deliveryPatternTxt = rpe.HomeDeliveryPatternTxt.getText().trim();
		System.out.println("Delivery pattern is : " + deliveryPatternTxt);
		if(deliveryPatternTxt.contains("EFT")) {
			EFT = true;
			System.out.println("Delivery type is EFT");
		}else {
			System.out.println("Delivery type is Cheque");
		}
		
		return EFT;
	}
	
	public void changeNominee() throws InterruptedException {
		//Go to Financial
		pdc.FinancialTab.click();
		System.out.println("Finacial Tab is clicked");
		logger.log(LogStatus.PASS, "Finacial Tab is clicked");
		
		//Click on Nominees
		pdc.NomineesTab.click();
		System.out.println("Nominees is clicked");
		logger.log(LogStatus.PASS, "Nominees is clicked");
		
		//Verify Nominees is opened
		Thread.sleep(1000);
		driver.switchTo().frame(2);
		String nomineesTxt = pdc.NomineesTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(nomineesTxt, "Nominees");
		System.out.println("Nominees is opened");
		logger.log(LogStatus.PASS, "Nominees is opened");
		
		//Click on Action Button
		pdc.NomineesActionMenu.click();
		System.out.println("Action Menu is clicked");
		logger.log(LogStatus.PASS, "Action Menu is clicked");
		
		//Click on Change Bank Account option
		pdc.NomineesChangeBankAccountAction.click();
		System.out.println("Change Bank Account option is clicked");
		logger.log(LogStatus.PASS, "Change Bank Account option is clicked");
		
		//Click on Select bank
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(3);
		pdc.NomineesChangeBankAccountSelectButton.click();
		System.out.println("Select Bank Account button is clicked");
		logger.log(LogStatus.PASS, "Select Bank Account button is clicked");
		
		//Click on Yes button to confirm
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(3);
		pdc.NomineesChangeBankAccountConfirmButton.click();
		System.out.println("Yes button is clicked");
		logger.log(LogStatus.PASS, "Yes button is clicked");

		
	}
	
	public void activateCase(String type) throws InterruptedException {
		//Click on Home Tab
		driver.switchTo().window(driver.getWindowHandle());
		pdc.HomeTab.click();
		System.out.println("Home Tab is clicked");
		logger.log(LogStatus.PASS, "Home Tab is clicked");
		
		if(type.equalsIgnoreCase("ACB") || type.equalsIgnoreCase("ECB") || type.equalsIgnoreCase("SNEB")) {
			//Click on Home Action menu
			driver.switchTo().frame(2);
			pdc.HomeActionMenu.click();
			System.out.println("Home Action menu is clicked");
			logger.log(LogStatus.PASS, "Home Action menu is clicked");
			
			//Click on Activate option
			pdc.ActivateButton.click();
			System.out.println("Activate option is clicked");
			logger.log(LogStatus.PASS, "Activate option is clicked");
		}else {
			driver.switchTo().frame(2);
			pdc.HomePageAction.click();
			System.out.println("Home Action menu is clicked");
			logger.log(LogStatus.PASS, "Home Action menu is clicked");
			
			//Click on Activate option
			pdc.ActivateButton2.click();
			System.out.println("Activate option is clicked");
			logger.log(LogStatus.PASS, "Activate option is clicked");
		}
		
		//Click on Yes to confirm
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(3);
		String activateTxt = pdc.ActivateTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(activateTxt, "Are you sure you want to activate this case?");
		System.out.println("Activate case window is opened");
		logger.log(LogStatus.PASS, "Activate case window is opened");
		
		//Click on Yes button
		pdc.ActivateYesButton.click();
		System.out.println("Activate Yes button is clicked");
		logger.log(LogStatus.PASS, "Activate Yes button is clicked");
		
		//CLick on Refresh button
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(2);
		Thread.sleep(3000);
		pdc.RefreshButton.click();
		System.out.println("Refresh button is clicked");
		logger.log(LogStatus.PASS, "Refresh button is clicked");
		
		//Check the Status
		String status = pdc.CaseStatus.getText().trim();
		while(!status.equalsIgnoreCase("Active")) {
			Thread.sleep(1000);
			pdc.RefreshButton.click();
			System.out.println("Refresh button is clicked again");
			logger.log(LogStatus.PASS, "Refresh button is clicked again");
			status = pdc.CaseStatus.getText().trim();
		}
		AssertTextPresentmethodWithExtendPassFail(status, "Active");
		System.out.println("The Status is: " + status);
		
	}
	
	public void submitForApproval() throws InterruptedException {
		//Click on Home Tab
		driver.switchTo().window(driver.getWindowHandle());
		pdc.HomeTab.click();
		System.out.println("Home Tab is clicked");
		logger.log(LogStatus.PASS, "Home Tab is clicked");
		
		//Click on Home Action menu
		driver.switchTo().frame(2);
		pdc.HomePageAction.click();
		System.out.println("Home Action menu is clicked");
		logger.log(LogStatus.PASS, "Home Action menu is clicked");
		
		//Click on Submit for Approval option
		pdc.SubmitApprovealButton.click();
		System.out.println("Submit for Approval option is clicked");
		logger.log(LogStatus.PASS, "Submit for Approval option is clicked");
		
		//Click on Yes to confirm
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(3);
		String activateTxt = pdc.ActivateTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(activateTxt, "Are you sure you want to submit this case for approval?");
		System.out.println("Submit for Approval case window is opened");
		logger.log(LogStatus.PASS, "Submit for Approval case window is opened");
		
		//Click on Yes button
		pdc.ActivateYesButton.click();
		System.out.println("Submit for Approval Yes button is clicked");
		logger.log(LogStatus.PASS, "Submit for Approval Yes button is clicked");
		
		//CLick on Refresh button
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(2);
		Thread.sleep(3000);
		pdc.RefreshButton.click();
		System.out.println("Refresh button is clicked");
		logger.log(LogStatus.PASS, "Refresh button is clicked");
		
		//Check the Status
		String status = pdc.CaseStatus.getText().trim();
		while(!status.equalsIgnoreCase("Approved")) {
			Thread.sleep(1000);
			pdc.RefreshButton.click();
			System.out.println("Refresh button is clicked again");
			logger.log(LogStatus.PASS, "Refresh button is clicked again");
			status = pdc.CaseStatus.getText().trim();
		}
		AssertTextPresentmethodWithExtendPassFail(status, "Approved");
		System.out.println("The Status is: " + status);
		
	}
	
	public void addContracts() throws InterruptedException {
		//Go to Contracts Tab
		driver.switchTo().window(driver.getWindowHandle());
		pdc.ContractsTab.click();
		System.out.println("Contract tab is clicked");
		logger.log(LogStatus.PASS, "Contract tab is clicked");
		
		//Verify Contracts is opened
		driver.switchTo().frame(2);
		String contractsTxt = pdc.ContractsTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(contractsTxt, "Contracts");
		System.out.println("Contracts is opened");
		logger.log(LogStatus.PASS, "Contracts is opened");
		
		//Click on New Button
		pdc.ContractsNewButton.click();
		System.out.println("Contract New button is clicked");
		logger.log(LogStatus.PASS, "Contract New button is clicked");
		
		//Verify the New Contract window is opened
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(3);
		String contractDetailsTxt = pdc.ContractsDetailsTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(contractDetailsTxt, "Details");
		System.out.println("Contract window is opened");
		logger.log(LogStatus.PASS, "Contract window is opened");
		
		//Click on Save button
		pdc.ContractsSaveButton.click();
		System.out.println("Contract Save button is clicked");
		logger.log(LogStatus.PASS, "Contract Save button is clicked");
		
		//Click on Action menu
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(2);
		Thread.sleep(1000);
		pdc.ContractsActionMenu.click();
		System.out.println("Contract Action Menu is clicked");
		logger.log(LogStatus.PASS, "Contract Action Menu is clicked");
		
		//Click on Edit option
		pdc.ContractsEditOption.click();
		System.out.println("Contract Edit option is clicked");
		logger.log(LogStatus.PASS, "Contract Edit option is clicked");
		
		//Enter date signed
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(3);
		pdc.ContractsDateSigned.sendKeys(setDate(0));
		System.out.println("Contract Date Signed is entered");
		logger.log(LogStatus.PASS, "Contract Date Signed is entered");
		
		//Contract Save button is clicked
		pdc.ContractsSaveButton.click();
		System.out.println("Contract Save button is clicked");
		logger.log(LogStatus.PASS, "Contract Save button is clicked");
		
		//Check the Contract status
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(2);
		Thread.sleep(2000);
		String contractStatusTxt = pdc.ContractsStatus.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(contractStatusTxt, "Active");
		System.out.println("Contract status is: " + contractStatusTxt);
		logger.log(LogStatus.PASS, "Contract status is: " + contractStatusTxt);
		
	}
	
	public void addMonitors() {
		//Go to Monitors tab
		driver.switchTo().window(driver.getWindowHandle());
//		verifyErrorsNotPresentWithOutPassReport();
		pdc.MonitorsTab.click();
		System.out.println("Monitors tab is clicked");
		logger.log(LogStatus.PASS, "Monitors tab is clicked");
		
		//Verify Monitors tab is opened
		driver.switchTo().frame(2);
		String monitorsTxt = pdc.MonitorsText.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(monitorsTxt, "Monitors");
		System.out.println("Monitors tab is opened");
		logger.log(LogStatus.PASS, "Monitors tab is opened");
		
		//Click the Initial Monitor Action button
		pdc.MonitorsActionInitial.click();
		System.out.println("Initial Monitor Action button is clicked");
		logger.log(LogStatus.PASS, "Initial Monitor Action button is clicked");
		
		//Click the Record Monitor Option
		pdc.MonitorsInitalRecordOption.click();
		System.out.println("Record Monitor Option for Initial is clicked");
		logger.log(LogStatus.PASS, "Record Monitor Option for Initial is clicked");
		
		//Verify the Monitor window is opened
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(3);
//		verifyErrorsNotPresentWithOutPassReport();
		String monitorsWindowTxt = pdc.MonitorsClientInfoTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(monitorsWindowTxt, "Client Information");
		System.out.println("Monitor window is opened");
		logger.log(LogStatus.PASS, "Monitor window is opened");
		
		//Enter Monitor schedule
		pdc.MonitorsScheduleDate.sendKeys(setDate(0));
		System.out.println("Initial Monitor Schedule Date is entered");
		logger.log(LogStatus.PASS, "Initial Monitor Schedule Date is entered");
		
		//Click on Save button
		pdc.MonitorsSaveButton.click();
		System.out.println("Initial Monitor Save button is clicked");
		logger.log(LogStatus.PASS, "Initial Monitor Save button is clicked");
		
		//Click on Final Monitor action menu
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(2);
//		verifyErrorsNotPresentWithOutPassReport();
		pdc.MonitorsActionFinal.click();
		System.out.println("Final Monitor Action menu is clicked");
		logger.log(LogStatus.PASS, "Final Monitor Action menu is clicked");
		
		//Click on Record Monitor option
		pdc.MonitorsFinalRecordOption.click();
		System.out.println("Final Record Monitor option is clicked");
		logger.log(LogStatus.PASS, "Final Record Monitor option is clicked");
		
		//Verify the Monitor window is opened
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(3);
//		verifyErrorsNotPresentWithOutPassReport();
		monitorsWindowTxt = pdc.MonitorsClientInfoTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(monitorsWindowTxt, "Client Information");
		System.out.println("Monitor window is opened");
		logger.log(LogStatus.PASS, "Monitor window is opened");
		
		//Enter Monitor schedule
		pdc.MonitorsScheduleDate.sendKeys(setDate(0));
		System.out.println("Initial Monitor Schedule Date is entered");
		logger.log(LogStatus.PASS, "Initial Monitor Schedule Date is entered");
		
		//Click on Save button
		pdc.MonitorsSaveButton.click();
		System.out.println("Initial Monitor Save button is clicked");
		logger.log(LogStatus.PASS, "Initial Monitor Save button is clicked");
		
	}
}
