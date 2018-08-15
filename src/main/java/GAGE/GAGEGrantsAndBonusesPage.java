package GAGE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import testbase.testbaseforproject;

public class GAGEGrantsAndBonusesPage extends testbaseforproject{

WebDriverWait wait = new WebDriverWait(driver, 90);
	
	public GAGEGrantsAndBonusesPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of Gage OneKey Login page Elements   ==============
	
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-grants-bonuses/div[1]/h2")
			public WebElement GrantsAndBunusesPageHeaderTxt;
			
			@FindBy(xpath="//*[@id=\"firstName\"]")
			public WebElement GrantsAndBunusesFirstName;
			
			@FindBy(xpath="//*[@id=\"lastName\"]")
			public WebElement GrantsAndBunusesLastName;
			
			@FindBy(xpath="//*[@id=\"GAGE_FILTER\"]")
			public WebElement GrantsAndBunusesGageFilter;
			
			@FindBy(xpath="//*[@id=\"ECB_FILTER\"]")
			public WebElement GrantsAndBunusesECBFilter;
			
			@FindBy(xpath="//*[@id=\"LEVEL1_FILTER\"]")
			public WebElement GrantsAndBunusesLevel1Filter;
			
			@FindBy(xpath="//*[@id=\"LEVEL2_FILTER\"]")
			public WebElement GrantsAndBunusesLevel2Filter;
			
			@FindBy(xpath="//*[@id=\"LEVEL3_FILTER\"]")
			public WebElement GrantsAndBunusesLevel3Filter;
			
			@FindBy(xpath="//*[@id=\"LEVEL4_FILTER\"]")
			public WebElement GrantsAndBunusesLevel4Filter;
			
			@FindBy(xpath="//*[@id=\"COMPLETION_FILTER\"]")
			public WebElement GrantsAndBunusesCompletionFilter;
			
			@FindBy(xpath="//*[@id=\"2018\"]")
			public WebElement GrantsAndBunuses2018Filter;
			
			@FindBy(xpath="//*[@id=\"2017\"]")
			public WebElement GrantsAndBunuses2017Filter;
			
			@FindBy(xpath="//*[@id=\"2016\"]")
			public WebElement GrantsAndBunuses2016Filter;
			
			@FindBy(xpath="//*[@id=\"2015\"]")
			public WebElement GrantsAndBunuses2015Filter;
			
			@FindBy(xpath="//*[@id=\"SORT_ORDER\"]")
			public WebElement GrantsAndBunusesSortDropdown;
			
			@FindBy(xpath="/html/body/appr-root/div[2]/div/appr-router/appr-sponsor-grants-bonuses/div[2]/div/p/a")
			public WebElement GrantsAndBunusesRegistrationLink;
}
