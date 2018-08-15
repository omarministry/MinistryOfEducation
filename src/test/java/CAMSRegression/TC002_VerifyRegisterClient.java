package CAMSRegression;

import java.awt.AWTException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.LogStatus;

import CAMS.LoginPageElements;
import CAMS.RegistrationCAMS;
import CAMS.SearchCriteriaCAMS;
import CAMS.TopAndLeftNavElements;
import testbase.testbaseforproject;

public class TC002_VerifyRegisterClient extends testbaseforproject {
	
	LoginPageElements lpe;
	TopAndLeftNavElements tlne;
	SearchCriteriaCAMS scc;
	RegistrationCAMS rc;
	
	@BeforeClass
	public void setup() {
		init();
	}
	
	//@SuppressWarnings("unchecked")
		@Test
		public void verifyLoginCamps() throws InterruptedException, AWTException {
			
			try {
		
			logger = report.startTest("Register a client ");
			lpe = new LoginPageElements(driver);
			
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			Thread.sleep(2000);
			String username = config.getProperty("userCAMPSAdmin");
			String password = config.getProperty("pwdCAMPSAdmin");
			System.out.println("User Name from Config file...." + username);
			lpe.campsLogin(username, password);
			Thread.sleep(2000);
			System.out.println("Back into main class...." );
			
			tlne = new TopAndLeftNavElements(driver);
			
			//Click Cases and Outcomes
			tlne.CasesAndOutComes.click();
			//Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Clicked Cases and Outcomes");
			System.out.println("Clicked Cases and Outcomes...." );
			
			//Click Expand Shortcuts in left nav
			tlne.ExpandShortcutsLeftNav.click();
			logger.log(LogStatus.PASS, "Clicked Expand in the left nav bottom");
			System.out.println("Clicked Expand in the left nav bottom...." );
			//Thread.sleep(1000);
			
			//Click Cases
			tlne.CasesLeftNav.click();
			Thread.sleep(1000);
			logger.log(LogStatus.PASS, "Clicked Cases in the left nav bottom");
			System.out.println("Clicked Cases in the left nav bottom...." );
			
			//Click New Case
			tlne.NewCaseLeftNav.click();
			logger.log(LogStatus.PASS, "Clicked New Case link in left nav");
			Thread.sleep(2000);
			System.out.println("Clicked New Case link in left nav...." );
			
			
			
			driver.switchTo().frame(1);
			Thread.sleep(2000);
			System.out.println("Switched to iFrame...." );
			
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
			
			String fullname = firstName+lastName;
			scc = new SearchCriteriaCAMS(driver);
			
			//Type Last name for search
			scc.LastName.sendKeys(fullname);
			logger.log(LogStatus.INFO, "Entered the name to search ======>>>> " +  fullname);
			//driver.findElement(By.xpath("//form[@id='mainForm']//input[@id='__o3id2']")).sendKeys("Test");
			//lpe.clickLastName();
			//Thread.sleep(10000);
			System.out.println("Typed Last Name " + fullname );
			
			//Click Search button
			scc.SearchBtnCAMS.click();
			//driver.findElement(By.xpath("//*[@id=\"page-action-set-\"]/a[1]/span/span/span")).click();
			System.out.println("Search button clicked...." );
			Thread.sleep(2000);
			
			//Click Continue button
			scc.ContinueBtnSearchCAMS.click();
			//driver.findElement(By.xpath("//*[@id=\"page-action-set-\"]/a[3]/span/span/span")).click();
			System.out.println("Continue button clicked...." );
			Thread.sleep(5000);
			
			rc = new RegistrationCAMS(driver);
			rc.FirstNameRegisterPerson.sendKeys("SeleniumAutomation");
			logger.log(LogStatus.INFO, "Entered the First name under Register Person section ");
			//driver.findElement(By.xpath("")).sendKeys("First name");
			System.out.println("Typed First name entered...." );
			//Thread.sleep(1000);
			
			//Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"widget___o3id9\"]/div[1]/input")));
			//dropdown.selectByIndex(1);
			//driver.findElement(By.xpath("//*[@id=\"widget___o3id9\"]/div[1]/input")).sendKeys("Male");
		
			//Status
			rc.StatusRegisterPerson.sendKeys("Canadian Citizen");
			//driver.findElement(By.xpath("//*[@id=\"__o3idf\"]")).sendKeys("Canadian Citizen");
			logger.log(LogStatus.PASS, "Status selected  ");
			System.out.println("Status Entered..." );
			//Thread.sleep(1000);
			
			//DOB
			rc.DOBRegisterPerson.sendKeys("03/05/1980");
			//driver.findElement(By.xpath("//*[@id=\"__o3ida\"]")).sendKeys("03/05/1980");
			logger.log(LogStatus.PASS, "Date of Birth entered ");
			System.out.println("DOB Entered" );
			//Thread.sleep(1000);
			
			//Preferred language
			rc.PLangRegisterPerson.sendKeys("English");
			//driver.findElement(By.xpath("//*[@id=\"__o3id11\"]")).sendKeys("English");
			logger.log(LogStatus.PASS, "Preferred Language selected ");
			System.out.println("Preferred Language...." );
			//Thread.sleep(1000);
			
			//Identity As
			rc.IdentityAsRegisterPerson.click();
			logger.log(LogStatus.PASS, "Female selected for Identity As ");
			driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div/div[3]/div/table/tbody/tr[3]/td[1]")).click();
			System.out.println("Selected female" );
			
			//Marital Status
			rc.MaritalStatusRegisterPerson.sendKeys("Married");
			//driver.findElement(By.xpath("//*[@id=\"__o3id13\"]")).sendKeys("Married");
			logger.log(LogStatus.PASS, "Marital Status selected ");
			System.out.println("Marital Status" );
			Thread.sleep(2000);
			
			//Enter Postal Code
			rc.PostalCodeRegisterPerson.sendKeys("M1M1M1");
			//driver.findElement(By.xpath("//*[@id=\"__o3id1e\"]")).sendKeys("M1M1M1");
			logger.log(LogStatus.PASS, "Postal Code Entered ");
			Thread.sleep(5000);
			
			//Click Search Postal Code
			rc.SearchPCodeRegisterPerson.click();
			//driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div/div[5]/div/table/tbody/tr/td[2]/span/a")).click();
			logger.log(LogStatus.PASS, "Click Search Postal Code ");
			//Thread.sleep(5000);
			System.out.println("Clicked Search Postal Code" );
			
			String myWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(myWindowHandle);
			driver.switchTo().frame("iframe-curam_ModalDialog_0");
			System.out.println("**** Swithced to Frame 1 second time *****" );
			
			 //Enter Street Number
			//driver.findElement(By.xpath("//*[@id=\"__o3id0\"]")).sendKeys("2559");
			rc.EnterStAddressRegisterPerson.sendKeys("2559");
			logger.log(LogStatus.PASS, "Street number entered ");
			//driver.findElement(By.xpath("//form[@id='mainForm']//input[@id='__o3id0']")).sendKeys("2559");		
			System.out.println("Entered Steet number on Child window" );
			Thread.sleep(1000);
			
			//Continue after Street Number
			rc.ContinueStAddressRegisterPerson.click();
			logger.log(LogStatus.PASS, "Continue after street address ");
			//driver.findElement(By.xpath("//*[@id=\"modal-actions-panel\"]/div/a[1]/span/span/span")).click();	
			System.out.println("Continue after St No...." );
			Thread.sleep(3000);
			
			
			//driver.switchTo().frame(0);
			//driver.switchTo().defaultContent();
			String mainWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(mainWindowHandle);
			System.out.println(mainWindowHandle);
			System.out.println("Back to main window");
			
			//driver.switchTo().frame("Content Panel - Register Person");
			driver.switchTo().frame(1);
			System.out.println("Frame switch");
			Thread.sleep(3000);
			
			//Register
			rc.RegisterLinkRegisterPerson.click();
			logger.log(LogStatus.PASS, "Clicked Register ");
			//driver.findElement(By.xpath("//*[@id=\"Curam_Person_register\"]/div[1]/div[1]/div[2]/a[1]/span/span/span")).click();
			System.out.println("Clicked Register....");
			Thread.sleep(3000);
			
			
			//Success after registration
			rc.RefNoSuccessRegisterPerson.getText();
			//String referenceNo = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/table/tbody/tr[2]/td/span")).getText();
			String referenceNo = rc.RefNoSuccessRegisterPerson.getText();
			logger.log(LogStatus.PASS, "Reference Number for successful Registration ====>>>> " + referenceNo );
			System.out.println(referenceNo);
			
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
