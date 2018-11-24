package com.sgic.automation.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
	private WebElement lblHeader =driver.findElement(By.xpath("//h1"));

	DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public boolean isDashboardDisplayed() {
		 boolean flag = false;
		 try {
			 lblHeader.isDisplayed();
			 flag=true;
		 }
		 catch(Exception e) {
			 flag=false;
				 
			 }
		 return flag;
		 }
	}
	


