package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class RegistrationPage extends BasePage{
	
	@FindBy(id="ap_phone_number")
	public WebElement mobileNumber;
	
	@FindBy(id="ap_customer_name")
	public WebElement yourName;
	
	@FindBy(id="ap_password")
	public WebElement password;
	
	@FindBy(xpath="//a[@id='ra-sign-in-link' and contains(text(),'Sign in instead')]")
	public WebElement signInInsteadLink;
	
	@FindBy(xpath="//input[@id='continue']")
	public WebElement verifyMobileNumber;
	

	
	public RegistrationPage(WebDriver driver) {
		super(driver);
	  PageFactory.initElements(driver, this);	
		
	}
	
	public WebElement getsignInInsteadElement() {
		wait.waitForElementToBeClickable(signInInsteadLink);
		return signInInsteadLink;
	} 
	
	public WebElement getmobileNumberElement() {
		wait.waitForElementToBeClickable(mobileNumber);
		return mobileNumber;
	} 
	
	public WebElement getyourNameElement() {
		wait.waitForElementToBeClickable(yourName);
		return yourName;
	} 
	
	public WebElement getpasswordElement() {
		wait.waitForElementToBeClickable(password);
		return password;
	} 
	
	public WebElement getVerifyMobileNumber() {
		wait.waitForElementToBeClickable(verifyMobileNumber);
		return verifyMobileNumber;
	} 
	
	public void enterYourName(String name) {
		getyourNameElement().sendKeys(name);
	}
	
	public void enterMobileNumber(String number) {
		getmobileNumberElement().sendKeys(number);
	}
	
	public void enterPassword(String password) {
		getpasswordElement().sendKeys(password);
	}
	
	public void clickOnVerifyMobileNumber() {
		getVerifyMobileNumber().click();
	}

	public void verifyMobileNumberFunctionality(String name,String password , String mobile) {
		enterMobileNumber(mobile);
		enterYourName(name);
		enterPassword(password);
		clickOnVerifyMobileNumber();
	}

	

	public void clickOnSignInLink() {
		getsignInInsteadElement().click();
	}









	public boolean verifyPresenceOfElementsOnPage(List<String> fieldNames) {
        boolean result = true;
        int count = 0;
        for(String fieldName : fieldNames) {
       	  WebElement element = getElementByFieldName(fieldName);
       	  
       	  if(element==null) {
       		  System.out.println("Element is null so please make sure this corresponding webelement is present in this excel - "+fieldName);
       		  result = false;
       		  continue;
       	  }
       	  if(wait.getElementPresentState()==true) {
       		  if(element.isDisplayed() == true) {
       			  System.out.println(fieldName+" is present on the page");
       		  }
       	  }else {
   			  System.out.println(fieldName+" is not present on the page");
                 count++;
   		  }
        }
        if(count!=0) {
       	 result = false;
        }
        
        return result;
	}
	
	public WebElement getElementByFieldName(String fieldName) {
		WebElement element = null;
		try {
			switch (fieldName.toLowerCase()) 
			{
			case "your name": {
				element = getyourNameElement();
				break;
			}			
			case "mobile number":{
				element = getmobileNumberElement();
				break;
			}
			case "password":{
				element = getpasswordElement();
				break;
			}
			case "verify mobile number button":{
				element = getVerifyMobileNumber();
				break;
			}
			case "sign in link":{
				element = getsignInInsteadElement();
				break;
			}
			default:
				throw new IllegalArgumentException("INvalid field name: " + fieldName);
			}
			
		}catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
		
		
		return element;
	}

}
