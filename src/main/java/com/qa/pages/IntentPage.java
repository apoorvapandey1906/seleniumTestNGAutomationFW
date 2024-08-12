package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class IntentPage extends BasePage{
	
	@FindBy(xpath="//input[@aria-labelledby='intention-submit-button-announce']")
	public WebElement proceedToCreateAnAccountButton;
	
	
	public WebElement getproceedToCreateAnAccountButtonElement() {
		wait.waitForVisibilityOfElement(proceedToCreateAnAccountButton);
		return proceedToCreateAnAccountButton;
	}
	
	
	//methods acting on page elements
	public void openRegistrationPage() {
		getproceedToCreateAnAccountButtonElement().click();
	}
	
	public IntentPage(WebDriver driver) {
		super(driver);
	  PageFactory.initElements(driver, this);		
	}

}
