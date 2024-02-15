package org.aston.pages;

import org.aston.pages.base.BasePage;
import org.aston.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WildberriesBasketPage extends BasePage {
    private List<String> namesProductsFromBasketList = new ArrayList<>();
    private List<Double> pricesProductsFromBasketList = new ArrayList<>();

    public WildberriesBasketPage(WebDriver driver) {
        super(driver);
    }

    private By totalPriceProducts = By.xpath("//p[@class=\"b-top__total line\"]//span[2]");
    private By namesProductBasketXpath = By.xpath("//span[@class='good-info__good-name']");
    private By pricesProductBasketXpath = By.xpath("//div[@class='list-item__price-new']");

    public WildberriesBasketPage getAttributesProductsFromBasket(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        List<WebElement> namesProducts = driver.findElements(namesProductBasketXpath);
        List<WebElement> pricesProducts = driver.findElements(pricesProductBasketXpath);
        for(int i = namesProducts.size() - 1; i >= 0; i--){
            namesProductsFromBasketList.add(namesProducts.get(i).getText().replace(".","").trim());
            pricesProductsFromBasketList.add(StringUtils.returnValidPrice(pricesProducts.get(i).getText()));
        }
        return this;
    }

    public Double getTotalPriceFromBasket(){
        return StringUtils.returnValidPrice(waitElementIsVisible(driver.findElement(totalPriceProducts)).getText());
    }

    public Double getPriceProductFromBasketByIndex(int index){
        return pricesProductsFromBasketList.get(index);
    }

    public String getNameProductFromBasketByIndex(int index){
        return namesProductsFromBasketList.get(index);
    }

    public int getQuantityAllProductsInBasket(){
        return pricesProductsFromBasketList.size();
    }

    public WildberriesBasketPage wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

}
