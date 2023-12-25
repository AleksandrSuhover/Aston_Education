package org.aston.utils;

public class StringUtils {

    public static void printTextInConsoleSpecifiedNumber(String textToPrint, int quantity){
        while (quantity > 0){
            System.out.println(textToPrint);
            --quantity;
        }
    }
}
