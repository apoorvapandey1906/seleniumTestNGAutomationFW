package com.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.ConfigReader;
import com.qa.utils.CustomWait;

public class BasePage {
	
	protected static WebDriver driver;
	protected CustomWait wait;
	public ConfigReader configReader;
	
	@FindBy(xpath="//i[@class='a-icon a-icon-logo' and @aria-label='Amazon']")
	public WebElement amazonLogo;
	
	//constructor 
	public BasePage(WebDriver driver) {
		
		System.out.println("Basepage");
		configReader = new ConfigReader();
		this.wait = new CustomWait(driver, Duration.ofSeconds(configReader.getGlobalWaitInLongFormat()));
		PageFactory.initElements(driver, this);
	}
	

	public WebDriver getDriver (String browser) {
		
		if(browser.equalsIgnoreCase("chrome")){		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("firefox")) {		
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		
		return driver;		
	}
	
	public void quitDriver() {
		driver.quit();
	}
	
	
	public WebElement getLogo() {
		wait.waitForVisibilityOfElement(amazonLogo);
		return amazonLogo;
	}
	
	public String getTitleOfThePage() {
		
		return driver.getTitle();
	}
	
	public String getCurrentURL() {
		 return driver.getCurrentUrl();
	}
	
	
	public boolean verifyLogo() {	
		return getLogo().isDisplayed();
	}
	
	public void navigateBackward() {
		driver.navigate().back();
		}
	
	public void navigateForward() {
		driver.navigate().forward();	
		}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
}
