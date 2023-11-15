package GenericUtilities;

import java.io.IOException;
import java.nio.file.Path;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


/**
 * Tis class provides implementation to ITestListeners Interface of TestNG
 * @author rajes
 *GenericUtilities.ListenersImplementation
 */

public class ListenersImplementation implements ITestListener{
ExtentReports report;
ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();//name of the @test method
		System.out.println(methodName+"------Test execution started----------");

		//@Test execution started
		 test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Pass----------");
		
		test.log(Status.PASS, methodName+" ---- Test PASS ----");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Fail----------");
		System.out.println(result.getThrowable());
		

		test.log(Status.FAIL, methodName+" ---- Test FAIL ----");
		test.log(Status.INFO, result.getThrowable());
		
		
		WebDriverUtility wutil=new WebDriverUtility();
		javaUtility jutil=new javaUtility();
		
		String screenshotName = methodName+jutil.getsystemDateInFormat();
		
		try {
			String path = wutil.captureScreenShot(BaseClass.sdriver, screenshotName);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Skip----------");
		System.out.println(result.getThrowable());
		
		test.log(Status.SKIP, methodName+" ---- Test SKIP ----");
		test.log(Status.INFO, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("------Suite execution started----------");
		

		//Extent Report configuration
		
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\extendReports\\Report-"+new javaUtility().getsystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("Execution Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("QCO-SOEAJD-M5-Execution Report");
		
	    report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base PlatForm", "Windows Family");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "srividhya");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("------Suite execution finished----------");
	

		//generate the report
		report.flush();
				
		
	}
	

}
