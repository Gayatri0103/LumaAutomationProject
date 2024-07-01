package com.luma.functions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.luma.base.LumaBase;
import com.luma.login.LoginPage;

public class SearchPage extends LumaBase {

	By womenDrpdwn = By.xpath("//*[@id=\"ui-id-4\"]/span[2]");
	By Sm = By.linkText("Tops");
	By Sm2 = By.linkText("Jackets");
	By Sm2Search = By.xpath("//*[@id=\"page-title-heading\"]/span");
	By gearDrpDwn = By.linkText("Gear");
	By SmBags = By.linkText("Bags");
	By item1 = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div");
	By addWL = By.linkText("ADD TO WISH LIST");
	By wishList = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");
	By sort = By.id("sorter");
	By sizeOp = By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[1]");
	By mSize = By.xpath("//*[@id=\"narrow-by-list\"]/div[2]/div[2]/div/div/a[3]/div");
	By removeSize = By.xpath("//*[@id=\"layered-filter-block\"]/div[2]/div[1]/ol/li/a");
	By compareList = By.linkText("ADD TO COMPARE");
	By moreInfo = By.xpath("//a[@id=\"tab-label-additional-title\"]");
	By itemMoreInfo = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/" + "div[3]/ol/li[1]/div/a/span/span/img");
	By reviewTab = By.xpath("//a[@id='tab-label-reviews-title']");
	By starRating = By.xpath("//label[span[text()='5 stars']]");
	By nickName = By.name("nickname");
	By summary = By.id("summary_field");
	By review = By.id("review_field");
	By submitReviewBtn = By.xpath("//button[span[text()='Submit Review']]");
	By reviewSucess = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div");

	public boolean hoverSearch() {
		// WebDriver driver=new ChromeDriver();
		// driver.get("https://magento.softwaretestingboard.com/");
		WebElement mainMenu = driver.findElement(womenDrpdwn);
		Actions act = new Actions(driver);
		act.moveToElement(mainMenu).build().perform();
		WebElement subMenu = driver.findElement(Sm);
		act.moveToElement(subMenu).perform();
		WebElement subMenu2 = driver.findElement(Sm2);
		act.moveToElement(subMenu2).click().perform();
		return driver.findElement(Sm2Search).isDisplayed();
	}

	public void addTo() {
		WebElement mainMenu = driver.findElement(gearDrpDwn);
		Actions act = new Actions(driver);
		act.moveToElement(mainMenu).build().perform();
		WebElement subMenu = driver.findElement(SmBags);
		act.moveToElement(subMenu).click().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		WebElement itemToAdd = driver.findElement(item1);
		act.moveToElement(itemToAdd).build().perform();
//        System.out.println("text--"+itemToAdd.getText());
//        WebElement ac = driver.findElement(addWL);
//        act.moveToElement(ac).click().perform();
//        return driver.findElement(wishList).isDisplayed();
	}

	public boolean addToWishlist() {
		addTo();
		Actions act = new Actions(driver);
		WebElement ac = driver.findElement(addWL);
		act.moveToElement(ac).click().perform();
		return driver.findElement(wishList).isDisplayed();
	}

	public void sortSearch() {
		hoverSearch();
		WebElement sortFilter = driver.findElement(sort);
		Select obj = new Select(sortFilter);
		obj.selectByVisibleText("Product Name ");
	}

	public void searchFilterBySize() {
		hoverSearch();
		driver.findElement(sizeOp).click();
		driver.findElement(mSize).click();
	}

	public void clearSizeFilter() {
		searchFilterBySize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(removeSize).click();
	}

	public void addToCompare() {
		addTo();
		Actions act = new Actions(driver);
		WebElement ac = driver.findElement(compareList);
		act.moveToElement(ac).click().perform();
	}

	public void moreInformation() {
		addTo();
		driver.findElement(itemMoreInfo).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(moreInfo).click();
	}

	public void reviewTab() {
		addTo();
		driver.findElement(itemMoreInfo).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(reviewTab).click();
	}

	public boolean submitReview() {
		reviewTab();
		WebElement element = driver.findElement(starRating);
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
		driver.findElement(nickName).sendKeys("Miss X");
		driver.findElement(summary).sendKeys("Push it messenger Bag");
		driver.findElement(review).sendKeys("is a great addition ");
		driver.findElement(submitReviewBtn).click();
		return driver.findElement(reviewSucess).isDisplayed();
		// System.out.println(msg);
	}
}
