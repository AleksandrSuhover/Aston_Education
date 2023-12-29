package org.aston.lesson_4;

public class Employee {
    private String firstName;
    private String lastName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String firstName,
                    String lastName,
                    String position,
                    String email,
                    String phone,
                    double salary,
                    int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String info(){
        return String.format(
                             "First name: %s; \n" +
                             "Last name: %s; \n" +
                             "Position: %s; \n" +
                             "Email: %s; \n" +
                             "Phone: %s; \n" +
                             "Salary: %.2f; \n" +
                             "Age: %d",
                             this.firstName, this.lastName, this.position, this.email, this.phone, this.salary, this.age
                            );
    }
}
