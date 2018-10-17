package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRSkillSetElements extends testbaseforproject{

	public APPRSkillSetElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of the Elements Under Skill Set  ==============
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement SkillSetSearchTxt;
	
	@FindBy(xpath="//*[@id=\"toss\"]")
	public WebElement SkillSetTOSSCodeField;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[1]/tbody/tr[5]/td[3]/select/option[2]")
	public WebElement SkillSetProgramOption;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr[2]/td[1]/input")
	public WebElement SkillSetSearchButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[4]/tbody/tr[1]/td/a")
	public WebElement SkillSetFirstResult;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement SkillSetTxt;
}
