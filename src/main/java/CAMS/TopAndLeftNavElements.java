package CAMS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class TopAndLeftNavElements extends testbaseforproject {
	
	public TopAndLeftNavElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of the Top Nav Elements  ==============
	
		@FindBy(xpath="//*[@id=\"app-sections-container-dc_tablist_MTCUSPMGRHomeSection-stc_tabLabel\"]")
		public WebElement WorkSpace;
		
		@FindBy(xpath="//*[@id=\"app-sections-container-dc_tablist_MTCUSPMGRWorkspaceSection-sbc_tabLabel\"]")
		public WebElement CasesAndOutComes;
		
		@FindBy(xpath="//*[@id=\"app-sections-container-dc_tablist_DefaultAppInboxSection-sbc_tabLabel\"]")
		public WebElement Tasks;
		
		@FindBy(xpath="//*[@id=\"app-sections-container-dc_tablist_DefaultAppCalendarSection-stc_tabLabel\"]")
		public WebElement Calendar;
		
		//============= xPaths of the Left Nav Elements  ==============
		
		@FindBy(xpath="//*[@id=\"curam_layout_ExpandoPane_0\"]/div[1]/div")
		public WebElement ExpandShortcutsLeftNav;
		
		
		@FindBy(xpath="//*[@id=\"dijit_layout_AccordionPane_0_button_title\"]")
		public WebElement ParticipantLeftNav;
		
		@FindBy(xpath="//*[@id=\"dijit_layout_AccordionPane_1_button_title\"]")
		public WebElement CasesLeftNav;
		
		@FindBy(xpath="//*[@id=\"dijit_layout_AccordionPane_1\"]/ul/li[1]/a")
		public WebElement NewCaseLeftNav;
		
		@FindBy(xpath="//*[@id=\"dijit_layout_AccordionPane_2_button_title\"]")
		public WebElement ServiceProviderLeftNav;

}
