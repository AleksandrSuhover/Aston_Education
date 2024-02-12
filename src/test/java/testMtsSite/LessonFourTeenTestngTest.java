package testMtsSite;

import org.aston.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LessonFourTeenTestngTest extends BaseTest {
    private static final String PHONE_NUMBER_TEST = "297777777";
    private static final String AMOUNT_PAYMENT_TEST = "100.00";


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
        Assert.assertEquals(getDriver().findElement(By.id(firstInputId)).getAttribute("placeholder"), firstPlaceholderValue);
        Assert.assertEquals(getDriver().findElement(By.id(secondInputId)).getAttribute("placeholder"), secondPlaceholderValue);
        Assert.assertEquals(getDriver().findElement(By.id(thirtyInputId)).getAttribute("placeholder"), thirtyPlaceholderValue);
    }


    @Test(testName = "Проверка полей фрейма 'Оплата: Услуги связи'")
    public void testFieldsFramePaymentCommunicationService(){
        WebElement inputPhoneNumber = getDriver().findElement(By.id("connection-phone"));
        WebElement inputReplenishmentAmount = getDriver().findElement(By.id("connection-sum"));
        WebElement btnContinue = getDriver().findElement(By.xpath("//div[@class='pay__wrapper']//button[contains(text(), 'Продолжить')]"));

        inputPhoneNumber.click();
        inputPhoneNumber.sendKeys(PHONE_NUMBER_TEST);
        inputReplenishmentAmount.click();
        inputReplenishmentAmount.sendKeys(AMOUNT_PAYMENT_TEST);
        btnContinue.click();

        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        WebDriverWait waitWebDriver = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        WebElement headerAmountFrame = getDriver().findElement(By.xpath("//p[@class='header__payment-amount']"));
        WebElement buttonPayFrame = getDriver().findElement(By.xpath("//button[@class='colored disabled ng-star-inserted']"));
        WebElement headerPaymentPhoneNumberFrame = getDriver().findElement(By.xpath("//p[@class='header__payment-info']"));
        WebElement inputCardNumberFrame = getDriver().findElement(By.xpath("//div[@class='content ng-tns-c47-1']"));
        WebElement inputValidityPeriodFrame = getDriver().findElement(By.xpath("//div[@class='content ng-tns-c47-4']"));
        WebElement inputCVCFrame = getDriver().findElement(By.xpath("//div[@class='content ng-tns-c47-5']"));
        WebElement inputOwnerNameFrame = getDriver().findElement(By.xpath("//div[@class='content ng-tns-c47-3']"));
        List<WebElement> iconsPartnersInputFrame = waitWebDriver.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='cc-number']/../following-sibling::div/.//img")));

        Assert.assertEquals(StringUtils.returnOnlyAmountPayValue(headerAmountFrame.getAttribute("textContent")), AMOUNT_PAYMENT_TEST);
        Assert.assertEquals(StringUtils.returnOnlyAmountPayValue(buttonPayFrame.getAttribute("textContent")), AMOUNT_PAYMENT_TEST);
        Assert.assertEquals(StringUtils.returnOnlyAmountPayValue(headerPaymentPhoneNumberFrame.getAttribute("textContent")), "375" + PHONE_NUMBER_TEST);
        Assert.assertEquals(inputCardNumberFrame.getAttribute("textContent"), "Номер карты");
        Assert.assertEquals(inputValidityPeriodFrame.getAttribute("textContent"), "Срок действия");
        Assert.assertEquals(inputCVCFrame.getAttribute("textContent"), "CVC");
        Assert.assertEquals(inputOwnerNameFrame.getAttribute("textContent"), "Имя держателя (как на карте)");
        Assert.assertEquals(iconsPartnersInputFrame.size(), 5);
        for(WebElement iconsPartners : iconsPartnersInputFrame){
           Assert.assertTrue(iconsPartners.isDisplayed());
        }
    }
}
