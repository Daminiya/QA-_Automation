package com.sgic.automation.demo.test;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.sgic.automation.demo.util.Log;

public class LoginTest extends BaseTest{
	
	private static Logger logger = LogManager.getLogger(LoginTest.class);

	boolean flag =false;
  @Test
  public void testUntitledTestCase() throws Exception {
	  extentTest=extentReport.startTest(" Test"+i);
    driver.get(prop.getProperty("baseUrl"));
    Log.startTestCase();
    driver.findElement(By.id("txtUsername")).clear();
    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
    extentTest.log(LogStatus.PASS)
    logger.log(Level.INFO,"######  entered username ######");
    driver.findElement(By.id("divPassword")).click();
    driver.findElement(By.id("frmLogin")).click();
    driver.findElement(By.id("txtPassword")).click();
    logger.log(Level.INFO,"######  entered password ######");
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
    driver.findElement(By.id("btnLogin")).click();
    logger.log(Level.INFO,"######  login button clicked ######");
  
	if (driver.findElement(By.id("welcome")).getText().equalsIgnoreCase("Welcoe Admin")) {
		
		flag =true;
	} else {
		String File=captureScreenShot();
		logger.log(Level.ERROR, "Failed To find the message.\n"+"Screenshot file:"+;
	}
	
	Assert.assertTrue(flag);

    //Thread.sleep(2000);
    driver.findElement(By.id("welcome")).click();
    driver.findElement(By.linkText("Logout")).click();
    Log.
    Log.endTestCase();
  }

}
