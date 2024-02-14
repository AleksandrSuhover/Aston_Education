package base;

import org.aston.common.CommonAction;
import org.aston.pages.base.BasePage;
import org.aston.pages.MtsHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MtsHomePage mtsHomePage = new MtsHomePage(driver);

    @BeforeClass
    public void beforeClass(){
        driver.manage().deleteAllCookies();
        basePage.open("https://mts.by");
        mtsHomePage.acceptCookies();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
