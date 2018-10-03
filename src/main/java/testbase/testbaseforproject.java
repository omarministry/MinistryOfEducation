package testbase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import support.ConfiguratorSupport;
import support.DeleteFile;
import support.FindFile;
import support.Xls_Reader;

public class testbaseforproject {
	
	public static WebDriver driver;
	public ConfiguratorSupport config= new ConfiguratorSupport("config.properties");
	//String url = "https://www.koodomobile.com/";
	String browser = "firefox";
	//public static WebDriverWait wait;
	
	public static ExtentReports report;
	public static ExtentTest logger;
	public static Xls_Reader reader;
	public static DeleteFile delete;
	public static FindFile findfile;
	
	
	
	@BeforeTest
	public void report()
	{
		report = new ExtentReports("Reports/MyReports.html");
		report.addSystemInfo("Environment", "PROD");
		report.addSystemInfo("Release", "Commerce");
		
		
		
	}
	
	public void init(){
		selectBrowser(config.getProperty("browser"));
		//Read url from Property File
		getUrl(config.getProperty("url"));
		//getUrl("https://digital:notwebchannel@koodo-my-account.qa11-prod.wctest.telus.com/my-account/");
		//getUrl("https://identity.koodomobile.com/as/authorization.oauth2?pc=0&client_id=unifiedss_koodo&response_type=code&scope=priceplaninfo+securitymgmt+usagedetails+profilemanagement+invoiceinfo+usagemanagement+accountactivity+subscriberinfo+paymentmanagement+accountinfo+usagepreferencemanagement+usageblockmanagement+profileinfohighdetail+devicemanagement+serviceeligibility+loyaltyandrewards+usagemeter+customerinfo+accountmanagement+paymentprocessing+ciiLogin+ordermgmt&redirect_uri=https%3A%2F%2Fwww.koodomobile.com%2Fmy-account%2Foauth_callback");
		//getUrl("https://www.koodomobile.com/");	
		
	
	}
	
	public void selectBrowser(String browser){
		
		if(browser.equalsIgnoreCase("firefox")){
			//System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/drivers/geckodriver");
			
			//System.setProperty("webdriver.gecko.driver", "C:\\Users\\x201640\\Documents\\Omar\\Automation Related\\Automation Tools Downloads\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			
			
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(capability);
			
			
			 
		}
		else if(browser.equalsIgnoreCase("chrome")){
			//System.out.println(System.getProperty("user.dir"));
			//System.setProperty("webdriver.chrome.marionette", System.getProperty("user.dir") + "drivers\\chromedriver");
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		else if(browser.equalsIgnoreCase("IE")){
			//System.out.println(System.getProperty("user.dir"));
			//System.setProperty("webdriver.chrome.marionette", System.getProperty("user.dir") + "drivers\\chromedriver");
			
			//System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver","drivers\\IEDriverServer.exe");
			DesiredCapabilities capability = new DesiredCapabilities();
			//capability.setCapability("ignoreZoomSetting", true);
			capability.setBrowserName("IE");
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			driver = new InternetExplorerDriver(capability);
			
			
			
			//driver = new InternetExplorerDriver();
			
		}
		

	}
	
	public void getUrl(String url){
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//add change to go to region/language   
//		 driver.findElement(By.xpath("//*[@id='edit-languages']/div[1]/label")).click();
//	     driver.findElement(By.xpath("//*[@id='edit-regions']/div[9]/label/span[1]")).click();
	    
	}

	public static String screenshot()
	{
		String src_path=System.getProperty("user.dir")+"Screenshot\\";
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			//FileUtils.copyFile(scrFile, new File(src_path+uuid+".jpeg"));
			// TODO: handle exception
		}
		catch(Exception e)
		{
			System.out.println("Unable tp capture screenshot");
		}
		return src_path+uuid+".jpeg";
	}
	
	public void verityTextPresentTestBase(WebElement webElement, String textToVerify, String featureUnderTest) {
		
		try 
		{
		if(webElement.getText().equalsIgnoreCase(textToVerify))
		{
			System.out.println(featureUnderTest);
			logger.log(LogStatus.PASS, featureUnderTest + " has " + textToVerify);
		}
		else
		{
			throw new Exception();
		}
		
		} catch (Exception e) {
			
			logger.log(LogStatus.FAIL,  featureUnderTest + " has NO  " + textToVerify +logger.addScreenCapture(testbaseforproject.screenshot()));
			System.out.println(featureUnderTest);
			//logger.log(LogStatus.INFO, e);
		}
		
	}
	
	public void urlRedirectTextPresent(WebElement webElement, String textToVerify, String featureUnderTest, int rowNo) {
		
		try 
		{
		if(webElement.getText().equalsIgnoreCase(textToVerify))
		{
			System.out.println(rowNo);
			logger.log(LogStatus.FAIL,  featureUnderTest + " ---> HAS " + textToVerify + " Row No: " + rowNo  + logger.addScreenCapture(testbaseforproject.screenshot()));
			
		}
		else
		{
			throw new Exception();
		}
		
		} catch (Exception e) {
			
			
			logger.log(LogStatus.PASS, featureUnderTest + " ---> HAS no " + textToVerify + " Row No: " + rowNo );
			System.out.println(rowNo);
		}
		
	}
	
	
	public void verifyErrorsNotPresent() {
		if(driver.getPageSource().contains("Oh la la") && driver.getPageSource().contains("Il semble que cette page est introuvable") )
		{
			logger.log(LogStatus.FAIL,  "Error message " +  " Oh la la  " + "Displayed" );
			System.out.println(" Oh la la ");
		}
		else if(driver.getPageSource().contains("Oh zut") )
		{
			logger.log(LogStatus.FAIL,  "Error message " +  " Oh zut  " + "Displayed" );
		}
		else if(driver.getPageSource().contains("Oh snap") && driver.getPageSource().contains("Looks like this page wasn't found on our server.") ) {
			logger.log(LogStatus.FAIL,  "Error message " +  " Oh snap  " + "Displayed" );
		}
		else if(driver.getPageSource().contains("Oh no!") && driver.getPageSource().contains("That page cannot be found")){
			System.out.println("Oh no Found");
			
			logger.log(LogStatus.FAIL,  "Error message " +  " Oh no!  " + "Displayed" );
		}
		else if(driver.getPageSource().contains("Access Denied")){
			System.out.println("Access Denied Found");
			
			logger.log(LogStatus.FAIL,  "Error message " +  " Access Denied  " + "Displayed" );
		}
		else if(driver.getPageSource().contains("Page not found")){
			System.out.println("*****Page Not Found......****");
			
			logger.log(LogStatus.FAIL,  "Error message " +  " Page not found  " + "Displayed" );
		}
		else {
			logger.log(LogStatus.PASS, "No errors displayed on the page");
			
		}

	}
	
	public void verifyErrorsNotPresentWithOutPassReport() {
		if(driver.getPageSource().contains("Oh la la") && driver.getPageSource().contains("Il semble que cette page est introuvable") )
		{
			logger.log(LogStatus.FAIL,  "Error message " +  " Oh la la  " + "Displayed" );
			System.out.println(" Oh la la ");
		}
		else if(driver.getPageSource().contains("Oh zut") )
		{
			logger.log(LogStatus.FAIL,  "Error message " +  " Oh zut  " + "Displayed" );
		}
		else if(driver.getPageSource().contains("Oh snap") && driver.getPageSource().contains("Looks like this page wasn't found on our server.") ) {
			logger.log(LogStatus.FAIL,  "Error message " +  " Oh snap  " + "Displayed" );
		}
		else if(driver.getPageSource().contains("Oh no!") && driver.getPageSource().contains("That page cannot be found")){
			System.out.println("Oh no Found");
			
			logger.log(LogStatus.FAIL,  "Error message " +  " Oh no!  " + "Displayed" );
		}
		else if(driver.getPageSource().contains("Access Denied")){
			System.out.println("Access Denied Found");
			
			logger.log(LogStatus.FAIL,  "Error message " +  " Access Denied  " + "Displayed" );
		}
		else if(driver.getPageSource().contains("Page not found")){
			System.out.println("*****Page Not Found......****");
			
			logger.log(LogStatus.FAIL,  "Error message " +  " Page not found  " + "Displayed" );
		}
		else {
			//logger.log(LogStatus.PASS, "No errors displayed on the page");
			
		}

	}
	
	
	public boolean AssertTextPresentmethod(String ElementText, String testToVerify) {
		
		try {
				Assert.assertEquals(ElementText, testToVerify);
				return true;
		} 
		catch(AssertionError  e) {
			return false;
		}
		
		
	}
	
	public void AssertTextPresentmethodWithExtendPassFail(String ElementText, String testToVerify) {
		
		try {
			Assert.assertEquals(ElementText, testToVerify);
			logger.log(LogStatus.PASS , " Assertion text verifed ---> " +  testToVerify  );
			//return true;
		} 
		catch(AssertionError  e) {
			logger.log(LogStatus.FAIL, " Assertion Text NOT Found. " + "Expected Text --->>> " +testToVerify + ", but found --->>> " + ElementText );
			//return false;
		}
		
	}
	
	public boolean isElementPresentTestBase(By locator)
	{
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			
			return false;
		}
	}
	
	public boolean isElementPresentTestBaseByWE(WebElement WebElementToCheck)
	{
		try {
			if(WebElementToCheck.isDisplayed()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			
			return false;
		}
	}
	
	public static void scrollDownToElementTestBase(WebElement ElementToBeScrolledDownTo) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ElementToBeScrolledDownTo);
	}
	
	public void handleSurveyPopUp() {
		
		/*hp = new homepage(driver);
		hp.ShoppingCartonHomePage.click();
		hp.ClearOrderinShoppingcart.click();
		hp.ClearButtonOnPopUpWindow.click();*/
		System.out.println("Cleared Shoping cart");
		logger.log(LogStatus.INFO, "Restarting the test");
		report.endTest(logger);
		report.flush();
		driver.quit();
		init();
		System.out.println("Home Page URL accesseed....");
	}
	
	public String randomNumber() {
		Random rand = new Random();
		int random = rand.nextInt(900) + 100;
		String randomString = Integer.toString(random);
		return randomString;
	}
	
	public String generalRandomNumber(int min, int max) {
		Random rand = new Random();
		int random = rand.nextInt(max) + min;
		String randomString = Integer.toString(random);
		return randomString;
	}
	
	public String setDate(int shiftDays) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, shiftDays);
		Date newDate = c.getTime();
		return formatter.format(newDate);
	}
	
	public String setSunday(int days) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		c.add(Calendar.DATE, days);
		Date date = c.getTime();
		return formatter.format(date);
	}
	
		
}
	
	
		

