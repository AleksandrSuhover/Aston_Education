package org.aston.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayUtils {

    public static int[] createArrayOfZerosAndOnes(int lengthArray){
        if(lengthArray <= 0) return new int[0];

        int[] arrayOfZerosAndOnes = new int[lengthArray];
        for(int i = 0; i < arrayOfZerosAndOnes.length; i++){
            arrayOfZerosAndOnes[i] = (int)Math.round(Math.random());
        }

        for(int i = 0; i < arrayOfZerosAndOnes.length; i++){
            arrayOfZerosAndOnes[i] = arrayOfZerosAndOnes[i] == 0 ? 1 : 0;
        }
        return arrayOfZerosAndOnes;
    }

    public static int[] createArrayWithConsecutiveValues(int lengthArray){
        if(lengthArray <= 0) return new int[0];

        int[] resultArray = new int[lengthArray];
        for (int i = 0; i < resultArray.length; i++){
            resultArray[i] = i + 1;
        }
        return resultArray;
    }

    public static int[] multiplyNumbersInArrayLessThreshold(int [] arrayNumbers, int threshold, int multiply){
        for(int i = 0; i < arrayNumbers.length; i++){
            if(arrayNumbers[i] < threshold){
                arrayNumbers[i] *= multiply;
            }
        }
       return arrayNumbers;
    }

    public static int[][] createDoubleArrayWithDiagonals(int lengthArray){
        if(lengthArray <= 0) return new int[0][0];

        int[][] squareArray = new int[lengthArray][lengthArray];

        for(int i = 0; i < squareArray.length; i++) {
            --lengthArray;
            squareArray[i][i] = 1;
            squareArray[i][lengthArray] = 1;
        }
        return squareArray;
    }

    public static int[] createArrayWithDynamicLength(int len, int initialValue){
        int[] dynamicArray = new int[len];
        Arrays.fill(dynamicArray, initialValue);
        return dynamicArray;
    }

    public static String[][] createDoubleArrayStringWithNumbers(int upperArrayLength, int nestedArrayLength){
        String[][] arrayString = new String[upperArrayLength][nestedArrayLength];
        for (int i = 0; i < arrayString.length; i++) {
            for (int j = 0; j < arrayString[i].length; j++) {
                arrayString[i][j] = String.valueOf(j);
            }
        }
        return arrayString;
    }

    public static ArrayList<String> createArrayStringWithDuplicates(int quantityValue, int repeatValue){
        if(quantityValue <= 0) return new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < quantityValue; i++){
            result.add("TestString" + i);
            if(i < repeatValue) result.add("TestString" + i);
        }
        return result;
    }

}
