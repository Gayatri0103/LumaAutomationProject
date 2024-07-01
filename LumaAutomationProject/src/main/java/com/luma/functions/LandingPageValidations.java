package com.luma.functions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import com.luma.base.LumaBase;

public class LandingPageValidations extends LumaBase {

	By shopPants = By.xpath("//span[text()='Luma pants when you shop today*']");
	By footer = By.xpath("/html/body/div[2]/footer/div");
	By sales = By.xpath("//a[span[text()='Sale']]");
	By womenDeal = By.xpath("//span[text()='Shop Women’s Deals']");
	By womenSale = By.xpath("//span[text()='Women Sale']");
	By advSearch = By.xpath("//a[text()='Advanced Search']");
	By prodName = By.name("name");
	By sku = By.name("sku");
	By advSearchBtn = By.xpath("//*[@id=\"form-validate\"]/div/div/button");

	public String shopPantsValidation() {
		driver.findElement(shopPants).click();
		return driver.getTitle();
		// System.out.println("title--"+driver.getTitle());
	}

	public boolean scrollTofooter() {
		WebElement target = driver.findElement(footer);
		Actions act = new Actions(driver);
		act.scrollToElement(target).build().perform();
		return driver.findElement(footer).isDisplayed();
		// System.out.println(msg);
	}

	public boolean salesMenu() {
		driver.findElement(sales).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(womenDeal).click();
		return driver.findElement(womenSale).isDisplayed();
	}

	public String advSearch() {
		scrollTofooter();
		driver.findElement(advSearch).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(prodName).sendKeys("Juno Jacket");
		driver.findElement(sku).sendKeys("WJ06");
		driver.findElement(advSearchBtn).click();
		return driver.getTitle();
		// System.out.println(title);
	}
}
