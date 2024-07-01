package com.luma.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.functions.SearchBox;
import com.luma.functions.ShoppingCart;
import com.luma.login.LoginPage;

public class ShoppingCartTest {
	
	LoginPage lp;
	ShoppingCart sc;
	
	@BeforeMethod
	public void browserSetUp() {
		lp=new LoginPage();
		lp.initialization();
	}
	
	@Test
	public void shoppingCartValidation()  {
		sc=new ShoppingCart();
		sc.shoppingCart();
	}
	
	@Test
	public void shippingValidationTest() {
		sc=new ShoppingCart();
		sc.shippingValidation();
	}
	
	@Test
	public void paymentValidationTest() {
		sc=new ShoppingCart();
		String expTitle="Checkout";
		AssertJUnit.assertEquals(sc.paymentValidation(), expTitle);
	}
	
	@Test
	public void signInAftrShippingTest() {
		sc=new ShoppingCart();
		sc.signInAftrShipping();
	}
	
	@Test
	public void editCartTest() {
		sc=new ShoppingCart();
		String expTitle="Shopping Cart";
		AssertJUnit.assertEquals(sc.editCart(), expTitle);
	}
	
	@AfterMethod
	public void closeBrowserSetUp() {
		lp.tearDown();
	}
	
}
