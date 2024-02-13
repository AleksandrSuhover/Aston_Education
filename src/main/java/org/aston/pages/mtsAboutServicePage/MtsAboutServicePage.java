package org.aston.pages.mtsAboutServicePage;

import org.aston.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MtsAboutServicePage extends BasePage {

    public MtsAboutServicePage(WebDriver driver) {
        super(driver);
    }

    By headerAboutServicePage = By.xpath("//div[@class=\"container-fluid\"]//h3[1]");

    public String getMainHeader(){
        waitElementIsVisible(driver.findElement(headerAboutServicePage));
        return driver.findElement(headerAboutServicePage).getText();
    }
}
