package org.example;
import java.util.Scanner;

public class BankDepositCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных пользователем
        System.out.println("Введите длительность вклада в месяцах:");
        int durationMonths = scanner.nextInt();

        System.out.println("Введите годовой процент по вкладу:");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Введите начальную сумму вклада:");
        double initialAmount = scanner.nextDouble();

        // Вычисление ежемесячного дохода и итогового дохода
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        double totalAmount = initialAmount;

        for (int month = 1; month <= durationMonths; month++) {
            double interest = totalAmount * monthlyInterestRate;
            totalAmount += interest;
            System.out.printf("Месяц %d: Доход %.2f, Итоговая сумма %.2f%n", month, interest, totalAmount);
        }

        // Вывод итоговой суммы
        System.out.printf("Итоговая сумма вклада через %d месяцев: %.2f%n", durationMonths, totalAmount);

        scanner.close();
    }
}
