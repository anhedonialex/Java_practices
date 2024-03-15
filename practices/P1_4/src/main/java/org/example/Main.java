package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Person person = new Person("Ivan Petrov", 20);
        person.doSleep(8);
        person.doEat(new String[]{"Shawarma", "Coffe"});
        Student firstStudent = new Student("RIBO-03-22", 1,true, "Ivan Petrov");
        firstStudent.goToUniversity("MIREA");
    }
}