package com.luma.functions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.luma.base.LumaBase;

public class ShoppingCart extends LumaBase {

	By minicart = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
	// openMiniCartDialogue=By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/strong");
	By closeMiniDialogue = By.xpath("//button[@id='btn-minicart-close']");
	By email = By.id("customer-email");
	By fName = By.name("firstname");
	By lname = By.name("lastname");
	By city = By.name("city");
	By CntryDrpDwn = By.name("country_id");
	By state = By.name("region_id");
	By zip = By.name("postcode");
	By phone = By.name("telephone");
	By shpngMthd = By.name("ko_unique_1");
	By Next = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button");
	By street = By.name("street[0]");
	By addressChBx = By.name("billing-address-same-as-shipping");
	By placeOrdr = By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div");
	By signIn = By.xpath("//*[@id=\"checkout\"]/div[1]/button");
	By loginEmail = By.name("username");
	By loginpwd = By.name("password");
	By login = By.xpath("//*[@id=\"modal-content-7\"]/div/div/div[3]/form/div[2]/div[1]/button");
	By editCart = By.xpath("//span[text()='View and Edit Cart']");
	By login1 = By.xpath("//*[@id=\"checkout\"]/div[1]/aside/div[2]");

	public void shoppingCart() {
		driver.findElement(minicart).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(closeMiniDialogue).click();
		// System.out.println(msg);
	}

	public void shippingValidation() {
		SearchBox sb = new SearchBox();
		sb.proccedToChkOut();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		// System.out.println("2");
		driver.findElement(email).sendKeys("abc@xyz.com");
		driver.findElement(fName).sendKeys("A");
		driver.findElement(lname).sendKeys("B");
		driver.findElement(street).sendKeys("BStreet");
		driver.findElement(city).sendKeys("Hyderabad");
		WebElement country = driver.findElement(CntryDrpDwn);
		Select obj = new Select(country);
		obj.selectByVisibleText("India");
		WebElement states = driver.findElement(state);
		Select stObj = new Select(states);
		stObj.selectByVisibleText("Telangana");
		driver.findElement(zip).sendKeys("123456");
		driver.findElement(phone).sendKeys("1234567890");
		driver.findElement(shpngMthd).click();
		driver.findElement(Next).click();
	}

	public String paymentValidation() {
		shippingValidation();
		driver.findElement(addressChBx).click();
		driver.findElement(placeOrdr).click();
		// System.out.println("3--"+driver.getCurrentUrl());
		//System.out.println("4--" + driver.getTitle());
		return driver.getTitle();
	}

	public String editCart() {
		SearchBox sb = new SearchBox();
		sb.searchResult();
		driver.findElement(minicart).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(editCart).click();
		// System.out.println("edit title--"+driver.getTitle());
		return driver.getTitle();
	}

	public void signInAftrShipping() {
		SearchBox sb = new SearchBox();
		sb.proccedToChkOut();
		driver.findElement(signIn).click();
		driver.findElement(loginEmail).sendKeys(prop.getProperty("email"));
		driver.findElement(loginpwd).sendKeys(prop.getProperty("cpassword"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// driver.findElement(login).click();
		Actions act = new Actions(driver);
		WebElement element = driver.findElement(login1);
		act.moveToElement(element).perform();
		WebElement element1 = driver.findElement(login);
		act.moveToElement(element1).click().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
}
