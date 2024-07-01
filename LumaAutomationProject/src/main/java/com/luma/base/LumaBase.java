package com.luma.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LumaBase {

	public static WebDriver driver;
	public static Properties prop;

	public void initialization() {
		loadPropertyFile();
		String browser = prop.getProperty("browser");
		// System.out.println(browser);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("please open correct browser");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	public void tearDown() {
		driver.quit();
	}

	public void loadPropertyFile() {

		String configFilePath = "./src/main/java/com/luma/config/config.properties";
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(configFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error in locating file");
		}
	}

}
