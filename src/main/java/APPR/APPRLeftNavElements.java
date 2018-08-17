package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRLeftNavElements extends testbaseforproject {
	
	public APPRLeftNavElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of the Elements Under Search in Left Nav  ==============
	
		//--- Client under Search ---
		@FindBy(xpath="//table[8]/tbody/tr/td[1]/table/tbody/tr[6]/td/a") 
		public WebElement APPRclientLeftNav;
		
		//--- Sponsor under Search ---
		@FindBy(xpath="html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[30]/td/a") 
		public WebElement APPRSponsorLeftNav;
		
		//---Program Entry
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[27]/td/a") 
		public WebElement APPRClientEntry;
}

