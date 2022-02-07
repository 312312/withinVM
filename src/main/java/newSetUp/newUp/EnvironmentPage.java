package newSetUp.newUp;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BaseClass.BaseClass;


public class EnvironmentPage extends BaseClass {

	@FindBy(xpath = "(//a[contains(text(),'Environments')])[1]")
	static WebElement environmentTab;

	@FindBy(css = "a[title='Create a new environment']")
	static WebElement newEnvironment;

	@FindBy(xpath = "(//label[@title='Select this template'])[1]")
	static WebElement selectFirstEnvironemnt;
	
	@FindBy(xpath = "(//input[@type='radio'])[2]")
	static WebElement firstRadioButton;
	
	@FindBy(css = "input[value='Create environment']")
	static WebElement createEnvironment;
	
	@FindBy(xpath = "(//button[@title='Run VM(s)'])[1]")
	static WebElement runEnvironment;
	
	@FindBy(xpath = "(//button[@title='Suspend VM(s)'])[1]")
	static WebElement suspendEnvironment;
	
	@FindBy(xpath = "(//button[@title='Shutdown VM(s)'])[1]")
	static WebElement shutdownEnvironment;
	
	
	@FindBy(xpath = "//button[@title='Add environments to project']")
	static WebElement addEnvironemntToProject;

	@FindBy(xpath = "(//div/a[@data-test='resource-list-item__resource-name'])[1]")
	static WebElement listOfEnvironmentInProject;

	
	@FindBy(xpath = "(//li/a[.='Groups'])[2]")
	static WebElement groupTab;

	static WebElement deleteButton;
	
	static By projectTitle = By.xpath("//form/h2[contains(text(),'Add assets to project(s)')]");
	static By changeOwnerDilaogbox = By.xpath("//div/h2[contains(text(),'Change Owner of Asset')]");
	
	static By busySwirly=By.xpath("//strong[text()='Busy …']");
	
	static Actions actions = new Actions(driver);

	static WebDriverWait wait = new WebDriverWait(driver, 230);

	public EnvironmentPage() {
		PageFactory.initElements(driver, this);
	}

	public void environmentTab() throws InterruptedException {

		environmentTab.click();

	}

	public void createNewEnvironment() {
		newEnvironment.click();
		wait.until(ExpectedConditions.visibilityOf(selectFirstEnvironemnt));
		firstRadioButton.click();
		wait.until(ExpectedConditions.visibilityOf(createEnvironment));
		createEnvironment.click();

	}

	public void runEnvironemnt() {
		wait.until(ExpectedConditions.visibilityOf(runEnvironment));
		runEnvironment.click();
	}
	
	public void suspendEnvironemnt() throws InterruptedException {		
	
		wait.until(ExpectedConditions.invisibilityOfElementLocated(busySwirly));
		suspendEnvironment.click();
		
	}
	
	public void shutDownEnvironemnt() throws InterruptedException {		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(busySwirly));
		driver.navigate().refresh();
		runEnvironment.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(busySwirly));
		driver.navigate().refresh();
		shutdownEnvironment.click();	
	}
	
}
