package support;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testbase.testbaseforproject;

public class SelfServeSupport extends testbaseforproject {
	SmartRobot robot;
	public SelfServeSupport(WebDriver driver){
		PageFactory.initElements(driver, this);
	
	}
	
	public void enterUserNamePwdOnAuthWindow() throws AWTException, InterruptedException {
		Alert aa = driver.switchTo().alert();
		robot = new SmartRobot();
		robot.type("digital");
		System.out.println("User name entered");
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.type("notwebchannel");
		System.out.println("Pwd entered");
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		System.out.println("O.k Button Clicked.....");
	}
	
	public void enterUserNamePwdOnAuthWindowUATSupport() throws AWTException, InterruptedException {
		Alert aa = driver.switchTo().alert();
		robot = new SmartRobot();
		robot.type("koodo");
		System.out.println("User name entered");
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.type("gQhwA8u7ktjT");
		System.out.println("Pwd entered");
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		System.out.println("O.k Button Clicked.....");
	}

}
