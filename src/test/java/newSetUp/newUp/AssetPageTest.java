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

public class AssetPageTest extends BaseClass {

	AssetPage assetPage;
	loginPage loginPage;
	HomePage homePage;

	int tabNum = 0;
	ExtentReports extent;
	
	public AssetPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		assetPage = new AssetPage();
		loginPage = new loginPage();
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		System.out.println(prop.getProperty("password"));

		
	}

	@Test(priority=1)
	public void navigateToUploadassetPage() throws AWTException, InterruptedException {
		assetPage.assetPage();
		assetPage.uploadFile();
		AssetPage.windowHandle(tabNum);

	}

	@Test(enabled=false)
	public void downloadAsset()

	{
		extent.createTest("downloadAsset").assignCategory("Regression").assignAuthor("Rohit");
		assetPage.assetPage();
		AssetPage.downloadFile();
		

	}

	@Test(priority = 3)
	public void moreOptionDropDown() throws InterruptedException

	{
	
		extent.createTest("moreOptionDropDown").assignCategory("Regression").assignAuthor("Rohit");
		assetPage.assetPage();
		AssetPage.moreOptionDD();
		
	}

	
	
	@AfterTest
	
	public void  closeSession()
	{
		
		driver.close();
	}
	
}