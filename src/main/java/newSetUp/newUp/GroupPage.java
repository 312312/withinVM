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


public class GroupPage extends BaseClass {

	@FindBy(css = "div[title='management controls']")
	static WebElement manageTab;

	@FindBy(xpath = "//*[text()='Groups']")
	static WebElement groupsTab;

	@FindBy(xpath = "//a[@title='Create a new Group']")
	static WebElement createANewGroup;

	@FindBy(css = "input#groupName")
	static WebElement groupName;

	@FindBy(xpath = "//input[@value='Create']")
	static WebElement createGroup;

	@FindBy(xpath = "//*[text()='Edit this group']")
	static WebElement textVerification;

	@FindBy(xpath = "//a[@title='Add User(s) to Group']")
	static WebElement addUserToGroup;

	@FindBy(xpath = "//*[@title='Find Project For Group']")
	static WebElement addGroupToGroup;

	@FindBy(xpath = "//*[text()='Available Users']")
	static WebElement availableUser;
	
	@FindBy(xpath = "//*[text()='Available Projects']")
	static WebElement availableProjects;
	
	@FindBy(xpath = "(//table/tbody/tr/td[2])[2]")
	static WebElement addToGroup;
	
	@FindBy(xpath = "(//table[@id='available_projects']/tbody/tr/td[3])[1]")
	static WebElement addGroupToProject;
	
	@FindBy(xpath = "//input[@value='Done']")
	static WebElement doneButton;
	
	@FindBy(xpath = "//*[text()='Remove User From Group']")
	static WebElement removeUser;
	
	@FindBy(xpath = "//*[text()='Remove Group From Project']")
	static WebElement removeGroup;
	
	
	
	
	static Actions actions = new Actions(driver);
	static WebDriverWait wait = new WebDriverWait(driver, 30);
	static JavascriptExecutor jse= (JavascriptExecutor)driver;

	
	
	public GroupPage() {
		PageFactory.initElements(driver, this);
	}

	public void manageTab() throws InterruptedException {
		manageTab.click();
		groupsTab.click();

	}

	public void createGroup() {
		createANewGroup.click();
		groupName.sendKeys("Yipee");
		createGroup.click();
		wait.until(ExpectedConditions.visibilityOf(textVerification));
		String str=textVerification.getText();
		Assert.assertEquals(str,"Edit this group");
		
		System.out.println(driver.getCurrentUrl());
		
	}

	public void addResources() throws InterruptedException {	
	addUserToGroup.click();
	wait.until(ExpectedConditions.visibilityOf(availableUser));
	wait.until(ExpectedConditions.visibilityOf(addToGroup));
	addToGroup.click();
	wait.until(ExpectedConditions.textToBePresentInElement(addToGroup, "Added"));
	doneButton.click();
	
	jse.executeScript("history.go(0)");
	addGroupToGroup.click();
	wait.until(ExpectedConditions.visibilityOf(availableProjects));
	wait.until(ExpectedConditions.elementToBeClickable(addGroupToProject));
	addGroupToProject.click();
	wait.until(ExpectedConditions.textToBePresentInElement(addGroupToProject, "Added"));
	doneButton.click();
	String str=jse.executeScript("return document.title;").toString();
	System.out.println(str);
	
	String str1=jse.executeScript("return document.URL").toString();
	System.out.println(str1);
	
	jse.executeScript("history.go(0)");
	}
	
	
	public void removeUser()
	{
		removeUser.click();
		wait.until(ExpectedConditions.invisibilityOf(removeUser));
		
	}
	
	public void removeGroup() throws InterruptedException
	{
		jse.executeScript("history.go(0)");
		Thread.sleep(2000);
		removeGroup.click();
		wait.until(ExpectedConditions.invisibilityOf(removeGroup));
		
	}
	
}
