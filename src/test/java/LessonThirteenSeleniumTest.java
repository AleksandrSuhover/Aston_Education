import io.github.bonigarcia.wdm.WebDriverManager;
import org.aston.utils.StringUtils;
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
    public void beforeSuite(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement btnAgreeCookie = driver.findElement(By.id("cookie-agree"));
        btnAgreeCookie.click();
    }

    @AfterSuite
    public void afterSuite(){
        driver.quit();
    }

    @Test(priority = 1, testName = "Проверка заголовка онлайн пополнения")
    public static void testCheckPayWrapperHeader(){
        WebElement payWrapperHeader = driver.findElement(By.xpath("//div[@class='pay__wrapper']//h2"));

        Assert.assertEquals(StringUtils.deleteSpacesAndLineBreak(payWrapperHeader.getText()), "Онлайн пополнение без комиссии");
    }

    @Test(priority = 1, testName = "Проверка наличия баннеров партнеров")
    public static void testCheckPartnersBanner(){
        List<WebElement> partnersElements = driver.findElements(By.xpath("//div[@class='pay__partners']//li"));

        Assert.assertEquals(partnersElements.size(), 6);
        for(WebElement partner : partnersElements){
            Assert.assertTrue(partner.isDisplayed());
        }
    }

    @Test(priority = 2, testName = "Проверка работоспособности ссылки 'Подробнее о сервисе'")
    public static void testCheckLinkInPayWrapper(){
        WebElement linksWrapper = driver.findElement(By.xpath("//div[@class='pay__wrapper']//a"));

        linksWrapper.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
        driver.get("https://www.mts.by/");
    }

    @Test(priority = 3, testName = "Проверка работоспособности формы пополнения счёта")
    public static void testReplenishmentAccount(){
        WebElement inputPhoneNumber = driver.findElement(By.id("connection-phone"));
        WebElement inputReplenishmentAmount = driver.findElement(By.id("connection-sum"));
        WebElement btnContinue = driver.findElement(By.xpath("//div[@class='pay__wrapper']//button[contains(text(), 'Продолжить')]"));

        inputPhoneNumber.click();
        inputPhoneNumber.sendKeys("297777777");

        inputReplenishmentAmount.click();
        inputReplenishmentAmount.sendKeys("100");

        Assert.assertTrue(btnContinue.isEnabled());
        btnContinue.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        WebElement testBtn = driver.findElement(By.xpath("//p[@class='header__payment-info']"));

        Assert.assertEquals("Оплата: Услуги связи Номер:375297777777", StringUtils.deleteSpacesAndLineBreak(testBtn.getAttribute("textContent")));
    }
}
