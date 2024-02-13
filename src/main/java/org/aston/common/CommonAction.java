package org.aston.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.aston.common.Config.IMPLICIT_WAIT;
import static org.aston.common.Config.PLATFORM_AND_BROWSER;

public class CommonAction {
    private static WebDriver driver = null;

    private CommonAction(){}

    public static WebDriver createDriver(){
        if(driver == null){
            switch (PLATFORM_AND_BROWSER){
                case "win_chrome":
                    driver = new ChromeDriver();
                    break;
                case "win_firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Некорректное имя браузера или платформы");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        }
        return driver;
    }

}
