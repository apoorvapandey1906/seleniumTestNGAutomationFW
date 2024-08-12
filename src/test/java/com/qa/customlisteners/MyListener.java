package com.qa.customlisteners;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.qa.basetest.BaseTest;

public class MyListener extends BaseTest implements ITestListener,IAnnotationTransformer {
	
	
	

	@Override
	public void onTestStart(ITestResult result) {
		String className = result.getTestClass().getName().substring(result.getTestClass().getName().lastIndexOf(".")+1);
		String methodName = result.getMethod().getMethodName();
		logger.info(" Started Test: "+className+" => "+ methodName);
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		//USe this method to take some action when test has failed like taking screenshot	
		String className = result.getTestClass().getName().substring(result.getTestClass().getName().lastIndexOf(".")+1);
		String methodName = result.getMethod().getMethodName();
		logger.info(" Started Test: "+className+" => "+ methodName);
		
		LocalDateTime now = LocalDateTime.now();
		//format the current time according to the format provided
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		
		//It will create a string name for the screenshot captured , by using TestName and attaching the current timestamp.
		String dynamicScreenshotName = result.getName()+formatter.format(now);
		
		//This line will take screenshot and save it in a file as fImage
		File fImage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {			
			//This line will copy the fImage to a new image created  by using the new name-dynamicScreenshotName at runtime at the location provided below
		   FileUtils.copyFile(fImage, new File(System.getProperty("user.dir")+"./src/test/resources/Screenshots/"+dynamicScreenshotName+".png"));	
			
		}catch (IOException io) {
			io.printStackTrace();
			logger.error(io.getMessage());
		}	

	}
	
	//This transform method will trigger MyRetryAnalyzer class to perform the rerunning of the testcases on TC failures
	@Override
	public void transform(ITestAnnotation annotation , Class testclass, Constructor testConstructor , Method testMthod) {
		annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
	}

}
