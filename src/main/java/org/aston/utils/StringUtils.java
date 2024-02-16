package org.aston.utils;

public class StringUtils {

    public static String deleteSpacesAndLineBreak(String stringValue){
        return stringValue.replaceAll("\n/", " ").trim();
    }

    public static String returnOnlyAmountPayValue(String stringValue){
        return stringValue.replaceAll("[a-zA-Zа-яА-Я\\\\n:₽ /]*", "").trim();
    }

    public static Double returnValidPrice(String price){
        return Double.valueOf(price.replaceAll("[a-zA-Zа-яА-Я ₽]*", "").trim());
    }
}
