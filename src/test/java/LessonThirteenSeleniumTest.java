import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LessonThirteenSeleniumTest {
    static WebDriver driver;

    @BeforeSuite
    public void BeforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement btnAgreeCookie = driver.findElement(By.id("cookie-agree"));
        btnAgreeCookie.click();
    }

    @AfterSuite
    public void AfterTest(){
        driver.quit();
    }

    @Test
    public static void testCheckPayWrapperHeader(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement payWrapperHeader = driver.findElement(By.xpath("//div[@class='pay__wrapper']//h2"));
        String headerWindow =  payWrapperHeader.getText().replaceAll("\n", " ");
        Assert.assertEquals(headerWindow, "Онлайн пополнение без комиссии");
    }

    @Test
    public static void testCheckPartnersBanner(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> partnersElements = driver.findElements(By.xpath("//div[@class='pay__partners']//li"));

        Assert.assertEquals(partnersElements.size(), 6);
        for(WebElement partner : partnersElements){
            Assert.assertTrue(partner.isDisplayed());
        }
    }

//    @Test
//    public static void testCheckLinkInPayWrapper(){
//        List<WebElement> linksWrapper = driver.findElements(By.xpath("//div[@class='pay__wrapper']//a"));
//        for(WebElement link : linksWrapper){
//            String urlLink = link.getAttribute("href");
//
//        }
//    }

    @Test
    public static void testCheckLinkInPayWrapper(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement linksWrapper = driver.findElement(By.xpath("//div[@class='pay__wrapper']//a"));
        linksWrapper.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");

    }
}