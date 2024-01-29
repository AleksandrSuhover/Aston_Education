package org.aston.lesson_9;

import java.util.*;
import java.util.stream.Collectors;

public class StudentApp {

    public void executeTask4Lesson9(){
        Collection<Student> students = Arrays.asList(new Student("Дмитрий", 17, Gender.MAN),
                                                     new Student("Максим", 20, Gender.MAN),
                                                     new Student("Екатерина", 20, Gender.WOMAN),
                                                     new Student("Михаил", 28, Gender.MAN));

        OptionalDouble averageValueAgeStudents = students.stream()
                                                         .mapToInt(Student::getAge)
                                                         .average();
        System.out.println(averageValueAgeStudents);

        List<Student> studentsOfMilitaryAge = students.stream()
                                                      .filter(el -> el.getAge() < 27 && el.getAge() > 17 && el.gender == Gender.MAN)
                                                      .collect(Collectors.toList());
        System.out.println(studentsOfMilitaryAge);
    }


    private enum Gender{
        MAN,
        WOMAN
    }

    private static class Student{
        private final String name;
        private final int age;
        private final StudentApp.Gender gender;

        public Student(String name, int age, StudentApp.Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public StudentApp.Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return  true;
            if(!(obj instanceof StudentApp.Student)) return false;
            StudentApp.Student student = (StudentApp.Student) obj;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
}
