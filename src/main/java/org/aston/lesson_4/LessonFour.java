package org.aston.lesson_4;

import org.aston.utils.ObjectUtils;
import org.aston.utils.NumberUtils;

public class LessonFour {
    public static void executeLesson4(){
        Employee newEmp = new Employee("John", "Smith", "Middle", "test@mail.ru", "+3456234234", 500.50, 25);
        System.out.println(newEmp.info());

        Employee[] arrayEmployees = ObjectUtils.createArrayTestEmployees(5);
        for (Employee emp : arrayEmployees){
            System.out.println(emp.info());
        }


        Park newPark = new Park("Sparrow Hills", "Kosygina str., 28, Moscow, Russia");
        Park.Attraction ziplineAttraction = newPark.new Attraction(
                                                        "Zipline",
                                                         "09:00 - 18:00",
                                                                     NumberUtils.getRandomDoubleNumber(1000.00, 5000));

        Park.Attraction carouselAttraction = newPark.new Attraction(
                                                        "Carousel",
                                                         "10:00 - 19:00",
                                                                     NumberUtils.getRandomDoubleNumber(1000.00, 5000));
        newPark.addAttraction(ziplineAttraction);
        newPark.addAttraction(carouselAttraction);
        System.out.println(newPark);
    }
}
