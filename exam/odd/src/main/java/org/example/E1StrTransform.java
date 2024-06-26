package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class E1StrTransform {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter fout = new FileWriter("E1StrTransform.txt");
        String temporary;
        System.out.print("Enter your precious string: ");
        String my_precious_str = scanner.nextLine();
        temporary = new StringBuilder(my_precious_str).reverse().toString();
        System.out.println("Reversed: " + temporary);
        fout.write("Reversed: " + temporary + "\n");
        if (my_precious_str.length() > 2) {
            temporary = my_precious_str.substring(1, my_precious_str.length() - 1);
            System.out.println("Minus first 'n' last: " + temporary);
            fout.write("Minus first 'n' last: " + temporary + "\n");
        }
        else {
            System.out.println("Minus first 'n' last: Failed due to length() < 2");
            fout.write("Minus first 'n' last: Failed due to length() < 2\n");
        }
        temporary = my_precious_str.toUpperCase();
        System.out.println("Upper: " + temporary);
        fout.write("Upper: " + temporary + "\n");
        fout.close();
    }
}