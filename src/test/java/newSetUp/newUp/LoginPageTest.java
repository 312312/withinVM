package newSetUp.newUp;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
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
		String title= loginPage.validatePageTitle();
		System.out.println(title);
//		Assert.assertEquals(title,"Sign In1232Skytap");
		
		
	}
	
	
	@Test(priority=2)
	public void loginApplication() throws AWTException
	{	
				
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		
		
	}
	
	
	
	@AfterClass()
	public void afterMethod()
	{
		super.closeInstance();
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
