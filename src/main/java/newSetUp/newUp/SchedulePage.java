package newSetUp.newUp;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseClass.BaseClass;

public class SchedulePage extends BaseClass {

	public SchedulePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Schedule')]")
	static WebElement schedules;

	@FindBy(xpath = "(//a[@title='Create a new schedule'])[1]")
	static WebElement newScheduleButton;

	@FindBy(xpath="(//tbody/tr[@class='resource']/td[1])[1]")
	static WebElement selectResource;

	@FindBy(xpath="//input[@name='start_time_ui']")
	static WebElement startTime;
	
	@FindBy(xpath="//li/input[@value='Finish']")
	static WebElement finishButton;
	
	@FindBy(xpath = "//li/a[.='Continue']")
	static WebElement continueButton;
	
		
	static JavascriptExecutor jse=(JavascriptExecutor)driver;
	static Actions actions = new Actions(driver);

	static WebDriverWait wait = new WebDriverWait(driver, 130);

	

	
	public static void scheduleClick() throws InterruptedException {

		schedules.click();
		newScheduleButton.click();
		Thread.sleep(7000);
		selectResource.click();
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");
		Date date = new Date();		
		String systemdateandtime= dateFormat.format(date);
		System.out.println(systemdateandtime);
		
		startTime.clear();
		Thread.sleep(1000);
		startTime.sendKeys(systemdateandtime);
		jse.executeScript("window.scrollBy(0,1000)");
		finishButton.click();
		


	}

	
}

