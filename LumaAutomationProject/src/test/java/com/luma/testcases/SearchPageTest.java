package com.luma.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.luma.functions.SearchPage;
import com.luma.login.LoginPage;

public class SearchPageTest {
	
	LoginPage lp;
	SearchPage hs; 
	
	@BeforeMethod
	public void browserSetUp() {
		lp=new LoginPage();
		lp.initialization();
	}
	
	@Test
	public void hoverSearchTest() {
		hs=new SearchPage();
		Assert.assertTrue(hs.hoverSearch());
	}
	
	@Test
	public void addToWishlistTest() {
		lp.login();
		hs=new SearchPage();
		Assert.assertTrue(hs.addToWishlist());
	}

	@Test
	public void sortSearchTest() {
		hs=new SearchPage();
		hs.sortSearch();
	}
	
	@Test
	public void searchFilterBySizeTest() {
		hs=new SearchPage();
		hs.searchFilterBySize();
	}
	
	@Test
	public void clearSizeFilterTest() {
		hs=new SearchPage();
		hs.clearSizeFilter();
	}
	
	@Test
	public void addToCompareTest() {
		hs=new SearchPage();
		hs.addToCompare();
	}
	
	@Test
	public void moreInformationTest() {
		hs=new SearchPage();
		hs.moreInformation();
	}
	
	@Test
	public void reviewTabTest() {
		hs=new SearchPage();
		hs.reviewTab();
	}
	
	@Test
	public void submitReviewTest() {
		hs=new SearchPage();
		Assert.assertTrue(hs.submitReview());
	}
	
	@AfterMethod
	public void closeBrowser() {
		lp.tearDown();
	}
	
}
