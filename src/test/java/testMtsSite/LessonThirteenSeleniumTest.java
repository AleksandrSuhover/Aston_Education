package testMtsSite;

import org.aston.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class LessonThirteenSeleniumTest extends BaseTest {

    @Test(priority = 1, testName = "Проверка заголовка онлайн пополнения")
    @Parameters("headerPayWindow")
    public void testCheckPayWrapperHeader(@Optional("Онлайн пополнение без комиссии") String headerPayWindow){
        WebElement payWrapperHeader = getDriver().findElement(By.xpath("//div[@class='pay__wrapper']//h2"));

        Assert.assertEquals(StringUtils.deleteSpacesAndLineBreak(payWrapperHeader.getText()), headerPayWindow);
    }

    @Test(priority = 1, testName = "Проверка наличия баннеров партнеров")
    @Parameters("quantityBannersPartners")
    public void testCheckPartnersBanner(@Optional("6") int quantityBannersPartners){
        List<WebElement> partnersElements = getDriver().findElements(By.xpath("//div[@class='pay__partners']//li"));

        Assert.assertEquals(partnersElements.size(), quantityBannersPartners);
        for(WebElement partner : partnersElements){
            Assert.assertTrue(partner.isDisplayed());
        }
    }

    @Test(priority = 2, testName = "Проверка работоспособности ссылки 'Подробнее о сервисе'")
    @Parameters("urlInfoService")
    public void testCheckLinkInPayWrapper(@Optional String urlInfoService){
        WebElement linksWrapper = getDriver().findElement(By.xpath("//div[@class='pay__wrapper']//a"));

        linksWrapper.click();
        Assert.assertEquals(getDriver().getCurrentUrl(), urlInfoService);
        getDriver().get("https://www.mts.by/");
    }

    @Test(priority = 3, testName = "Проверка работоспособности формы пополнения счёта")
    @Parameters({"phoneNumber", "amountOfPayment"})
    public void testReplenishmentAccount(@Optional("297777777") String phoneNumber, @Optional("10") String amountOfPayment){
        WebElement inputPhoneNumber = getDriver().findElement(By.id("connection-phone"));
        WebElement inputReplenishmentAmount = getDriver().findElement(By.id("connection-sum"));
        WebElement btnContinue = getDriver().findElement(By.xpath("//div[@class='pay__wrapper']//button[contains(text(), 'Продолжить')]"));

        inputPhoneNumber.click();
        inputPhoneNumber.sendKeys(phoneNumber);

        inputReplenishmentAmount.click();
        inputReplenishmentAmount.sendKeys(amountOfPayment);

        Assert.assertTrue(btnContinue.isEnabled());
        btnContinue.click();

        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        WebElement headerFrame = getDriver().findElement(By.xpath("//p[@class='header__payment-info']"));

        Assert.assertEquals("Оплата: Услуги связи Номер:375" + phoneNumber, StringUtils.deleteSpacesAndLineBreak(headerFrame.getAttribute("textContent")));
    }
}
