package extentReports;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportFive {

	@Test
	public void extentTest() throws IOException {

		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/spark.html");

		// final File CONF = new File("extent-config.xml");
		// spark.loadXMLConfig(CONF);

		//final File CONF = new File("extent-config.json");
		//spark.loadJSONConfig(CONF);

		//spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);

		ExtentTest test = extent.createTest("Login Test");
		test.info("URL is loaded");
		test.pass("Value Entered");
		test.pass("Login test created successfully");
		test.info("Test Case End");

		ExtentTest test1 = extent.createTest("HomePage Test");
		test1.info("URL is loaded");
		test1.pass("Value Entered");
		test1.fail("HomePage test created successfully");
		test1.info("Test Case End");

		extent.flush();

	}
}
