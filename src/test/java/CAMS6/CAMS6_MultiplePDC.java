package CAMS6;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import support.ReadWriteDataToExcel;
import testbase.testbaseforproject;

public class CAMS6_MultiplePDC extends testbaseforproject{
	
	CAMS6_LoginElements login;
	CAMS6_PDCElements pdc;
	String filePath = System.getProperty("user.dir") + "//TestData";
	ReadWriteDataToExcel data;
	CAMS6_CreatePDC createPDC;
	CAMS6_RegisterPerson register;
	CAMS6_RegisterPersonElements rpe;
	CAMS6_CreatePDC_SecondCareer sc;
	CAMS6_CreatePDC_ACB acb;
	
	
	@BeforeClass
	public void setup() {
//		init();
	}
	
	@Test
	public void createPDC() throws InterruptedException, AWTException {
	
		try {
			

	
		sc = new CAMS6_CreatePDC_SecondCareer();
		acb = new CAMS6_CreatePDC_ACB();
		
		
		int i = 1;
		while(i <= 2) {
			
			System.out.println("********** START LOOP " + i + " *************");
			logger = report.startTest("********** START LOOP " + i + " *************");
			init();
			acb.createACBPDC();
			driver.quit();
			
			init();
			sc.createSecondCareerPDC();
			driver.quit();
			
			
			i++;

		}
	
		} catch (Exception e) {
			
			
			logger.log(LogStatus.FAIL, " Test is NOT successful due to the following exception " + logger.addScreenCapture(testbaseforproject.screenshot()));
			logger.log(LogStatus.INFO, e);
			
			
		}
		
		}
	
	@AfterClass
	public void endTest() {
		report.endTest(logger);
		report.flush();
		driver.quit();
	}
	
	
}
