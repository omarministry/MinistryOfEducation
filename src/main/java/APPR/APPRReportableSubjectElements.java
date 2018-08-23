package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRReportableSubjectElements extends testbaseforproject{

	public APPRReportableSubjectElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============XPaths under Reportable Subject ==============
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement APPRRRTxt;
	
	@FindBy(xpath="//*[@id=\"toss\"]")
	public WebElement APPRRSTOSScode;
	
	@FindBy(xpath="//*[@id=\"program\"]/option[2]")
	public WebElement APPRRSProgramOption;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[3]/tbody/tr[2]/td[1]/input")
	public WebElement APPRRSSearchButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[5]")
	public WebElement APPRRSSearchResultTable;
	
	@FindBy(xpath="//*[@id=\"text\"]")
	public WebElement APPRRSPage;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr/td/input")
	public WebElement APPRRSNextButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr/td/input[2]")
	public WebElement APPRRSSecondNextButton;
}
