package com.qa.tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.basetest.BaseTest;



public class RegistrationPageTest extends BaseTest{
	
	
	@BeforeMethod(alwaysRun=true)
	public void setupPage() {
		//Open the registration page from the HomePage of amazon
	     homePage.openSignInOrCreateAccountPage();
	     signInOrCreateAccountPage.openIntentPage("siya5122@gmail.com");
	     intentPage.openRegistrationPage();
	}
	
	@Test(groups={"sanity"})
	public void isLogoPresentTest() {
		Assert.assertTrue(registrationPage.verifyLogo(),"Error - Logo is not present");
	}
//
//	@Test(groups={"sanity"})
//	public void pageTitleTest() {
//		Assert.assertEquals(registrationPage.getTitleOfThePage(), "Amazon Registration","Error - pageTitle is not matching with the expected title.Expected pageTitle=Amazon Registration||Actual pageTitle="+registrationPage.getTitleOfThePage()		);
//	}
//
//	
//	@Test(groups={"regression"})
//	public void verifyMobileNumberTest() {
//		registrationPage.verifyMobileNumberFunctionality("Name","pass","6788792");
//	}
//	
//	@Test(groups={"regression"})
//	public void signInLinkTest() {
//		registrationPage.clickOnSignInLink();
//		Assert.assertEquals(signInPage.getTitleOfThePage(), "Amazon SignIn Page","Error - Sign In Page didn't open after clicking on the signIn link");
//	}
//	
//	
//	
//	@Test(groups={"regression"})
//	public void verifyFieldsOnThatPageTest() throws IOException {
//		List<String> fieldNames = excelReader.getFieldsNamesfromExcel("SignInPage");
//		Assert.assertTrue(registrationPage.verifyPresenceOfElementsOnPage(fieldNames), "some elements are not present on the page");
//		//We can store all the fields in an excel and compare actual fields at run time
//		//Assert all the fields and print if any field is not present from the expected list
//	}
}
