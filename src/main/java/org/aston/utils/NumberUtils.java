package org.aston.utils;

public class NumberUtils {
    public static Boolean isSumBetweenRange(int firstNum, int secondNum, int lowerRange, int upperRange){
        int sumNumbers = firstNum + secondNum;
        return sumNumbers >= lowerRange && sumNumbers <= upperRange;
    }

    public static void isPositive(int number){
        System.out.println(!isNegative(number)
                ? "Переданное число положительное."
                : "Переданное число отрицательное.");
    }

    public static Boolean isNegative(int number){
        return number < 0;
    }

    public static double getRandomDoubleNumber(double lowerRange, double upperRange){
        upperRange -= lowerRange;
        return (Math.random() * ++upperRange) + lowerRange;
    }

    public static int getRandomIntNumber(double lowerRange, double upperRange){
        upperRange -= lowerRange;
        return (int) ((Math.random() * ++upperRange) + lowerRange);
    }
}
