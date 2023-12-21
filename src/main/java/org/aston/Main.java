package org.aston;

import static org.aston.lesson_2.LessonTwo.*;
import static org.aston.lesson_3.LessonThree.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkNumbersForRange(4, 17));
        checkNumberForPositivity(-5);
        System.out.println(checkNumberForNegativity(0));
        printTextInConsole("Hello world!", 2);
        checkLeapYear(8);
    }
}