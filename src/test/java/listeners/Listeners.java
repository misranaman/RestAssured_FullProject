package listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter {

	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext testContext) {

		extent = new ExtentReports();
		spark = new ExtentSparkReporter("target/TestReport1.html");

		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Rest API Automation");
		spark.config().setReportName("Rest API Automation");
		extent.attachReporter(spark);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {

		String testCaseName = getMyTCName(tr.getInstanceName());

		test = extent.createTest(testCaseName + "==>" + tr.getName());
		test.log(Status.PASS, "Test Case passed is --" + tr.getName());
	}

	@Override
	public void onTestFailure(ITestResult tr) {

		String testCaseName = getMyTCName(tr.getInstanceName());
		test = extent.createTest(testCaseName + "==>" + tr.getName());

		test.log(Status.FAIL, "Test Case Failed is --" + tr.getName());
		test.log(Status.FAIL, "Error Log: " + tr.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult tr) {

		String testCaseName = getMyTCName(tr.getInstanceName());

		test = extent.createTest(testCaseName + "==>" + tr.getName());
		test.log(Status.SKIP, "Test Case Skipped is --" + tr.getName());

	}

	@Override
	public void onFinish(ITestContext testContext) {

		test.log(Status.INFO, "Finalizing the report");
		extent.flush();
	}

	public static String getMyTCName(String str) {

		String res = "";
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '.')
				res = res + "%";
			else
				res = res + str.charAt(i);

		}

		String sarr[] = res.split("%");

		int n = sarr.length;

		String tcName = sarr[n - 1];

		return tcName;

	}

}
