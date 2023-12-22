package org.aston;

import java.util.Arrays;

//import static org.aston.lesson_2.LessonTwo.*;
import static org.aston.lesson_3.LessonThree.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkNumbersForRange(4, 17));
        checkNumberForPositivity(-5);
        System.out.println(checkNumberForNegativity(0));
        printTextInConsole("Hello world!", 2);
        System.out.println(Arrays.toString(createAndEditArray()));
        System.out.println(checkLeapYear(400));
        createArrayWithOneHundredValues();
        multiplyNumbersInArray(new int[]{ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 });
        createDoubleArrayWithDiagonals();
        System.out.println(Arrays.toString(createArrayWithDynamicLength(4, 5)));
    }
}