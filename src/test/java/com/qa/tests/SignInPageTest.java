package com.qa.tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;

public class SignInPageTest extends BaseTest{

	
	@BeforeMethod(alwaysRun = true)
	public void setupPage() {
		homePage.openSignInOrCreateAccountPage();
		signInOrCreateAccountPage.enterEmailID("apoorvapandey1906@gmail.com");
		signInOrCreateAccountPage.clickOnContinueButton();
	}
	
//	@Test(groups={"sanity"})
//	public void isLogoPresentTest() {
//		Assert.assertTrue(signInPage.verifyLogo(),"Error - Logo is not present");
//	}
//
//	@Test(groups={"sanity"})
//	public void pageTitleTest() {
//		Assert.assertEquals(signInPage.getTitleOfThePage(), "Amazon Sign In","Error - pageTitle is not matching with the expected title.Expected pageTitle=Amazon Sign In||Actual pageTitle="+signInPage.getTitleOfThePage()		);
//	}
//	
//	
//	@Test(groups={"sanity"})
//	public void verifyFieldsOnThatPageTest() throws IOException {
//		List<String> fieldNames = excelReader.getFieldsNamesfromExcel("SignInPage");
//		Assert.assertTrue(signInPage.verifyPresenceOfElementsOnPage(fieldNames), "some elements are not present on the page");
//		//We can store all the fields in an excel and compare actual fields at run time
//		//Assert all the fields and print if any field is not present from the expected list
//		
//	}
//	
//	@Test (groups={"sanity"})
//	public void signInWithIncorrectPasswordTest(String incorrectPassword) {
//		String errorText = signInPage.getIncorrectPasswordErrorText(incorrectPassword);
//		Assert.assertEquals(errorText, "Your password is incorrect","Error - Error message is not correct.Expected pageTitle=Your password is incorrect||Actual pageTitle="+errorText);
//	}
//	
//	@Test(groups={"regression"})
//	public void signInWithValidCredentials( String password) {
//		signInPage.enterpassword(password);
//		signInPage.clickOnSignInButton();	
//		//Assert the successful sign in by verifying the fields
//	}
}
