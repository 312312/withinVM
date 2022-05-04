package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import BaseClass.BaseClass;
import BaseClass.ExtentManager;

public class Listeners extends BaseClass implements ITestListener{
	
	WebDriver driver = null;
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Method Name is "+ result.getName());
				
	}

	
	public void onTestSuccess(ITestResult result) {			
		System.out.println("-- "+ result.getName());
		ExtentTest test=ExtentManager.extent.createTest(result.getMethod().getMethodName()).log(Status.PASS, MarkupHelper.createLabel(null, ExtentColor.GREEN));
		
		
	}

	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Failure Test Case"+ result.getName());
		String methodname=result.getMethod().getMethodName();
		ExtentManager.extent.createTest(methodname);
		String methodName=result.getMethod().getMethodName();
		
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	
			getScreenshot(methodName, driver);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		ExtentTest test=ExtentManager.extent.createTest(result.getMethod().getMethodName()).log(Status.FAIL, MarkupHelper.createLabel(null, ExtentColor.RED));
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("--Skipped "+ result.getName());
		ExtentTest test=ExtentManager.extent.createTest(result.getMethod().getMethodName()).log(Status.SKIP, MarkupHelper.createLabel(null, ExtentColor.YELLOW));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("-- "+ result.getName());
		ExtentTest test=ExtentManager.extent.createTest(result.getMethod().getMethodName()).log(Status.INFO, MarkupHelper.createLabel(null, ExtentColor.BLUE));
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentManager.extent=ExtentManager.createReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.extent.flush();
		
	}

}
