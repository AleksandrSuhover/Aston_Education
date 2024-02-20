import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import org.aston.common.CommonAction;
import org.aston.pages.MainAppCalcPage;
import org.testng.annotations.AfterClass;


public class BaseTest {
    protected AndroidDriver<AndroidElement> driver = CommonAction.createAndroidDriver();
    protected MainAppCalcPage mainAppCalcPage = new MainAppCalcPage(driver);

    @AfterClass
    public static void teardown() {
        CommonAction.quitDriver();
    }

}