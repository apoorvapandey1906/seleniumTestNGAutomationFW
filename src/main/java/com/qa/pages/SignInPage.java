package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class SignInPage extends BasePage{
	
	protected WebDriver driver;
	
	
	@FindBy(xpath="//div[@class='a-alert-content']//span[contains(text(),'Your password is incorrect')]")
	public WebElement incorrectPasswordError;
	
	@FindBy(id="ap_password")
	public WebElement enterPassword;
	
	@FindBy(id="signInSubmit")
	public WebElement signInButton;

	
	public SignInPage(WebDriver driver) {
		super(driver);
	  PageFactory.initElements(driver, this);		
	}
	
	//getter methods
	public WebElement getincorrectPasswordErrorElement() {
		wait.waitForVisibilityOfElement(incorrectPasswordError);
		return incorrectPasswordError;
	} 
	
	
	public WebElement getenterPasswordElement() {
		wait.waitForVisibilityOfElement(enterPassword);
		return enterPassword;
	} 
	
	public WebElement getsignInButtonElement() {
		wait.waitForVisibilityOfElement(signInButton);
		return signInButton;
	} 

	public void enterpassword(String password) {
		getenterPasswordElement().sendKeys(password);		
	}

	public void clickOnSignInButton() {
		getsignInButtonElement().click();
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
			case "password": {
				element = getenterPasswordElement();
				break;
			}
			
			case "sign in button":{
				element = getsignInButtonElement();
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
	
	
	
	public String getIncorrectPasswordErrorText(String password) {
		getenterPasswordElement().sendKeys(password);
		getsignInButtonElement().click();
		return getincorrectPasswordErrorElement().getText().trim();
	}

}
