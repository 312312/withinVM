package BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;
	public static  ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	
	public static ExtentReports createReport() {
		
		String path= System.getProperty("user.dir")+"\\Extentreport\\index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setReportName("Web Testing");
		report.config().setDocumentTitle("MySelf Automation");
		extent=new ExtentReports();
		extent.attachReporter(report);
		
		return extent;
	}
	
	
	
	
	
}
