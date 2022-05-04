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

public class ProjectPage extends BaseClass {

	@FindBy(xpath = "(//a[contains(text(),'Project')])[1]")
	static WebElement project;

	@FindBy(xpath = "//button[@title='Create a new project']")
	static WebElement newProjectButton;

	@FindBy(css = "input#name")
	static WebElement projectName;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	static WebElement saveButton;

	@FindBy(xpath = "//span[@data-test='project-name']")
	static WebElement createdProjectName;

	@FindBy(xpath = "//button[@title='Add environments to project']")
	static WebElement addEnvironemntToProject;

	@FindBy(xpath = "(//div/a[@data-test='resource-list-item__resource-name'])[1]")
	static WebElement listOfEnvironmentInProject;

	@FindBy(xpath = "(//a[@data-test='add-undo__add-click'])[1]")
	static WebElement addButton;

	@FindBy(xpath = "//div/button[.='Add']")
	static WebElement add;

	@FindBy(xpath = "//button[@data-test='project-add-resources__done-button']")
	static WebElement doneButton;

	@FindBy(xpath = "//a[@data-test='tab-button__configurations']")
	static WebElement environmentMainTab;
	
	@FindBy(xpath = "//a[@data-test='tab-button__templates']")
	static WebElement templateMainTab;
	
	@FindBy(xpath = "//a[@data-test='tab-button__assets']")
	static WebElement assetMainTab;

	@FindBy(xpath = "//a[@data-test='tab-button__users']")
	static WebElement userMainTab;

	@FindBy(xpath = "(//a[@data-test='tab-button__templates'])[2]")
	static WebElement templateTab;

	@FindBy(xpath = "(//a[@data-test='tab-button__assets'])[2]")
	static WebElement assetTab;

	@FindBy(xpath = "(//a[@data-test='tab-button__users'])[2]")
	static WebElement userTab;

	@FindBy(xpath = "(//li/a[.='Groups'])[2]")
	static WebElement groupTab;

	@FindBy(xpath = "//button[@title='Add groups to project']")
	static WebElement groupButton;

	@FindBy(xpath = "(//div/a[@data-test='resource-list-item__resource-name'])[1]")
	static WebElement listOfGroupInProject;

	@FindBy(xpath = "(//input[@id='project_add_members__groups'])[1]")
	static WebElement selectFirstGroup;

	@FindBy(xpath = "(//input[@id='project_add_members__users'])[2]")
	static WebElement selectSecondUser;
	
	@FindBy(xpath = "(//span[@title='Remove from project'])[1]")
	static WebElement removeFromProject;

	@FindBy(xpath = "(//div/a[starts-with(@class,'resource-list-item')])[1]")
	static WebElement resourceAddedInProject;
	
	@FindBy(xpath = "//button[@data-test='remove-resource-action']")
	static WebElement removeButton;
	
	@FindBy(xpath = "//div/span[@title='Delete project']")
	static WebElement deleteProject;
	
	@FindBy(xpath = "//div/button[.='Delete']")
	static WebElement deleteButton;
	
	
	
	
	
	
	static By projectTitle = By.xpath("//form/h2[contains(text(),'Add assets to project(s)')]");
	static By changeOwnerDilaogbox = By.xpath("//div/h2[contains(text(),'Change Owner of Asset')]");
	static By projectAddSuccessMessage = By.cssSelector("div.msg");
	static By removeMessage = By.cssSelector("div a.hide-msg");
	static By firstresource = By.xpath("(//div/a[@data-test='resource-list-item__resource-name'])[1]");
	static By addedText = By.xpath("//div[@class='add-undo__undo']/div[contains(text(),'Added')]");
	static By deleteSuccessMessage = By.xpath("//a[@class='message__hide-msg']");
	
	
	
	static Actions actions = new Actions(driver);

	static WebDriverWait wait = new WebDriverWait(driver, 130);

	public ProjectPage() {
		PageFactory.initElements(driver, this);
	}

	public void projectClick() throws InterruptedException {

		project.click();

		newProjectButton.click();
		LocalTime now = LocalTime.now();

		String projectFullName = "Project" + " " + now;
		projectName.sendKeys(projectFullName);
		saveButton.click();
		wait.until(ExpectedConditions.visibilityOf(createdProjectName));
		String projectDefinedName = createdProjectName.getAttribute("textContent");
		Assert.assertEquals(projectDefinedName, projectFullName);
		

	}

	public void addEnvironmentToProject() {
		
		addEnvironemntToProject.click();
		wait.until(ExpectedConditions.visibilityOf(listOfEnvironmentInProject));
		addButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addedText));
		System.out.println(driver.getCurrentUrl());

	}

	public void addTemplateToProject() {
		templateTab.click();
		wait.until(ExpectedConditions.visibilityOf(listOfEnvironmentInProject));

		addButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addedText));

	}

	public void addAssetToProject() {
		assetTab.click();
		wait.until(ExpectedConditions.visibilityOf(listOfEnvironmentInProject));

		addButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addedText));
		doneButton.click();

	}

	public void addGroupToProject() throws InterruptedException {
		Thread.sleep(5000);
		groupTab.click();
		groupButton.click();
		wait.until(ExpectedConditions.visibilityOf(selectFirstGroup));

		if (selectFirstGroup.isEnabled()) {
			selectFirstGroup.click();
		}
		add.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addedText));

	}

	public void addUserToProject() {
		userTab.click();
		wait.until(ExpectedConditions.visibilityOf(selectSecondUser));

		if (selectSecondUser.isEnabled()) {
			selectSecondUser.click();
		}
		else
		{
			selectSecondUser.click();
			
		}
		add.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(addedText));
		doneButton.click();

		driver.navigate().refresh();
		
	}
	
	public void removeResourceFromProject()
	{
		
		
		actions.moveToElement(environmentMainTab).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(resourceAddedInProject));
		removeFromProject.click();	
		wait.until(ExpectedConditions.visibilityOf(removeButton));
		removeButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessMessage));	
		
		driver.navigate().refresh();
		actions.moveToElement(templateMainTab).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(resourceAddedInProject));
		removeFromProject.click();
		wait.until(ExpectedConditions.visibilityOf(removeButton));
		removeButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessMessage));	
		
		driver.navigate().refresh();
		actions.moveToElement(assetMainTab).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(resourceAddedInProject));
		removeFromProject.click();
		wait.until(ExpectedConditions.visibilityOf(removeButton));
		removeButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessMessage));	
		
		driver.navigate().refresh();
		actions.moveToElement(groupTab).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(resourceAddedInProject));
		removeFromProject.click();
		wait.until(ExpectedConditions.visibilityOf(removeButton));
		removeButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessMessage));	
		
		driver.navigate().refresh();
		actions.moveToElement(userMainTab).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(resourceAddedInProject));
		removeFromProject.click();
		wait.until(ExpectedConditions.visibilityOf(removeButton));
		removeButton.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessMessage));		
		deleteProject.click();
		deleteButton.click();
		
		
			
	}
	
	
}

//<listeners>
//<listener class-name="com.Sky.qa.utils.Listeners" />
//<listener class-name="com.Sky.qa.utils.RetryListener" /> 
//</listeners>
