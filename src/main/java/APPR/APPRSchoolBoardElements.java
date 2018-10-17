package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRSchoolBoardElements extends testbaseforproject{

	public APPRSchoolBoardElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============XPaths under School Board ==============
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement SchoolBoardSearchTxt;
	
	@FindBy(xpath="//*[@id=\"type\"]/option[2]")
	public WebElement SchoolBoardStatusActive;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[3]/tbody/tr/td[1]/input")
	public WebElement SchoolBoardSearchButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[1]/td/a")
	public WebElement SchoolBoardFirstResult;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td")
	public WebElement SchoolBoardGeneralTxt;

}
