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
    
    //Ch???n ngu???n tin L???y l???i
    driver.findElement(By.id("news.sourceId")).click();
    {
      WebElement dropdown = driver.findElement(By.id("news.sourceId"));
      dropdown.findElement(By.xpath("//option[@value = '4: 000002']")).click();
    }
    
    //Ch???n lo???i tin b??i
//    driver.findElement(By.id("select2-select2-331c7f6a-f66e-464f-961c-80127472fb52-container")).click();
    
    //Nh???p title
    driver.findElement(By.name("news.title")).click();
    driver.findElement(By.name("news.title")).sendKeys("Bruno Fernandes ???????c v?? nh?? Cantona");
    TimeUnit.SECONDS.sleep(3);
    //Nh???p m?? t???
    {
        WebElement element = driver.findElement(By.name("news.description"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).clickAndHold().perform();
      }
    driver.findElement(By.id("kt_content")).click();
//    driver.findElement(By.name("news.description")).click();
    driver.findElement(By.name("news.description")).sendKeys("C???u ti???n v??? Paul Ince cho r???ng h???u b???i Bruno Fernandes t???o ra t???m ???nh h?????ng l???n v???i Man Utd, gi???ng nh?? Eric Cantona.");
    
    //Nh???p avtar
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
    //Di chu???t v??o image v?? ch???n
    {
        WebElement element = driver.findElement(By.cssSelector("div.ckf-file-desc"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".col-4:nth-child(1) .ckf-file-desc .btn > .btn")).click();
    driver.switchTo().frame(0);

    //Nh???p n???i dung
//    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
////    driver.findElement(By.cssSelector("html")).click();
//    {
//      WebElement element = driver.findElement(By.id("tinymce"));
//      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>\"Cantona gia nh???p Man Utd v?? ngay l???p t???c g???n k???t ?????i b??ng\", Ince n??i v???i Sky Sports. \"Anh ???y gi???ng nh?? m???nh gh??p c??n thi???u c???a Man Utd. Cantona ki???n t???o nhi???u b??n th???ng, c???i thi???n n??ng l???c c???a ?????ng ?????i. ??i???m n??y Fernandes gi???ng v???i Cantona\".Bruno Fernandes (ph???i) c??ng l?? ti???n v??? t???n c??ng nh?? Eric Cantona, v?? ???????c k??? v???ng ????a Man Utd t???i ch???c v?? ?????ch Ngo???i h???ng Anh sau nhi???u n??m.&nbsp;</p><p><br>\"Cantona c?? th??? l??m m???i th???\", c???u ti???n v??? tuy???n Anh n??i th??m. \"??? c??c tr???n ?????u ch??ng t??i c???n b??n th???ng, nh??ng to??n ?????i b???t ?????u lo l???ng v?? m???i th??? kh??ng ??i ????ng h?????ng, Cantona s??? xu???t hi???n v?? ghi b??n quy???t ?????nh. Fernandes c??ng v???y, c???u ???y ghi nh???ng b??n r???t quan tr???ng\".</p><p>Ince n??i th??m v??? ti???n v??? B??? ????o Nha: \"Trong m??a ?????u ti??n, Fernandes h??a nh???p th???n t???c. M??a n??y c???u ???y kh??ng c??n ???n t?????ng nh?? th???, nh??ng v???n l?? h???t nh??n trong ?????i. ????i khi Fernandes im ti???ng su???t 25 ph??t, nh??ng c???u ???y ????? kh??? n??ng t???o ra ph??p m??u v??o ????ng th???i ??i???m, d?? l?? ph???t ?????n, ???????ng chuy???n tuy???t v???i hay ???? ph???t. Kh??ng ?????i th??? n??o ???????c ph??p ch??? quan, v???i nh???ng ph???m ch???t c???a Fernandes. C??c ?????ng ?????i ?????u y??u m???n Fernandes, b???i c?? t??nh c???a c???u ???y. B??ng ???? ??ang thi???u ??i nh???ng c?? t??nh l???n, nh??ng t??i th???y Fernandes c?? n?? khi c???u ???y to ti???ng v???i Victor Lindelof. Fernandes ????i h???i nhi???u t??? ?????ng ?????i\".</p><p>Ince thi ?????u cho Man Utd giai ??o???n 1989-1995, c??n Cantona c???p b???n Old Trafford n??m 1992. Trong n??m m??a ??? Man Utd, Cantona ghi 82 b??n trong 185 tr???n, ??o???t b???n Ngo???i h???ng Anh. C??n Fernandes ???? ghi 27 b??n trong 46 tr???n cho Man Utd, trong ???? 15 b??n t???i t??? ph???t ?????n.</p>'}", element);
//    }
//    
    //Nh???p n???i dung, ch??n ???nh ABC 
//    driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
//    driver.findElement(By.cssSelector("p")).click();
    driver.switchTo().frame(0);
    {
    	WebElement element = driver.findElement(By.id("tinymce"));
    	js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>TP H?? N???i quy???t ?????nh b???n ph??o hoa t???i 30 qu???n, huy???n trong ????m giao th???a T???t Qu?? M??o 2023, trong ???? qu???n Ho??n Ki???m c?? 2 tr???n ?????a ph??o t???m cao.<br>Ng??y 19/12, t???i bu???i ti???p x??c c??? tri qu???n Ho??n Ki???m, ??ng Nguy???n Ng???c Tu???n, Ch??? t???ch H??ND TP H?? N???i cho bi???t, Th?????ng tr???c Th??nh ???y nh???t tr?? v???i k??? ho???ch b???n ph??o hoa t???i 30 qu???n, huy???n.</p><p>??ng Nguy???n Ng???c Tu???n cho bi???t, kinh ph?? t??? ch???c b???n ph??o hoa tr??n ?????a b??n TP H?? N???i ???????c huy ?????ng t??? ngu???n x?? h???i h??a.</p><p><br data-mce-bogus=\"1\"></p>'}", element);
    }
    driver.switchTo().defaultContent();
    TimeUnit.SECONDS.sleep(3);
    js.executeScript("window.scrollTo(0,700)");
    
//    WebElement iframeElement = driver.findElement(By.cssSelector(".tox-editor-header"));
//    driver.switchTo().frame(iframeElement);
//    new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tox-toolbar__group:nth-child(2) > .tox-tbtn:nth-child(1)")));
//    new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title='Ch???n ???nh'][aria-label='Ch???n ???nh']")));

    System.out.println("S???p Click can giua...");
    TimeUnit.SECONDS.sleep(5);
    
    driver.findElement(By.cssSelector("button[title='Canh gi???a'][aria-label='Canh gi???a']")).click();
    
    System.out.println("???? Click can giua");
       
    
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
//      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>TP H?? N???i quy???t ?????nh b???n ph??o hoa t???i 30 qu???n, huy???n trong ????m giao th???a T???t Qu?? M??o 2023, trong ???? qu???n Ho??n Ki???m c?? 2 tr???n ?????a ph??o t???m cao.<br>Ng??y 19/12, t???i bu???i ti???p x??c c??? tri qu???n Ho??n Ki???m, ??ng Nguy???n Ng???c Tu???n, Ch??? t???ch H??ND TP H?? N???i cho bi???t, Th?????ng tr???c Th??nh ???y nh???t tr?? v???i k??? ho???ch b???n ph??o hoa t???i 30 qu???n, huy???n.</p><p>??ng Nguy???n Ng???c Tu???n cho bi???t, kinh ph?? t??? ch???c b???n ph??o hoa tr??n ?????a b??n TP H?? N???i ???????c huy ?????ng t??? ngu???n x?? h???i h??a.</p><figure class=\"image vnn-content-image\" contenteditable=\"false\"><img src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/10/25/0009CB/-1157-1666191985.jpg\" data-mce-src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/10/25/0009CB/-1157-1666191985.jpg\"><figcaption contenteditable=\"true\"></figcaption></figure><div id=\"mceResizeHandlenw\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: nw-resize; margin: 0px; padding: 0px; left: 11px; top: 132.562px;\" style=\"cursor: nw-resize; margin: 0px; padding: 0px; left: 11px; top: 132.562px;\"></div><div id=\"mceResizeHandlene\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: ne-resize; margin: 0px; padding: 0px; left: 1244px; top: 132.562px;\" style=\"cursor: ne-resize; margin: 0px; padding: 0px; left: 1244px; top: 132.562px;\"></div><div id=\"mceResizeHandlese\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: se-resize; margin: 0px; padding: 0px; left: 1244px; top: 1021.86px;\" style=\"cursor: se-resize; margin: 0px; padding: 0px; left: 1244px; top: 1021.86px;\"></div><div id=\"mceResizeHandlesw\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: sw-resize; margin: 0px; padding: 0px; left: 11px; top: 1021.86px;\" style=\"cursor: sw-resize; margin: 0px; padding: 0px; left: 11px; top: 1021.86px;\"></div>'}", element);
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
//      js.executeScript("if(arguments[0].contentEditable === 'true') {arguments[0].innerText = '<p>\"Cantona gia nh???p Man Utd v?? ngay l???p t???c g???n k???t ?????i b??ng\", Ince n??i v???i Sky Sports. \"Anh ???y gi???ng nh?? m???nh gh??p c??n thi???u c???a Man Utd. Cantona ki???n t???o nhi???u b??n th???ng, c???i thi???n n??ng l???c c???a ?????ng ?????i. ??i???m n??y Fernandes gi???ng v???i Cantona\".Bruno Fernandes (ph???i) c??ng l?? ti???n v??? t???n c??ng nh?? Eric Cantona, v?? ???????c k??? v???ng ????a Man Utd t???i ch???c v?? ?????ch Ngo???i h???ng Anh sau nhi???u n??m.&nbsp;</p><p><br>\"Cantona c?? th??? l??m m???i th???\", c???u ti???n v??? tuy???n Anh n??i th??m. \"??? c??c tr???n ?????u ch??ng t??i c???n b??n th???ng, nh??ng to??n ?????i b???t ?????u lo l???ng v?? m???i th??? kh??ng ??i ????ng h?????ng, Cantona s??? xu???t hi???n v?? ghi b??n quy???t ?????nh. Fernandes c??ng v???y, c???u ???y ghi nh???ng b??n r???t quan tr???ng\".</p><p>Ince n??i th??m v??? ti???n v??? B??? ????o Nha: \"Trong m??a ?????u ti??n, Fernandes h??a nh???p th???n t???c. M??a n??y c???u ???y kh??ng c??n ???n t?????ng nh?? th???, nh??ng v???n l?? h???t nh??n trong ?????i. ????i khi Fernandes im ti???ng su???t 25 ph??t, nh??ng c???u ???y ????? kh??? n??ng t???o ra ph??p m??u v??o ????ng th???i ??i???m, d?? l?? ph???t ?????n, ???????ng chuy???n tuy???t v???i hay ???? ph???t. Kh??ng ?????i th??? n??o ???????c ph??p ch??? quan, v???i nh???ng ph???m ch???t c???a Fernandes. C??c ?????ng ?????i ?????u y??u m???n Fernandes, b???i c?? t??nh c???a c???u ???y. B??ng ???? ??ang thi???u ??i nh???ng c?? t??nh l???n, nh??ng t??i th???y Fernandes c?? n?? khi c???u ???y to ti???ng v???i Victor Lindelof. Fernandes ????i h???i nhi???u t??? ?????ng ?????i\".</p><p>Ince thi ?????u cho Man Utd giai ??o???n 1989-1995, c??n Cantona c???p b???n Old Trafford n??m 1992. Trong n??m m??a ??? Man Utd, Cantona ghi 82 b??n trong 185 tr???n, ??o???t b???n Ngo???i h???ng Anh. C??n Fernandes ???? ghi 27 b??n trong 46 tr???n cho Man Utd, trong ???? 15 b??n t???i t??? ph???t ?????n.</p><figure class=\"image vnn-content-image\" contenteditable=\"false\" data-mce-selected=\"1\"><img src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/12/14/0009CB/neymar-celebrating-psg-vs-amiens-ligue-1-2019.jpg\" data-mce-src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/12/14/0009CB/neymar-celebrating-psg-vs-amiens-ligue-1-2019.jpg\"><figcaption contenteditable=\"true\"></figcaption></figure><div data-mce-bogus=\"all\" class=\"mce-offscreen-selection\" id=\"sel-mce_0\" style=\"top: 371.078px;\">&nbsp;<figure class=\"image vnn-content-image\" contenteditable=\"false\"><img src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/12/14/0009CB/neymar-celebrating-psg-vs-amiens-ligue-1-2019.jpg\" data-mce-src=\"https://uat-cms-files.vietnamnet.vn/cdn-files/images/2022/12/14/0009CB/neymar-celebrating-psg-vs-amiens-ligue-1-2019.jpg\"><figcaption contenteditable=\"true\"></figcaption></figure>&nbsp;</div><div id=\"mceResizeHandlenw\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: nw-resize; margin: 0px; padding: 0px; left: 11px; top: 366.078px;\" style=\"cursor: nw-resize; margin: 0px; padding: 0px; left: 11px; top: 366.078px;\"></div><div id=\"mceResizeHandlene\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: ne-resize; margin: 0px; padding: 0px; left: 1098px; top: 366.078px;\" style=\"cursor: ne-resize; margin: 0px; padding: 0px; left: 1098px; top: 366.078px;\"></div><div id=\"mceResizeHandlese\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: se-resize; margin: 0px; padding: 0px; left: 1098px; top: 1125.03px;\" style=\"cursor: se-resize; margin: 0px; padding: 0px; left: 1098px; top: 1125.03px;\"></div><div id=\"mceResizeHandlesw\" data-mce-bogus=\"all\" class=\"mce-resizehandle\" unselectable=\"true\" data-mce-style=\"cursor: sw-resize; margin: 0px; padding: 0px; left: 11px; top: 1125.03px;\" style=\"cursor: sw-resize; margin: 0px; padding: 0px; left: 11px; top: 1125.03px;\"></div>'}", element);
//    }
    
    //Nh???p SEO
    js.executeScript("window.scrollTo(0,630)");
    driver.switchTo().defaultContent();
//    driver.findElement(By.name("news.seoOption.title")).click();
    driver.findElement(By.name("news.seoOption.title")).sendKeys("Bruno Fernandes ???????c v?? nh?? Cantona");
//    driver.findElement(By.name("news.seoOption.description")).click();
    driver.findElement(By.name("news.seoOption.description")).sendKeys("C???u ti???n v??? Paul Ince cho r???ng h???u b???i Bruno Fernandes t???o ra t???m ???nh h?????ng l???n v???i Man Utd, gi???ng nh?? Eric Cantona.");
//    driver.findElement(By.name("news.seoOption.keywords")).click();
    driver.findElement(By.name("news.seoOption.keywords")).sendKeys("C???u ti???n v??? Paul Ince cho r???ng h???u b???i Bruno Fernandes t???o ra t???m ???nh h?????ng l???n v???i Man Utd, gi???ng nh?? Eric Cantona.");
 
    //Ch???n ch??? ????? Tag    
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

    //Ch???n tin li??n quan
    driver.findElement(By.cssSelector("kt-button-icon:nth-child(2) .flaticon2-plus-1")).click();
//  js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(1) > .text-center > .switch span")).click();
    driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(2) > .text-center > .switch span")).click();
    driver.findElement(By.cssSelector(".ng-star-inserted:nth-child(3) .switch span")).click();
    driver.findElement(By.cssSelector(".btn-shadow-hover")).click();
    
    //Ch???n Category
    TimeUnit.SECONDS.sleep(3);
    driver.switchTo().defaultContent();
    js.executeScript("window.scrollTo(0,2000)");
    System.out.println("??ang ch???n Category...");
    driver.findElement(By.xpath("//span[contains(text(),'Ch???n m???c ch??nh')]")).click();
//    driver.findElement(By.cssSelector(".col-6.ng-star-inserted select2.ng-pristine.ng-untouched.ng-valid[_ngcontent-uca-c286='']")).click();
    driver.findElement(By.cssSelector(".select2-search--dropdown > .select2-search__field")).sendKeys("C???ng ?????ng");
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector(".select2-search--dropdown > .select2-search__field")).sendKeys(Keys.ENTER);
    System.out.println("???? ch???n Category...");
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
