package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRCreateClass extends testbaseforproject {
	
	public APPRCreateClass(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	
	//xpath of all used elements to create a class and activate it
	@FindBy(xpath="//*[@id=\"contract\"]")
	public WebElement TOSScode;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[3]/tbody/tr/td[1]/input")
	public WebElement searchButton;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[1]/td/a")
	public WebElement selectOption1;

	@FindBy (xpath="/html/body/table[6]/tbody/tr/td/table/tbody/tr/td[5]/form/input[4]")
	public WebElement courseOfferingButton;
	
	@FindBy (xpath="//*[@id=\"what\"]/option[2]")
	public WebElement selectAddClass;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[3]/tbody/tr/td[3]/input")
	public WebElement pressGo;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[1]/td[2]/select/option[2]")
	public WebElement fullTimeClassType;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[2]/td[2]/select/option[2]")
	public WebElement deliveryModeAlternativeBlock;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[3]/td[2]/select/option[2]")
	public WebElement campusOption2;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[4]/td[2]/select/option[2]")
	public WebElement instructionLanguageEnglish;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[1]/td[4]/select/option[2]")
	public WebElement instructionMediumClassroom;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[6]/tbody/tr[2]/td[4]/select/option[2]")
	public WebElement paymentActualMax;
	
	@FindBy (xpath="//*[@id=\"plannedseats\"]")
	public WebElement plannedSeats;
	
	@FindBy (xpath="//*[@id=\"max\"]")
	public WebElement maxSeats;
	
	@FindBy (xpath="//*[@id=\"day\"]")
	public WebElement startDay;
	
	@FindBy (xpath="//*[@id=\"month\"]")
	public WebElement startMonth;
	
	@FindBy (xpath="//*[@id=\"year\"]")
	public WebElement startYear;
	
	@FindBy (xpath="//*[@id=\"day1\"]")
	public WebElement endDay;
	
	@FindBy (xpath="//*[@id=\"month1\"]")
	public WebElement endMonth;
	
	@FindBy (xpath="//*[@id=\"year1\"]")
	public WebElement endYear;
	
	@FindBy (xpath="//*[@id=\"perday\"]")
	public WebElement hoursInClass;
	
	@FindBy (xpath="//*[@id=\"daysper\"]")
	public WebElement daysInClass;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[9]/tbody/tr/td[7]/input")
	public WebElement calculate;	
	
	@FindBy (xpath="//*[@id=\"rsMap0\"]")
	public WebElement selectAllLevelOne;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/input")
	public WebElement save;
	
	@FindBy (xpath="/html/body/table[4]/tbody/tr/td[3]/a[3]")
	public WebElement tdaCourseOffering;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/fieldset/table[7]/tbody/tr[1]/td[2]")
	public WebElement classNumber;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/form/table[2]/tbody/tr[2]/td[2]/select/option[17]")
	public WebElement selecting415A;
	
	@FindBy (xpath="//*[@id=\"offering00\"]")
	public WebElement selectingClassToActivate;
	
	@FindBy (xpath="//*[@id=\"what\"]/option[1]")
	public WebElement activateTheSelectedClass;
	
	@FindBy (xpath="//*[@id=\"saveButton\"]")
	public WebElement finalSave;
	
	@FindBy (xpath="/html/body/table[8]/tbody/tr/td[4]/table[3]/tbody/tr/td")
	public WebElement updateAppliedMessage;
	
}
