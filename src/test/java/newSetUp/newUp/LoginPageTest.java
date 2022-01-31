package newSetUp.newUp;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseClass.BaseClass;

public class LoginPageTest extends BaseClass {

	loginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
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
		report.config().setDocumentTitle("Automation");
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Rohit","Saini");
			
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		System.out.println("Login page started");
		loginPage= new loginPage();
			
	}
	
	
	
	@Test(priority=1)
	public void pageTitle()
	{
		extent.createTest("page Title").assignCategory("Regression").assignAuthor("Rohit");
		String title= loginPage.validatePageTitle();
		System.out.println(title);
//		Assert.assertEquals(title,"Sign In1232Skytap");
		
		
	}
	
	
	@Test(priority=2)
	public void loginApplication() throws AWTException
	{	
		extent.createTest("Login Application").assignCategory("Regression").assignAuthor("Rohit");

		
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		
		
	}
	
	
	
	@AfterTest
	public void afterMethod()
	{
		extent.flush();
		
	}

	
	@Test(enabled=false)
	public void loginPage()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\autoadmin\\Desktop\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://test.skytap.com");
		driver.manage().window().maximize();
		driver.get("https://aol.com");
		
	}
	
	
}