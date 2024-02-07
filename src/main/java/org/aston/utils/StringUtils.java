package org.aston.utils;

public class StringUtils {

    public static void printTextInConsoleSpecifiedNumber(String textToPrint, int quantity){
        while (quantity > 0){
            System.out.println(textToPrint);
            --quantity;
        }
    }

    public static String createRandomPhoneNumber(){
        return "+" + NumberUtils.getRandomIntNumber(900000000, 100000000);
    }

    public static String deleteSpacesAndLineBreak(String stringValue){
        return stringValue.replaceAll("\n", " ").trim();
    }
}
