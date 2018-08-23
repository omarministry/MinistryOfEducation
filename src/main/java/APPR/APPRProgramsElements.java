package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRProgramsElements extends testbaseforproject{

	public APPRProgramsElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of the Elements under Programs ==============
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement APPRProgramsSearchTxt;
	
	@FindBy(xpath="//*[@id=\"toss\"]")
	public WebElement APPRProgramsTOSS;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[3]/tbody/tr/td[1]/input")
	public WebElement APPRProgramsSearchButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[1]/td/a")
	public WebElement APPRProgramsSearchFirstResult;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[4]/td/a")
	public WebElement APPRProgramsSearchSecondResult;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td")
	public WebElement APPRProgramsGeneralTxt;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[6]/tbody/tr[2]/td[2]/a")
	public WebElement APPRProgramsStatus;
}
