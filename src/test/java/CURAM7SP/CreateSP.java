package CURAM7SP;

import java.io.IOException;

import support.ReadWriteDataToExcel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.relevantcodes.extentreports.LogStatus;
import testbase.testbaseforproject;

public class CreateSP extends testbaseforproject{
	SPElements sp;
	String filePath = System.getProperty("user.dir") + "//TestData";
	ReadWriteDataToExcel data = new ReadWriteDataToExcel();
	
	public void createNewServicePlan(String programName, String referredIn, String serviceDeliverySite, String selfInitiated) throws InterruptedException, IOException {
	//	driver.switchTo().window(driver.getWindowHandle());
		
		//click on action button and select 'New Service Plan'
		sp = new SPElements(driver);
		sp.EOActionButton.click();
		sp.newServicePlan.click();
		System.out.println("New Service Plan button clicked");
		logger.log(LogStatus.INFO, "New Service Plan button clicked");
		
		//Verify pop-up window opened
		Thread.sleep(2000);
		String selectProductTypeWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(selectProductTypeWindowHandle);
		System.out.println("Switch to Create Service Plan popup window");
		logger.log(LogStatus.INFO, "Switch to Create Service Plan popup window");
		driver.switchTo().frame(3);
		String selectProductTypeTxt = sp.PopupWindowTextDetails.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(selectProductTypeTxt, "Details");
		System.out.println("Create Service Plan popup window is opened successfully");
		
		//Fill out the new service plan pop up window fields and save
		sp.selectProgram.sendKeys(programName);
		
		if (referredIn != "NA") {
			sp.referredIn.sendKeys(referredIn);
		}
		
		sp.SDS.sendKeys(serviceDeliverySite);
		
		if(programName.equalsIgnoreCase("Supported Employment")) {
			sp.TransitionalClient.sendKeys("MVHE (MOHLTC)");
		}
		

		//Checks if program has Self Initiated field
		if (selfInitiated == "Yes") {
			sp.selfInitiated.sendKeys(selfInitiated);
		}
		
		//Saves the new Service plan
		sp.saveButton.click();
		System.out.println("New Service Plan created");
		logger.log(LogStatus.PASS, "New Service Plan created");
		
		//Switch back to main window
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		System.out.println("Switch back to main window");
		
		//Close EO tab
		sp.closeEO.click();
		
		//Verify that service plan has been created
		driver.switchTo().frame(2);
		String homeTxt = sp.HomeTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(homeTxt, "Service Plan Home");
		System.out.println("Service Plan home is opened");
		logger.log(LogStatus.PASS, "Service Plan home is opened");
		
		//Print case ID for report
		String caseRef = sp.planRefNum.getText();
		System.out.println("The service plan reference number is: " + caseRef);
		logger.log(LogStatus.INFO, "The service plan reference number is: " + caseRef);
		
		//Write Case ID on excel file
		int caseRefNum = Integer.parseInt(caseRef);
		if(programName.equalsIgnoreCase("Supported Employment")){
			data.writeExcel(filePath, "CaseID.xlsx", "SP_SECaseID", caseRefNum);
			System.out.println("SE case Reference Number is written to excel file");
		}else if(programName.equalsIgnoreCase("Youth Job Connection")) {
			data.writeExcel(filePath, "CaseID.xlsx", "SP_YJCCaseID", caseRefNum);
			System.out.println("YJC case Reference Number is written to excel file");
		}else if(programName.equalsIgnoreCase("Youth Job Connection Summer")) {
			data.writeExcel(filePath, "CaseID.xlsx", "SP_YJCSCaseID", caseRefNum);
			System.out.println("YJCS case Reference Number is written to excel file");
		}else if(programName.equalsIgnoreCase("Literacy and Basic Skills")) {
			data.writeExcel(filePath, "CaseID.xlsx", "SP_LBSCaseID", caseRefNum);
			System.out.println("LBS case Reference Number is written to excel file");
		}else if(programName.equalsIgnoreCase("Employment Service")) {
			data.writeExcel(filePath, "CaseID.xlsx", "SP_ESCaseID", caseRefNum);
			System.out.println("ES case Reference Number is written to excel file");
		}else if(programName.equalsIgnoreCase("Employment Service")) {
			data.writeExcel(filePath, "CaseID.xlsx", "SP_SAO2CaseID", caseRefNum);
			System.out.println("SAO2 case Reference Number is written to excel file");
		}else if(programName.equalsIgnoreCase("Youth Job Link")) {
			data.writeExcel(filePath, "CaseID.xlsx", "SP_YJLCaseID", caseRefNum);
			System.out.println("YJL case Reference Number is written to excel file");
		}

	}
	
	public void planSummary() throws InterruptedException {
		//get todays date for acceptance
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date = format.format(now);
		
		//Switch back to main window
		String mainWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(mainWindowHandle);
		System.out.println("Switch back to main window");
		
		//go to Plan Summary tab and create a new summary
		sp.planSummaryTab.click();
		driver.switchTo().frame(2);
		sp.newPlanSummary.click();
		Thread.sleep(2000);
		
		//select and accept plan summary
		sp.selectButton.click();
		Thread.sleep(1000);
		sp.planSummaryActionButton.click();
		sp.editPlanSummary.click();
		Thread.sleep(1000);
		
		//Verify pop-up window opened
		Thread.sleep(2000);
		String selectProductTypeWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(selectProductTypeWindowHandle);
		driver.switchTo().frame(3);
		System.out.println("Switch to Modify Plan Summary popup window");
		logger.log(LogStatus.INFO, "Switch to Modify Plan Summary popup window");
		String selectProductTypeTxt = sp.PlanSummaryConfirmLabel.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(selectProductTypeTxt, "Date Accepted");
		System.out.println("Modify Plan Summary popup window is opened successfully");;
		sp.dateAccepted.sendKeys(date);
		sp.planSummarySaveButton.click();
		System.out.println("Plan summary created successfully");
		logger.log(LogStatus.PASS, "Plan summary created successfully");
	}
	
	public void globalLookupByCaseID(String sheetName) throws InterruptedException, IOException {
		//Get EOCaseID from the file
		String CaseID = Integer.toString(data.readExcel(filePath, "CaseID.xlsx", sheetName));
		
		//Search EOCaseID by global search
		sp = new SPElements(driver);
		sp.ReferenceNumberSearchField.sendKeys(CaseID);
		
		//Reports that EOCaseID is searched
		System.out.println("Case Reference Number " + CaseID + " is entered");
		logger.log(LogStatus.PASS, "Case Reference Number " + CaseID + " is entered");
		
		//Click on search button
		sp.ReferenceNumberLookUpGlassButton.click();
		System.out.println("Search button is clicked");
		logger.log(LogStatus.PASS, "Search button is clicked");

		Thread.sleep(2000);
		
		//Switch frame
		driver.switchTo().frame(2);
		System.out.println("Switch to Frame 2");
	}
}
