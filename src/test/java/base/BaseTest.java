package base;

import org.aston.common.CommonAction;
import org.aston.pages.WildberriesBasketPage;
import org.aston.pages.WildberriesHomePage;
import org.aston.pages.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected WildberriesHomePage wildberriesHomePage = new WildberriesHomePage(driver);
    protected WildberriesBasketPage wildberriesBasketPage = new WildberriesBasketPage(driver);


    @BeforeClass
    public void beforeClass(){
        driver.manage().deleteAllCookies();
        basePage.open("https://www.wildberries.ru/");
    }

    @AfterClass
    public void afterClass() {
       driver.quit();
    }
}
