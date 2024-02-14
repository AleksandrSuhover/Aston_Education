package testMtsSite;

import base.BaseTest;
import org.aston.utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        Assert.assertEquals(mtsHomePage.getPlaceholderWebElementById(firstInputId), firstPlaceholderValue);
        Assert.assertEquals(mtsHomePage.getPlaceholderWebElementById(secondInputId), secondPlaceholderValue);
        Assert.assertEquals(mtsHomePage.getPlaceholderWebElementById(thirtyInputId), thirtyPlaceholderValue);
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
        Assert.assertEquals(mtsHomePage.getInputFrameTextByName("cardNumber"), "Номер карты");
        Assert.assertEquals(mtsHomePage.getInputFrameTextByName("validityPeriodFrame"), "Срок действия");
        Assert.assertEquals(mtsHomePage.getInputFrameTextByName("cvcFrame"), "CVC");
        Assert.assertEquals(mtsHomePage.getInputFrameTextByName("ownerNameFrame"), "Имя держателя (как на карте)");
    }

    @Test(testName = "Проверка иконок партнёров внутри фрейма 'Оплата: Услуги связи'")
    public void testIconsPartnersInFramePayment(){
        mtsHomePage
                .enterPhoneNumber()
                .enterPaymentAmount()
                .clickContinueBtn()
                .switchOnPaymentFrame();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(mtsHomePage.isDisplayedIconFrameBySrc("mastercard"), "Логотип Mastercard не отображается");
        softAssert.assertTrue(mtsHomePage.isDisplayedIconFrameBySrc("visa"), "Логотип Visa не отображается");
        softAssert.assertTrue(mtsHomePage.isDisplayedIconFrameBySrc("belkart"), "Логотип Belkart не отображается");
        softAssert.assertTrue(mtsHomePage.isDisplayedIconFrameBySrc("mir"), "Логотип Mir не отображается");
        softAssert.assertTrue(mtsHomePage.isDisplayedIconFrameBySrc("maestro"), "Логотип Maestro не отображается");
        softAssert.assertAll();
    }
}
