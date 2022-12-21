package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
public class GmailLogin {
	private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setUp() {
	    driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	  @Test
	public void gmaillogin() {
		  
	      System.setProperty("webdriver.chrome.driver",
	      "C:\\Users\\admin\\Desktop\\VMS\\eclipse-java-2022-09-R-win32-x86_64\\chromedriver_win32\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      
//	      option = webdriver.ChromeOptions();
//	      option.add_experimental_option("debuggerAddress", "localhost:8797");
//	      driver = webdriver.Chrome(executable_path = "C:\\Users\\admin\\Desktop\\VMS\\eclipse-java-2022-09-R-win32-x86_64\\chromedriver_win32\\chromedriver.exe", options = option );
	      
	      //URL launch
	      driver.get("https://accounts.google.com/signin");
	      driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	      
	      //identify email
	      WebElement l = driver
	      .findElement(By.name("identifier"));
	      l.sendKeys("autotestvms@gmail.com");
	      WebElement b = driver
	      .findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/span"));
	      b.click();
	      
	      //identify password
	      WebElement p = driver
	      .findElement(By.name("Passwd"));
	      p.sendKeys("vnn123456");
//	      driver.findElement(By.xpath("//input[@name='password']")).sendKeys("vnn123456");
	      WebElement b2 = driver
	    		  .findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/span"));
	    	      b2.click();
	    	      
	      //close browser when open new tab for getContent
//	      driver.close();
	   }
}
