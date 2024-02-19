package org.aston.pages;


public class MainPage extends BasePage {
    private static final String idDigitLocator = "com.google.android.calculator:id/digit_";
    private static final String idOperationLocator = "com.google.android.calculator:id/";

    public MainPage enterExpression(String expression) {
        String[] expr = expression.split(" ");
        for (int i = 0; i < expr.length; i++) {
            if (i % 2 == 0) driver.findElementById(idDigitLocator + expr[i]).click();
            else clickOperation(expr[i]);
        }
        return this;
    }

    public String getResult() {
        driver.findElementById(idOperationLocator + "eq").click();
        return driver.findElementById(idOperationLocator + "result_final").getText();
    }

    private void clickOperation(String operation) {
        switch (operation) {
            case "+":
                driver.findElementById(idOperationLocator + "op_add").click();
                break;
            case "-":
                driver.findElementById(idOperationLocator + "op_sub").click();
                break;
            case "*":
                driver.findElementById(idOperationLocator + "op_mul").click();
                break;
            case "/":
                driver.findElementById(idOperationLocator + "op_div").click();
                break;
        }
    }
}