package testMtsSite;

import base.BaseTest;
import org.aston.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.aston.common.Config.AMOUNT_PAYMENT;
import static org.aston.common.Config.PHONE_NUMBER;

public class LessonFourTeenTestngTest extends BaseTest {

    @DataProvider(name = "payFormsOnline")
    public Object[][] payFormsOnline() {
        return new String[][]
                {{"Номер телефона", "Сумма", "E-mail для отправки чека", "connection-phone", "connection-sum", "connection-email"},
                {"Номер абонента", "Сумма", "E-mail для отправки чека", "internet-phone", "internet-sum", "internet-email"},
                {"Номер счета на 44", "Сумма", "E-mail для отправки чека", "score-instalment", "instalment-sum", "instalment-email"},
                {"Номер счета на 2073", "Сумма", "E-mail для отправки чека", "score-arrears", "arrears-sum", "arrears-email"}};
    }

    @Test(dataProvider = "payFormsOnline",testName = "Проверка текста незаполненных полей формы оплаты услуг по ID")
    public void testInputPlaceholdersPaymentFormById(String firstPlaceholderValue, String secondPlaceholderValue, String thirtyPlaceholderValue,
                                                     String firstInputId, String secondInputId, String thirtyInputId)
    {
        Assert.assertEquals(mtsHomePage.getWebElementById(firstInputId).getAttribute("placeholder"), firstPlaceholderValue);
        Assert.assertEquals(mtsHomePage.getWebElementById(secondInputId).getAttribute("placeholder"), secondPlaceholderValue);
        Assert.assertEquals(mtsHomePage.getWebElementById(thirtyInputId).getAttribute("placeholder"), thirtyPlaceholderValue);
    }


    @Test(testName = "Проверка полей фрейма 'Оплата: Услуги связи'")
    public void testFieldsFramePaymentCommunicationService(){
        mtsHomePage
                .enterPhoneNumber()
                .enterPaymentAmount()
                .clickContinueBtn()
                .switchOnPaymentFrame();

        Assert.assertEquals(StringUtils.returnOnlyAmountPayValue(mtsHomePage.getPaymentFrameHeaderAmount()), AMOUNT_PAYMENT);
        Assert.assertEquals(StringUtils.returnOnlyAmountPayValue(mtsHomePage.getButtonPayFrameText()), AMOUNT_PAYMENT);
        Assert.assertEquals(StringUtils.returnOnlyAmountPayValue(mtsHomePage.getPaymentFrameHeaderInfo()), "375" + PHONE_NUMBER);
        Assert.assertEquals(mtsHomePage.getInputCardNumberFrameText(), "Номер карты");
        Assert.assertEquals(mtsHomePage.getInputValidityPeriodFrameText(), "Срок действия");
        Assert.assertEquals(mtsHomePage.getInputCVCFrameText(), "CVC");
        Assert.assertEquals(mtsHomePage.getInputOwnerNameFrame(), "Имя держателя (как на карте)");
    }

    @DataProvider(name = "iconsPartnersFrame")
    public Object[][] iconsPartnersFrame() {
        return new String[][] {{"mastercard"}, {"visa"}, {"belkart"}, {"mir"}, {"maestro"}};
    }

    @Test(testName = "Проверка иконок партнёров внутри фрейма 'Оплата: Услуги связи'", dataProvider = "iconsPartnersFrame")
    public void testIconsPartnersInFramePayment(String srcIcon){
        if(srcIcon == "mastercard"){
            mtsHomePage
                    .enterPhoneNumber()
                    .enterPaymentAmount()
                    .clickContinueBtn()
                    .switchOnPaymentFrame();
        }
        WebElement iconPartner = mtsHomePage.waitElementIsVisible(driver.findElement(By.xpath("//img[contains(@src,'" + srcIcon + "-system')]")));
        Assert.assertTrue(iconPartner.isDisplayed());
    }
}
