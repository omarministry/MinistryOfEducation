package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRVenderSearch extends testbaseforproject{

	public APPRVenderSearch (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of the Elements Under Vender/TDA  ==============
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement VenderSearchTxt;
	
	@FindBy(xpath="//*[@id=\"contract\"]")
	public WebElement VenderTossField;
	
	@FindBy(xpath="//*[@id=\"type\"]/option[2]")
	public WebElement VenderProgramParticipationStatus;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[3]/tbody/tr/td[1]/input")
	public WebElement VenderSearchButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[1]/td/a")
	public WebElement VenderFirstResult;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td")
	public WebElement TDAGeneralTxt;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[2]/tbody/tr[1]/td[2]")
	public WebElement TDAName;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[6]/tbody/tr[4]/td[2]/a")
	public WebElement TDAStatus;
	
	@FindBy(xpath="/html/body/table[6]/tbody/tr/td/table/tbody/tr/td[3]/form/input[4]")
	public WebElement ProgramParticipationTab;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[2]/tbody/tr[2]/td[2]/select/option[8]")
	public WebElement ProgramOption;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[6]/tbody/tr[2]/td[2]/label")
	public WebElement ProgramName;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[6]/tbody/tr[4]/td[3]/a")
	public WebElement ProgramStatus;
	
}
