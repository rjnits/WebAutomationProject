package Utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.webapp.qa.base.TestBase;

public class TestngListners extends TestBase implements ITestListener {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	@Override
	public void onTestStart(ITestResult result) {
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "/ExtentReports/ExtentReports-Output.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/src/main/resources/extent-config.xml");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel("<b><i>" + tr.getName() + "</i></b>" + " Testcase is passed",
				ExtentColor.GREEN));

	}

	@Override
	public void onTestFailure(ITestResult tr) {
//		System.out.println("Test is Fail");
//		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshot\\"+result.getMethod().getMethodName()+".png") );
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		logger = extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(
				"<b><i>" + tr.getName() + "</i></b>" + " Testcase is failed due to following issue ", ExtentColor.RED));
		logger.log(Status.FAIL, tr.getThrowable().getMessage());

		// Screenshot of failure
		String timestamp = new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date()); // to find current timestamp
		File srcFile = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
		String tgtFile = System.getProperty("user.dir") + "/Screenshot/" + tr.getMethod().getMethodName() + timestamp
				+ ".png";
		try {
			FileUtils.copyFile(srcFile, new File(tgtFile));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			logger.log(Status.FAIL, MarkupHelper.createLabel(
					"Screenshot is captured below for failed " + "<b><i>" + tr.getName() + "</i></b>" + " Testcase",
					ExtentColor.RED));
			logger.addScreenCaptureFromPath(tgtFile);
		} catch (Exception e) {
			System.out.println();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is Skip");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

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
