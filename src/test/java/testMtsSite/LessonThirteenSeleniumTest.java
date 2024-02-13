package testMtsSite;

import base.BaseTest;
import org.aston.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.aston.common.Config.PHONE_NUMBER;

public class LessonThirteenSeleniumTest extends BaseTest {

    @Test(priority = 1, testName = "Проверка заголовка онлайн пополнения")
    public void testCheckPayWrapperHeader(){
       Assert.assertEquals(StringUtils.deleteSpacesAndLineBreak(mtsHomePage.getPayWrapperHeader()), "Онлайн пополнение без комиссии");
    }

    @DataProvider(name = "partnersBannersName")
    public static Object[] paymentSystemsData() {
        return new Object[] {"Visa", "Verified By Visa",  "MasterCard", "MasterCard Secure Code", "МИР", "Белкарт"};
    }

    @Test(priority = 1, testName = "Проверка наличия баннеров партнеров", dataProvider = "partnersBannersName")
    public void testCheckPartnersBanner(String bannerName){
        WebElement banner = driver.findElement(By.cssSelector("img[alt='" + bannerName + "']"));
        Assert.assertTrue(banner.isDisplayed());
    }


    @Test(priority = 2, testName = "Проверка работоспособности ссылки 'Подробнее о сервисе'")
    public void testCheckLinkInPayWrapper() {
        mtsHomePage.clickLinksMoreAboutService();
        Assert.assertEquals(mtsAboutServicePage.getMainHeader(), "Оплата банковской картой");
    }

    @Test(priority = 3, testName = "Проверка работоспособности формы пополнения счёта")
    public void testReplenishmentAccount(){
        mtsHomePage
                .enterPhoneNumber()
                .enterPaymentAmount()
                .clickContinueBtn()
                .switchOnPaymentFrame();
        Assert.assertEquals("Оплата: Услуги связи Номер:375" + PHONE_NUMBER, StringUtils.deleteSpacesAndLineBreak(mtsHomePage.getPaymentFrameHeaderInfo()));
    }
}
