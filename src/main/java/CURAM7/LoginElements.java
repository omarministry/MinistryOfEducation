package CURAM7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import testbase.testbaseforproject;

public class LoginElements extends testbaseforproject{

	public LoginElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"j_username\"]")
	public WebElement Username;
	
	@FindBy(xpath="//*[@id=\"j_password\"]")
	public WebElement Password;
	
	@FindBy(xpath="/html/body/div[2]/a/span/span/span")
	public WebElement LoginButton;
	
	@FindBy(xpath="//*[@id=\"app-banner\"]/div[3]/div[2]/span")
	public WebElement Header;
	
	public void curam7Login(String userID, String password) throws InterruptedException {
		
		Username.sendKeys(userID);
		logger.log(LogStatus.PASS, "Login page displayed successfully");
		logger.log(LogStatus.INFO, "Entered User name");
		Password.sendKeys(password);
		logger.log(LogStatus.INFO, "Password entered");
		LoginButton.click();
		logger.log(LogStatus.PASS, "Login button clicked");
		
	}
}
