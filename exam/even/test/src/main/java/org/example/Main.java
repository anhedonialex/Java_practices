package org.example;

import java.math.BigInteger;
import java.util.*;

public class Main extends Thread {
    private final int number;
    private BigInteger factorial = BigInteger.valueOf(1);


    public Main(int number) {
        this.number = number;
    }

    public void run() {
        if (number < 0) {
            System.out.println("Факториал отрицательного числа не определен");
            return;
        }

        int i = 1;
        while (i <= number) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
            i++;
        }

        System.out.println("Факториал числа " + number + " равен: " + factorial);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число для вычисления факториала: ");
        int inputNumber = scanner.nextInt();

        Main factorialThread = new Main(inputNumber);
        factorialThread.start();
    }
}