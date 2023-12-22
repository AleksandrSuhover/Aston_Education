package org.aston.lesson_3;

import java.lang.reflect.Array;
import java.util.Arrays;

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

    public static Boolean checkLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int[] createAndEditArray(){
        int[] arrayOneAndTwo = new int[10];
        for(int i = 0; i < arrayOneAndTwo.length; i++){
            arrayOneAndTwo[i] = (int)Math.round(Math.random());
        }
        System.out.println(Arrays.toString(arrayOneAndTwo));

        for(int i = 0; i < arrayOneAndTwo.length; i++){
            arrayOneAndTwo[i] = arrayOneAndTwo[i] == 0 ? 1 : 0;
        }
        return arrayOneAndTwo;
    }

    public static void createArrayWithOneHundredValues(){
        int[] arrayOneHundred = new int[100];
        int value = 1;
        for (int i = 0; i < arrayOneHundred.length; i++){
            arrayOneHundred[i] = value;
            value++;
        }
        System.out.println(Arrays.toString(arrayOneHundred));
    }

    public static void multiplyNumbersInArray(int [] arrayNumbers){
        for(int i = 0; i < arrayNumbers.length; i++){
            if(arrayNumbers[i] < 6){
                arrayNumbers[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrayNumbers));
    }

    public static void createDoubleArrayWithDiagonals(){
        int[][] squareArray = new int[8][8];
        int arrayLength = squareArray.length;

        for(int i = 0; i < squareArray.length; i++){
            --arrayLength;
            squareArray[i][i] = 1;
            squareArray[i][arrayLength] = 1;
            System.out.println(Arrays.toString(squareArray[i]));
        }
    }

    public static int[] createArrayWithDynamicLength(int len, int initialValue){
        int[] dynamicArray = new int[len];
        Arrays.fill(dynamicArray, initialValue);
        return dynamicArray;
    }
}
