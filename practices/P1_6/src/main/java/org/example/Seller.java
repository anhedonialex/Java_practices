package org.example;
import java.util.Scanner;

public class Seller {
    private String modify(String manufacturer) {
        // Замена символов 'o' на 'a'
        String modifiedManufacturer = manufacturer.replaceAll("o", "a");

        // Проверка наличия 'N' или 'n' в начале исходного названия
        boolean startsWithN = manufacturer.toLowerCase().startsWith("n");

        // Преобразование в строчные буквы, если не начинается с 'N' или 'n'
        if (!startsWithN) {
            modifiedManufacturer = modifiedManufacturer.toLowerCase();
        }

        return modifiedManufacturer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bondarew Alexey Petrovich RIBO-03-22, variant 2");
        System.out.print("Enter the name of the phone manufacturer: ");
        String manufacturer = scanner.nextLine();

        Telephone phone = new Telephone(manufacturer);
        Seller seller = new Seller();
        String modifiedManufacturer = seller.modify(phone.getManufacturer());

        System.out.println("The original name: " + phone.getManufacturer());
        System.out.println("Changed name: " + modifiedManufacturer);
    }
}
