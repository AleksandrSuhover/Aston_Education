package testMtsSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public static final long IMPLICITLY_WAIT = 5;
    public static final long PAGE_LOAD_TIMEOUT = 5;
    public static final long SCRIPT_RUN_TIMEOUT = 5;

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    protected void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_RUN_TIMEOUT));
        driver.get("https://www.mts.by/");
        WebElement btnAgreeCookie = driver.findElement(By.id("cookie-agree"));
        btnAgreeCookie.click();
    }

    @AfterClass
    protected void afterMethod() {
        driver.quit();
    }
}

