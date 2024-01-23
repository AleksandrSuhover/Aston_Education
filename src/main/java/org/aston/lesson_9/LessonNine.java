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



    private enum Gender{
            MAN,
            WOMAN
        }

    private static class Student{
        private final String name;
        private final int age;
        private final Gender gender;

        public Student(String name, int age, Gender gender) {
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

        public Gender getGender() {
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
            if(!(obj instanceof Student)) return false;
            Student student = (Student) obj;
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
