package newSetUp.newUp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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
	
	@BeforeTest
	public void reportSetUp()
	{
		
		initialization();
		loginPage= new loginPage();
		homePage=loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		environmentPage= new EnvironmentPage();	
			
	}
	
	@Test(priority=1)
	public void pageTitle()
	{		
		String title= loginPage.validatePageTitle();
		System.out.println(title);		
	}
	
	
	@Test(priority=3)
	public void environmentPage() throws AWTException
	{	

		try {
			environmentPage.environmentTab();
			
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		
	}
  	
	@Test(priority=4)
	public void createEnvironment() 
	{	
		environmentPage.createNewEnvironment();
		System.out.println(driver.getCurrentUrl());
	
	}
  	
	@Test(priority=5)
	public void runEnvironment()
	{	
		environmentPage.runEnvironemnt();
		
	}
  	
	@Test(priority=6)
	public void suspendEnvironment() throws InterruptedException
	{	
		Thread.sleep(1000);
		try {
			environmentPage.suspendEnvironemnt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=7)
	public void shutdownEnvironment() throws InterruptedException 
	{	
		environmentPage.shutDownEnvironemnt();
		
	}
	

//	@Test(priority=8)
	public void data() throws IOException
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\rohit.saini\\Desktop\\TestData.xls");
		HSSFWorkbook workbook=new HSSFWorkbook(fis);
		HSSFSheet sheet=workbook.getSheetAt(0);
		
		
		Iterator<Row> rowIterator = sheet.iterator();
	    while (rowIterator.hasNext()) {
	        Row row = rowIterator.next();

	        Iterator<Cell> cellIterator = row.cellIterator();
	        while (cellIterator.hasNext()) {
	            Cell cell = cellIterator.next();
	            switch (cell.getCellType()) {
	                case NUMERIC:
	                    System.out.println(cell.getNumericCellValue());
	                    break;
	                case STRING:
	                    System.out.println(cell.getStringCellValue());
	                    break;
	            }
	        }
	        System.out.println("");
	    }


	
	
	}
	
	@AfterClass
	public void afterMethod()
	{
		super.closeInstance();
	}

}
