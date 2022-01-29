package newSetUp.newUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage {

	
	@Test
	public void loginPage()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\autoadmin\\Desktop\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://test.skytap.com");
		driver.manage().window().maximize();
		driver.get("https://aol.com");
		
	}
	
	
}
