package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/MyReport.html");
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Functional Testing");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Computer Name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Project Name", "Identifybikes");
        extent.setSystemInfo("OS", "Windows 11");
        extent.setSystemInfo("Browser Name", "Chrome");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test Case PASSED is : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Case FAILED is : " + result.getName());
        test.log(Status.FAIL, "Cause is : " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test Case SKIPPED is : " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}