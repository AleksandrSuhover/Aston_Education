package org.aston.utils;

import org.aston.lesson_6.AppData;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CsvUtils {

    private static final Logger logger = Logger.getLogger(CsvUtils.class.getName());

    public static void writeFile(String path, AppData appData) {
        Path filepath = Paths.get(path);

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filepath)) {
            bufferedWriter.write(String.join(";,", appData.getHeader()));
            bufferedWriter.newLine();

            for (int[] row : appData.getData()) {
                List<String> rowData = Arrays.stream(row)
                                                        .boxed()
                                                        .map(Object::toString)
                                                        .collect(Collectors.toList());
                    bufferedWriter.write(String.join(";,", rowData));
                    bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AppData readCsvFile(String path) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(path));

        if (strings.isEmpty()) {
            logger.warning("File should not be empty");
            return null;
        }

        AppData appData = new AppData();

        String[] headers = Arrays.stream(strings.get(0).split(","))
                .map((value) -> value.replace(";", ""))
                .toArray(String[]::new);
        appData.setHeader(headers);

        strings.remove(0);

        List<int []> data = new ArrayList<>();

        strings.forEach((row) -> {
            int[] integers = Arrays.stream(row.split(","))
                    .map((value) -> value.replace(";", ""))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            data.add(integers);
        });

        int[][] ints = new int[data.size()][headers.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = data.get(i);
        }
        appData.setData(ints);

        return appData;
    }
}
