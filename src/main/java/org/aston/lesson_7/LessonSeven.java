package org.aston.lesson_7;

public class LessonSeven {

    public static int executeLesson7(String[][] arrString, int validArrayLength) throws MyArraySizeException, MyArrayDataException {
        if (arrString.length != validArrayLength) throw new MyArraySizeException("Invalid array length, received: " + arrString.length + ", expected: " + validArrayLength + ".");
        int sumResult = 0;

        for (int i = 0; i < arrString.length; i++) {
            if (arrString[i].length != validArrayLength) throw new MyArraySizeException("Invalid array length, received: " + arrString.length + ", expected: " + validArrayLength + ".");
            for (int j = 0; j < arrString[i].length; j++) {
                try {
                    sumResult += Integer.parseInt(arrString[i][j]);
                } catch (NumberFormatException e) {
                    String msg = "Error converting String to int, array element under indexes: [" + i + "][" + j + "].";
                    throw new MyArrayDataException(msg, e);
                }
            }
        }
        return sumResult;
    }
}
