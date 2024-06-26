package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь к файлу для сохранения объекта: ");
        String filePath = scanner.nextLine();

        Message message = new Message("Alice", "Bob", "Hello, how are you?");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(message);
            System.out.println("Сообщение успешно сериализовано в файл: " + filePath);
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }

        scanner.close();
    }
}