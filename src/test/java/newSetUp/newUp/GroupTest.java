package newSetUp.newUp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import BaseClass.BaseClass;


public class GroupTest extends BaseClass {

	GroupPage groupPage;
	loginPage loginPage;
	HomePage homePage;
		
	public GroupTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		groupPage = new GroupPage();
		loginPage = new loginPage();
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
			
	}

	@Test(priority=1)
	public void createGroup() throws InterruptedException {
		groupPage.manageTab();	
		groupPage.createGroup();
		groupPage.addResources();
		groupPage.removeUser();
		groupPage.removeGroup();
	}
	
	@Test(priority=2)
	public void addResurces() throws InterruptedException {
		groupPage.addResources();
	}
	
	@Test(priority=3)
	public void removeResources() throws InterruptedException {
		groupPage.removeUser();
		groupPage.removeGroup();
	}
	

	@AfterClass()
	public void lastTest()
	{
		
	}
	
	
	
}