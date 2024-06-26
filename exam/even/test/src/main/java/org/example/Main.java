package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input HashMap quantity: ");
        int quantity = 0;
        boolean valueIsInt = false;
        while (!valueIsInt){
            try{
                quantity = Integer.parseInt(scanner.nextLine());
                valueIsInt = true;
            }catch (NumberFormatException e){
                System.out.println("Try again: ");
                quantity = 3;
            }
        }


        System.out.print("Введите ключ - значение через пробел:\n");
        for (int i = 0; i < quantity; i++) {
            System.out.print(i+1 + "key-value: ");
            String input = scanner.nextLine();
            String[] keyValues = input.split(" ");
            if (keyValues.length<2){
                boolean inputCorrected = false;
                while (!inputCorrected){
                    System.out.println("Try again: ");
                    input = scanner.nextLine();
                    keyValues = input.split(" ");
                    if (keyValues.length>=2){
                        inputCorrected = true;
                    }
                }
            }
            String key = keyValues[0];
            String value = keyValues[1];
            hashMap.put(key, value);
        }

        Map<String, String> sortedMap = new TreeMap<>(hashMap);

        System.out.println("Отсортированный по ключу HashMap:");
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        scanner.close();
    }
}