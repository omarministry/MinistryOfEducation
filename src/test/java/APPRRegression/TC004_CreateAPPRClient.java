package APPRRegression;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRCreateClientElements;
import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class TC004_CreateAPPRClient extends testbaseforproject{
	public static String clientID;
	
	public String getClientID() {
		return clientID;
	}
	
	APPRLoginPageElements alpe;
	APPRLeftNavElements alne;
	APPRCreateClientElements acce;
	
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
		
		//Start the Process of creating Client in APPR
		alne = new APPRLeftNavElements(driver);
		alne.APPRClientEntry.click();
		Thread.sleep(1000);
		//test
		
		//Start entering SIN number
		acce = new APPRCreateClientElements(driver);
		acce.APPRClientSearchSIN1.sendKeys(randomNumber());
		acce.APPRClientSearchSIN2.sendKeys(randomNumber());
		acce.APPRClientSearchSIN3.sendKeys(randomNumber());
		acce.APPRClientSearchButton.click();
		System.out.println("SIN number searched");
		logger.log(LogStatus.PASS, "SIN number searched successful");
		
		//Start create new client
		acce.APPRClientNextButton.click();
		acce.APPRClientYesRadioButton.click();
		acce.APPRClientNextStepButton.click();
		Thread.sleep(2000);
		
		//Enter TOSS code on Choose a trade/occupation page
		String chooseTradeTxt = acce.APPRClientChooseTradeTxt.getText();
		AssertTextPresentmethodWithExtendPassFail(chooseTradeTxt, "Choose a trade/occupation");
		logger.log(LogStatus.PASS, "Landing on Choose trade page");
		acce.APPRClientTOSSCode.sendKeys("268R");
		acce.APPRClientTradeNextStepButton.click();
		Thread.sleep(2000);
		
		//Enter Personal Information
		String personalInfoTxt = acce.APPRClientPersonalInfoTxt.getText();
		AssertTextPresentmethodWithExtendPassFail(personalInfoTxt, "Personal Information");
		Faker fake = new Faker();
		String firstName = fake.name().firstName();
		if(firstName.contains("'")) {
			System.out.println("Text has Single Quote");
			System.out.println("Text with Single Quote:  " + firstName);
			firstName = firstName.replaceAll("'", "");
		}
		acce.APPRClientFirstName.sendKeys(firstName);
		System.out.println("First name is entered");
		
		String lastName = fake.name().lastName();
		if(lastName.contains("'")) {
			System.out.println("Text has Single Quote");
			System.out.println("Text with Single Quote: " + lastName);
			lastName = lastName.replaceAll("'", "");
		}
		acce.APPRClientLastName.sendKeys(lastName);
		System.out.println("Last name is entered");
		
		acce.APPRClientDayforDateOfBirth.sendKeys("01");
		acce.APPRClientMonthforDateOfBirth.sendKeys("12");
		acce.APPRClientYearforDateOfBirth.sendKeys("1986");
		acce.APPRClientPhone1.sendKeys("437");
		acce.APPRClientPhone2.sendKeys("125");
		acce.APPRClientPhone3.sendKeys("3640");
		System.out.println("Phone number is entered");
		
		acce.APPRClientFemaleRadioButton.click();
		System.out.println("Gender Famale radio button clicked");
		
		acce.APPRClientEducationG12.click();
		System.out.println("G12 selected");
		
		acce.APPRClientPreferredLanguageRadioButton.click();
		System.out.println("Preferred English is clicked");
		
		acce.APPRClientPostalCode.sendKeys("M1T1T5");
		acce.APPRClientPostalCodeLookUpButton.click();
		System.out.println("Postal Code Look Up button clicked");
		
		//Postal Code look up page
		String postalCodePageTxt = acce.APPRClientPostalCodePageTxt.getText();
		AssertTextPresentmethodWithExtendPassFail(postalCodePageTxt, "Postal Code Look-up");
		logger.log(LogStatus.PASS, "Land on Postal code look-up page");
		
		acce.APPRClientStreetNumber.sendKeys("03");
		acce.APPRClientPostalCodeNextButton.click();
		Thread.sleep(1000);
		
		acce.APPRClientPersonalInfoNextStepButton.click();
		Thread.sleep(3000);
		
		//On Required Document page
		String requiredDocTxt = acce.APPRClientRequiredDocTxt.getText();
		AssertTextPresentmethodWithExtendPassFail(requiredDocTxt, "Required Documents");
		logger.log(LogStatus.PASS, "Landing on Required Documents page");
		
		acce.APPRClientProofOfAgeCheckbox.click();
		acce.APPRClientProofOfEducationCheckbox.click();
		acce.APPRClientProofOfSINCheckbox.click();
		acce.APPRClientRequiredDocumentNextStepButton.click();
		System.out.println("Required Documents page Next Button clicked");
		logger.log(LogStatus.PASS, "All required documents checked");
		Thread.sleep(1000);
		
		//On Confirm Party Identification page
		String confirmPartyTxt = acce.APPRClientConfirmPartyTxt.getText();
		AssertTextPresentmethodWithExtendPassFail(confirmPartyTxt, "Confirm Party Identification");
		logger.log(LogStatus.PASS, "Land on Confirm Party Identification page");
		
		acce.APPRClientConfirmRadioButton.click();
		if(acce.APPRClientConfirmYesRadioButton.isDisplayed()) {
			acce.APPRClientConfirmYesRadioButton.click();
		}
		acce.APPRClientConfirmButton.click();
		System.out.println("Confirm Party Identification confirm button clicked");
		Thread.sleep(1000);
		
		//On Confirm Application page
		String confirmApplicationTxt = acce.APPRClientConfirmApplicationTxt.getText();
		AssertTextPresentmethodWithExtendPassFail(confirmApplicationTxt, "Confirm Application");
		logger.log(LogStatus.PASS, "Land on Confirm Appliation page");

		acce.APPRClientSubmitAsApprovedButton.click();
		System.out.println("Submit as approved button clicked");
		Thread.sleep(1000);
		
		//On Application Summary page
		String applicationSummaryTxt = acce.APPRClientApplicationSummaryTxt.getText();
		AssertTextPresentmethodWithExtendPassFail(applicationSummaryTxt, "Application Summary");
		logger.log(LogStatus.PASS, "Land on Application Summary page");
		
		clientID = acce.APPRClientID.getText();
		System.out.println("New created Client ID: " + clientID);
		logger.log(LogStatus.PASS, "Created a client successfully with ID: " + clientID);
		
		String filePath = System.getProperty("user.dir") + "\\src";
		ReadWriteDataToExcel dataExcel = new ReadWriteDataToExcel();
		int value = Integer.parseInt(clientID);
		dataExcel.writeExcel(filePath, "Data.xlsx", "Client", value);
		System.out.println("Client ID is written to the file");
		logger.log(LogStatus.PASS, "Client ID is written to the file");
		
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

