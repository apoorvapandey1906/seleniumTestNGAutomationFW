package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class SignInOrCreateAccountPage extends BasePage {
	
	
	protected WebDriver driver;

	@FindBy(id="ap_email_login")
	public WebElement enterMobileNumberOrEmail;
	
	
	@FindBy(xpath="//span[@id='continue']//input")
	public WebElement continueButton;
	
	@FindBy(xpath="//div[@id='invalid-email-alert']//div[contains(text(),'Invalid email address')]")
	public WebElement invalidEmailError;
	
	@FindBy(id="ap_password")
	public WebElement enterPassword;
	
	@FindBy(id="signInSubmit")
	public WebElement signInButton;
	
	@FindBy(xpath="//span[contains(text(),'Shop on Amazon Business')]/..")
	public WebElement shopOnAmazonBusinessLink;
	
	
	
	public SignInOrCreateAccountPage(WebDriver driver) {
		super(driver);
	  PageFactory.initElements(driver, this);		
	}
	
	
	//getter methods
	public WebElement getenterMobileNumberOrEmailElement() {
		wait.waitForVisibilityOfElement(enterMobileNumberOrEmail);
		return enterMobileNumberOrEmail;
	} 
	
	public WebElement getShopOnAmazonBusinessLinkElement() {
		wait.waitForVisibilityOfElement(shopOnAmazonBusinessLink);
		return shopOnAmazonBusinessLink;
	} 
	
	public WebElement getcontinueButtonElement() {
		wait.waitForElementToBeClickable(continueButton);
		return continueButton;
	} 
	
	public WebElement getenterPasswordElement() {
		wait.waitForVisibilityOfElement(enterPassword);
		return enterPassword;
	} 
	
	public WebElement getsignInButtonElement() {
		wait.waitForVisibilityOfElement(signInButton);
		return signInButton;
	} 
	
	public WebElement getinvalidEmailErrorElement() {
		wait.waitForVisibilityOfElement(invalidEmailError);
		return invalidEmailError;
	} 
	
	public void openIntentPage(String emailOrNumber) {		
		enterEmailID(emailOrNumber);
		clickOnContinueButton();
	}

	public void enterEmailID(String emailOrNumber) {
		getenterMobileNumberOrEmailElement().sendKeys(emailOrNumber);		
	
	}

	public void enterpassword(String password) {
		getenterMobileNumberOrEmailElement().sendKeys(password);		
	}

	public void clickOnContinueButton() {
		getcontinueButtonElement().click();
	}

	

	public void signInWithValidCredentials(String emailIdOrNumber, String password) {
		enterEmailID(emailIdOrNumber);
		clickOnContinueButton();
		enterpassword(password);
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
			case "enter mobile number or email": {
				element = getenterMobileNumberOrEmailElement();
				break;
			}
			
			case "continue button":{
				element = getcontinueButtonElement();
				break;
			}
			case "shop on amazon business":{
				element = getShopOnAmazonBusinessLinkElement();
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
