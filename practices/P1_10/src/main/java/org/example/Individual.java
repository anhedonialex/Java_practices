package org.example;

import java.io.*;
import java.util.Scanner;

public class Individual {
    public static void main(String[] args) {
        // Проверяем, был ли передан путь к файлу в аргументах командной строки
        System.out.println("Enter path to file to reverse contents");
        Scanner scan = new Scanner(System.in);
        String inputFilePath = scan.next();
        String outputFilePath = inputFilePath.replace(".txt", "_reversed.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            // Читаем каждую строку из исходного файла
            while ((line = reader.readLine()) != null) {
                // Переворачиваем строку
                String reversedLine = reverseString(line);
                // Записываем перевернутую строку в новый файл
                writer.write(reversedLine);
                writer.newLine();
            }

            System.out.println("File modification successful. Output file: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }

    // Метод для переворачивания строки
    private static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
    }
