package org.aston.utils;

import org.aston.lesson_4.Employee;
import org.aston.lesson_5.Cat;

import java.util.ArrayList;

public class ObjectUtils {

    public static Employee[] createArrayTestEmployees(int lengthArray){
        Employee[] employees = new Employee[lengthArray];
        for(int i = 0; i < lengthArray; i++){
            Employee testEmployee = createTestEmployeeWithNumber(i);
            employees[i] = testEmployee;
        }
        return employees;
    }

    public static Employee createTestEmployeeWithNumber(int numberEmloyee){
        return  new Employee("Test_first_name_" + numberEmloyee,
                             "Test_last_name_" + numberEmloyee,
                             "Test_position_" + numberEmloyee,
                             "Test_" + numberEmloyee + "@mail.ru",
                             StringUtils.createRandomPhoneNumber(),
                             NumberUtils.getRandomDoubleNumber(100, 2000),
                             NumberUtils.getRandomIntNumber(18, 70));
    }

    public static ArrayList<Cat> createArrayTestCat(int lengthArray){
        ArrayList<Cat> catsArray = new ArrayList<Cat>();
        for(int i = 0; i < lengthArray; i++){
            catsArray.add(createTestCat(i));
        }
        return catsArray;
    }

    public static Cat createTestCat(int numberCat){
     return new Cat("Test_cat_" + numberCat);
    }

}
