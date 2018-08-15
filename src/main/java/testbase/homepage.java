package testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import support.SelfServeSupport;

public class homepage extends testbaseforproject {
	
	SelfServeSupport sss;
	
	
	
	@FindBy(xpath="//li[@id='li-self-serve-4423-1']/a[@title='Self Serve']")
	WebElement selfServe;
	
	@FindBy(xpath="//li[@id='li-self-serve-4423-1']")
	WebElement selfServeFromHomePage;
	
	
	@FindBy(xpath="//li[@id='li-self-serve']/a")
	WebElement selfServeAfterLogin;
	
	@FindBy(xpath="//input[@name='userIDFromHeader']")
	WebElement loginEmail;
	
	@FindBy(xpath="//input[@name='passwordFromHeader']")
	WebElement loginPassword;
	
	@FindBy(xpath="//select[@name='predefroles']")
	WebElement userDropDown;
	
	@FindBy(xpath="//input[@name='submitLogin']")
	WebElement loginSubmit;
	
	
	
	
	//***** Shopping Cart on Home Page
	@FindBy(xpath="//div[@id='site-wrapper']/header/div[1]/div[1]/div[4]/ul/li[2]/a/span")
	public WebElement ShoppingCartonHomePage;
	
	//***** Clear Order in Shopping cart
	@FindBy(xpath="//a[@id='clear-order']/span[2]/span")
	public static WebElement ClearOrderinShoppingcart;
	
	//***** Clear Button On Pop Up Window
	@FindBy(xpath="html/body/div[7]/div/div[2]/a[1]")
	public WebElement ClearButtonOnPopUpWindow;

		
		
	
	
	//**********Billing Elements***************
	@FindBy(xpath="//li[@id='li-self-serve']/ul/li[3]/a")
	WebElement billingSubMenuInSelfserve;
	
		
		public  WebElement getLogout()
	    {
	         return driver.findElement(By.xpath(".//*[@id='li-self-serve']/ul/li[8]/a"));
	    }
	
		
	public homepage(WebDriver driver){
		PageFactory.initElements(driver, this);
	
	}
	
	
	
	public void logintoapplication(String emailAddress, String password) {
		try {
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			//System.out.println("Clicked on Self Serve");
			loginEmail.sendKeys(emailAddress);
			loginPassword.sendKeys(password);
			logger.log(LogStatus.PASS, "Entered Email address " + emailAddress +" and Password "+password);
			System.out.println("Entered Email address and Password");
			loginSubmit.click();
			logger.log(LogStatus.PASS, "Clicked on Login Submit Button");
			System.out.println("Clicked on Login Submit Button");
			sss = new SelfServeSupport(driver);
			if(config.getProperty("url").contains("qa11"))
			{
				sss.enterUserNamePwdOnAuthWindow();
			}
			
			
			
		} catch (Exception e) {
			
			
			if ( (driver.getPageSource().contains("We want to hear from you!")) || (driver.getPageSource().contains("Fill out a quick 2-3 minute"))) {
				
				logger.log(LogStatus.FAIL, " Test is Terminated due to the SURVEY POP up " + logger.addScreenCapture(testbaseforproject.screenshot()));
				
			}
			else
			{
				//logger.log(LogStatus.FAIL, "Invalid email address and password");
				logger.log(LogStatus.FAIL, "Invalid email address and password " + logger.addScreenCapture(testbaseforproject.screenshot()));
				logger.log(LogStatus.INFO, e);
			}

		}
				
	}
	
	public void apprLogin(String emailAddress, String password) throws InterruptedException {
		
		loginEmail.sendKeys(emailAddress);
		logger.log(LogStatus.PASS, "Login page displayed successfully");
		logger.log(LogStatus.INFO, "Entered User name");
		loginPassword.sendKeys(password);
		logger.log(LogStatus.INFO, "Password entered");
		loginSubmit.click();
		logger.log(LogStatus.PASS, "Submit button clicked");
		
	}
	
	
	
	
	public void urltoVerify(String helpUrl) {
		String helpUrlToVerfiy =  helpUrl;
		getUrl(helpUrlToVerfiy);
	}
	
	

	
	public void verityTextPresent(WebElement webElement, String textToVerify, String featureSuccessful) {
		
		try 
		{
		if(webElement.getText().equalsIgnoreCase(textToVerify))
		{
			System.out.println("Registration Successful...message from new method");
			logger.log(LogStatus.PASS, featureSuccessful + " Successful");
		}
		else
		{
			throw new Exception();
		}
		
		} catch (Exception e) {
			
			logger.log(LogStatus.FAIL,  featureSuccessful + " is NOT successful " +logger.addScreenCapture(testbaseforproject.screenshot()));
			logger.log(LogStatus.INFO, e);
		}
	}
	
	
	
	
	
	

}




