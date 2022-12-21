package com.example.tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
public class LoginOTPGmailTest {
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
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void loginOTPGmail() {
    driver.get("https://uat-cms.vietnamnet.vn/");
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(1936, 1048));
    driver.switchTo().frame(0);
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.id("googlelogin")).click();
    //Có thể đặt class GmailLogin vào đây
    WebElement l = driver
  	      .findElement(By.name("identifier"));
  	      l.sendKeys("autotestvms@gmail.com");
  	      WebElement b = driver
  	      .findElement(By.xpath("//*[@id=\'identifierNext\']/div/button/span"));
  	      b.click();
  	    WebElement p = driver
  		      .findElement(By.name("Passwd"));
  		      p.sendKeys("vnn123456");
  		    WebElement b2 = driver
  	    		  .findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/span"));
  	    	      b2.click();
  	// Continued
    vars.put("win8650", waitForWindow(2000));
    vars.put("root", driver.getWindowHandle());
    driver.switchTo().window(vars.get("win8650").toString());
    driver.findElement(By.cssSelector(".JDAKTe:nth-child(1) .wLBAL")).click();
    driver.switchTo().window(vars.get("root").toString());
    driver.findElement(By.id("otp_type")).click();
    {
      WebElement dropdown = driver.findElement(By.id("otp_type"));
      dropdown.findElement(By.xpath("//option[. = 'Email']")).click();
    }
    driver.findElement(By.cssSelector(".btn-primary")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".btn-primary"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.name("otp")).click();
    driver.findElement(By.name("otp")).sendKeys("713413");
    driver.findElement(By.cssSelector(".btn-info")).click();
  }
}
