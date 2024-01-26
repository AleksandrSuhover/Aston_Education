package org.aston;

import org.aston.lesson_12_junit_5.LessonTwelveJunit5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class LessonTwelveJunit5Test {

    @DisplayName("Вычисление факториала переданного числа")
    @ParameterizedTest
    @CsvSource({"1, 0", "1, 1", "1, -1", "120, 5"})
    void getTestFactorialNumber(int expectedValue, int transmittedNum){
        Assertions.assertEquals(expectedValue, LessonTwelveJunit5.getFactorialNumber(transmittedNum));
    }
}

