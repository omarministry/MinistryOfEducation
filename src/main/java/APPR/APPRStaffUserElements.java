package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRStaffUserElements extends testbaseforproject{

	public APPRStaffUserElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//============= xPaths of the Elements Under Staff User  ==============
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/table/tbody/tr/td")
	public WebElement StaffUserSearchTxt;
	
	@FindBy(xpath="//*[@id=\"last\"]")
	public WebElement StaffUserLastName;
	
	@FindBy(xpath="//*[@id=\"first\"]")
	public WebElement StaffUserFirstName;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[3]/tbody/tr/td[1]/input")
	public WebElement StaffUserSearchButton;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[1]/td/a")
	public WebElement StaffUserResult;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[1]/tbody/tr/td")
	public WebElement StaffUserGeneralTxt;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[4]/tbody/tr[1]/td[2]")
	public WebElement StaffUserName;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[4]/tbody/tr[3]/td[2]")
	public WebElement StaffUserSerialNumber;
	
	@FindBy(xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[4]/tbody/tr[5]/td[2]/a")
	public WebElement StaffUserStatus;
	
}
