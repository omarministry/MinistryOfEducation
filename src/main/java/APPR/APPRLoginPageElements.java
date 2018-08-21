package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import testbase.testbaseforproject;

public class APPRLoginPageElements extends testbaseforproject {
	
WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public APPRLoginPageElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of APPR Login page Elements   ==============
	
		@FindBy(xpath="html/body/table[7]/tbody/tr/td[4]/form/table[2]/tbody/tr[1]/td[2]/input")
		public WebElement ApprLoginUserName;
		
		@FindBy(xpath="html/body/table[7]/tbody/tr/td[4]/form/table[2]/tbody/tr[2]/td[2]/input[2]")
		public WebElement ApprLoginPassword;
		
		@FindBy(xpath="html/body/table[7]/tbody/tr/td[4]/form/table[2]/tbody/tr[2]/td[3]/input")
		public WebElement ApprLoginSubmit;
		
		@FindBy(xpath="html/body/table[8]/tbody/tr/td[4]/table[1]/tbody/tr/td")
		public WebElement ApprSuccessWorkQuesText;
		
		
		
		
		public void apprLogin(String userID, String password) throws InterruptedException {
			
			ApprLoginUserName.sendKeys(userID);
			logger.log(LogStatus.PASS, "Login page displayed successfully");
			logger.log(LogStatus.INFO, "Entered User name");
			ApprLoginPassword.sendKeys(password);
			logger.log(LogStatus.INFO, "Password entered");
			ApprLoginSubmit.click();
			logger.log(LogStatus.PASS, "Submit button clicked");
			
		}

}
