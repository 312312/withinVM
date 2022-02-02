package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import BaseClass.BaseClass;

public class Listeners extends BaseClass implements ITestListener{
	
	WebDriver driver = null;
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Method Name is "+ result.getName());
		System.out.println("Started Test");		
	}

	
	public void onTestSuccess(ITestResult result) {			
		System.out.println("Success Test");
	}

	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Method Name is "+ result.getName());
		
		String methodName=result.getMethod().getMethodName();
		
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
	
			getScreenshot(methodName, driver);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
			
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Method Name is "+ result.getName());
		System.out.println("Skipped Test");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		System.out.println("Method Name is "+ result.getName());
		System.out.println("Success Percentage Test");
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
