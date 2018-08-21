package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.testbaseforproject;

public class APPRExaminationTest extends testbaseforproject {
	
	public APPRExaminationTest(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		}
	
	//xpath of type dropdown
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[1]/tbody/tr[2]/td[2]/select/option[3]")
	public WebElement typeExam;
	
	//xpath of status dropdown
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[1]/tbody/tr[4]/td[2]/select/option[2]")
	public WebElement statusActive;
	
	//xpath of toss code input field
	@FindBy(xpath="//*[@id=\"toss\"]")
	public WebElement tossCode;

	//xpath of search button
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr/td[1]/input")
	public WebElement searchButton;
	
	//xpath of the first option in the search results
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[5]/tbody/tr[1]/td/a")
	public WebElement firstResult;
	
	//xpath of Program Associations column
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[6]/tbody/tr[1]/th")
	public WebElement programAssociates;
}
