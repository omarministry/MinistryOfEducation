package CAMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import testbase.testbaseforproject;

public class LoginPageElements extends testbaseforproject {
	WebDriverWait wait = new WebDriverWait(driver, 90);
	public LoginPageElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of the Elements of login page  ==============
	
		@FindBy(xpath="//input[@id='j_username']")
		public WebElement UserNameCamps;
		
		@FindBy(xpath="//input[@id='j_password']")
		public WebElement PwdCamps;
		
		@FindBy(xpath="//div[2]/a/span/span/span")
		public WebElement LoginSubmitCamps;
		
		@FindBy(xpath="//form[@id='mainForm']//div[@class='cluster cluster-with-header is-uncollapsed label-field']//input[@id='__o3id2']")
		public WebElement lastNameCamps;
		
		

		
		
		public void campsLogin(String emailAddress, String password) throws InterruptedException {
			
			UserNameCamps.sendKeys(emailAddress);
			logger.log(LogStatus.PASS, "Login page displayed successfully");
			logger.log(LogStatus.INFO, "Entered User name");
			PwdCamps.sendKeys(password);
			logger.log(LogStatus.INFO, "Password entered");
			LoginSubmitCamps.click();
			logger.log(LogStatus.PASS, "Submit button clicked");
			
		}
		
		
		public void clickLastName() {
			wait.until(ExpectedConditions.elementToBeClickable(lastNameCamps));
			lastNameCamps.sendKeys("test");
		}

}
