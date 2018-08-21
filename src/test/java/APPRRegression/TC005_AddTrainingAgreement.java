package APPRRegression;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRClientTabElements;
import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import APPR.ClientSearchElementsOnRight;
import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class TC005_AddTrainingAgreement extends testbaseforproject{

	APPRLoginPageElements alpe;
	APPRLeftNavElements alne;
	ClientSearchElementsOnRight cseor;
	APPRClientTabElements acte;
	
	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void createClientFlow() throws Throwable {
		
		try {
	
		logger = report.startTest("Successful Login");
		
		alpe = new APPRLoginPageElements(driver);
		
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
	
		Thread.sleep(2000);
		String username = config.getProperty("userNameAPPR");
		String password = config.getProperty("PasswordAPPR");
		System.out.println("User Name from Config file...." + username);
		alpe.apprLogin(username, password);
		
		//Thread.sleep(10000);
		
		String workQueTxt = alpe.ApprSuccessWorkQuesText.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(workQueTxt, "Work Queues");
		
		//Click on search client on Left Nav
		alne = new APPRLeftNavElements(driver);
		alne.APPRclientLeftNav.click();
		
		//Search Client by ID get from the excel file
		String filePath = System.getProperty("user.dir") + "\\src";
		ReadWriteDataToExcel dataExcel = new ReadWriteDataToExcel();
		String clientID = dataExcel.readExcel(filePath, "Data.xlsx", "Client");
		cseor = new ClientSearchElementsOnRight(driver);
		cseor.clientID.sendKeys(clientID);
		cseor.SearchButtonClientSearch.click();
		cseor.clientSearchResultClickableName.click();
		Thread.sleep(1000);
		
		//On Client General Tab
		acte = new APPRClientTabElements(driver);
		String generalTxt = acte.APPRClientGeneralTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(generalTxt, "General");
		logger.log(LogStatus.PASS, "Landing on Client General tab");

		
		//On Client Program Participation tab
		acte.APPRClientProgramParticipationTab.click();
		Thread.sleep(1000);
		String programParticipationTxt = acte.APPRClientProgramParticipationTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(programParticipationTxt, "Program Participation");
		logger.log(LogStatus.PASS, "Landing on Program Participation tab");
		
		//Add training agreement
		acte.APPRClientProgramParticipationCheckbox.click();
		acte.APPRClientProgramParticipationAddTAOption.click();
		acte.APPRClientProgramParticipationGoButton.click();
		Thread.sleep(1000);
		
		//On Add New training agreement page
		String newTATxt = acte.APPRClientPPAddNewTATxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(newTATxt, "Add a New Competency-based Training Agreement");
		logger.log(LogStatus.PASS, "Landing on Add new TA page");
		acte.APPRClientPPAddNewTAYesRadioButton.click();
		acte.APPRClientPPAddNewTASearchSponsorButton.click();
		Thread.sleep(1000);
		
		//On Search sponsor page
		String sponsorTxt = acte.APPRClientPPAddNewTASponsorTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(sponsorTxt, "Search Sponsor/Employer");
		logger.log(LogStatus.PASS, "Landing on Search Sponsor page");
		
		//Read sponsor from data file and search
		String sponsorID = dataExcel.readExcel(filePath, "Data.xlsx", "Sponsor");
		acte.APPRClientPPAddNewTASponsorIDField.sendKeys(sponsorID);
		acte.APPRClientPPAddNewTASponsorSearchButton.click();
		Thread.sleep(1000);
		
		acte.APPRClientPPAddNewTASponsorSearchRadioButton.click();
		acte.APPRClientPPAddNewTASponsorSearchReturnButton.click();
		logger.log(LogStatus.PASS, "Sponsor was selected successfully");
		Thread.sleep(1000);
		
		//Enter Employed date
		acte.APPRClientPPAddNewTADayofEmployed.sendKeys("01");
		acte.APPRClientPPAddNewTAMonthofEmployed.sendKeys("12");
		acte.APPRClientPPAddNewTAYearofEmployed.sendKeys("2017");
		
		//Enter Registration Date
		acte.APPRClientPPAddNewTADayofReg.sendKeys("02");
		acte.APPRClientPPAddNewTAMonthofReg.sendKeys("12");
		acte.APPRClientPPAddNewTAYearofReg.sendKeys("2017");
		
		//Save Training Agreement
		acte.APPRClientPPAddNewTASaveButton.click();
		Thread.sleep(2000);
		
		//Back to Program Participation tab
		acte.APPRClientPPNav.click();
		
		//Go to TA tab
		acte.APPRClientTATab.click();
		Thread.sleep(1000);
		String TATxt = acte.APPRClientTATxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(TATxt, "Training Agreements");
		logger.log(LogStatus.PASS, "Landing on TA tab");
		
		//Check TA status is Pending
		String TAstatus = acte.APPRClientTAStatus.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(TAstatus, "Pending");
		logger.log(LogStatus.PASS, "TA status is: " + TAstatus);
		
		//Register TA
		acte.APPRClientTACheckbox.click();
		acte.APPRClientTARegisterOption.click();
		acte.APPRClientTAGoButton.click();
		Thread.sleep(1000);
		
		//Go to Change TA status page
		acte.APPRClientTAConsultantSelection.click();
		acte.APPRClientTASaveButton.click();
		Thread.sleep(1000);
		
		//Go back to TA page
		acte.APPRClientTANav.click();
		TAstatus = acte.APPRClientTAStatus.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(TAstatus, "Registered");
		logger.log(LogStatus.PASS, "TA status has been changed to: " + TAstatus);
		
		}catch (Exception e) {
			
			
			logger.log(LogStatus.FAIL, " Test is NOT successful due to the following exception " + logger.addScreenCapture(testbaseforproject.screenshot()));
			logger.log(LogStatus.INFO, e);
			
			
		}
	
	}

	@AfterClass
	public void endTest() {
		report.endTest(logger);
		report.flush();
		driver.quit();
	}
}
