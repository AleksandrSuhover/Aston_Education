import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LessonThirteenSeleniumTest {

    @Test
    public static void testMethod(){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement btnAgreeCookie = driver.findElement(By.id("cookie-agree"));
        btnAgreeCookie.click();
        WebElement payWrapper = driver.findElement(By.xpath("//div[@class=\"pay__wrapper\"]"));
        WebElement headerWindowElement = payWrapper.findElement(By.xpath("h2"));
        String headerWindow =  headerWindowElement.getText().replaceAll("\n", " ");

        Assert.assertEquals(headerWindow, "Онлайн пополнение без комиссии");


        WebElement partnersPay = payWrapper.findElement(By.xpath("div[@class='pay__partners']"));
        System.out.println(partnersPay.findElements(By.tagName("li")).size());


        driver.quit();


    }
}
