import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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
        WebElement payWrapperHeader = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]//h2"));
        String headerWindow =  payWrapperHeader.getText().replaceAll("\n", " ");
        Assert.assertEquals(headerWindow, "Онлайн пополнение без комиссии");
    }

//    @Test
//    public static void testMethodTwo(){
//              WebElement partnersPay = payWrapper.findElement(By.xpath("div[@class='pay__partners']"));
//        System.out.println(partnersPay.findElements(By.tagName("li")).size());
//    }
}
