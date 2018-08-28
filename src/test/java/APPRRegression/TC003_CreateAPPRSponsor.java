package APPRRegression;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.relevantcodes.extentreports.LogStatus;

import APPR.APPRCreateSponsorElements;
import APPR.APPRLeftNavElements;
import APPR.APPRLoginPageElements;
import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class TC003_CreateAPPRSponsor extends testbaseforproject {
	public static String sponsorID;
	APPRLoginPageElements alpe;
	APPRCreateSponsorElements acse;
	APPRLeftNavElements alne;
	
	public String getSponsorID() {
		return sponsorID;
	}
	
	@BeforeClass
	public void setup() {
		init();
	}

	@Test
	public void verifyCreateSponsor() throws Throwable {
		
		try {
	
		logger = report.startTest("Create Sponsor");
		
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
		
		//Start the Process of creating Sponsor in APPR
		alne = new APPRLeftNavElements(driver);
		alne.APPRSponsorLeftNav.click();
		Thread.sleep(1000);
		
		acse = new APPRCreateSponsorElements(driver);
		
		//Type Sponsor/Employer name
		acse.APPRSponsorNameCreateSponsor.sendKeys("Abcd");
		logger.log(LogStatus.PASS, "Sponsor name entered");
		System.out.println("Sponsor name entered");
		
		//Click Search button
		acse.APPRSearchCreateSponsor.click();
		logger.log(LogStatus.PASS, "Clicked Search button on Sponsor/Employer Search page");
		System.out.println("Clicked Search after name entered on Sponsor/Employer Search ");
		//Thread.sleep(5000);
		
		//Click Next Step on Sponsor/Employer Search page
		acse.APPRNextStepCreateSponsor.click();
		logger.log(LogStatus.PASS, "Clicked NextStep");
		System.out.println("Clicked NextStep after first search");
		
		
		//Select Yes Radio Button
		acse.APPRYesRdBtnCreateSponsor.click();
		logger.log(LogStatus.PASS, "Yes Radio button");
		System.out.println("Yes Radio button");
		
		
		//Next after yes
		acse.APPRNextStepAfterYesCreateSponsor.click();
		logger.log(LogStatus.PASS, "Next Step after Yes Radio button");
		System.out.println("Next Step after Yes Radio button");
		
		
		//Type TOSS Code
		acse.APPRTossCodeCreateSponsor.sendKeys("268R");
		logger.log(LogStatus.PASS, "Entred TOSS Code");
		System.out.println("Toss Code");
		Thread.sleep(2000);
		
		//Next After Toss Code
		acse.APPRNextAfterTossCodeCreateSponsor.click();
		logger.log(LogStatus.PASS, "Next Step after TOSS Code");
		System.out.println("Next Step after Toss Code");
		
		
		//Yes radio button for Location 
		acse.APPRRBtnLocaionOntCreateSponsor.click();
		logger.log(LogStatus.PASS, "Yes Radio button for location");
		System.out.println("Yes Radio button for location");
		//Thread.sleep(5000);
		
		//Yes radio button for trainers
		acse.APPRRBtnTrainersCreateSponsor.click();
		logger.log(LogStatus.PASS, "Yes Radio button for location");
		System.out.println("Yes Radio button for trainers");
		Thread.sleep(2000);
		
		//NextStep on Progra mQuestions page
		
		
		
		acse.APPRNextOnPrQuestionsCreateSponsor.submit();
		logger.log(LogStatus.PASS, "Next Step on Program Question");
		System.out.println("Next Step on Program Question");
		Thread.sleep(1000);
		
		//****Enter details on Sponsor/Employer Information
		
		//Select Employer Radio button
		acse.APPRRBtnTypeEmployerCreateSponsor.click();
		logger.log(LogStatus.PASS, "Employer Type Radio button selected");
		System.out.println("Employer Type Radio button selected");
		Thread.sleep(1000);
		
		//Enter Sponsor name
		//Retrieve random name to enter in Last Name for Search
		Faker f = new Faker();
		String firstName=f.name().firstName();
		if(firstName.contains("'"))
		{
			
			System.out.println("Text has Single Quote");
			System.out.println("Text with Single Quote:  "+firstName);
			firstName = firstName.replaceAll("'","");
		}
						
		String lastName=f.name().lastName();
		if(lastName.contains("'"))
		{
			
			System.out.println("Text has Single Quote");
			System.out.println("Text with Single Quote:  "+lastName);
			lastName = lastName.replaceAll("'","");
		}
		
		String cell = f.phoneNumber().cellPhone();
		IdNumber number = f.idNumber();
		System.out.println(cell + " " + number);
		
		String fullname = firstName+lastName;
		
		f.idNumber().ssnValid();
		
		/*WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(acse.APPREmployerNameTwoCreateSponsor));*/
		
		
		
//		 WebElement searchbox = null;
//
//		    Thread.sleep(1000);
//		    searchbox = (WebElement) (((JavascriptExecutor) driver).executeScript("return document.getElementById('sponsor');", searchbox));
//		    searchbox.sendKeys("hello");

			
		acse.APPREmployerNameTwoCreateSponsor.sendKeys(fullname);
		logger.log(LogStatus.PASS, "Employer Full name entered: " + fullname);
		System.out.println("Employer Full name entered");
		
		//Enter Owner name
		acse.APPROwnerCreateSponsor.sendKeys(fullname);
		logger.log(LogStatus.PASS, "Owner Full name entered: " + fullname);
		System.out.println("Owner Full name entered");
		
		//Select English as Preferred Language
		acse.APPRPlangEngCreateSponsor.click();
		logger.log(LogStatus.PASS, "Preferred Language English selected");
		System.out.println("Preferred Language English selected");
		
		
		//Enter Poster Code
		acse.APPRPostalCreateSponsor.sendKeys("M1M1M1");
		logger.log(LogStatus.PASS, "Postal Code entered");
		System.out.println("Postal Code entered");
		
		//Click Address Lookup
		acse.APPRAddrLookUpCreateSponsor.click();
		logger.log(LogStatus.PASS, "Clicked Address Look up");
		System.out.println("Clicked Address Look up");
		
		//Enter Street Number
		acse.APPRStNoCreateSponsor.sendKeys("2559");
		logger.log(LogStatus.PASS, "Entered Street number");
		System.out.println("Entered Street number");
		
		
		//Click next after street number
		acse.APPRNextAfterStNoCreateSponsor.click();
		logger.log(LogStatus.PASS, "Clicked Next after Street number");
		System.out.println("Clicked Next after Street number");
		
		//Enter Contacat name
		acse.APPRContactNameCreateSponsor.sendKeys(fullname);
		logger.log(LogStatus.PASS, "Entered contact name");
		System.out.println("Entered contact name");
		Thread.sleep(5000);
		
		//Enter Contact phone1
		acse.APPRPhoneOneCreateSponsor.sendKeys("416");
		logger.log(LogStatus.PASS, "Entered Phone 1");
		System.out.println("Entered Phone 1");
		
		//Enter Contact phone2
		acse.APPRPhoneTwoCreateSponsor.sendKeys("445");
		logger.log(LogStatus.PASS, "Entered Phone 2");
		System.out.println("Entered Phone 2");
		
		//Enter Contact phone3
		acse.APPRPhoneThreeCreateSponsor.sendKeys("7788");
		logger.log(LogStatus.PASS, "Entered Phone 3");
		System.out.println("Entered Phone 3");
		Thread.sleep(2000);
		
		/*WebElement element = acse.APPRNextStepSpInfoCreateSponsor;
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", element);  */
		
		
		//Click Next Step on Sponsor/Employer Information page
		acse.APPRNextStepSpInfoCreateSponsor.click();
		logger.log(LogStatus.PASS, "Clicked Next Step on Sponsor/Employer Information page");
		System.out.println("Clicked Next Step on Sponsor/Employer Information page");
		Thread.sleep(10000);
		
		acse.APPRRdBtnUseSpCreateSponsor.click();
		logger.log(LogStatus.PASS, "Use the Sponsor info Radio button clicked");
		System.out.println("Use the Sponsor info Radio button clicked");
		
		acse.APPRCkhYesIWantCreateSponsor.click();
		logger.log(LogStatus.PASS, "Yes I want Chk box clicked");
		System.out.println("Yes I want Chk box clicked");
		
		acse.APPRConfirmInfoCreateSponsor.click();
		Thread.sleep(1000);
		
		acse.APPRSubmitCreateSponsor.click();
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "Submitted");
		System.out.println("Submitted");
		
		sponsorID = acse.APPRSponsorID.getText().trim();
		logger.log(LogStatus.INFO, sponsorID);
		System.out.println("Sponsor ID: " + sponsorID);
		
		String filePath = System.getProperty("user.dir") + "\\src";
		ReadWriteDataToExcel dataExcel = new ReadWriteDataToExcel();
		int value = Integer.parseInt(sponsorID);
		dataExcel.writeExcel(filePath, "Data.xlsx", "Sponsor", value);
		System.out.println("Sponsor ID is written to the file");
		logger.log(LogStatus.PASS, "Sponsor ID is written to the file");
		
		} catch (Exception e) {
			
		
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
