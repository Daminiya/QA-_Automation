package com.sgic.automation.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.sgic.automation.demo.util.Functions;

public class BaseTest {
//String driverPathChrome = "C:\\Users\\Dilshanth\\Documents\\GitHub\\eclipse\\automation\\webdrivers\\chromedriver.exe";
//String driverPathFirefox = "C:\\Users\\Dilshanth\\Documents\\GitHub\\eclipse\\automation\\webdrivers\\chromedriver.exe"; 
  protected static WebDriver driver;
  private String browser;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  protected static Properties prop = new Properties();
private String screenShotFolderPath=System.getProperty("usr.dir")+"/src/test/resources/screenshots/";
  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    baseUrl = "https://www.katalon.com/";
    
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
        break;}
    }
    
public static String captureScreenShot() {
        
        String filename = Functions.getTimeStamp("yyyy-MM-dd_HH:mm:ss")+".jpg";
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File(screenShotFolderPath + filename));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
        return filename;
    }
    
//    System.out.println("Launching Chrome Browser...");
//    System.setProperty("webdriver.chrome.driver", driverPathChrome);   
//    driver = new ChromeDriver();
    
//    System.out.println("Launching Firefox Browser...");
//    System.setProperty("webdriver.gecko.driver", driverPathFirefox);   
//    driver = new FirefoxDriver();
 
  
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
	  extentReport.flush();
    driver.quit();
  }

}
