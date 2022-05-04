package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int retryCount = 0;
	public static final int maxCount = 1;

	public boolean retry(ITestResult result) {

		if (retryCount < maxCount) {
			retryCount++;
			return true;
		}

		return false;
	}

}
