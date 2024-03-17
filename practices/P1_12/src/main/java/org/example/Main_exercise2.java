package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main_exercise2 {
    public static void main(String[] args) {
        System.out.println("Hello! I am " + Thread.currentThread().getName());
        Path currentPath = Paths.get("").toAbsolutePath();
        //Person p = new Person("John", "Wick",40,100000);
        //SaverRunnable sr = new SaverRunnable(p, currentPath.toString()+"\\person.ser");
        LoaderRunnable lr = new LoaderRunnable(currentPath.toString()+"\\person.ser");
        Thread th = new Thread(lr);
        th.start();

    }
}
