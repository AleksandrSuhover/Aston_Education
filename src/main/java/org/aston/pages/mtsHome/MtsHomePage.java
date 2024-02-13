package org.aston.pages.mtsHome;

import org.aston.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.aston.common.Config.AMOUNT_PAYMENT;
import static org.aston.common.Config.PHONE_NUMBER;

public class MtsHomePage extends BasePage {

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    By btnCookieAgree = By.id("cookie-agree");
    By payWrapperHeader = By.xpath("//div[@class='pay__wrapper']//h2");
    By linksMoreAboutService = By.xpath("//div[@class='pay__wrapper']//a");
    By inputPhoneNumber = By.id("connection-phone");
    By inputReplenishmentAmount = By.id("connection-sum");
    By btnContinue = By.xpath("//div[@class='pay__wrapper']//button[contains(text(), 'Продолжить')]");
    By onlinePaymentFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    By headerPaymentFrameInfo = By.xpath("//p[@class='header__payment-info']");
    By headerPaymentFrameAmount = By.xpath("//p[@class='header__payment-amount']");
    By buttonPayFrame = By.xpath("//div[@class=\"card-page__card\"]//button[contains(text(), 'Оплатить')]");
    By inputCardNumberFrame = By.xpath("//div[@class='content ng-tns-c47-1']");
    By inputValidityPeriodFrame = By.xpath("//div[@class='content ng-tns-c47-4']");
    By inputCVCFrame = By.xpath("//div[@class='content ng-tns-c47-5']");
    By inputOwnerNameFrame = By.xpath("//div[@class='content ng-tns-c47-3']");


    public void acceptCookies(){
        driver.findElement(btnCookieAgree).click();
    }

    public String getPayWrapperHeader(){
        return driver.findElement(payWrapperHeader).getText();
    }

    public MtsHomePage clickLinksMoreAboutService(){
        driver.findElement(linksMoreAboutService).click();
        return this;
    }

    public MtsHomePage enterPhoneNumber(){
        WebElement inputPhoneDriver = driver.findElement(inputPhoneNumber);
        inputPhoneDriver.click();
        inputPhoneDriver.sendKeys(PHONE_NUMBER);
        return this;
    }

    public MtsHomePage enterPaymentAmount(){
        WebElement inputAmount = driver.findElement(inputReplenishmentAmount);
        inputAmount.click();
        inputAmount.sendKeys(AMOUNT_PAYMENT);
        return this;
    }

    public MtsHomePage clickContinueBtn(){
        driver.findElement(btnContinue).click();
        return this;
    }

    public MtsHomePage switchOnPaymentFrame(){
        waitElementIsVisible(driver.findElement(onlinePaymentFrame));
        driver.switchTo().frame(driver.findElement(onlinePaymentFrame));
        return this;
    }

    public String getPaymentFrameHeaderInfo(){
        waitElementIsVisible(driver.findElement(headerPaymentFrameInfo));
        return driver.findElement(headerPaymentFrameInfo).getText();
    }

    public String getPaymentFrameHeaderAmount(){
        waitElementIsVisible(driver.findElement(headerPaymentFrameAmount));
        return driver.findElement(headerPaymentFrameAmount).getText();
    }

    public String getButtonPayFrameText(){
        return driver.findElement(buttonPayFrame).getText();
    }

    public String getInputCardNumberFrameText(){
        return driver.findElement(inputCardNumberFrame).getText();
    }

    public String getInputValidityPeriodFrameText(){
        return driver.findElement(inputValidityPeriodFrame).getText();
    }

    public String getInputCVCFrameText(){
        return driver.findElement(inputCVCFrame).getText();
    }

    public String getInputOwnerNameFrame(){
        return driver.findElement(inputOwnerNameFrame).getText();
    }

}
