package org.aston.pages;

import org.aston.pages.base.BasePage;
import org.aston.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.aston.common.Config.QUANTITY_PRODUCT;

public class WildberriesHomePage extends BasePage {

    private List<String> namesSelectedProductsList = new ArrayList<>();
    private List<Double> priceSelectedProductsList = new ArrayList<>();
    private List<WebElement> buttonsAddToBasketProductsList = new ArrayList<>();

    public WildberriesHomePage(WebDriver driver) {
        super(driver);
    }

    private String buttonSelectedProductXpath = "//article[%s]//a[contains(@class, 'product-card__add-basket')]";
    private String nameSelectedProductXpath = "//article[%s]//span[@class='product-card__name']";
    private String priceSelectedProductXpath ="//article[%s]//ins[contains(@class, 'price__lower-price')]";
    private By selectedSizeProductWindow = By.xpath("//div[@class='popup__content']/ul/li");
    private By buttonBasket = By.xpath("//span[contains(@class,'navbar-pc__icon--basket')]");

    public WildberriesHomePage getProductOnHomePage(){
            for (int i = 1; i <= QUANTITY_PRODUCT; i++){
                namesSelectedProductsList.add(waitElementIsVisible(driver.findElement(By.xpath(String.format(nameSelectedProductXpath, i))))
                                                                                        .getText()
                                                                                        .split("/")[1].trim());
                priceSelectedProductsList.add(StringUtils.returnValidPrice(waitElementIsVisible(driver.findElement(By.xpath(String.format(priceSelectedProductXpath, i))))
                                                                                                      .getText()));
                buttonsAddToBasketProductsList.add(waitElementIsVisible(driver.findElement(By.xpath(String.format(buttonSelectedProductXpath, i)))));
        }
        return this;
    }

    public WildberriesHomePage addProductsToBasket() {
        if (!buttonsAddToBasketProductsList.isEmpty()) {
            for (WebElement addButton : buttonsAddToBasketProductsList) {
                addButton.click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                if(!driver.findElements(selectedSizeProductWindow).isEmpty()){
                    driver.findElement(selectedSizeProductWindow).click();
                }
            }
        }
        return this;
    }

    public WildberriesBasketPage clickOnButtonBasket(){
        driver.findElement(buttonBasket).click();
        return new WildberriesBasketPage(driver);
    }

    public int getQuantityAllProducts(){
        return namesSelectedProductsList.size();
    }

    public double getTotalPriceProducts(){
        return Math.ceil((priceSelectedProductsList.stream()
                                                   .mapToDouble(Double::doubleValue)
                                                   .sum())/97*100);
    }

    public double getPriceProductByIndex(int index){
        return Math.ceil((priceSelectedProductsList.get(index))/97*100);

    }

    public String getNameProductByIndex(int index){
        return namesSelectedProductsList.get(index);
    }

}
