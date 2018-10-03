package CURAM7Regression;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
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

public class RegisterPerson extends testbaseforproject{

	LoginElements login;
	RegisterPersonElements rpe;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	@Test
	public void registerPerson() throws InterruptedException, AWTException {
		
		try {
	
		logger = report.startTest("Register Person");
		
		//Login
		login = new LoginElements(driver);
		
		String browser = config.getProperty("browser");
		if (browser.equalsIgnoreCase("IE")){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		Thread.sleep(2000);
		
		String username = config.getProperty("userCURAM7CaseWorker");
		String password = config.getProperty("pwdCURAM7CaseWorker");
		System.out.println("User Name from Config file...." + username);
		login.curam7Login(username, password);
		
		Thread.sleep(2000);
		
		String header = login.Header.getText().trim();
		AssertTextPresentmethodWithExtendPassFail(header, "CASE MANAGEMENT SYSTEM - MINISTRY CASEWORKER APPLICATION");
		System.out.println("Login Successfully");
		

		rpe = new RegisterPersonElements(driver);
		
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
	
	public void registerAPerson(RegisterPersonElements rpe) throws InterruptedException, IOException {
		
			
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
			
			//Enter lastName
			rpe.LastnameField.sendKeys(lastName);
			System.out.println("Last Name was entered");
			logger.log(LogStatus.PASS, "Last Name was entered");
			
			//Enter firstName
			rpe.FirstnameField.sendKeys(firstName);
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
			String registerDate = setDate(-8);
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
			
		
			Thread.sleep(3000);
			//Click on Register button
			rpe.RegisterButton.click();
			System.out.println("Register button clicked");
			logger.log(LogStatus.PASS, "Register button clicked");
			
			Thread.sleep(10000);
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
			
			//Click to open the Employment Ontario Home page
			rpe.EmploymentOntarioLink.click();
			System.out.println("Employment Ontario link clicked");
			logger.log(LogStatus.PASS, "Employment Ontario link clicked");
			

			
			Thread.sleep(3000);
			
			//Get the Employment Ontario Case Reference number
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			System.out.println("Tabs size: " + tabs.size());
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(2000);
			driver.switchTo().frame(3);
			System.out.println("Switch to frame 3");
			Thread.sleep(2000);
			String referenceNum = rpe.EmploymentOntarioCaseReference.getText().trim();
			System.out.println("Employment Ontario case reference number: " + referenceNum);
			int caseRefNum = Integer.parseInt(referenceNum);
			
			ReadWriteDataToExcel data = new ReadWriteDataToExcel();
			String filePath = System.getProperty("user.dir") + "//TestData";
			data.writeExcel(filePath, "CaseID.xlsx", "ClientReferenceNum", clientRef);
			System.out.println("Client Reference Number is written to excel file");
			data.writeExcel(filePath, "CaseID.xlsx", "EOCaseID", caseRefNum);
			System.out.println("EO Reference Number is written to excel file");
			
			//Close EO tab
			driver.switchTo().window(driver.getWindowHandle());
			rpe.CloseEO.click();
			
			//Close Register Person tab
			rpe.CloseRegisterPerson.click();
	}
	

	@AfterClass
	public void endTest() {
		report.endTest(logger);
		report.flush();
		driver.quit();
	}
	
}
