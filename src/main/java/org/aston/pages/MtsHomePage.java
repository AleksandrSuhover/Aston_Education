package org.aston.pages;

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
    By btnClosePaymentFrame = By.xpath("//svg-icon[@class='header__close-icon']");

    public void acceptCookies(){
        driver.findElement(btnCookieAgree).click();
    }

    public String getPayWrapperHeaderText(){
        return driver.findElement(payWrapperHeader).getText();
    }

    public MtsHomePage clickLinksMoreAboutService(){
        driver.findElement(linksMoreAboutService).click();
        return this;
    }

    public boolean isDisplayedIconByBannerName(String bannerName){
       return driver.findElement(By.cssSelector("img[alt='" + bannerName + "']")).isDisplayed();
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
        return waitElementIsVisible(driver.findElement(headerPaymentFrameInfo)).getText();
    }

    public MtsHomePage closePaymentFrame(){
        waitElementIsVisible(driver.findElement(btnClosePaymentFrame)).click();
        return this;
    }
}
