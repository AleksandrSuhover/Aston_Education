package org.aston.lesson_3;

public class LessonThree {
    public static Boolean checkNumbersForRange(int firstNum, int secondNum){
        int sumNumbers = firstNum + secondNum;
        return sumNumbers >= 10 && sumNumbers <= 20;
    }

    public static void checkNumberForPositivity(int number){
        System.out.println(number >= 0 ? "Переданное число положительное."
                                       : "Переданное число отрицательное.");
    }

    public static Boolean checkNumberForNegativity(int number){
        return number < 0;
    }

    public static void printTextInConsole(String textToPrint, int quantity){
        while (quantity > 0){
            System.out.println(textToPrint);
            --quantity;
        }
    }

    public static void checkLeapYear(int year){
        System.out.println(year % 4);
    }
}
