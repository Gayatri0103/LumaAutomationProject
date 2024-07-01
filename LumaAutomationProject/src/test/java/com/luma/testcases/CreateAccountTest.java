package com.luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.create.CreateAccount;

public class CreateAccountTest {
	
	CreateAccount ca;
	
	@BeforeMethod
	public void browserSetup() {
		ca=new CreateAccount();
		ca.initialization();
	}
	
	@Test
	public void validateCreateAccountTest() {
		ca.createAccount();
	}
	
	@Test
	public void checkEmailValidationTest() {
		Assert.assertTrue(ca.checkEmailValidation());
	}
	
	@AfterMethod
	public void closeSetUp() {
		ca.tearDown();
	}

}
