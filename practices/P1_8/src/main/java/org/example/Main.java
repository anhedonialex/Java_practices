package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Alex");
        names.add("Masha");
        names.add("Dima");
        names.add("Anna");
        System.out.println(names.size());
        for (String str : names){
            System.out.println(str);
        }
        names.set(0, "Lena");
        names.remove("Dima");
        names.remove(3);
        System.out.println(names);
        Collections.sort(names);
        System.out.println(names);

    }
}