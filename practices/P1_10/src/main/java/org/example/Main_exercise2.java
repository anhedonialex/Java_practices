package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_exercise2 {
    public static void main(String[] args) {
        Person prs = new Person();
        prs.setFirstName("Ivan");
        prs.setAge(17);
        try {
            System.out.println("Length of FName" + prs.getFirstName().length());
            System.out.println("Length of LName" + prs.getLastName().length());
        }catch (NullPointerException npe){
            System.out.println("Кажется, мы имеем дело с нулевой неинициализированной ссылкой");
        }finally {
            System.out.println("Вычисление завершено");
        }



    }
}