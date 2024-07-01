package com.luma.functions;

import java.time.Duration;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.openqa.selenium.By;

import com.luma.base.LumaBase;

public class SearchBox extends LumaBase{
	
	By searchBx=By.name("q");
	By Clicksearch=By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button");
	By searchSuccess=By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span");
	By SearchRes1=By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]"
			+ "/div[2]/ol/li[1]/div/a/span/span/img");
	By addCartBtn=By.id("product-addtocart-button");
	By size=By.xpath("//*[@id=\"option-label-size-143-item-166\"]");
	By color=By.xpath("//*[@id=\"option-label-color-93-item-50\"]");
	By added=By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div");
	By minicart=By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"); 
	By chkOutBtn=By.xpath("//*[@id=\"top-cart-btn-checkout\"]");
	
	public boolean searchBoxValidation() {
		driver.findElement(searchBx).sendKeys("T-Shirt");
		driver.findElement(Clicksearch).click();
		return driver.findElement(searchSuccess).isDisplayed();
	}
	
	public boolean searchResult() {
		searchBoxValidation();
		driver.findElement(SearchRes1).click();
		//driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[1]/h1")).isDisplayed();
		driver.findElement(size).click();
		driver.findElement(color).click();
		driver.findElement(addCartBtn).click();
		return driver.findElement(added).isDisplayed();
		//System.out.println("msg--"+msg);
	}
	
	public String proccedToChkOut() {
		searchResult();
		driver.findElement(minicart).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(chkOutBtn).click();
		//System.out.println("title is--"+driver.getTitle());
		return driver.getTitle();
		}
}
