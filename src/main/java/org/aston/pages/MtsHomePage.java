package org.aston.pages;

import org.aston.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static org.aston.common.Config.AMOUNT_PAYMENT;
import static org.aston.common.Config.PHONE_NUMBER;

public class MtsHomePage extends BasePage {

    public MtsHomePage(WebDriver driver) {
        super(driver);
    }

    private By btnCookieAgree = By.id("cookie-agree");
    private By inputPhoneNumber = By.id("connection-phone");
    private By inputReplenishmentAmount = By.id("connection-sum");
    private By btnContinue = By.xpath("//div[@class='pay__wrapper']//button[contains(text(), 'Продолжить')]");
    private By onlinePaymentFrame = By.xpath("//iframe[@class='bepaid-iframe']");
    private By headerPaymentFrameInfo = By.xpath("//p[@class='header__payment-info']");
    private By headerPaymentFrameAmount = By.xpath("//p[@class='header__payment-amount']");
    private By buttonPayFrame = By.xpath("//div[@class=\"card-page__card\"]//button[contains(text(), 'Оплатить')]");
    private Map<Object, Object> inputsFrameMap = Map.of("cardNumber", By.xpath("//div[@class='content ng-tns-c47-1']"),
                                                    "validityPeriodFrame", By.xpath("//div[@class='content ng-tns-c47-4']"),
                                                    "cvcFrame", By.xpath("//div[@class='content ng-tns-c47-5']"),
                                                    "ownerNameFrame", By.xpath("//div[@class='content ng-tns-c47-3']"));

    public void acceptCookies(){
        driver.findElement(btnCookieAgree).click();
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

    public String getInputFrameTextByName(String inputName){
        return driver.findElement((By) inputsFrameMap.get(inputName)).getText();
    }

    public boolean isDisplayedIconFrameBySrc(String srcIcon){
        return waitElementIsVisible(driver.findElement(By.xpath("//img[contains(@src,'" + srcIcon +"')]"))).isDisplayed();
    }

}
