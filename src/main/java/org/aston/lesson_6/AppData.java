package org.aston.lesson_6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData() {}

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.stream(data).map(Arrays::toString).collect(Collectors.toList()) +
                '}';
    }
}
