package com.qa.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;

public class SignInOrCreateAccountPageTest extends BaseTest{
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void setupPage() {
		System.out.println("HI -1");
		homePage.openSignInOrCreateAccountPage();
	}
	
	@Test(groups={"sanity"})
	public void isLogoPresentTest() {
		try {
		Assert.assertTrue(signInPage.verifyLogo(),"Error - Logo is not present");
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Test(groups={"sanity"})
	public void pageTitleTest() {
		Assert.assertEquals(signInPage.getTitleOfThePage(), "Amazon Sign In","Error - pageTitle is not matching with the expected title.Expected pageTitle=Amazon Sign In||Actual pageTitle="+signInPage.getTitleOfThePage()		);
	}
//	
//	@Test(groups={"sanity"})
//	public void backAndforthScenarioTest()
//	{
//		basePage.navigateBackward();
//		Assert.assertEquals(homePage.getTitleOfThePage(), "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in","Error - User is not properly moved to the previous page");
//	    basePage.navigateForward();
//		Assert.assertEquals(signInPage.getTitleOfThePage(), "Amazon Sign In");
//		basePage.refreshPage();
//		Assert.assertEquals(signInPage.getTitleOfThePage(), "Amazon Sign In");
//
//	}
//	
//	
//	@Test(groups={"regression"})
//	public void verifyFieldsOnThatPageTest() throws IOException {
//		List<String> fieldNames = excelReader.getFieldsNamesfromExcel("SignInPage");
//		Assert.assertTrue(signInOrCreateAccountPage.verifyPresenceOfElementsOnPage(fieldNames), "some elements are not present on the page");
//		//We can store all the fields in an excel and compare actual fields at run time
//		//Assert all the fields and print if any field is not present from the expected list
//	}
//	
//	@Test (groups={"regression"})
//	public void signInWithUnregisteredEmailIDTest() {
//		signInOrCreateAccountPage.enterEmailID("abc.Test@exam.com");
//		signInOrCreateAccountPage.clickOnContinueButton();
//		Assert.assertEquals(intentPage.getTitleOfThePage(), "Looks like you are new to Amazon","Error - pageTitle is not matching with the expected title.Expected pageTitle=Looks like you are new to Amazon||Actual pageTitle="+intentPage.getTitleOfThePage()		);
//	}
//	
//	@Test (groups={"regression"})
//	public void signInWithInvalidEmailIDTest() {
//		signInOrCreateAccountPage.enterEmailID("abc.Test");
//		signInOrCreateAccountPage.clickOnContinueButton();
//		Assert.assertEquals(signInOrCreateAccountPage.getinvalidEmailErrorElement().getText(), "Invalid Email address");
//	}
//	
//	
//	@Test(groups={"regression"})
//	public void signInWithValidCredentials(String username , String password) {
//		signInOrCreateAccountPage.enterEmailID(username);
//		signInOrCreateAccountPage.clickOnContinueButton();
//		signInPage.enterpassword(password);
//		signInPage.clickOnSignInButton();	
//		//Assert the successful sign in by verifying the fields
//	}

}
