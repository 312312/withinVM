package newSetUp.newUp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BaseClass.BaseClass;

public class loginPage extends BaseClass{

	
	@FindBy(name="user[login_name]")
	WebElement username;
	
	@FindBy(name="user[login_password]")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Sign in']")
	WebElement loginbutton;
	
	public loginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
		
	public HomePage login(String ur, String pwd)
	{
		username.sendKeys(ur);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
		
	}	
	
}
