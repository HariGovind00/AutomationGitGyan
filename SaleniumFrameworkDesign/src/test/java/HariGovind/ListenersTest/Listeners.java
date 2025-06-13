package HariGovind.ListenersTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import ExtentReport.ExtentReportNGTest;
import HariGovindAcademy.DriverBaseFile;

public class Listeners extends DriverBaseFile implements ITestListener {

	ExtentReports extent = ExtentReportNGTest.getReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> tl=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		// The below method will call the method name for the reports.
		test = extent.createTest(result.getMethod().getMethodName());
		tl.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tl.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// test.log(Status.FAIL, "Test Failed");
		// to get the result of the failure
		tl.get().fail(result.getThrowable());

		// Code which will help to get the driver information
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String filepath = null;
		// Take the Screenshot
		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tl.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
