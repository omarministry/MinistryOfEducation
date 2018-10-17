package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRTOSSElements extends testbaseforproject{

	public APPRTOSSElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of the Elements TOSS  ==============
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement TossSearchTxt;
	
	@FindBy(xpath="//*[@id=\"toss\"]")
	public WebElement TossCodeField;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr[2]/td[1]/input")
	public WebElement TossSearchButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[4]/tbody/tr[1]/td/a")
	public WebElement TossSearchResult;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement TossGeneralTxt;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[1]/tbody/tr/td[2]")
	public WebElement TossName;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[5]/tbody/tr[7]/td[2]/a")
	public WebElement TossStatus;
	
}
