package testMtsSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LessonFourTeenTestngTest extends BaseTest {

    @Test(testName = "Проверка незаполненных полей формы 'Услуги связи'")
    public void testFieldsCommunicationServiceForm(){
        WebElement inputPhoneNumber = getDriver().findElement(By.id("connection-phone"));
        WebElement inputReplenishmentAmount = getDriver().findElement(By.id("connection-sum"));
        WebElement inputEmail = getDriver().findElement(By.id("connection-email"));

        Assert.assertEquals(inputPhoneNumber.getAttribute("placeholder"), "Номер телефона");
        Assert.assertEquals(inputReplenishmentAmount.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(inputEmail.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test(testName = "Проверка незаполненных полей формы 'Домашний интернет'")
    public void testFieldsHomeInternetForm(){
        WebElement inputInternetSubscriberNumber = getDriver().findElement(By.id("internet-phone"));
        WebElement inputReplenishmentAmount = getDriver().findElement(By.id("internet-sum"));
        WebElement inputEmail = getDriver().findElement(By.id("internet-email"));

        Assert.assertEquals(inputInternetSubscriberNumber.getAttribute("placeholder"), "Номер абонента");
        Assert.assertEquals(inputReplenishmentAmount.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(inputEmail.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test(testName = "Проверка незаполненных полей формы 'Рассрочка'")
    public void testFieldsInstallmentPlanForm(){
        WebElement inputAccountNumber = getDriver().findElement(By.id("score-instalment"));
        WebElement inputReplenishmentAmount = getDriver().findElement(By.id("instalment-sum"));
        WebElement inputEmail = getDriver().findElement(By.id("instalment-email"));

        Assert.assertEquals(inputAccountNumber.getAttribute("placeholder"), "Номер счета на 44");
        Assert.assertEquals(inputReplenishmentAmount.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(inputEmail.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test(testName = "Проверка незаполненных полей формы 'Задолженность'")
    public void testFieldsArrearsForm(){
        WebElement inputAccountNumber = getDriver().findElement(By.id("score-arrears"));
        WebElement inputReplenishmentAmount = getDriver().findElement(By.id("arrears-sum"));
        WebElement inputEmail = getDriver().findElement(By.id("arrears-email"));

        Assert.assertEquals(inputAccountNumber.getAttribute("placeholder"), "Номер счета на 2073");
        Assert.assertEquals(inputReplenishmentAmount.getAttribute("placeholder"), "Сумма");
        Assert.assertEquals(inputEmail.getAttribute("placeholder"), "E-mail для отправки чека");
    }

    @Test(testName = "Проверка полей фрейма 'Оплата: Услуги связи")
    public void testFieldsFramePaymentCommunicationService(){
        WebElement inputPhoneNumber = getDriver().findElement(By.id("connection-phone"));
        WebElement inputReplenishmentAmount = getDriver().findElement(By.id("connection-sum"));
        WebElement btnContinue = getDriver().findElement(By.xpath("//div[@class='pay__wrapper']//button[contains(text(), 'Продолжить')]"));

        inputPhoneNumber.click();
        inputPhoneNumber.sendKeys("297777777");
        inputReplenishmentAmount.click();
        inputReplenishmentAmount.sendKeys("100");
        btnContinue.click();

        getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        WebElement headerAmountFrame = getDriver().findElement(By.xpath("//p[@class='header__payment-amount']"));
        WebElement buttonPayFrame = getDriver().findElement(By.xpath("//button[@class='colored disabled ng-star-inserted']"));

        System.out.println(headerAmountFrame.getAttribute("textContent"));
        System.out.println(buttonPayFrame.getAttribute("textContent"));

    }
}
