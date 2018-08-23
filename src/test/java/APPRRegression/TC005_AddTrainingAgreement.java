package APPRRegression;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	public void fullClientFlow() throws Throwable {
		
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
		int clientIDValue = dataExcel.readExcel(filePath, "Data.xlsx", "Client");
		String clientID = Integer.toString(clientIDValue);
		cseor = new ClientSearchElementsOnRight(driver);
		cseor.clientID.sendKeys(clientID);
		cseor.SearchButtonClientSearch.click();
		cseor.clientSearchResultClickableName.click();
		System.out.println("Search client successfully");
		Thread.sleep(1000);
		
		//On Client General Tab
		acte = new APPRClientTabElements(driver);
		String generalTxt = acte.APPRClientGeneralTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(generalTxt, "General");
		logger.log(LogStatus.PASS, "Landing on Client General tab");

		
		//On Client Program Participation tab
		acte.APPRClientProgramParticipationTab.click();
		System.out.println("Program Participation tab clicked");
		Thread.sleep(1000);
		String programParticipationTxt = acte.APPRClientProgramParticipationTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(programParticipationTxt, "Program Participation");
		logger.log(LogStatus.PASS, "Landing on Program Participation tab");
		
		//Validate the Program participation status is Active
		String PPstatus = acte.APPRClientProgramParticipationStatus.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(PPstatus, "Active");
		System.out.println("Program Paricipation status is " + PPstatus);
		logger.log(LogStatus.PASS, "Program Paricipation status is " + PPstatus);
		
		//Add training agreement
		acte.APPRClientProgramParticipationCheckbox.click();
		acte.APPRClientProgramParticipationAddTAOption.click();
		acte.APPRClientProgramParticipationGoButton.click();
		System.out.println("Add new Training Agreement option clicked");
		Thread.sleep(1000);
		
		//On Add New training agreement page
		String newTATxt = acte.APPRClientPPAddNewTATxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(newTATxt, "Add a New Competency-based Training Agreement");
		logger.log(LogStatus.PASS, "Landing on Add new TA page");
		acte.APPRClientPPAddNewTAYesRadioButton.click();
		acte.APPRClientPPAddNewTASearchSponsorButton.click();
		System.out.println("Search Sponsor button clicked");
		Thread.sleep(1000);
		
		//On Search sponsor page
		String sponsorTxt = acte.APPRClientPPAddNewTASponsorTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(sponsorTxt, "Search Sponsor/Employer");
		logger.log(LogStatus.PASS, "Landing on Search Sponsor page");
		
		//Read sponsor from data file and search
		int sponsorIDvalue = dataExcel.readExcel(filePath, "Data.xlsx", "Sponsor");
		String sponsorID = Integer.toString(sponsorIDvalue);
		acte.APPRClientPPAddNewTASponsorIDField.sendKeys(sponsorID);
		acte.APPRClientPPAddNewTASponsorSearchButton.click();
		Thread.sleep(1000);
		
		acte.APPRClientPPAddNewTASponsorSearchRadioButton.click();
		acte.APPRClientPPAddNewTASponsorSearchReturnButton.click();
		System.out.println("Sponsor was selected successfully");
		logger.log(LogStatus.PASS, "Sponsor was selected successfully");
		Thread.sleep(1000);
		
		//Enter Employed date
		acte.APPRClientPPAddNewTADayofEmployed.sendKeys("01");
		acte.APPRClientPPAddNewTAMonthofEmployed.sendKeys("12");
		acte.APPRClientPPAddNewTAYearofEmployed.sendKeys("2017");
		System.out.println("Employed date entered");
		
		//Enter Registration Date
		acte.APPRClientPPAddNewTADayofReg.sendKeys("02");
		acte.APPRClientPPAddNewTAMonthofReg.sendKeys("12");
		acte.APPRClientPPAddNewTAYearofReg.sendKeys("2017");
		System.out.println("Registration date entered");
		
		//Save Training Agreement
		acte.APPRClientPPAddNewTASaveButton.click();
		System.out.println("Save button clicked");
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
		System.out.println("TA status is: " + TAstatus);
		logger.log(LogStatus.PASS, "TA status is: " + TAstatus);
		
		//Register TA
		acte.APPRClientTACheckbox.click();
		acte.APPRClientTARegisterOption.click();
		acte.APPRClientTAGoButton.click();
		System.out.println("Register TA option selected");
		Thread.sleep(1000);
		
		//Go to Change TA status page
		acte.APPRClientTAConsultantSelection.click();
		acte.APPRClientTASaveButton.click();
		System.out.println("Change status Save button clicked");
		Thread.sleep(1000);
		
		//Go back to TA page
		acte.APPRClientTANav.click();
		TAstatus = acte.APPRClientTAStatus.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(TAstatus, "Registered");
		System.out.println("TA status is: " + TAstatus);
		logger.log(LogStatus.PASS, "TA status has been changed to: " + TAstatus);
		
		//Go to Schooling tab
		acte.APPRClientSchoolingTab.click();
		Thread.sleep(1000);
		String schoolingTxt = acte.APPRClientSchoolingTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(schoolingTxt, "Schooling");
		System.out.println("Schooling Tab clicked");
		logger.log(LogStatus.PASS, "Land on Schooling tab");
		
		//Schedule level 1 class to the client and complete it
		completeAClass("level1ClassID");
		System.out.println("--------- Level 1 completed --------");
		logger.log(LogStatus.PASS, "Level 1 completed");
		
		//Schedule level2 class to the client and complete it
		completeAClass("level2ClassID");
		System.out.println("--------- Level 2 completed --------");
		logger.log(LogStatus.PASS, "Level 2 completed");
		
		//Schedule level3 class to the client and complete it
		completeAClass("level3ClassID");
		System.out.println("--------- Level 3 completed --------");
		logger.log(LogStatus.PASS, "Level 3 completed");
		
		//Go to Reportable Subjects Tab
		acte.APPRClientReportableSubjectsTab.click();
		Thread.sleep(1000);
		String reportableSubjectTxt = acte.APPRClientReportableSubjectTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(reportableSubjectTxt, "Reportable Subject");
		System.out.println("On Reportable Subject page");
		logger.log(LogStatus.PASS, "Land on Reportable subjects page");
		
		//Expand Level 1 and validate all subjects status
		acte.APPRClientRSExpandLevel1.click();
		
		System.out.println("---- Level 1 ----");
		
		for(int i = 3; i <= 10; i++) {
			String xpathSubject = "tbody/tr[" + i + "]/td[2]";
			String xpathStatus = "tbody/tr[" + i + "]/td[3]";
			WebElement columnSubject = acte.APPRClientRSTableLevel1.findElement(By.xpath(xpathSubject));
			WebElement columnStatus = acte.APPRClientRSTableLevel1.findElement(By.xpath(xpathStatus));
			String subject = columnSubject.getText().trim();
			String status = columnStatus.getText().trim();
			System.out.println(subject + " --> " + status);
			logger.log(LogStatus.PASS, subject + " --> " + status);
		}
		
		System.out.println("---- Level 2 ----");
		acte.APPRClientRSExpandLevel2.click();
		for(int i = 3; i <= 10; i++) {
			String xpathSubject = "tbody/tr[" + i + "]/td[2]";
			String xpathStatus = "tbody/tr[" + i + "]/td[3]";
			WebElement columnSubject = acte.APPRClientRSTableLevel2.findElement(By.xpath(xpathSubject));
			WebElement columnStatus = acte.APPRClientRSTableLevel2.findElement(By.xpath(xpathStatus));
			String subject = columnSubject.getText().trim();
			String status = columnStatus.getText().trim();
			System.out.println(subject + " --> " + status);
			logger.log(LogStatus.PASS, subject + " --> " + status);
		}
		
		System.out.println("---- Level 3 ----");
		acte.APPRClientRSExpandLevel3.click();
		for(int i = 3; i <= 10; i++) {
			String xpathSubject = "tbody/tr[" + i + "]/td[2]";
			String xpathStatus = "tbody/tr[" + i + "]/td[3]";
			WebElement columnSubject = acte.APPRClientRSTableLevel3.findElement(By.xpath(xpathSubject));
			WebElement columnStatus = acte.APPRClientRSTableLevel3.findElement(By.xpath(xpathStatus));
			String subject = columnSubject.getText().trim();
			String status = columnStatus.getText().trim();
			System.out.println(subject + " --> " + status);
			logger.log(LogStatus.PASS, subject + " --> " + status);
		}
		
		//Go to Skills tab
		acte.APPRClientSkillsTab.click();
		Thread.sleep(1000);
		String skillsTxt = acte.APPRClientSkillsTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(skillsTxt, "Skills");
		System.out.println("On Skills page");
		logger.log(LogStatus.PASS, "Land on Skills page");
		
		//Complete all selected skills
		acte.APPRClientSkillsSelectAll.click();
		acte.APPRClientSkillsCompleteSkillOption.click();
		acte.APPRClientSkillsGoButton.click();
		Thread.sleep(1000);
		System.out.println("Complete all selected skills option clicked");
		logger.log(LogStatus.PASS, "Complete all selected skills option clicked");
		
		//Change the status of all skills
		String changeStatusTxt = acte.APPRClientSkillsChangeStatusTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(changeStatusTxt, "Change Status");
		acte.APPRClientSkillsChangeStatusSaveButton.click();
		acte.APPRClientSkillsNav.click();
		Thread.sleep(1000);
		
		String skillsNoneTxt = acte.APPRClientSkillsNoneTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(skillsNoneTxt, "None");
		System.out.println("The skill set is: " + skillsNoneTxt);
		logger.log(LogStatus.PASS, "The skill set is: " + skillsNoneTxt);
		System.out.println("All skills are completed");
		logger.log(LogStatus.PASS, "All skills are completed");
		
		//Go to Completion tab
		acte.APPRClientCompletionTab.click();
		Thread.sleep(1000);
		String completionTxt = acte.APPRClientCompletionTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(completionTxt, "Completion");
		System.out.println("On Completion page");
		logger.log(LogStatus.PASS, "Land on Completion page");
		
		//Complete the Completion activities
		acte.APPRClientCompletionTSSignedOffCheckbox.click();
		acte.APPRClientCompletionDurationMetRadioButton.click();
		acte.APPRClientCompletionProofOfCompletionSelection.click();
		String uploadFilePath = System.getProperty("user.dir") + "\\src\\fileUpload.txt";
		acte.APPRClientCompletionUploadButton.sendKeys(uploadFilePath);
		System.out.println("File Upload successfully");
		logger.log(LogStatus.PASS, "File upload successfully");
		
		acte.APPRClientCompletionReviewer.sendKeys("Dan");
		acte.APPRClientCompletionSaveButton.click();
		System.out.println("Completion Save button clicked");
		logger.log(LogStatus.PASS, "Completion Save button clicked");
		
		//update OCOT
		String url = "jdbc:oracle:thin:@cscdtovsdbor045:1521/EOISQA_APPR";
		String DBusername = "asaqa";
		String DBpassword = "asaqa";
		updateDB(Integer.parseInt(clientID), url, DBusername, DBpassword);
		Thread.sleep(1000);

		//Complete Training Agreement
		acte.APPRClientTATab.click();
		Thread.sleep(1000);
		acte.APPRClientTACheckbox.click();
		acte.APPRClientTACompleteOption.click();
		acte.APPRClientTAGoButton.click();
		System.out.println("Complete Training Agreement option clicked");
		logger.log(LogStatus.PASS, "Complete Training Agreement option clicked");
		Thread.sleep(1000);
		
		//Save change status
		acte.APPRClientTASaveButton.click();
		Thread.sleep(1000);
		acte.APPRClientTANav.click();
		Thread.sleep(1000);
		
		//Validate the TA status as completed
		TAstatus = acte.APPRClientTAStatus.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(TAstatus, "Completed");
		System.out.println("TA status is: " + TAstatus);
		logger.log(LogStatus.PASS, "TA status is:" + TAstatus);
		
		//Change Program participation status to Completed Training
		acte.APPRClientProgramParticipationTab.click();
		Thread.sleep(1000);
		acte.APPRClientProgramParticipationCheckbox.click();
		acte.APPRClientProgramParticipationCompleteOption.click();
		acte.APPRClientProgramParticipationGoButton.click();
		Thread.sleep(1000);
		System.out.println("Complete PP option clicked");
		logger.log(LogStatus.PASS, "Complete PP option clicked");
		
		//Save change status
		acte.APPRClientProgramParticipationSaveButton.click();
		Thread.sleep(1000);
		acte.APPRClientPPNav.click();
		Thread.sleep(1000);
		
		//Validate the Program Participation status is Completed Training
		PPstatus = acte.APPRClientProgramParticipationStatus.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(PPstatus, "Completed Training");
		System.out.println("PP status is: " + PPstatus);
		logger.log(LogStatus.PASS, "PP status is: " + PPstatus);
		
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
	
	public void completeClassChangeStatus() throws InterruptedException {
		String changeStatusTxt = acte.APPRClientSchoolingClassChangeStatusTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(changeStatusTxt, "Change Status");
		System.out.println("On class change status page");
		logger.log(LogStatus.PASS, "Land on class change status page");
		acte.APPRClientSchoolingClassChangeStatusSaveButton.click();
		System.out.println("Change Status Save button clicked");
		
		//Go back to View Class list page
		acte.APPRClientSchoolingClassListNav.click();
		Thread.sleep(1000);
	}
	
	public void completeAClass(String inputClassID) throws InterruptedException {
		acte.APPRClientSchoolingScheduleClassOption.click();
		acte.APPRClientSchoolingGoButton.click();
		System.out.println("Schedule client to a class option selected");
		logger.log(LogStatus.PASS, "Schedule client to a class option selected");
		Thread.sleep(1000);
		
		//Go to Class Search page
		String classSearchTxt = acte.APPRClientSchoolingClassSearchTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(classSearchTxt, "Class Search");
		System.out.println("On class search page");
		logger.log(LogStatus.PASS, "Land on Class Search page");
		
		//Search a class
		String classID = config.getProperty(inputClassID);
		acte.APPRClientSchoolingClassIDField.sendKeys(classID);
		acte.APPRClientSchoolingClassSearchButton.click();
		System.out.println("Class search button clicked");
		logger.log(LogStatus.PASS, "Class search button clicked");
		
		//Select the searched class
		acte.APPRClientSchoolingClassRadioButton.click();
		acte.APPRClientSchoolingClassReturnButton.click();
		System.out.println("Return class button clicked");
		logger.log(LogStatus.PASS, "Return class button clicked");
		Thread.sleep(1000);
		
		//Validate the status of the client in a class
		String classStatus = acte.APPRClientSchoolingStatusOffered.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(classStatus, "Offered");
		System.out.println("The class status is: " + classStatus);
		logger.log(LogStatus.PASS, "Class Status is: " + classStatus);
		
		//Go to class list page
		acte.APPRClientSchoolingClassLink.click();
		Thread.sleep(1000);
		String classListTxt = acte.APPRClientSchoolingClassListTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(classListTxt, "View Class List");
		System.out.println("On View Class List page");
		logger.log(LogStatus.PASS, "Land on View Class List page");
		
		//Filter client by status Offer and confirm client to class
		acte.APPRClientSchoolingClassStatusOffered.click();
		Thread.sleep(1000);
		acte.APPRClientSchoolingClassClientSelectCheckbox.click();
		acte.APPRClientSchoolingClassConfirmOption.click();
		acte.APPRClientSchoolingClassListGoButton.click();
		System.out.println("Confirm client to class option selected");
		logger.log(LogStatus.PASS, "Confirm client to class option selected");
		Thread.sleep(1000);
		
		//Save class change status
		completeClassChangeStatus();
		
		//Filter client by status Confirmed and enroll client
		acte.APPRClientSchoolingClassStatusConfirmed.click();
		Thread.sleep(1000);
		acte.APPRClientSchoolingClassClientSelectCheckbox.click();
		acte.APPRClientSchoolingClassEnrollOption.click();
		acte.APPRClientSchoolingClassListGoButton.click();
		System.out.println("Enroll client to class option selected");
		logger.log(LogStatus.PASS, "Enroll client to class option selected");
		Thread.sleep(1000);
		
		//Save class change status
		completeClassChangeStatus();
		
		//Filter client by status Enrolled and validate client
		acte.APPRClientSchoolingClassStatusEnrolled.click();
		Thread.sleep(1000);
		acte.APPRClientSchoolingClassClientSelectCheckbox.click();
		acte.APPRClientSchoolingClassValidateOption.click();
		acte.APPRClientSchoolingClassListGoButton.click();
		System.out.println("Validate client to class option selected");
		logger.log(LogStatus.PASS, "Validate client to class option selected");
		Thread.sleep(1000);
		
		//Save class change status
		completeClassChangeStatus();
		
		//Filter client by status Validated and indicate client as Passed
		acte.APPRClientSchoolingClassStatusValidated.click();
		Thread.sleep(1000);
		acte.APPRClientSchoolingClassClientSelectCheckbox.click();
		acte.APPRClientSchoolingClassPassOption.click();
		acte.APPRClientSchoolingClassListGoButton.click();
		System.out.println("Record selected client as passed option selected");
		logger.log(LogStatus.PASS, "Record selected client as passed option selected");
		Thread.sleep(1000);
		
		//Go back to Schooling page
		acte.APPRClientSchoolingNav.click();
		Thread.sleep(1000);
		
		//Validate the status of the client in a class
		classStatus = acte.APPRClientSchoolingStatusCompleted.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(classStatus, "Completed");
	}
	
	public void updateDB(int clientID, String url, String username, String password) throws SQLException {
		Connection con = null;
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connected to DB....");
			
			//queries
			String updateOCOTInClient = "update CLIENT set OCOT_MEMBERSHIP_ID = ? where PARTY_ID = ?";
			String getPPID = "select PROGRAM_PARTICIPATION_ID from PROGRAM_PARTICIPATION where PARTY_ID = ?";
			String insertOCOT_CLIENT = "INSERT INTO OCOT_CLIENT (PROGRAM_PARTICIPATION_ID,  CLASS, EFFECTIVE_DATE_TIME, DATE_CREATED, DATE_LAST_MODIFIED, UPDATING_USER_ID ) "
					+ "VALUES( ?, 'APPR', sysdate, SYSDATE, SYSDATE, 'OCOT')";
			String insertOCOTHistory = "INSERT INTO OCOT_CLIENT_STATUS_HIST (STATUS_ID, PROGRAM_PARTICIPATION_ID, CODE_ID, CODE_VALUE, EFFECTIVE_DATE_TIME, UPDATING_USER_ID, UPDATE_TIMESTAMP) " + 
					"VALUES (STATUS_ID_SEQ.NEXTVAL, ?,'OCOT_Client_Status','ACT', sysdate,'OCOT', SYSDATE)"; 
			String updateTA = "update TRAINING_AGREEMENT_STATUS_HIST set EFFECTIVE_DATE_TIME = (sysdate - 1) where PROGRAM_PARTICIPATION_ID = ?";
			
			//Update OCOT_MEMBERSHIP_ID in CLIENT table
			PreparedStatement pstmt = null;
			pstmt = con.prepareStatement(updateOCOTInClient);
			pstmt.setInt(1, 13100282);
			pstmt.setInt(2, clientID);
			result = pstmt.executeUpdate();
			
			con.setAutoCommit(false);
			if(result == 1) {
				con.commit();
				System.out.println("Updated successfully");
			}else {
				System.out.println("0 row is updated");
			}
			
			//Get PROGRAM_PARTICIPATION_ID
			int PPID = 0;
			pstmt = con.prepareStatement(getPPID);
			pstmt.setInt(1, clientID);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PPID = rs.getInt(1);
				System.out.println("Program Participation ID is : " + PPID);
			}
			
			//Insert record to OCOT_CLIENT table
			pstmt = con.prepareStatement(insertOCOT_CLIENT);
			pstmt.setInt(1, PPID);
			result = pstmt.executeUpdate();
			if(result == 1) {
				con.commit();
				System.out.println("Inserted OCOT_CLIENT successfully");
			}else {
				System.out.println("0 row is inserted to OCOT_CLIENT");
			}
			
			//Insert record to OCOT_CLIENT_STATUS_HIST table
			pstmt = con.prepareStatement(insertOCOTHistory);
			pstmt.setInt(1, PPID);
			result = pstmt.executeUpdate();
			if(result == 1) {
				con.commit();
				System.out.println("Inserted OCOT_CLIENT_STATUS_HIST successfully");
			}else {
				System.out.println("0 row is inserted to OCOT_CLIENT_STATUS_HIST");
			}
			
			//update the EFFECTIVE_DATE_TIME in TRAINING_AGREEMENT_STATUS_HIST Table
			pstmt = con.prepareStatement(updateTA);
			pstmt.setInt(1, PPID);
			result = pstmt.executeUpdate();
			if(result == 1) {
				con.commit();
				System.out.println("Updated EFFECTIVE_DATE_TIME in TRAINING_AGREEMENT_STATUS_HIST successfully");
			}else {
				System.out.println("0 row is updated in TRAINING_AGREEMENT_STATUS_HIST");
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Roll back database....");
			if(con != null) 
				con.rollback();
		}
		
	}
}
