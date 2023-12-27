package org.aston.lesson_3;

import org.aston.utils.NumberUtils;
import org.aston.utils.StringUtils;
import org.aston.utils.DateUtils;
import org.aston.utils.ArrayUtils;

import java.util.Arrays;

public class LessonThree {

    public static void executeLesson3(){
        System.out.println(NumberUtils.isSumBetweenRange(5, 3, 10, 20));
        NumberUtils.isPositive(6);
        System.out.println(NumberUtils.isNegative(-5));
        StringUtils.printTextInConsoleSpecifiedNumber("Hello World", -5);
        System.out.println(DateUtils.isLeapYear(2100));
        System.out.println(Arrays.toString(ArrayUtils.createArrayOfZerosAndOnes(7)));
        System.out.println(Arrays.toString(ArrayUtils.createArrayWithConsecutiveValues(100)));
        System.out.println(Arrays.toString(ArrayUtils.multiplyNumbersInArrayLessThreshold(new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}, 6, 2)));
        ArrayUtils.createDoubleArrayWithDiagonals(8);
        System.out.println(Arrays.toString(ArrayUtils.createArrayWithDynamicLength(6, 5)));
    }
}
