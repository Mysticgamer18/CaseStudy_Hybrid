package com.mindtree.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mindtree.reusablecomponent.Base;




public class Listeners extends Base implements ITestListener {

	ExtentReports extent= ExtentReporterNG.extentReportGenerator();
	
	String abc=null;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	public void onTestFailure(ITestResult result)
	{
		

		try {
			abc=Screenshot.getScreenshot(result.getMethod().getMethodName());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			test.fail(result.getMethod().getMethodName()+" test failed ",MediaEntityBuilder.createScreenCaptureFromPath(abc).build());
		
		//test.addScreenCaptureFromBase64String(getScreenshot(result.getMethod().getMethodName()),result.getMethod().getMethodName());


	}
	public void onTestSuccess(ITestResult result)
	{
		

		try {
			abc=Screenshot.getScreenshot("Screenshot captured");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
			test.pass(result.getMethod().getMethodName()+" test successful",MediaEntityBuilder.createScreenCaptureFromPath(abc).build());
		

	}


}
