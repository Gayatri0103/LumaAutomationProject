package com.luma.login;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.luma.base.LumaBase;

public class LoginPage extends LumaBase {

	By signIn = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
	By email = By.id("email");
	By pwd = By.id("pass");
	By send = By.name("send");
	By welcomeMsg = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span");
	By menuOptions = By.xpath("//button[span[text()='Change']]");
	By signOut = By.linkText("Sign Out");

	public boolean login() {
		driver.findElement(signIn).click();
		driver.findElement(email).sendKeys(prop.getProperty("email"));
		driver.findElement(pwd).sendKeys(prop.getProperty("cpassword"));
		driver.findElement(send).click();
		return driver.findElement(welcomeMsg).isDisplayed();
		// System.out.println("success msg is--"+msg);
	}

	public void signOut() {
		login();
		driver.findElement(menuOptions).click();
		driver.findElement(signOut).click();
	}

}
