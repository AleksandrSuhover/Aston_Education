package testWildberriesSite;

import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LessonFiveTeenTestngTest extends BaseTest {
    private final int FIRST_PRODUCT_INDEX = 0;
    private final int SECOND_PRODUCT_INDEX = 1;
    private final int THIRD_PRODUCT_INDEX = 2;

    @Test
    public void addProductToBasketTest(){
        wildberriesHomePage.getProductOnHomePage()
                         .addProductsToBasket()
                         .clickOnButtonBasket();
        wildberriesBasketPage.wait(5000)
                           .getAttributesProductsFromBasket();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(wildberriesHomePage.getTotalPriceProducts(),
                                wildberriesBasketPage.getTotalPriceFromBasket(),
                        "Different total price");
        softAssert.assertEquals(wildberriesHomePage.getQuantityAllProducts(),
                                wildberriesBasketPage.getQuantityAllProductsInBasket(),
                        "Different quantity products");

        softAssert.assertEquals(wildberriesHomePage.getPriceProductByIndex(FIRST_PRODUCT_INDEX),
                                wildberriesBasketPage.getPriceProductFromBasketByIndex(FIRST_PRODUCT_INDEX),
                        "Different price value in first product");
        softAssert.assertEquals(wildberriesHomePage.getPriceProductByIndex(SECOND_PRODUCT_INDEX),
                                wildberriesBasketPage.getPriceProductFromBasketByIndex(SECOND_PRODUCT_INDEX),
                        "Different price value in second product");
        softAssert.assertEquals(wildberriesHomePage.getPriceProductByIndex(THIRD_PRODUCT_INDEX),
                                wildberriesBasketPage.getPriceProductFromBasketByIndex(THIRD_PRODUCT_INDEX),
                        "Different price value in third product");

        softAssert.assertEquals(wildberriesHomePage.getNameProductByIndex(FIRST_PRODUCT_INDEX),
                                wildberriesBasketPage.getNameProductFromBasketByIndex(FIRST_PRODUCT_INDEX),
                        "Different name value in first product");
        softAssert.assertEquals(wildberriesHomePage.getNameProductByIndex(SECOND_PRODUCT_INDEX),
                                wildberriesBasketPage.getNameProductFromBasketByIndex(SECOND_PRODUCT_INDEX),
                        "Different name value in second product");
        softAssert.assertEquals(wildberriesHomePage.getNameProductByIndex(THIRD_PRODUCT_INDEX),
                                wildberriesBasketPage.getNameProductFromBasketByIndex(THIRD_PRODUCT_INDEX),
                        "Different name value in third product");
        softAssert.assertAll();
    }
}
