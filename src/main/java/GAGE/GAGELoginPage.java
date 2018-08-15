package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import testbase.testbaseforproject;

public class GAGELoginPage extends testbaseforproject {

WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGELoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of Gage OneKey Login page Elements   ==============
	
	@FindBy(xpath="//*[@id=\"ldap_user\"]")
	public WebElement OneKeyLoginUserID;
	
	@FindBy(xpath="//*[@id=\"ldap_password\"]")
	public WebElement OneKeyLoginPassword;
	
	//@FindBy(xpath="//*[@id=\"Login\"]")
	@FindBy(xpath="//input[@id='Login']")
	public WebElement OneKeySignInButton;
	
	
	@FindBy(xpath="//*[@id=\"current-security-question\"]")
	public WebElement  SecurityQuestionTxtAfterLogin;
	
	
	@FindBy(xpath="//*[@id=\"answer\"]")
	public WebElement SecurityAnswerAfterLogin;
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-session-boot/div[2]/div/div/appr-two-factor/form/div[5]/div/button")
	public WebElement SecurityAnswerConfirmAfterLogin;
	
	
	@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-router/appr-gage-application/div/div/form/div[1]/div/h3")
	public WebElement BusInfoAfterLoginTxt;
	
	
	
	public void gageOneKeyLogin(String emailAddress, String password) throws InterruptedException {
		OneKeyLoginUserID.sendKeys(emailAddress);
		OneKeyLoginPassword.sendKeys(password);
		Thread.sleep(2000);
		OneKeySignInButton.click();
		System.out.println("After clicking the SignIN button");
		logger.log(LogStatus.PASS, "Submit button clicked");
		
	}
	
	public void handleSecurityAnswer() {
		if(SecurityQuestionTxtAfterLogin.getText().equalsIgnoreCase("What was your favourite childhood cartoon?")) {
			SecurityAnswerAfterLogin.sendKeys("cartoon");
			SecurityAnswerConfirmAfterLogin.click();
			System.out.println("inside question 1");
			//Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Login Successful");
		}
		else if(SecurityQuestionTxtAfterLogin.getText().equalsIgnoreCase("What is your grandmother's (on your mother's side) maiden name?")) {
			SecurityAnswerAfterLogin.sendKeys("name");
			SecurityAnswerConfirmAfterLogin.click();
			System.out.println("inside question 2");
			//Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Login Successful");
		}
		
		else if(SecurityQuestionTxtAfterLogin.getText().equalsIgnoreCase("What was the name of the street you lived on as a child?")) {
			SecurityAnswerAfterLogin.sendKeys("child");
			SecurityAnswerConfirmAfterLogin.click();
			System.out.println("inside question 3");
			//Thread.sleep(2000);
			logger.log(LogStatus.PASS, "Login Successful");
		}
	}
	
	/*public void campsLogin(String emailAddress, String password) throws InterruptedException {
		
		UserNameCamps.sendKeys(emailAddress);
		logger.log(LogStatus.PASS, "Login page displayed successfully");
		logger.log(LogStatus.INFO, "Entered User name");
		PwdCamps.sendKeys(password);
		logger.log(LogStatus.INFO, "Password entered");
		LoginSubmitCamps.click();
		logger.log(LogStatus.PASS, "Submit button clicked");
		
	}*/
	
	
}
