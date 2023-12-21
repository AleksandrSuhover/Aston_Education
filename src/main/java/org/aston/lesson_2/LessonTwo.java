package org.aston.lesson_2;

public class LessonTwo {
    public static void printThreeWords()
    {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(int one, int two)
    {
        String result = (one + two) >= 0 ? "Сумма положительная" : "Сумма отрицательная";
        System.out.println(result);
    }

    public static void printColor(int num)
    {
        if(num <= 0){
            System.out.println("Красный");
        } else if(num <= 100){
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }
    public static void compareNumbers(int one, int two)
    {
        String result = one >= two ? "a >= b" : "a < b";
        System.out.println(result);
    }


}
