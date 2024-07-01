package com.luma.create;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.luma.base.LumaBase;

public class CreateAccount extends LumaBase {

	By fname = By.name("firstname");
	By lname = By.name("lastname");
	By email = By.name("email");
	By pwd = By.name("password");
	By pwd_cnfr = By.name("password_confirmation");
	By createAccnt1 = By.xpath("//a[text()='Create an Account']");
	By createAccnt2 = By.xpath("//span[text()='Create an Account']");

	public void createAccount() {
		driver.findElement(createAccnt1).click();
		driver.findElement(fname).sendKeys(prop.getProperty("Fname"));
		driver.findElement(lname).sendKeys(prop.getProperty("Lname"));
		driver.findElement(email).sendKeys(prop.getProperty("email"));
		driver.findElement(pwd).sendKeys(prop.getProperty("cpassword"));
		driver.findElement(pwd_cnfr).sendKeys(prop.getProperty("cpassword_confirmation"));
		driver.findElement(createAccnt2).click();
	}

	public boolean checkEmailValidation() {
		driver.findElement(createAccnt1).click();
		driver.findElement(fname).sendKeys(prop.getProperty("Fname"));
		driver.findElement(lname).sendKeys(prop.getProperty("Lname"));
		driver.findElement(email).sendKeys("abc");
		driver.findElement(pwd).sendKeys(prop.getProperty("cpassword"));
		driver.findElement(pwd_cnfr).sendKeys(prop.getProperty("cpassword_confirmation"));
		driver.findElement(createAccnt2).click();
		boolean errmsg = driver.findElement(By.id("email_address-error")).isDisplayed();
		return errmsg;
		// System.out.println("error is--"+errmsg);
	}

}
