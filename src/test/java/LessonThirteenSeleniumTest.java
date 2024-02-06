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

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement btnAgreeCookie = driver.findElement(By.id("cookie-agree"));
        btnAgreeCookie.click();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test(priority = 1, testName = "Проверка заголовка онлайн пополнения")
    @Parameters("headerPayWindow")
    public static void testCheckPayWrapperHeader(@Optional("Онлайн пополнение без комиссии") String headerPayWindow){
        WebElement payWrapperHeader = driver.findElement(By.xpath("//div[@class='pay__wrapper']//h2"));

        Assert.assertEquals(StringUtils.deleteSpacesAndLineBreak(payWrapperHeader.getText()), headerPayWindow);
    }

    @Test(priority = 1, testName = "Проверка наличия баннеров партнеров")
    @Parameters("quantityBannersPartners")
    public static void testCheckPartnersBanner(@Optional("6") int quantityBannersPartners){
        List<WebElement> partnersElements = driver.findElements(By.xpath("//div[@class='pay__partners']//li"));

        Assert.assertEquals(partnersElements.size(), quantityBannersPartners);
        for(WebElement partner : partnersElements){
            Assert.assertTrue(partner.isDisplayed());
        }
    }

    @Test(priority = 2, testName = "Проверка работоспособности ссылки 'Подробнее о сервисе'")
    @Parameters("urlInfoService")
    public static void testCheckLinkInPayWrapper(@Optional String urlInfoService){
        WebElement linksWrapper = driver.findElement(By.xpath("//div[@class='pay__wrapper']//a"));

        linksWrapper.click();
        Assert.assertEquals(driver.getCurrentUrl(), urlInfoService);
        driver.get("https://www.mts.by/");
    }

    @Test(priority = 3, testName = "Проверка работоспособности формы пополнения счёта")
    @Parameters({"phoneNumber", "amountOfPayment"})
    public static void testReplenishmentAccount(@Optional("297777777") String phoneNumber, @Optional("10") String amountOfPayment){
        WebElement inputPhoneNumber = driver.findElement(By.id("connection-phone"));
        WebElement inputReplenishmentAmount = driver.findElement(By.id("connection-sum"));
        WebElement btnContinue = driver.findElement(By.xpath("//div[@class='pay__wrapper']//button[contains(text(), 'Продолжить')]"));

        inputPhoneNumber.click();
        inputPhoneNumber.sendKeys(phoneNumber);

        inputReplenishmentAmount.click();
        inputReplenishmentAmount.sendKeys(amountOfPayment);

        Assert.assertTrue(btnContinue.isEnabled());
        btnContinue.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        WebElement headerFrame = driver.findElement(By.xpath("//p[@class='header__payment-info']"));

        Assert.assertEquals("Оплата: Услуги связи Номер:375" + phoneNumber, StringUtils.deleteSpacesAndLineBreak(headerFrame.getAttribute("textContent")));
    }
}
