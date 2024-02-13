package base;

import org.aston.common.CommonAction;
import org.aston.pages.base.BasePage;
import org.aston.pages.mtsAboutServicePage.MtsAboutServicePage;
import org.aston.pages.mtsHome.MtsHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected MtsHomePage mtsHomePage = new MtsHomePage(driver);
    protected MtsAboutServicePage mtsAboutServicePage = new MtsAboutServicePage(driver);

    @BeforeSuite
    public void beforeMethod(){
        driver.manage().deleteAllCookies();
        basePage.open("https://mts.by");
        mtsHomePage.acceptCookies();
    }

    @AfterSuite
    public void afterMethod() {
        driver.quit();
    }
}
