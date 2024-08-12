package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class HomePage extends BasePage{
	
	private Actions actions;
	protected WebDriver driver;
	
	
	@FindBy(id="nav-link-accountList")
	public WebElement accountAndLists;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//span[text()='Sign in']")
	public WebElement signInButton;
	
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-newCust']/a[text()='Start here.']")
	public WebElement newCustomerStartHereLink;
	
	public HomePage(WebDriver driver) {
		
		//This super(driver) will call the constructor of parent class i.e. BasePage.Constructor chaining
		super(driver);
		System.out.println("Hi");
		//This line will initialize all the webelements created above using PageFactory
	  PageFactory.initElements(driver, this);	
	  actions = new Actions(driver);
	}
	

	
	
	//getter methods
	public WebElement getAccountAndListsElement() {
		wait.waitForVisibilityOfElement(accountAndLists);
		return accountAndLists;
	}
	
	public WebElement getsignInButtonElement() {
		wait.waitForVisibilityOfElement(signInButton);
		return signInButton;
	}
	
	public WebElement getnewCustomerStartHereLinkElement() {
		wait.waitForVisibilityOfElement(newCustomerStartHereLink);
		return newCustomerStartHereLink;
	}
	
	
	//methods acting on page elements

			public void openSignInOrCreateAccountPage() {
				System.out.println("2");
				actions.moveToElement(getAccountAndListsElement()).perform();		
				getsignInButtonElement().click();
			}

}
