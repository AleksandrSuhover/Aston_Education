package org.aston;

import org.aston.lesson_7.LessonSeven;
import org.aston.lesson_7.MyArrayDataException;
import org.aston.lesson_7.MyArraySizeException;
import org.aston.utils.ArrayUtils;

public class Main {
    public static void main(String[] args) {
        String[][] arrayString = ArrayUtils.createDoubleArrayStringWithNumbers(4, 4);

        try {
            System.out.println(LessonSeven.executeLesson7(arrayString, 5));
        } catch (MyArraySizeException | MyArrayDataException exception) {
            System.out.println(exception.getMessage());
        }

        arrayString[1][3] = "s";
        try {
            System.out.println(LessonSeven.executeLesson7(arrayString, 4));
        } catch (MyArrayDataException | MyArraySizeException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
    }
}