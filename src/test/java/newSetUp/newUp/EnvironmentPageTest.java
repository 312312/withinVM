package newSetUp.newUp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseClass.BaseClass;

public class EnvironmentPageTest extends BaseClass {

	loginPage loginPage;
	HomePage homePage;
	EnvironmentPage environmentPage;
	
	public EnvironmentPageTest()
	{
		super();
	}
	
	ExtentReports extent;
	
	@BeforeTest
	public void reportSetUp()
	{
		
		String path= System.getProperty("user.dir")+"\\Extentreport\\index.html";

		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Web Testing");
		report.config().setDocumentTitle("kytap Automation");
		
		initialization();
		loginPage= new loginPage();
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		environmentPage= new EnvironmentPage();	
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Environment","Saini");
			
	}
	
	@Test(priority=1)
	public void pageTitle()
	{
		extent.createTest("page Title").assignCategory("Regression").assignAuthor("Rohit");
		String title= loginPage.validatePageTitle();
		System.out.println(title);		
	}
	
	
	@Test(priority=3)
	public void environmentPage() throws AWTException
	{	
		extent.createTest("Environment page").assignCategory("Regression").assignAuthor("Rohit");
		try {
			environmentPage.environmentTab();
			
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
	}
  	
	@Test(priority=4)
	public void createEnvironment() 
	{	
		extent.createTest("Create Environemnt").assignCategory("Regression").assignAuthor("Rohit");
		environmentPage.createNewEnvironment();
		
	}
  	
	@Test(priority=5)
	public void runEnvironment()
	{	
		extent.createTest("Run Environemnt").assignCategory("Regression").assignAuthor("Rohit");
		environmentPage.runEnvironemnt();
		
	}
  	
	@Test(priority=6)
	public void suspendEnvironment()
	{	
		extent.createTest("Suspend Environemnt").assignCategory("Regression").assignAuthor("Rohit");
		try {
			environmentPage.suspendEnvironemnt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=7)
	public void shutdownEnvironment() throws InterruptedException 
	{	
		extent.createTest("Shutdown Environemnt").assignCategory("Regression").assignAuthor("Rohit");
		environmentPage.shutDownEnvironemnt();
		
	}
	
	
	
	@AfterTest
	public void afterMethod()
	{
		extent.flush();
		
	}

}
