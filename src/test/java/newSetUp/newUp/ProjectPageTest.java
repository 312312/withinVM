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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseClass.BaseClass;

public class ProjectPageTest extends BaseClass {

	ProjectPage projectPage;
	loginPage loginPage;
	HomePage homePage;

	int tabNum = 0;
		
	public ProjectPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		projectPage = new ProjectPage();
		loginPage = new loginPage();
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
			
	}

	@Test(priority=1)
	public void createProject() throws AWTException, InterruptedException {
			
		projectPage.projectClick();
		
		
	}

	@Test(priority=2)
	public void addEnvironmentToProject() throws AWTException, InterruptedException {
			
		projectPage.addEnvironmentToProject();
	}
	
	
	@Test(priority=3)
	public void addTemplateToProject() throws AWTException, InterruptedException {
			
		projectPage.addTemplateToProject();
		
	}
	
	@Test(priority=4)
	public void addAssetToProject() throws AWTException, InterruptedException {
			
		projectPage.addAssetToProject();
		
	}
	
	@Test(priority=5)
	public void addGroupToProject() throws AWTException, InterruptedException {	
		
		projectPage.addGroupToProject();
		
	}
	
	@Test(priority=6)
	public void addUserToProject() throws AWTException, InterruptedException {
			
		
		projectPage.addUserToProject();
		
	}
	
	@Test(priority=7)
	public void removeFromProject() throws AWTException, InterruptedException {
			
		projectPage.removeResourceFromProject();
	}
	
	

	@AfterTest()
	public void lastTest()
	{
	
	}
	
	
	
}