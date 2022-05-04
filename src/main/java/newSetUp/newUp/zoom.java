package newSetUp.newUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class zoom {

	public static WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void setup()
	{
		String driverlocation=System.getProperty("user.dir")+"/src/main/java/resources/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",driverlocation);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver,30);
	}
	
	@Test
	public void url() throws InterruptedException
	{
		driver.get("https://skytap.zoom.us/j/778503003?pwd=bzcwOFVZN0dKTHFXUXdEeUZpVmpCdz09");	
		driver.switchTo().alert().dismiss();
		
	}
	
}
