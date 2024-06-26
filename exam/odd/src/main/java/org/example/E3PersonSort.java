package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// implements Comparable<Person> подсветится красным, alt+enter, implement methods
// Геттеры сеттеры генерируем с помощью alt + insert
class Person implements Comparable<Person>{
    private String name;
    private int age;
    private boolean isStudent = true;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name, int age, boolean isStudent) {
        this.age = age;
        this.name = name;
        this.isStudent = isStudent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, isStudent: %b",this.name, this.age, this.isStudent);
    }
}
public class E3PersonSort {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 10));
        persons.add(new Person("Doe", 99, false));
        persons.add(new Person("Charlotte", 20));
        Collections.sort(persons);
        System.out.println("Сортировка в алфавитном порядке");

        for (Person person : persons){
            System.out.println(person);
        }
    }
}