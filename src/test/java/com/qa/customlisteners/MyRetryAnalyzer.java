package com.qa.customlisteners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{
	
	private int retryCount=0;
	private int max_retryCount=2;

	@Override
	public boolean retry(ITestResult result) {

		if(retryCount < max_retryCount && !result.isSuccess()) {
			retryCount++;
			
			System.out.println("Retrying the test ==> "+ result.getName()+" ==> Attempt no ==> "+retryCount);
			return true;
		}
		return false;
	}

}
