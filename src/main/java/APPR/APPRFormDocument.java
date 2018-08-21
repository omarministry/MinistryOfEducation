package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.testbaseforproject;

public class APPRFormDocument extends testbaseforproject {
	
	public APPRFormDocument(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		}
	
	//xpath of toss code input field
	@FindBy(xpath="//*[@id=\"toss\"]")
	public WebElement tossCode;
	
	//xpath of search button
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[2]/tbody/tr/td[1]/input")
	public WebElement searchButton;
	
	//xpath of first search result
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[5]/tbody/tr[1]/td/a")
	public WebElement firstResult;
	
	//xpath of form/document id field
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[2]/tbody/tr[1]/td[1]")
	public WebElement formDocument;
}
