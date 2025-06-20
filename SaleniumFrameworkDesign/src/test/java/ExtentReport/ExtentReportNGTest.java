package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNGTest 
{
	
public static ExtentReports getReport()
{
	//ExtentReports, ExtendSparkReporter
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Report");
	reporter.config().setDocumentTitle("Test Result");
	
	ExtentReports extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "HariGovind");
	return extent;
	
}
}
