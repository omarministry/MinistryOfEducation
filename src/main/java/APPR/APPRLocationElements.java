package APPR;

import java.awt.print.Pageable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRLocationElements extends testbaseforproject{

	public APPRLocationElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of the Elements under Location ==============
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td") 
	public WebElement APPRLocationSearchTxt;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[1]/tbody/tr[3]/td[2]/select/option[13]")
	public WebElement APPRLocationRootName;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr/td[1]/input") 
	public WebElement APPRLocationSearchButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[5]/tbody/tr[6]/td/a") 
	public WebElement APPRLocationSearchResult;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td") 
	public WebElement APPRLocationGeneralTabTxt;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[2]/tbody/tr/td[2]") 
	public WebElement APPRLocationName;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[5]/tbody/tr[18]/td[2]/a") 
	public WebElement APPRLocationRegionStatus;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[7]/tbody/tr[4]/td[3]/a") 
	public WebElement APPRLocationCentralLink;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[7]/tbody/tr[7]/td[3]/a") 
	public WebElement APPRLocationEasternLink;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[7]/tbody/tr[10]/td[3]/a") 
	public WebElement APPRLocationWesternLink;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[7]/tbody/tr[8]/td[3]/a") 
	public WebElement APPRLocationNorthernLink;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[7]/tbody/tr[2]/td/a") 
	public WebElement APPRLocationRootLink;
	
}
