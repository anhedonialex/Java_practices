package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_exercise1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scan.next();
        int age = 0;
        while(age == 0){
            try{
                System.out.println("Enter your age:");
                age = scan.nextInt();
            }catch(InputMismatchException ime){
                scan.next();
                System.out.println("Age error! Try again!");
            }
        }
        System.out.println("Thank you");
    }
}