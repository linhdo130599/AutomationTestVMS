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

import com.beust.jcommander.internal.Console;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class Normal1Test {
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
  public void normal1() throws InterruptedException {
    driver.get("https://uat-cms.vietnamnet.vn/");
    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    driver.manage().window().setSize(new Dimension(1936, 1048));
    driver.switchTo().frame(0);
    
    // Login
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.id("googlelogin")).click();
    vars.put("win4893", waitForWindow(2000));
    vars.put("root", driver.getWindowHandle());
    driver.switchTo().window(vars.get("win4893").toString());
    driver.findElement(By.id("identifierId")).sendKeys("autotestvms@gmail.com");
    driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
    driver.findElement(By.name("password")).sendKeys("vnn123456");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
//    driver.close();
    driver.switchTo().window(vars.get("root").toString());
    driver.findElement(By.id("otp_type")).click();
    {
      WebElement dropdown = driver.findElement(By.id("otp_type"));
      dropdown.findElement(By.xpath("//option[. = 'Email']")).click();
    }
    driver.findElement(By.cssSelector(".btn-primary")).click();
    System.out.println("Click otp input...");
    driver.findElement(By.name("otp")).click();
    //OTP number
    TimeUnit.SECONDS.sleep(15);
    
    System.out.println("Finished 15s");
    
    // driver.findElement(By.name("otp")).sendKeys("338944");
    
    //OTP number
    driver.findElement(By.cssSelector(".btn-info")).click();
//    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    TimeUnit.SECONDS.sleep(5);
    
    // Access to NormalContent from Menu
    driver.findElement(By.cssSelector(".svg-icon-danger > svg")).click();
    driver.findElement(By.cssSelector(".menu-item-submenu:nth-child(5) > .menu-link > .menu-text")).click();
    driver.findElement(By.cssSelector(".menu-item:nth-child(5) .menu-item:nth-child(2) .menu-text")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".menu-item:nth-child(5) .menu-item:nth-child(2) .menu-text"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    
    //Chọn nguồn tin Lấy lại
    driver.findElement(By.id("news.sourceId")).click();
    {
      WebElement dropdown = driver.findElement(By.id("news.sourceId"));
      dropdown.findElement(By.xpath("//option[@value = '4: 000002']")).click();
    }
    
    //Chọn loại tin bài
//    driver.findElement(By.id("select2-select2-331c7f6a-f66e-464f-961c-80127472fb52-container")).click();
    
    //Nhập title
    driver.findElement(By.name("news.title")).click();
    driver.findElement(By.name("news.title")).sendKeys("Bruno Fernandes được ví như Cantona");
    TimeUnit.SECONDS.sleep(3);
    //Nhập mô tả
    {
        WebElement element = driver.findElement(By.name("news.description"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).clickAndHold().perform();
      }
    driver.findElement(By.id("kt_content")).click();
//    driver.findElement(By.name("news.description")).click();
    driver.findElement(By.name("news.description")).sendKeys("Cựu tiền vệ Paul Ince cho rằng hậu bối Bruno Fernandes tạo ra tầm ảnh hưởng lớn với Man Utd, giống như Eric Cantona.");
    
    //Nhập avtar
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
    //Di chuột vào image và chọn
    {
        WebElement element = driver.findElement(By.cssSelector("div.ckf-file-desc"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".col-4:nth-child(1) .ckf-file-desc .btn > .btn")).click();
    driver.switchTo().frame(0);

    //Nhập nội dung
//    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
////    driver.findElement(By.cssSelector("html")).click();
//    {
//      WebElement element = driver.findElement(By.id("tinymce"));
//      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>\"Cantona gia nhập Man Utd và ngay lập tức gắn kết đội bóng\", Ince nói với Sky Sports. \"Anh ấy giống như mảnh ghép còn thiếu của Man Utd. Cantona kiến tạo nhiều bàn thắng, cải thiện năng lực của đồng đội. Điểm này Fernandes giống với Cantona\".Bruno Fernandes (phải) cùng là tiền vệ tấn công như Eric Cantona, và được kỳ vọng đưa Man Utd tới chức vô địch Ngoại hạng Anh sau nhiều năm.&nbsp;</p><p><br>\"Cantona có thể làm mọi thứ\", cựu tiền vệ tuyển Anh nói thêm. \"Ở các trận đấu chúng tôi cần bàn thắng, nhưng toàn đội bắt đầu lo lắng vì mọi thứ không đi đúng hướng, Cantona sẽ xuất hiện và ghi bàn quyết định. Fernandes cũng vậy, cậu ấy ghi những bàn rất quan trọng\".</p><p>Ince nói thêm về tiền vệ Bồ Đào Nha: \"Trong mùa đầu tiên, Fernandes hòa nhập thần tốc. Mùa này cậu ấy không còn ấn tượng như thế, nhưng vẫn là hạt nhân trong đội. Đôi khi Fernandes im tiếng suốt 25 phút, nhưng cậu ấy đủ khả năng tạo ra phép màu vào đúng thời điểm, dù là phạt đền, đường chuyền tuyệt vời hay đá phạt. Không đối thủ nào được phép chủ quan, với những phẩm chất của Fernandes. Các đồng đội đều yêu mến Fernandes, bởi cá tính của cậu ấy. Bóng đá đang thiếu đi những cá tính lớn, nhưng tôi thấy Fernandes có nó khi cậu ấy to tiếng với Victor Lindelof. Fernandes đòi hỏi nhiều từ đồng đội\".</p><p>Ince thi đấu cho Man Utd giai đoạn 1989-1995, còn Cantona cập bến Old Trafford năm 1992. Trong năm mùa ở Man Utd, Cantona ghi 82 bàn trong 185 trận, đoạt bốn Ngoại hạng Anh. Còn Fernandes đã ghi 27 bàn trong 46 trận cho Man Utd, trong đó 15 bàn tới từ phạt đền.</p>'}", element);
//    }
//    
    //Nhập nội dung, chèn ảnh ABC 
//    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//    driver.findElement(By.cssSelector("p")).click();
    driver.switchTo().frame(0);
    {
    	WebElement element = driver.findElement(By.id("tinymce"));
    	js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>TP Hà Nội quyết định bắn pháo hoa tại 30 quận, huyện trong đêm giao thừa Tết Quý Mão 2023, trong đó quận Hoàn Kiếm có 2 trận địa pháo tầm cao.<br>Ngày 19/12, tại buổi tiếp xúc cử tri quận Hoàn Kiếm, ông Nguyễn Ngọc Tuấn, Chủ tịch HĐND TP Hà Nội cho biết, Thường trực Thành ủy nhất trí với kế hoạch bắn pháo hoa tại 30 quận, huyện.</p><p>Ông Nguyễn Ngọc Tuấn cho biết, kinh phí tổ chức bắn pháo hoa trên địa bàn TP Hà Nội được huy động từ nguồn xã hội hóa.</p><p><br data-mce-bogus=\"1\"></p>'}", element);
    }
    driver.switchTo().defaultContent();
    TimeUnit.SECONDS.sleep(3);
    js.executeScript("window.scrollTo(0,700)");
    
//    WebElement iframeElement = driver.findElement(By.cssSelector(".tox-editor-header"));
//    driver.switchTo().frame(iframeElement);
//    new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tox-toolbar__group:nth-child(2) > .tox-tbtn:nth-child(1)")));
//    new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Chọn ảnh'][aria-label='Chọn ảnh']")));

    System.out.println("Sắp Click can giua...");
    TimeUnit.SECONDS.sleep(5);
    
    driver.findElement(By.cssSelector("button[title='Canh giữa'][aria-label='Canh giữa']")).click();
    
    System.out.println("Đã Click can giua");
       
    
    //new WebDriverWait(driver, Duration.ofSeconds(100000)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tox-toolbar__group:nth-child(2) > .tox-tbtn:nth-child(1)")));
//    js.executeScript("window.scrollTo(0,0)");
//    {
//        WebElement element = driver.findElement(By.cssSelector("div.ckf-file-desc"));
//        Actions builder = new Actions(driver);
//        builder.moveToElement(element).perform();
//    }
//    driver.findElement(By.cssSelector(".col-4:nth-child(1) .ckf-file-desc .btn > .btn")).click();

//    {
//      WebElement element = driver.findElement(By.id("tinymce"));
//      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>TP Hà Nội quyết định bắn pháo hoa tại 30 quận, huyện trong đêm giao thừa Tết Quý Mão 2023, trong đó quận Hoàn Kiếm có 2 trận địa pháo tầm cao.<br>Ngày 19/12, tại buổi tiếp xúc cử tri quận Hoàn Kiếm, ông Nguyễn Ngọc Tuấn, Chủ tịch HĐND TP Hà Nội cho biết, Thường trực Thành ủy nhất trí với kế hoạch bắn pháo hoa tại 30 quận, huyện.</p><p>Ông Nguyễn Ngọc Tuấn cho biết, kinh phí tổ chức bắn pháo hoa trên địa bàn TP Hà Nội được huy động từ nguồn xã hội hóa.</p><figure class=\"image vnn-content-image\" contenteditable=\"false\"><img src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/10/25/0009CB/-1157-1666191985.jpg\" data-mce-src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/10/25/0009CB/-1157-1666191985.jpg\"><figcaption contenteditable=\"true\"></figcaption></figure><div id=\"mceResizeHandlenw\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: nw-resize; margin: 0px; padding: 0px; left: 11px; top: 132.562px;\" style=\"cursor: nw-resize; margin: 0px; padding: 0px; left: 11px; top: 132.562px;\"></div><div id=\"mceResizeHandlene\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: ne-resize; margin: 0px; padding: 0px; left: 1244px; top: 132.562px;\" style=\"cursor: ne-resize; margin: 0px; padding: 0px; left: 1244px; top: 132.562px;\"></div><div id=\"mceResizeHandlese\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: se-resize; margin: 0px; padding: 0px; left: 1244px; top: 1021.86px;\" style=\"cursor: se-resize; margin: 0px; padding: 0px; left: 1244px; top: 1021.86px;\"></div><div id=\"mceResizeHandlesw\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: sw-resize; margin: 0px; padding: 0px; left: 11px; top: 1021.86px;\" style=\"cursor: sw-resize; margin: 0px; padding: 0px; left: 11px; top: 1021.86px;\"></div>'}", element);
//    }
//    driver.findElement(By.cssSelector("figcaption")).click();
//    {
//      WebElement element = driver.findElement(By.cssSelector("figcaption"));
//      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = 'ABC'}", element);
//    }
    
    //Move to image and choose in content
//    driver.switchTo().defaultContent();
//    driver.findElement(By.cssSelector(".tox-tbtn:nth-child(1) img")).click();
//    js.executeScript("window.scrollTo(0,0)");
//    {
//        WebElement element = driver.findElement(By.cssSelector("div.ckf-file-desc"));
//        Actions builder = new Actions(driver);
//        builder.moveToElement(element).perform();
//    }
//    driver.findElement(By.cssSelector(".col-4:nth-child(1) .ckf-file-desc .btn > .btn")).click();
//    driver.switchTo().frame(1);
//    js.executeScript("window.scrollTo(0,465)");
//    driver.switchTo().defaultContent();
//    js.executeScript("window.scrollTo(0,567)");
//    driver.switchTo().frame(1);
//    {
//      WebElement element = driver.findElement(By.id("tinymce"));
//      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>\"Cantona gia nhập Man Utd và ngay lập tức gắn kết đội bóng\", Ince nói với Sky Sports. \"Anh ấy giống như mảnh ghép còn thiếu của Man Utd. Cantona kiến tạo nhiều bàn thắng, cải thiện năng lực của đồng đội. Điểm này Fernandes giống với Cantona\".Bruno Fernandes (phải) cùng là tiền vệ tấn công như Eric Cantona, và được kỳ vọng đưa Man Utd tới chức vô địch Ngoại hạng Anh sau nhiều năm.&nbsp;</p><p><br>\"Cantona có thể làm mọi thứ\", cựu tiền vệ tuyển Anh nói thêm. \"Ở các trận đấu chúng tôi cần bàn thắng, nhưng toàn đội bắt đầu lo lắng vì mọi thứ không đi đúng hướng, Cantona sẽ xuất hiện và ghi bàn quyết định. Fernandes cũng vậy, cậu ấy ghi những bàn rất quan trọng\".</p><p>Ince nói thêm về tiền vệ Bồ Đào Nha: \"Trong mùa đầu tiên, Fernandes hòa nhập thần tốc. Mùa này cậu ấy không còn ấn tượng như thế, nhưng vẫn là hạt nhân trong đội. Đôi khi Fernandes im tiếng suốt 25 phút, nhưng cậu ấy đủ khả năng tạo ra phép màu vào đúng thời điểm, dù là phạt đền, đường chuyền tuyệt vời hay đá phạt. Không đối thủ nào được phép chủ quan, với những phẩm chất của Fernandes. Các đồng đội đều yêu mến Fernandes, bởi cá tính của cậu ấy. Bóng đá đang thiếu đi những cá tính lớn, nhưng tôi thấy Fernandes có nó khi cậu ấy to tiếng với Victor Lindelof. Fernandes đòi hỏi nhiều từ đồng đội\".</p><p>Ince thi đấu cho Man Utd giai đoạn 1989-1995, còn Cantona cập bến Old Trafford năm 1992. Trong năm mùa ở Man Utd, Cantona ghi 82 bàn trong 185 trận, đoạt bốn Ngoại hạng Anh. Còn Fernandes đã ghi 27 bàn trong 46 trận cho Man Utd, trong đó 15 bàn tới từ phạt đền.</p><figure class=\"image vnn-content-image\" contenteditable=\"false\" data-mce-selected=\"1\"><img src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/12/14/0009CB/neymar-celebrating-psg-vs-amiens-ligue-1-2019.jpg\" data-mce-src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/12/14/0009CB/neymar-celebrating-psg-vs-amiens-ligue-1-2019.jpg\"><figcaption contenteditable=\"true\"></figcaption></figure><div data-mce-bogus=\"all\" class=\"mce-offscreen-selection\" id=\"sel-mce_0\" style=\"top: 371.078px;\">&nbsp;<figure class=\"image vnn-content-image\" contenteditable=\"false\"><img src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/12/14/0009CB/neymar-celebrating-psg-vs-amiens-ligue-1-2019.jpg\" data-mce-src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/12/14/0009CB/neymar-celebrating-psg-vs-amiens-ligue-1-2019.jpg\"><figcaption contenteditable=\"true\"></figcaption></figure>&nbsp;</div><div id=\"mceResizeHandlenw\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: nw-resize; margin: 0px; padding: 0px; left: 11px; top: 366.078px;\" style=\"cursor: nw-resize; margin: 0px; padding: 0px; left: 11px; top: 366.078px;\"></div><div id=\"mceResizeHandlene\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: ne-resize; margin: 0px; padding: 0px; left: 1098px; top: 366.078px;\" style=\"cursor: ne-resize; margin: 0px; padding: 0px; left: 1098px; top: 366.078px;\"></div><div id=\"mceResizeHandlese\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: se-resize; margin: 0px; padding: 0px; left: 1098px; top: 1125.03px;\" style=\"cursor: se-resize; margin: 0px; padding: 0px; left: 1098px; top: 1125.03px;\"></div><div id=\"mceResizeHandlesw\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: sw-resize; margin: 0px; padding: 0px; left: 11px; top: 1125.03px;\" style=\"cursor: sw-resize; margin: 0px; padding: 0px; left: 11px; top: 1125.03px;\"></div>'}", element);
//    }
    
    //Nhập SEO
    js.executeScript("window.scrollTo(0,630)");
    driver.switchTo().defaultContent();
//    driver.findElement(By.name("news.seoOption.title")).click();
    driver.findElement(By.name("news.seoOption.title")).sendKeys("Bruno Fernandes được ví như Cantona");
//    driver.findElement(By.name("news.seoOption.description")).click();
    driver.findElement(By.name("news.seoOption.description")).sendKeys("Cựu tiền vệ Paul Ince cho rằng hậu bối Bruno Fernandes tạo ra tầm ảnh hưởng lớn với Man Utd, giống như Eric Cantona.");
//    driver.findElement(By.name("news.seoOption.keywords")).click();
    driver.findElement(By.name("news.seoOption.keywords")).sendKeys("Cựu tiền vệ Paul Ince cho rằng hậu bối Bruno Fernandes tạo ra tầm ảnh hưởng lớn với Man Utd, giống như Eric Cantona.");
 
    //Chọn chủ đề Tag    
    js.executeScript("window.scrollTo(0,1200)");
    driver.findElement(By.cssSelector(".ng-untouched:nth-child(3) .select2-search__field")).click();
    driver.findElement(By.cssSelector(".ng-untouched:nth-child(3) .select2-search__field")).sendKeys("Test Tag");
//    {
//        WebElement element = driver.findElement(By.cssSelector(".select2-results__options li"));
//        Actions builder = new Actions(driver);
//        builder.moveToElement(element).perform();
//    }
//    driver.findElement(By.cssSelector(".ng-untouched:nth-child(3) .select2-search__field")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector(".select2-results__option.select2-results__option--highlighted")).click();

    //Chọn tin liên quan
    driver.findElement(By.cssSelector("kt-button-icon:nth-child(2) .flaticon2-plus-1")).click();
//  js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(1) > .text-center > .switch span")).click();
    driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(2) > .text-center > .switch span")).click();
    driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(3) .switch span")).click();
    driver.findElement(By.cssSelector(".btn-shadow-hover")).click();
    
    //Chọn Category
    TimeUnit.SECONDS.sleep(3);
    driver.switchTo().defaultContent();
    js.executeScript("window.scrollTo(0,2000)");
    System.out.println("Đang chọn Category...");
    driver.findElement(By.xpath("//span[contains(text(),'Chọn mục chính')]")).click();
//    driver.findElement(By.cssSelector(".col-6.ng-star-inserted select2.ng-pristine.ng-untouched.ng-valid[_ngcontent-uca-c286='']")).click();
    driver.findElement(By.cssSelector(".select2-search--dropdown > .select2-search__field")).sendKeys("Cộng đồng");
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector(".select2-search--dropdown > .select2-search__field")).sendKeys(Keys.ENTER);
    System.out.println("Đã chọn Category...");
    //Save
    driver.findElement(By.cssSelector(".btn-success > .far")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".btn-success > .far"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
//    {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();
//    }
    //Publish
    {
      WebElement element = driver.findElement(By.cssSelector(".btn-light-success"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
//    {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();
//    }
    driver.findElement(By.cssSelector(".btn-light-success")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector(".btn-elevate:nth-child(2)")).click();
  }
}
