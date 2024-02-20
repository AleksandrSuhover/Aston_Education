package org.aston.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainAppCalcPage extends BasePage{
    private static String commonIdNumerics = "com.google.android.calculator:id/digit_";
    private static String commonIdOperations = "com.google.android.calculator:id/";
    private static Map<String, String> operationsIdsMap = Map.of("+", "op_add",
                                                              "-", "op_sub",
                                                              "*", "op_mul",
                                                              "/", "op_div");

    public MainAppCalcPage(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public String getFinalResult(){
        driver.findElementById(commonIdOperations + "eq").click();
        return driver.findElementById(commonIdOperations + "result_final").getText();
    }

    public MainAppCalcPage clickSelectedOperation(String operationSymbol){
        driver.findElementById(commonIdOperations + operationsIdsMap.get(operationSymbol)).click();
        return this;
    }

    public MainAppCalcPage enterSpecifiedNumber(String numbers){
        char[] numbersList = numbers.toCharArray();
        for(char num : numbersList){
            driver.findElementById(commonIdNumerics + num).click();
        }
        return this;
    }
}
