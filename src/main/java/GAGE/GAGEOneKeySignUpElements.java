package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import testbase.testbaseforproject;

public class GAGEOneKeySignUpElements extends testbaseforproject {
	
WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGEOneKeySignUpElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of Gage OneKey SignUp page Elements   ==============
	
		@FindBy(xpath="//*[@id='SignUpBold']/a")
		public WebElement SignUpNowLink;
		
		@FindBy(xpath="//*[@id='oneKeyId']")
		public WebElement ChooseOneKeyID;
		
		@FindBy(xpath="//*[@id='password1']")
		public WebElement OneKeyPwd;
		
		@FindBy(xpath="//*[@id='password2']")
		public WebElement ConfirmOneKeyPwd;
		
		@FindBy(xpath="//*[@id='termAndCondition']")
		public WebElement IAcceptOneKey ;
		
		@FindBy(xpath="//*[@id='securityQuestion1']")
		public WebElement SecurityQ1 ;
		
		@FindBy(xpath="//*[@id='securityAnswer1']")
		public WebElement SecurityQ1Answer ;
		
		@FindBy(xpath="//*[@id='securityQuestion2']")
		public WebElement SecurityQ2 ;
		
		@FindBy(xpath="//*[@id='securityAnswer2']")
		public WebElement SecurityQ2Answer ;
		
		@FindBy(xpath="//*[@id='securityQuestion3']")
		public WebElement SecurityQ3 ;
		
		@FindBy(xpath="//*[@id='securityAnswer3']")
		public WebElement SecurityQ3Answer ;
		
		@FindBy(xpath="//*[@id='submitForm']")
		public WebElement OneKeySignUpButton ;
		
		
		@FindBy(xpath="//*[@id='wrapper']/form/p[1]/strong")
		public WebElement ConfirmOneKeyUserFinalStep ;
		
		@FindBy(xpath="//*[@id='Continue']")
		public WebElement ConfirmOneKeySignUp ;
		
		
		
		
}
