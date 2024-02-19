import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.aston.pages.DriverInstance;
import org.aston.pages.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static AndroidDriver<AndroidElement> driver;
    protected MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

    @BeforeClass
    public static void setup() {
        driver = DriverInstance.getDriver();
    }

    @AfterClass
    public static void teardown() {
        DriverInstance.quit();
    }
}