package org.aston.lesson_9;

import org.aston.utils.ArrayUtils;

import java.util.*;
import java.util.stream.Collectors;

public class LessonNine {
    public static void executeLesson9() {

        //Task N1
        ArrayList<Integer> arrayRandomNumbers = ArrayUtils.createArrayWithRandomNumbers(10, 1, 50);
        System.out.println(arrayRandomNumbers);

        ArrayList<Integer> arrayEvenNumbers = ArrayUtils.getOnlyValidNumbersFromArray(arrayRandomNumbers, x -> x % 2 == 0);
        System.out.println("Колличество чётных чисел: " + arrayEvenNumbers.size());
        System.out.println("Все чётные числа: " + arrayEvenNumbers);

        //Task N2
        List<String> arrayString = Arrays.asList("Highload", "High", "Load", "Highload");
        System.out.println(ArrayUtils.getCountSearchValueInList(arrayString, "High"));
        System.out.println(ArrayUtils.getFirstValueInListString(arrayString));
        System.out.println(ArrayUtils.getLastValueInListString(arrayString));

        //Task №3
        List<String> list = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        System.out.println(Arrays.toString(ArrayUtils.sortSpecificListString(list)));

        //Task N4
        StudentApp studentAppExecute = new StudentApp();
        studentAppExecute.executeTask4Lesson9();

        // Task№5
        Scanner in = new Scanner(System.in);
        List<String> arrayLogins = new ArrayList<>();
        String inputLogin;
        while(!(inputLogin = in.nextLine()).trim().isEmpty()){
            arrayLogins.add(inputLogin);
        }

        List<String> allLoginsBeginSpecificLetter = arrayLogins.stream()
                                                               .filter(el -> el.charAt(0) == 'f')
                                                               .collect(Collectors.toList());
        System.out.println(allLoginsBeginSpecificLetter);
    }

}
