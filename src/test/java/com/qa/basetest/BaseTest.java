package com.qa.basetest;

import java.util.logging.LogManager;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.base.BasePage;

import com.qa.pages.HomePage;
import com.qa.pages.IntentPage;
import com.qa.pages.RegistrationPage;
import com.qa.pages.SignInOrCreateAccountPage;
import com.qa.pages.SignInPage;
import com.qa.testdatareaders.ExcelReader;
import com.qa.utils.ConfigReader;

public class BaseTest {
	
	private static ThreadLocal<WebDriver> LocalDriver = new ThreadLocal<WebDriver>();
	protected static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(BaseTest.class);
	
	public BasePage basePage;
	 public   WebDriver driver;
	
	public RegistrationPage registrationPage;
	public SignInPage signInPage;
	public HomePage homePage;
	public IntentPage intentPage;
	public SignInOrCreateAccountPage signInOrCreateAccountPage;
	public ConfigReader configReader;
	public ExcelReader excelReader;
	
	
	public WebDriver getLocalDriver() {
		return LocalDriver.get();
	}
	
	@BeforeSuite(alwaysRun =true)
	public void setUpSuite(ITestContext context) 
	{
		String suiteName = context.getSuite().getName();
		String[] groupList = context.getIncludedGroups();
		String includedGroupList = String.join(",",groupList);
		logger.info("Starting execution for Test suites => "+suiteName+" with tag=> "+includedGroupList);
		
	}
	
	@BeforeTest(alwaysRun =true)
	public void setUpTest(ITestContext context) 
	{
		String testName = context.getName();
		logger.info("Starting execution for Test => "+testName);		
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public  void baseSetUP( ) {
		System.out.print("Starting the test- Basesetup");
		configReader = new ConfigReader();
		System.out.println("1");
		//Open the browser and hit the URL to open application		
		basePage = new BasePage(getLocalDriver());
		System.out.println("2");
		WebDriver driver = basePage.getDriver(configReader.getBrowser());
		LocalDriver.set(driver);
		System.out.println("3");
		getLocalDriver().get(configReader.getURL());
		System.out.println("4");
		
		
		//Print the session ID
		long threadID = Thread.currentThread().getId();
		String sessionID = ((RemoteWebDriver)getLocalDriver()).getSessionId().toString();
		System.out.println("Thread ID :=> "+threadID+ "&  sessionID:=> "+sessionID);
		
		//Instantiation of all the pageclasses
		homePage = new HomePage(getLocalDriver());
		registrationPage = new RegistrationPage(getLocalDriver());
		signInPage = new SignInPage(getLocalDriver());
		intentPage = new IntentPage(getLocalDriver());
		signInOrCreateAccountPage = new SignInOrCreateAccountPage(getLocalDriver());
		System.out.println("5");
		//To read excelReader
		excelReader = new ExcelReader("./src/test/resources/test-data/"+configReader.getFieldsVerificationExcelName());
	}
	
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		getLocalDriver().quit();
		LocalDriver.remove();
	}

}
