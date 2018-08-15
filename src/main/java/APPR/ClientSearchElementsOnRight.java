package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class ClientSearchElementsOnRight extends testbaseforproject {
	
	public ClientSearchElementsOnRight(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of the Elements Under Client Search on Right  ==============
	
		@FindBy(xpath="//input[@id='client']")
		public WebElement clientID;
		
		@FindBy(xpath="//input[@name='Search']")
		public WebElement SearchButtonClientSearch;
		
		@FindBy(xpath="//form[@name='ClientSearchForm']/fieldset/table[6]/tbody/tr[2]/td[2]")
		public WebElement clientSearchResultsBottom;
	
}
