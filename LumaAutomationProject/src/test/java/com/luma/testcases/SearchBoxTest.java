package com.luma.testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.functions.SearchBox;
import com.luma.login.LoginPage;

public class SearchBoxTest {
	
	LoginPage lp;
	SearchBox sb;
	
	@BeforeMethod
	public void browserSetUp() {
		lp=new LoginPage();
		lp.initialization();
	}
	
	@Test
	public void searchBoxValidationTest() {
		sb=new SearchBox();
		Assert.assertTrue(sb.searchBoxValidation());;
	}
	
	@Test
	public void searchResultValidation() {
		sb=new SearchBox();
		Assert.assertTrue(sb.searchResult());
	}
	
	@Test
	public void proccedToChkOutTest() {
		sb=new SearchBox();
		String expTitle="Checkout";
		AssertJUnit.assertEquals(sb.proccedToChkOut(), expTitle);
	}
	
	@AfterMethod
	public void closeBrowserSetUp() {
		lp.tearDown();
	}
}
