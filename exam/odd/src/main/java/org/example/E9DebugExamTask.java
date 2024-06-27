package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Scanner;

public class E9DebugExamTask {

    public static void main(String[] args) {
        System.out.println("Введите число больше 5 ");
        //Scanner sc = new Scanner(System.in);
        //int value = sc.nextInt();
        int value;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                value = sc.nextInt();
                break;
            } catch (Exception e){
                System.out.println("Введите INTEGER значение!");
            }
        }

        if(value > 5){
            Integer[] array = new Integer[value];
            // было
            //for(int i = 0;i <= value;i++){
            for(int i = 0;i < value; i++){
                array[i] = (i + 1) * 2;
            }          
            int data = Arrays.stream(array).max((Integer o1, Integer o2) -> o1.compareTo(o2)).get();
            Thread t = new Thread(() -> {
                try {
                    URL url = new URL("https://android-for-students.ru/exam/calc.php");
                    URLConnection connection = url.openConnection();
                    // было
                    // HttpURLConnection httpConnecton = connection;
                    HttpURLConnection httpConnecton = (HttpURLConnection) connection;
                    httpConnecton.setRequestMethod("POST");
                    // было
                    // httpConnecton.setDoOutput();
                    // true для POST и PUT
                    // false для GET
                    //Метод setDoOutput(true) в классе HttpURLConnection устанавливает флаг, который указывает, что соединение будет использоваться для отправки данных на сервер, а не только для получения данных.
                    httpConnecton.setDoOutput(true);
                    OutputStreamWriter osw = new OutputStreamWriter(httpConnecton.getOutputStream());
                    osw.write("value=" + data);
                    osw.flush();
                    int responseCode = httpConnecton.getResponseCode();
                    System.out.println("Response Code : " + responseCode);
                    if(responseCode == 200){
                        InputStreamReader isr = new InputStreamReader(httpConnecton.getInputStream());
                        BufferedReader br = new BufferedReader(isr);
                        String currentLine;
                        StringBuilder sbResponse = new StringBuilder();
                        while((currentLine = br.readLine()) != null){
                            sbResponse.append(currentLine);
                        }
                        String responseBody = sbResponse.toString();
                        //System.out.println("Integer value from server: " + Integer.valueOf(responseBody));
                        try {
                            System.out.println("Integer value from server: " + Integer.valueOf(responseBody));
                        } catch (Exception e){
                            System.out.println(e.getLocalizedMessage());
                        }

                    }else{
                        System.out.println("Error! Bad response code!");
                    }
                } catch (MalformedURLException ex) {
                    System.out.println("URL error" + ex.getLocalizedMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getLocalizedMessage());                
                }
            });
            t.start();       
            try {
                t.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        else {
            System.out.println("Сказано же, больше 5 надо");
        }
    }
}
