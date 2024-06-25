package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числовые значения через запятую:");
        String input = scanner.nextLine();

        String[] numbers = input.split(",");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int i = 0;
        while (i < numbers.length) {
            try {
                int num = Integer.parseInt(numbers[i].trim());
                min = Math.min(min, num);
                max = Math.max(max, num);
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Некорректное значение, введите числовые значения через запятую:");
                input = scanner.nextLine();
                numbers = input.split(",");
                i = 0;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
        }

        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число: " + max);

    }
}