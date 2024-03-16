package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MainPerson {
    public static void main(String[] args) {
        System.out.println("Main w/ persons");

        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Ivan","Ivanov",20));
        persons.add(new Person("Masha","Rasputina",19));
        persons.add(new Person("Alex","Alexandrov",17));
        persons.add(new Person("John","Wick",40));
        persons.add(new Person("Ivan","Petrov",16));
        System.out.println("List size: " + persons.size());
        Collections.sort(persons);
        for(Person p: persons){
            System.out.println(p.getLastName() + " " + p.getFirstName());
        }
        /*Iterator<Person> iter = persons.iterator(); // CursedLoop loop = new CursedLoop();
        while (iter.hasNext()){
            Person p = iter.next();
            if (p.getAge()<18){
                iter.remove();
            }
        }*/

    }
}
