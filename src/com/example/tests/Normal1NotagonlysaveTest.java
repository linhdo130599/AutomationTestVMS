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
import java.net.MalformedURLException;
import java.net.URL;
public class Normal1NotagonlysaveTest {
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
  public void normal1Notagonlysave() {
    driver.get("https://uat-cms.vietnamnet.vn/news/addv8/1");
    driver.manage().window().setSize(new Dimension(1936, 1048));
    //Phần này là login qua G+ và nhận OTP
    
    // Phần này là bắt đầu tự động soạn tin bài
    driver.findElement(By.id("news.sourceId")).click();
    {
      WebElement dropdown = driver.findElement(By.id("news.sourceId"));
      dropdown.findElement(By.xpath("//option[. = 'Báo chí toàn dân']")).click();
    }
    // Select loại tin bài
    driver.findElement(By.cssSelector("#select2-select2-29a17cda-d4de-4f21-8552-d9f575768b01-container>.select2-selection__placeholder")).click();
    driver.findElement(By.cssSelector("li.select2-results__option--highlighted")).click();
    driver.findElement(By.cssSelector(".row:nth-child(2) .far:nth-child(1)")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".row:nth-child(2) .far:nth-child(1)"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    //Select avatar
    {
      WebElement element = driver.findElement(By.cssSelector("div.ckf-file-desc"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    
    driver.findElement(By.cssSelector(".col-4:nth-child(1) .ckf-file-desc .btn > .btn")).click();
 // Add title
    driver.findElement(By.name("news.title")).click();
    driver.findElement(By.name("news.title")).sendKeys("HLV Hải Phòng bất ngờ khi dẫn trước Hà Nội ba bàn [Normal]");
    {
      WebElement element = driver.findElement(By.name("news.description"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    driver.findElement(By.id("kt_content")).click();
    driver.findElement(By.name("news.description")).sendKeys("HLV Hải Phòng bất ngờ khi dẫn trước Hà Nội ba bàn [Normal]");
    driver.findElement(By.name("news.title")).click();
    driver.findElement(By.name("news.seoOption.title")).click();
    driver.findElement(By.name("news.seoOption.title")).sendKeys("HLV Hải Phòng bất ngờ khi dẫn trước Hà Nội ba bàn [Normal]");
    driver.findElement(By.name("news.seoOption.description")).click();
    driver.findElement(By.name("news.seoOption.description")).sendKeys("HLV Hải Phòng bất ngờ khi dẫn trước Hà Nội ba bàn [Normal]");
    driver.findElement(By.name("news.seoOption.keywords")).click();
    driver.findElement(By.name("news.seoOption.keywords")).sendKeys("HLV Hải Phòng bất ngờ khi dẫn trước Hà Nội ba bàn [Normal]");
    driver.switchTo().frame(0);
    driver.findElement(By.cssSelector("html")).click();
    {
      WebElement element = driver.findElement(By.id("tinymce"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>Test ABC</p><p><br data-mce-bogus=\"1\"></p>'}", element);
    }
    driver.switchTo().defaultContent();
    driver.findElement(By.cssSelector(".tox-tbtn:nth-child(1) img")).click();
    js.executeScript("window.scrollTo(0,0)");
    {
      WebElement element = driver.findElement(By.cssSelector("div.ckf-file-desc"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".col-4:nth-child(1) .ckf-file-desc .btn > .btn")).click();
    driver.switchTo().frame(0);
    js.executeScript("window.scrollTo(0,298)");
    driver.switchTo().defaultContent();
    js.executeScript("window.scrollTo(0,700)");
    driver.switchTo().frame(0);
    driver.findElement(By.cssSelector("html")).click();
    {
      WebElement element = driver.findElement(By.id("tinymce"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>Test ABC</p><figure class=\"image vnn-content-image\" contenteditable=\"false\"><img src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/10/25/0009CB/-1157-1666191985.jpg\" data-mce-src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/10/25/0009CB/-1157-1666191985.jpg\"><figcaption contenteditable=\"true\"></figcaption></figure><p><br data-mce-bogus=\"1\"></p>'}", element);
    }
    driver.switchTo().defaultContent();
    driver.findElement(By.cssSelector(".tox-tbtn:nth-child(2) img")).click();
    js.executeScript("window.scrollTo(0,0)");
    {
      WebElement element = driver.findElement(By.cssSelector("div.ckf-file-desc"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".col-4:nth-child(1) .flaticon2-checkmark")).click();
    driver.switchTo().frame(0);
    driver.findElement(By.id("tinymce")).click();
    {
      WebElement element = driver.findElement(By.id("tinymce"));
      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>Test ABC</p><figure class=\"image vnn-content-image\" contenteditable=\"false\"><img src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/10/25/0009CB/-1157-1666191985.jpg\" data-mce-src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/10/25/0009CB/-1157-1666191985.jpg\"><figcaption contenteditable=\"true\"></figcaption></figure><figure class=\"vnn-resposive-video-embed-169\"><span contenteditable=\"false\" data-mce-object=\"iframe\" class=\"mce-preview-object mce-object-iframe\" data-mce-p-data-mce-fragment=\"1\" data-mce-p-allowfullscreen=\"allowfullscreen\" data-mce-p-allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" data-mce-p-src=\"https://uat-embed.vnncdn.net/v/0000KO.html\"><iframe width=\"560\" height=\"315\" src=\"https://uat-embed.vnncdn.net/v/0000KO.html\" allowfullscreen=\"allowfullscreen\" frameborder=\"0\"></iframe><span class=\"mce-shim\"></span></span></figure><p><br data-mce-bogus=\"1\"></p>'}", element);
    }
    driver.switchTo().defaultContent();
    driver.findElement(By.cssSelector(".ng-untouched:nth-child(3) .select2-search__field")).click();
    driver.findElement(By.cssSelector("li.select2-results__option")).click();
    driver.findElement(By.cssSelector("kt-button-icon:nth-child(2) .flaticon2-plus-1")).click();
    {
      WebElement element = driver.findElement(By.cssSelector("kt-button-icon:nth-child(2) .flaticon2-plus-1"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(1) > .text-center > .switch span")).click();
    driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(2) > .text-center > .switch span")).click();
    driver.findElement(By.cssSelector(".btn-shadow-hover")).click();
    driver.findElement(By.id("select2-select2-bd0a05a7-694d-46df-b90b-76b41799fe2b-container")).click();
    driver.findElement(By.cssSelector("li.select2-results__option")).click();
    driver.findElement(By.cssSelector(".btn-success > .far")).click();
    js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.cssSelector(".btn-light-success")).click();
    driver.findElement(By.cssSelector(".btn-elevate:nth-child(2)")).click();
    driver.findElement(By.xpath("//button[@class=\'btn btn-danger btn-elevate mr-2\']")).click();
  }
}
