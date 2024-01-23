package org.aston.utils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public static ArrayList<Integer> createArrayWithRandomNumbers(int lengthArray, int minValue, int maxValue){
        if(lengthArray <= 0) return new ArrayList<>();

        ArrayList<Integer> arrayNumbers = new ArrayList<>();
        for (int i = 0; i < lengthArray; i++){
            arrayNumbers.add(minValue + (int) (Math.random() * (maxValue - minValue + 1)));
        }
        return arrayNumbers;
    }

    public static ArrayList<Integer> getOnlyValidNumbersFromArray(ArrayList<Integer> arrayNumbers, Predicate<Integer> func){
        if (arrayNumbers.size() == 0) return new ArrayList<>();

        return (ArrayList<Integer>) arrayNumbers.stream()
                                                .filter(func)
                                                .collect(Collectors.toList());
    }

    public static long getCountSearchValueInList(List<String> stringArrayList, String searchValue){
        return stringArrayList.stream().filter(el -> Objects.equals(el, searchValue)).count();
    }

    public static String getFirstValueInListString(List<String> list){
        return list.isEmpty() ? "0" : list.get(0);
    }

    public static String getLastValueInListString(List<String> list){
        return list.isEmpty() ? "0" : list.get(list.size() - 1);
    }

    public static String[] sortSpecificListString(List<String> list) {
        return list.stream()
                   .sorted(Comparator.comparingInt(value -> Integer.parseInt(value.substring(1))))
                   .toArray(String[]::new);
    }
}
