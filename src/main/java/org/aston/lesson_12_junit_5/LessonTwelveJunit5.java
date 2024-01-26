package org.aston.lesson_12_junit_5;

public class LessonTwelveJunit5 {

    public static int getFactorialNumber(int num){
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i;
        }
        return result;
    }
}
