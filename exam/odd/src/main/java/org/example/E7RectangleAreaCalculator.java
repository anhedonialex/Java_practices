package org.example;

import java.util.Scanner;

public class E7RectangleAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите длину прямоугольника:");
        double length = getPositiveDouble(scanner);

        System.out.println("Введите ширину прямоугольника:");
        double width = getPositiveDouble(scanner);

        Runnable task = new AreaCalculatorTask(length, width);
        Thread thread = new Thread(task);
        thread.start();
    }

    private static double getPositiveDouble(Scanner scanner) {
        double value;
        while (true) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value <= 0) {
                    throw new NumberFormatException("Значение должно быть положительным.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректное значение. Пожалуйста, введите положительное число:");
            }
        }
        return value;
    }
}

class AreaCalculatorTask implements Runnable {
    private final double length;
    private final double width;

    public AreaCalculatorTask(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void run() {
        double area = length * width;
        System.out.println("Площадь прямоугольника: " + area);
    }
}
