package com.sgic.automation.demo.pagetests;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	protected static WebDriver driver;
	private String browser;
	protected static Properties prop = new Properties();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		// baseUrl = "https://www.katalon.com/";

		InputStream inputStream = null;
		inputStream = this.getClass().getClassLoader().getResourceAsStream("config/config.properties");
		prop.load(inputStream);

		browser = System.getProperty("browser");
		if (browser == null || browser.isEmpty()) {
			browser = prop.getProperty("browser");
		}

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriverPath"));
			driver = new FirefoxDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}

}
