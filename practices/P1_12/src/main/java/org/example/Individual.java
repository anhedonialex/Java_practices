package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Individual {
    public static void main(String[] args) {
        Path currentPath = Paths.get("").toAbsolutePath();
        System.out.println("Bondarew Alexey Petrovich RIBO-03-22 Vatiant 2\nVvedite nazvanie faila v directorii poekta (P1_12)");
        Scanner scanner = new Scanner(System.in);
        String file = scanner.next();
        LoaderRunnableMessage lr = new LoaderRunnableMessage(currentPath.toString()+"\\"+file);
        Thread th = new Thread(lr);
        th.start();
    }
}
