package CAMS6;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.binary.XSSFBSheetHandler;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;

import CURAM7.LoginElements;
import CURAM7.RegisterPersonElements;
import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class CAMS6_RegisterPerson extends testbaseforproject{

	CAMS6_LoginElements login;
	CAMS6_RegisterPersonElements rpe;
	ReadWriteDataToExcel data = new ReadWriteDataToExcel();
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void registerPerson() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Register Person");
		
		//Login
		login = new CAMS6_LoginElements(driver);
		
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		Thread.sleep(2000);
		
		String username = config.getProperty("userCAMPSAdmin");
		String password = config.getProperty("pwdCAMPSAdmin");
		System.out.println("User Name from Config file...." + username);
		login.curam7Login(username, password);
		
		Thread.sleep(2000);
		
		String header = login.Header.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(header, "CASE MANAGEMENT SYSTEM - MINISTRY CASEWORKER APPLICATION");
		System.out.println("Login Successfully");
		

		rpe = new CAMS6_RegisterPersonElements(driver);
		
		//Click on Cases and Outcomes tab
		rpe.CasesAndOutComesTab.click();
		System.out.println("Cases and Outcomes tab clicked");
		logger.log(LogStatus.PASS, "Cases and Outcomes tab clicked");
		
		//click on Expand Arrow
		rpe.ExpandArrow.click();
		System.out.println("Expand Arror clicked");
		logger.log(LogStatus.PASS, "Expand Arrow clicked");
		Thread.sleep(1000);
		
		//Call registration method
		registerAPerson(rpe);
		
		
		
		} catch (Exception e) {
			
		
			logger.log(LogStatus.FAIL, " Test is NOT successful due to the following exception " + logger.addScreenCapture(testbaseforproject.screenshot()));
			logger.log(LogStatus.INFO, e);
			
			
		}
		
		}
	
	
	public String randomSIN() throws IOException {
		FileInputStream inputStream = new FileInputStream("TestData/SINNumbers.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet("SIN");
		
		int rowNumber = Integer.parseInt(generalRandomNumber(0, sheet.getLastRowNum()));
		XSSFRow row = sheet.getRow(rowNumber);
		String SINNumber = row.getCell(0).toString();
		SINNumber = SINNumber.replace(" ", "");
		return SINNumber;
	}
	
	public void registerAPerson(CAMS6_RegisterPersonElements rpe) throws InterruptedException, IOException {
		
			
			//click on Register a Person on the left panel
			rpe.RegisterPersonLeftPanelButton.click();
			System.out.println("Register a Person link on the left panel clicked");
			logger.log(LogStatus.PASS, "Register a Person link on the left panel clicked");
			

			Thread.sleep(2000);
			
			//Verify Register a Person tab opened
			driver.switchTo().frame(1);
			System.out.println("Switch to Frame 1");
			String confirmRegisterPersonTxt = rpe.RegisterPersonTabOpenText.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(confirmRegisterPersonTxt, "Confirm Person Not Already Registered");
			System.out.println("Register a Person tab opened");
			logger.log(LogStatus.PASS, "Register a Person tab opened");
			
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
			
			//Enter lastName
			rpe.LastnameField.sendKeys("AutomationSelenium");
			System.out.println("Last Name was entered");
			logger.log(LogStatus.PASS, "Last Name was entered");
			
			//Enter firstName
			rpe.FirstnameField.sendKeys(name);
			System.out.println("First Name was entered");
			logger.log(LogStatus.PASS, "First Name was entered");
			
			//Click on Search Button
			rpe.SearchButton.click();
			System.out.println("Search button clicked");
			logger.log(LogStatus.PASS, "Search Button clicked");
			
			Thread.sleep(3000);
			
			//Clicked on Continue button
			rpe.ContinueButton.click();
			System.out.println("Continue button clicked");
			logger.log(LogStatus.PASS, "Continue Button clicked");
			
			Thread.sleep(1000);
			//Verify Register person main page is opened
			String registerPersonTxt = rpe.RegisterPersonTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(registerPersonTxt, "Register Person");
			System.out.println("On Register Person main page");
			logger.log(LogStatus.PASS, "On Register Person main page");
			
			
			//Enter I Identify As
			rpe.IdentityField.sendKeys("Male");
			System.out.println("I Identify As field is entered");
			logger.log(LogStatus.PASS, "I Identify As field is entered");
			
			//Enter Registration date
			String registerDate = setDate(-9);
			rpe.RegistrationDate.clear();
			rpe.RegistrationDate.sendKeys(registerDate);
			System.out.println("Registration Date is entered: " + registerDate);
			logger.log(LogStatus.PASS, "Registration Date is entered: " + registerDate);
			
			//Enter Status in Canada
			rpe.StatusInCanadaField.sendKeys("Canadian Citizen");
			System.out.println("Status in Canada field is entered");
			logger.log(LogStatus.PASS, "Status in Canada field is entered");
			
			//Enter Preferred Language
			rpe.PreferLanguageField.sendKeys("English");
			System.out.println("Preferred Language is entered");
			logger.log(LogStatus.PASS, "Preferred Language is entered");
			
			//Enter Marital Status 
			rpe.MaritalStatusField.sendKeys("Common Law");
			System.out.println("Marital Status field is entered");
			logger.log(LogStatus.PASS, "Marital Status field is entered");
			
			//Enter APPRID
			String APPRID = generalRandomNumber(1000000, 9000000);
			rpe.APPRID.sendKeys(APPRID);
			System.out.println("APPR ID is entered: " + APPRID);
			logger.log(LogStatus.PASS, "APPR ID is entered: " + APPRID);
			
			//Enter Date of Birth
			rpe.DateOfBirthField.sendKeys("29/06/1985");
			System.out.println("Date of Birth field is entered");
			logger.log(LogStatus.PASS, "Date of Birth field is entered");
			
			//enter SIN number
			String SIN = randomSIN();
			rpe.SINField.sendKeys(SIN);
			System.out.println("SIN Number is entered");
			logger.log(LogStatus.PASS, "SIN Number is entered");
			
			//Enter Postal Code
			rpe.PostalCodeLookUpField.sendKeys("M1T1T5");
			System.out.println("Postal Code Lookup is entered");
			logger.log(LogStatus.PASS, "Postal Code Lookup is entered");
			
			//Click Postal Code Lookup Search button
			rpe.PostalCodeSearchButton.click();
			System.out.println("Postal Code Lookup Search button clicked");
			logger.log(LogStatus.PASS, "Postal Code Lookup Search button clicked");
			Thread.sleep(3000);
			
			//Switch to popup window
			String popUpWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(popUpWindowHandle);
			driver.switchTo().frame(2);
			System.out.println("Switch to popup window frame");
			
			//Enter Street Number
			rpe.StreetNumberField.sendKeys("13");
			System.out.println("Street Number is entered");
			logger.log(LogStatus.PASS, "Street Number is entered");
			
			//Click on Continue Button on Address Details
			rpe.AddressDetailsContinueButton.click();
			System.out.println("Continue button clicked");
			logger.log(LogStatus.PASS, "Continue button clicked");
			
			//Switch back to main window
			String mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			driver.switchTo().frame(1);
			System.out.println("Switch back to Main window");
			
		
			Thread.sleep(1000);
			//Click on Register button
			rpe.RegisterButton.click();
			System.out.println("Register button clicked");
			logger.log(LogStatus.PASS, "Register button clicked");
			
			Thread.sleep(1000);
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			if(driver.findElements(By.id("error-messages")).size() != 0) {
				String error = rpe.ErrorMessageAPPRPartyIDExsits.getText().trim();
				if(error.contains("E4285")) {
					System.out.println("APPR Client Party ID already exists");
					logger.log(LogStatus.INFO, "APPR Client Party ID already exists");
					
					//generate another APPR ID
					APPRID = generalRandomNumber(1000000, 9000000);
					rpe.APPRID.clear();
					rpe.APPRID.sendKeys(APPRID);
					System.out.println("APPR ID is entered: " + APPRID);
					logger.log(LogStatus.PASS, "APPR ID is entered: " + APPRID);
					

				}else if (error.contains("E1710")) {
					System.out.println("SIN already exists");
					logger.log(LogStatus.INFO, "SIN already exists");
					
					//Enter another SIN
					SIN = randomSIN();
					rpe.SINField.clear();
					rpe.SINField.sendKeys(SIN);
					System.out.println("SIN Number is entered");
					logger.log(LogStatus.PASS, "SIN Number is entered");
					
					//Click on Register button
					rpe.RegisterButton.click();
					System.out.println("Register button clicked");
					logger.log(LogStatus.PASS, "Register button clicked");
				}
			}
			
			//Verify Person Registration Completed
			String completedTxt = rpe.RegistrationCompletedTxt.getText().trim();
			AssertTextPresentmethodWithExtendPassFail(completedTxt, "Person Registration Completed");
			System.out.println("Person Registration Completed");
			logger.log(LogStatus.PASS, "Person Registration Completed");
			
			
			//Get Client Reference Number
			String clientRefNum = rpe.CLientReferenceNum.getText().trim();
			System.out.println("Length: " + clientRefNum.length());
			clientRefNum = clientRefNum.substring(32, 39);
			System.out.println("Client Reference Number: " + clientRefNum);
			logger.log(LogStatus.PASS, "Client Reference Number: " + clientRefNum);
			int clientRef = Integer.parseInt(clientRefNum);
			
			//Click to open the Employment Ontario Home pages
			rpe.EmploymentOntarioLink.click();
			System.out.println("Employment Ontario link clicked");
			logger.log(LogStatus.PASS, "Employment Ontario link clicked");
			

			
			Thread.sleep(1000);
			
			//Get the Employment Ontario Case Reference number
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			System.out.println("Tabs size: " + tabs.size());
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(1000);
			driver.switchTo().frame(3);
			System.out.println("Switch to frame 3");
			Thread.sleep(1000);
			String referenceNum = rpe.EmploymentOntarioCaseReference.getText().trim();
			System.out.println("Employment Ontario case reference number: " + referenceNum);
			int caseRefNum = Integer.parseInt(referenceNum);
			
			ReadWriteDataToExcel data = new ReadWriteDataToExcel();
			String filePath = System.getProperty("user.dir") + "//TestData";
			data.writeExcel(filePath, "CaseID_CAMS6.xlsx", "ClientReferenceNum", clientRef);
			System.out.println("Client Reference Number is written to excel file");
			data.writeExcel(filePath, "CaseID_CAMS6.xlsx", "EOCaseID", caseRefNum);
			System.out.println("EO Reference Number is written to excel file");
			
			//Close EO tab
			driver.switchTo().window(driver.getWindowHandle());
			rpe.CloseEO.click();
			
			//Close Register Person tab
			rpe.CloseRegisterPerson.click();
	}
	
	public void addBankAccount(CAMS6_RegisterPersonElements rpe) throws InterruptedException, IOException {
		Thread.sleep(1000);
		//Click on Client
		rpe.ClientCaseLink.click();
		System.out.println("Client lick is clicked");
		logger.log(LogStatus.PASS, "Client lick is clicked");
		Thread.sleep(1000);
		
		//Get the array of tabs
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Number of tabs: " + tabs.size());
		driver.switchTo().window(tabs.get(0));
		System.out.println("Switch to tab 1");
		Thread.sleep(1000);
//		driver.switchTo().frame(4);
//		System.out.println("Switch to frame 4");
		
		//Verify Person Home is opened
//		String personHomeTxt = rpe.PersonHomeTxt.getText().trim();
//		AssertTextPresentmethodWithExtendPassFail(personHomeTxt, "Person Home");
//		System.out.println("Person Home is opened");
//		logger.log(LogStatus.PASS, "Person Home is opened");
		
		
//		Thread.sleep(1000);
		rpe.FinancialsTab.click();
		System.out.println("Finalcials Tab is clicked");
		logger.log(LogStatus.PASS, "Finalcials Tab is clicked");
		
		//Go to Bank Accounts
		rpe.BankAccountsTab.click();
		System.out.println("Bank Accounts is clicked");
		logger.log(LogStatus.PASS, "Bank Accounts is clicked");
		
		//Verify Bank Accounts is opened
		driver.switchTo().frame(4);
		String bankAccountsTxt = rpe.BankAccountsTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(bankAccountsTxt, "Bank Accounts");
		System.out.println("Bank Accounts page is opened");
		logger.log(LogStatus.PASS, "Bank Accounts page is opened");
		
		//Click on Bank Account New button
		rpe.BankAccountsNewButton.click();
		System.out.println("Bank Account New button is clicked");
		logger.log(LogStatus.PASS, "Bank Account New button is clicked");
		
		Thread.sleep(1000);
		
		//Verify the Create Bank account popup window is open
		String bankAccountWindow = driver.getWindowHandle();
		driver.switchTo().window(bankAccountWindow);
		driver.switchTo().frame(5);
		String detalsTxt = rpe.BankAccountsDetailsTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(detalsTxt, "Details");
		System.out.println("Create Bank Account popup window is opened");
		logger.log(LogStatus.PASS, "Create Bank Account popup window is opened");
		
		//Enter Account Name
		rpe.BankAccountsName.sendKeys("Automation Test");
		System.out.println("Bank Account Name is entered");
		logger.log(LogStatus.PASS, "Bank Account Name is entered");
		
		//Enter Account Number
		String accountNumber = generalRandomNumber(100000000, 999999999);
		rpe.BankAccountsNumber.sendKeys(accountNumber);
		System.out.println("Bank Account Number is entered");
		logger.log(LogStatus.PASS, "Bank Account Number is entered");
		
		//Click on Bank Branch lookup glass
		rpe.BankBranchLookupGlass.click();
		System.out.println("Bank Branch lookup glass is clicked");
		logger.log(LogStatus.PASS, "Bank Branch lookup glass is clicked");
		
		//Switch to bank Branch Search window
		String bankBranchWindow = driver.getWindowHandle();
		driver.switchTo().window(bankBranchWindow);
		driver.switchTo().frame(6);
		String searchCritiriaTxt = rpe.BankSearchTxt.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(searchCritiriaTxt, "Search Criteria");
		System.out.println("Bank Branch Search Window is opened");
		logger.log(LogStatus.PASS, "Bank Branch Search Window is opened");
		
		//Enter Institution Number
		rpe.BankInstitutionNumber.sendKeys("0003");
		System.out.println("Institution Number is entered");
		logger.log(LogStatus.PASS, "Institution Number is entered");
		
		//Enter Branch Number
		rpe.BankNumber.sendKeys("00616");
		System.out.println("Bank Branch Number is entered");
		logger.log(LogStatus.PASS, "Bank Branch Number is entered");
		
		//Click on Search Button
		rpe.BankSearchButton.click();
		System.out.println("Bank Search button is clicked");
		logger.log(LogStatus.PASS, "Bank Search button is clicked");
		
		Thread.sleep(1000);
		
		//Click on Select bank button
		rpe.BankSelectButton.click();
		System.out.println("Bank Select Button is clicked");
		logger.log(LogStatus.PASS, "Bank Select Button is clicked");
		
		//Enter From Date
		bankAccountWindow = driver.getWindowHandle();
		driver.switchTo().window(bankAccountWindow);
		driver.switchTo().frame(5);
		rpe.BankFrom.sendKeys(setMonday(-10));
		System.out.println("From Date is set");
		logger.log(LogStatus.PASS, "From Date is set");
		
		//Click on Save button
		rpe.BankSaveButton.click();
		System.out.println("Save Button is clicked");
		logger.log(LogStatus.PASS, "Save Button is clicked");
		
		//Re-enter the Account Number
		driver.switchTo().window(driver.getWindowHandle());
		driver.switchTo().frame(4);
		rpe.ReEnterAccountNumber.sendKeys(accountNumber);
		System.out.println("Re-enter Account Number");
		logger.log(LogStatus.PASS, "Re-enter Account Number");
		
		//Click on Save Button
		rpe.SaveAccountButton.click();
		System.out.println("Re-enter Account Number Save Button is clicked");
		logger.log(LogStatus.PASS, "Re-enter Account Number Save Button is clicked");
		
		//Close Person tab
		driver.switchTo().window(driver.getWindowHandle());
		rpe.CloseEO.click();
		System.out.println("Close the tab");
		logger.log(LogStatus.PASS, "CLose the tab");
		
		driver.switchTo().window(driver.getWindowHandle());
		
	}
	

	@AfterClass
	public void endTest() {
		report.endTest(logger);
		report.flush();
//		driver.quit();
	}
	
}
