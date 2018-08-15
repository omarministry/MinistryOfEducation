package CAMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class SearchCriteriaCAMS extends testbaseforproject {
	
WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public SearchCriteriaCAMS(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of the Elements of Search Criteria page in CAMS  ==============
	
		@FindBy(xpath="//form[@id='mainForm']//input[@id='__o3id2']")
		public WebElement LastName;
		
		@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[1]/span/span/span")
		public WebElement SearchBtnCAMS;
		
		@FindBy(xpath="//*[@id=\"page-action-set-\"]/a[3]/span/span/span")
		public WebElement ContinueBtnSearchCAMS;
		
		

}
