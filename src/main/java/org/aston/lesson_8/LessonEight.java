package org.aston.lesson_8;

import org.aston.utils.ArrayUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LessonEight {
    public static void executeLesson8(){
        List<String> arrayWithDuplicates = ArrayUtils.createArrayStringWithDuplicates(10, 5);
        System.out.println(arrayWithDuplicates);

        HashSet<String> setUniqueValues = new HashSet<>(arrayWithDuplicates);
        System.out.println(setUniqueValues);

        Map<String, Integer> resultMap = arrayWithDuplicates.stream()
                                                            .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));

        resultMap.forEach((k, v) -> System.out.println(k + ": " + v));


    }
}
