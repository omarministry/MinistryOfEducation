package APPR;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class APPRLeftNavElements extends testbaseforproject {
	
	public APPRLeftNavElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		//============= xPaths of the Elements Under Search in Left Nav  ==============
	
		//--- Client under Search ---
		@FindBy(xpath="//table[8]/tbody/tr/td[1]/table/tbody/tr[6]/td/a") 
		public WebElement APPRclientLeftNav;
		
		//--- Sponsor under Search ---
		@FindBy(xpath="html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[30]/td/a") 
		public WebElement APPRSponsorLeftNav;
		
		//---Program Entry under Apply Online
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[27]/td/a") 
		public WebElement APPRClientEntry;
		
		//---Vendor/TDA under search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[19]/td/a") 
		public WebElement APPRVendorTDALeftNav;
		
		//Class under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[5]/td/a")
		public WebElement APPRClassLeftNav;
		
		//Examination/Test under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[7]/td/a")
		public WebElement APPRExaminationTestLeftNav;
		
		//Form/Document under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[8]/td/a")
		public WebElement APPRFormDocumentLeftNav;
		
		//Location under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[9]/td/a")
		public WebElement APPRLocationLeftNav;
		
		//Programs under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[10]/td/a")
		public WebElement APPRProgramsLeftNav;
		
		//Reportable Subjects under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[11]/td/a")
		public WebElement APPRReportableSubjectsLeftNav;
		
		//School Board under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[12]/td/a")
		public WebElement APPRSchoolBoardLeftNav;
		
		//Skill under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[13]/td/a")
		public WebElement APPRSkillLeftNav;
		
		//Skill Set under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[14]/td/a")
		public WebElement APPRSkillSetLeftNav;
		
		//Sponsor/Employer under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[15]/td/a")
		public WebElement APPRSponsorEmployerLeftNav;
		
		//Staff User under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[16]/td/a")
		public WebElement APPRStaffUserLeftNav;
		
		//TIR under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[17]/td/a")
		public WebElement APPRTIRLeftNav;
		
		//TOSS under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[18]/td/a")
		public WebElement APPRTOSSLeftNav;
		
		//Sponsor/Emlpoyer Migration Log under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[20]/td/a")
		public WebElement APPREmployerMigrationLogLeftNav;
		
		//Client Migration Log under Search
		@FindBy(xpath="/html/body/table[8]/tbody/tr/td[1]/table/tbody/tr[21]/td/a")
		public WebElement APPRClientMigrationLogLeftNav;
}

