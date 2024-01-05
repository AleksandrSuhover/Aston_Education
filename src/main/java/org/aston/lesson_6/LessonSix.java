package org.aston.lesson_6;

import java.io.*;
import org.aston.utils.ArrayUtils;
import org.aston.utils.CsvUtils;

public class LessonSix {
    public static void executeLesson6() throws IOException {
        AppData dataToSave = new AppData(new String[]{"First", "Second", "Third"}, ArrayUtils.createDoubleArrayWithDiagonals(3));
        String path = "D:\\Aston Education\\Homework_Aston\\src\\main\\java\\org\\aston\\lesson_6\\demo.csv";
        CsvUtils.writeFile(path, dataToSave);
        AppData appData = CsvUtils.readCsvFile(path);
        System.out.println(appData);
    }
}
