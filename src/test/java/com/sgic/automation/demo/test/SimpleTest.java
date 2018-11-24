package com.sgic.automation.demo.test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SimpleTest extends BaseTest {

	private String browser;
	public static Properties prop = new Properties();

	
	@Test
	public void testOrangeHRM() throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.id("divLogin")).click();
		driver.findElement(By.id("txtPassword")).click();
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Waktu'])[1]/following::b[1]")).click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Confirm Toggl Sync'])[1]/following::b[1]"))
				.click();
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	
}
