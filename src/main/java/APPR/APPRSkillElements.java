package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRSkillElements extends testbaseforproject{

	public APPRSkillElements (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============XPaths under Skill ==============
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement SkillSearchTxt;
	
	@FindBy(xpath="//*[@id=\"toss\"]")
	public WebElement SkillTOSSField;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[1]/tbody/tr[5]/td[3]/select/option[2]")
	public WebElement SkillProgramOption;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr[2]/td[1]/input")
	public WebElement SkillSearchButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[4]/tbody/tr[1]/td/a")
	public WebElement SkillFirstResult;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement SkillTxt;
}
