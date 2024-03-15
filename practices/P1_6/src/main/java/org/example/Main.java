package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cat cat = new Cat ("Британский", "кошка");
        Animal anim = new Cat("Шотландский", "кошка");
        anim.doSound();
        cat.eatSausage(10);


        Person person = new Person("John","Doe");
        person.talk();


        Person person2 = new Person("Mikhail", "Saltikov");
        person2.setAge(21);

        MFC mfc = new MFC("Москва, улица Строителей 9");
        mfc.setOperatorsCount(10);
        mfc.changePersonParams(person2);
        System.out.println("Change person success");
        System.out.println(person2.toString());

        Student student = new Student("RIBO-03-22", 2, true,"Mikhail", "Saltikov");
        mfc.changePersonParams(student);
        System.out.println(student.toString());
    }
}