package com.luma.testcases;

import org.checkerframework.checker.units.qual.t;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.functions.LandingPageValidations;
import com.luma.login.LoginPage;

public class LandingPageTest {
	
	LoginPage lp;
	LandingPageValidations lpv;
	
	@BeforeMethod
	public void browserSetUp() {
		lp=new LoginPage();
		lp.initialization();
	}

	@Test
	public void shopPantsValidationTest() {
		lpv=new LandingPageValidations();
		String expTitle="Pants";
		Assert.assertEquals(lpv.shopPantsValidation(), expTitle);;
	}
	
	@Test
	public void scrollTofooterTest() {
		lpv=new LandingPageValidations();
		Assert.assertTrue(lpv.scrollTofooter());
	}
	
	@Test
	public void salesMenuTest() {
		lpv=new LandingPageValidations();
		Assert.assertTrue(lpv.salesMenu());
	}
	
	@Test
	public void advSearchTest() {
		lpv=new LandingPageValidations();
		String expTitle="Advanced Search Results";
		Assert.assertEquals(lpv.advSearch(), expTitle);
	}
	
	@AfterMethod
	public void closeBrowserSetUp() {
		lp.tearDown();
	}
	
}
