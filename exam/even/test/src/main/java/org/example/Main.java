package org.example;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main  {


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите URL веб-страницы для загрузки информации: ");
        String url = scanner.nextLine();

        executor.submit(() -> {
            downloadWebPage(url);
        });

        executor.shutdown();
    }

    private static void downloadWebPage(String url) {
        try {

            URL webpageURL = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(webpageURL.openStream()));

            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();

            File file = new File("downloadedPage.html");
            FileWriter writer = new FileWriter(file);
            writer.write(content.toString());
            writer.close();

            System.out.println("Содержимое веб-страницы успешно сохранено в файл downloadedPage.html");

        } catch (MalformedURLException e) {
            System.out.println("Неверный URL адрес веб-страницы: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке веб-страницы: " + e.getMessage());
        }
    }
}


