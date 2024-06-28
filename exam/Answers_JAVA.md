1. **Реализовать Java-программу в Apache NetBeans IDE, которая преобразовывает введенную пользователем с клавиатуры строку:  разворот строки;  удаление первого и последнего символа в строке;  перевод строки в верхний регистр. Три новых преобразованных строки необходимо сохранить в текстовый файл.** 
```java
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
```
2. **Реализовать Java-программу в Apache NetBeans IDE, которая вычисляет максимальное и минимальное число из введенных пользователем с клавиатуры числовых значений через запятую. Результаты отображаются в консоли. В решении необходимо использовать цикл while. Проверки на некорректные значения – обязательны!** 
```java
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числовые значения через запятую:");
        String input = scanner.nextLine();

        String[] numbers = input.split(",");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int i = 0;
        while (i < numbers.length) {
            try {
                int num = Integer.parseInt(numbers[i].trim());
                min = Math.min(min, num);
                max = Math.max(max, num);
                i++;
            } catch (NumberFormatException e) {
                System.out.println("Некорректное значение, введите числовые значения через запятую:");
                input = scanner.nextLine();
                numbers = input.split(",");
                i = 0;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
        }

        System.out.println("Минимальное число: " + min);
        System.out.println("Максимальное число: " + max);

    }
}
```

3. **Реализовать Java-программу в Apache NetBeans IDE, выполняющую вывод в консоль сортированных по имени сущностей типа Person (объекты хранятся в ArrayList). Помимо имени, класс Person должен содержать еще 3 переменных класса. В решении необходимо использовать интерфейс Comparable. Заполнение коллекции выполняется пользователем с клавиатуры во время выполнения программы (минимум 3 элемента коллекции).** 
```java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// implements Comparable<Person> подсветится красным, alt+enter, implement methods
// Геттеры сеттеры генерируем с помощью alt + insert
class Person implements Comparable<Person>{
    private String name;
    private int age;
    private boolean isStudent = true;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name, int age, boolean isStudent) {
        this.age = age;
        this.name = name;
        this.isStudent = isStudent;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, isStudent: %b",this.name, this.age, this.isStudent);
    }
}
public class E3PersonSort {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 10));
        persons.add(new Person("Doe", 99, false));
        persons.add(new Person("Charlotte", 20));
        Collections.sort(persons);
        System.out.println("Сортировка в алфавитном порядке");

        for (Person person : persons){
            System.out.println(person);
        }
    }
}
```
4. **Реализовать Java-программу в Apache NetBeans IDE, выполняющую вывод в консоль отсортированного по значению ключа HashMap (ключ – типа String). Заполнение HashMap выполняется пользователем с клавиатуры во время выполнения программы (минимум 5 значений). Необходимо предусмотреть проверки на некорректные значения и обработку исключений.**
```java
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
```

5. **Реализовать Java-программу в Apache NetBeans IDE, которая загружает содержимое текстового файла, удаляет все гласные буквы и выводит полученное значение в консоль. Путь к файлу вводит пользователь с клавиатуры. Проверки на некорректные значения – обязательны!** 
```java
package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class E5VowelRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу:");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(removeVowels(line));
            }
            System.out.println("Содержимое файла без гласных:");
            System.out.println(result.toString());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    private static String removeVowels(String input) {
        // тут используются регулярные выряжения (regex)
        // если наблюдаются проблемы с кодировкой русского, можно его убрать
        return input.replaceAll("[AEIOUaeiouАЕЁИОУЫЭЮЯаеёиоуыэюя]", "");
    }
}
```
6. **Реализовать Java-программу в Apache NetBeans IDE, которая сериализует в файл экземпляр класса сущности Message (класс должен содержать минимум 3 переменных). Путь к файлу вводит пользователь с клавиатуры.** 
   Main.java
```java
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
```
Message.java
```java
package org.example;  
  
import java.io.Serializable;  
  
public class Message implements Serializable {  
    private final String sender;  
    private final String receiver;  
    private final String content;  
  
    public Message(String sender, String receiver, String content) {  
        this.sender = sender;  
        this.receiver = receiver;  
        this.content = content;  
    }  
  
    @Override  
    public String toString() {  
        return "Message{" +  
                "sender='" + sender + '\'' +  
                ", receiver='" + receiver + '\'' +  
                ", content='" + content + '\'' +  
                '}';  
    }  
}
```
7. **Реализовать Java-программу в Apache NetBeans IDE, которая вычисляет площадь прямоугольника в отдельном потоке и выводит результат в консоль. Создание потока должно быть реализовано с использованием интерфейса Runnable. Значения сторон вводит пользователь с клавиатуры. Проверки на некорректные значения – обязательны!** 
```java
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

```
8. **Реализовать Java-программу в Apache NetBeans IDE, которая вычисляет в отдельном потоке факториал введенного пользователем числа с клавиатуры и выводит полученное значение в консоль. Необходимо использовать цикл while. Создание потока должно быть реализовано с использованием наследника класса Thread. Проверки на некорректные значения – обязательны!**
```java
package org.example;  
  
import java.math.BigInteger;  
import java.util.*;  
  
public class Main extends Thread {  
    private final int number;  
    private BigInteger factorial = BigInteger.valueOf(1);  
  
  
    public Main(int number) {  
        this.number = number;  
    }  
  
    public void run() {  
        if (number < 0) {  
            System.out.println("Факториал отрицательного числа не определен");  
            return;  
        }  
  
        int i = 1;  
        while (i <= number) {  
            factorial = factorial.multiply(BigInteger.valueOf(i));  
            i++;  
        }  
  
        System.out.println("Факториал числа " + number + " равен: " + factorial);  
    }  
  
    public static void main(String[] args) {  
  
        Scanner scanner = new Scanner(System.in);  
  
        System.out.print("Введите число для вычисления факториала: ");  
        int inputNumber = scanner.nextInt();  
  
        Main factorialThread = new Main(inputNumber);  
        factorialThread.start();  
    }  
}
```
9. **Дан исходный код Java-программы. При запуске программы (а также в ходе работы), возникают ошибки. Провести отладку программы (debugging), выявить в каких участках программы возникают ошибки, исправить их, запустить рабочий вариант. В данном задании проверяются знания темы обработки исключений, а также умение работы с отладчиком Apache NetBeans IDE. Загрузите программу по адресу: https://goo.su/MAN2U Программа считывает число с клавиатуры, проводит математические операции и отправляет некоторое значение на сервер. Сервер возвращает измененное число. Приложение содержит ошибки компиляции, также в приложении могут возникнуть ошибки при неправильной эксплуатации. Задача исправить ошибки и предусмотреть обработку ошибок в «уязвимых» участках кода.** 
```java
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

```
10. **Реализовать Java-программу в Apache NetBeans IDE, которая сохраняет в файл содержимое веб-страницы, адрес которой вводит пользователь с клавиатуры. Использование многопоточности – обязательно.** 
```java
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
```
11. **Реализовать мобильное приложение в Android Studio, которое складывает два целых числа, введенных пользователем в поля ввода (EditText). Результат вычисления необходимо отобразить в виджете TextView после нажатия на кнопку (Button) и отобразить в лог. В макете activity разрешено использовать контейнеры только одного типа: LinearLayout. В приложении необходимо использовать Library Data Binding для привязки виджетов. Проверки на некорректные значения – обязательны!** 

MainActivity.java
```java
package com.example.e11calc;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText e1 = findViewById(R.id.editText1);
        EditText e2 = findViewById(R.id.editText2);
        TextView tv = findViewById(R.id.textView);
        Button sum = findViewById(R.id.button);
        sum.setOnClickListener(v->{
            Log.i("Hint", "Кнопка нажата");
            String e1_val = e1.getText().toString();
            String e2_val = e2.getText().toString();
            if (!e1_val.isEmpty() && !e2_val.isEmpty()){
                int result = Integer.parseInt(e1_val) + Integer.parseInt(e2_val);
                Log.i("Sum", String.valueOf(result));
                tv.setText(String.valueOf(result));
            }
            else{
                Toast.makeText(getApplicationContext(), "Вы ввели кринж", Toast.LENGTH_LONG).show();
            }
        });
    }

}
```

activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    tools:context=".MainActivity">
    <LinearLayout
        android:layout_height="wrap_content"
        android:layout_width="match_parent"
        android:orientation="horizontal">
        <EditText
            android:id="@+id/editText1"
            android:ems="10"
            android:hint="Первое слагаемое"
            android:inputType="numberSigned"
            app:layout_constraintBottom_toTopOf="@+id/editText2"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            android:layout_height="wrap_content"
            android:layout_width="wrap_content"/>
        <EditText
            android:id="@+id/editText2"

            android:ems="10"
            android:hint="Второе слагаемое"
            android:inputType="numberSigned"
            android:layout_weight="1"
            android:layout_height="wrap_content"
            android:layout_width="wrap_content"/>
    </LinearLayout>
    <LinearLayout
        android:layout_marginTop="32dp"
        android:layout_width="wrap_content"
        android:layout_height="match_parent">
        <TextView
            android:id="@+id/textView"
            android:layout_weight="1"
            android:text="TextView"

            android:layout_height="wrap_content"
            android:layout_width="wrap_content"/>

        <Button
            android:id="@+id/button"
            android:layout_width="364dp"
            android:layout_height="wrap_content"
            android:layout_marginTop="32dp"
            android:layout_weight="1"
            android:text="Сослагать" />
    </LinearLayout>
</LinearLayout>
```
12. **Реализовать мобильное приложение в Android Studio, состоящее из двух activity, таким образом, чтобы в первую activity вернулся результат математической операции из второй activity. Подробнее: Вторая activity запускается по нажатию на кнопку (Button) в первой activity. Во второй activity пользователь вводит числовое значение в EditText. Далее это значение возводится в степень 2. Пользователь нажимает на кнопку (Button) и приложение возвращается в первую activity и отображает в поле TextView вычисленное значение. Проверки на некорректные значения – обязательны!** 

MainActivity.java
```java
package com.mirea.kt.ribo.test;  
  
import android.content.Intent;  
import android.os.Bundle;  
import android.view.View;  
import android.widget.Button;  
import android.widget.TextView;  
  
import androidx.annotation.Nullable;  
import androidx.appcompat.app.AppCompatActivity;  
  
public class MainActivity extends AppCompatActivity {  
    @Override  
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {  
        super.onActivityResult(requestCode, resultCode, data);  
        if (data == null) {  
            return;  
        }  
        int value = data.getIntExtra("VALUE", 0);  
        TextView textView = findViewById(R.id.text);  
        textView.setText(String.valueOf(value));  
    }  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        Button button = findViewById(R.id.button);  
        button.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);  
                startActivityForResult(intent, 1);  
            }  
        });  
    }  
}
```
SecondActivity.java
```java
package com.mirea.kt.ribo.test;  
  
import android.content.Intent;  
import android.os.Bundle;  
import android.widget.Button;  
import android.widget.EditText;  
  
import androidx.appcompat.app.AppCompatActivity;  
  
public class SecondActivity extends AppCompatActivity {  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_second);  
  
        EditText editText = findViewById(R.id.editText);  
        Button calcButton = findViewById(R.id.button);  
  
        calcButton.setOnClickListener(v -> {  
            if (editText.getText().length() > 0){  
                int value = Integer.parseInt(editText.getText().toString());  
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);  
                intent.putExtra("VALUE", value*value);  
                setResult(RESULT_OK, intent);  
                finish();  
            }  
        });  
    }  
}
```
13. **Реализовать мобильное приложение в Android Studio, с помощью которого по нажатию на картинку (ImageView) можно поделиться текстом из виджета EditText через другое приложение (мессенджеры, смс и т.п.). В приложении необходимо использовать Library Data Binding для привязки виджетов. Картинка для imageView: https://goo.su/TpgLD9l.**
MainActivity.java
```java
package com.example.e13share;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView imageView = findViewById(R.id.imageView);
        Button butt = findViewById(R.id.button);
        butt.setOnClickListener(v-> {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            shareImageandText(bitmap);
        });

    }
    private void shareImageandText(Bitmap bitmap) {
        Uri uri = getmageToShare(bitmap);
        Intent intent = new Intent(Intent.ACTION_SEND);

        // putting uri of image to be shared
        intent.putExtra(Intent.EXTRA_STREAM, uri);

        // adding text to share
        intent.putExtra(Intent.EXTRA_TEXT, "Sharing Image");

        // Add subject Here
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");

        // setting type to image
        intent.setType("image/png");

        // calling startactivity() to share
        startActivity(Intent.createChooser(intent, "Share Via"));
    }

    // Retrieving the url to share
    private Uri getmageToShare(Bitmap bitmap) {
        File imagefolder = new File(getCacheDir(), "images");
        Uri uri = null;
        try {
            imagefolder.mkdirs();
            File file = new File(imagefolder, "shared_image.png");
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, outputStream);
            outputStream.flush();
            outputStream.close();
            uri = FileProvider.getUriForFile(this, "com.example.e13share.fileprovider", file);
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        return uri;
    }
}
```

AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <application
            android:allowBackup="true"
            android:dataExtractionRules="@xml/data_extraction_rules"
            android:fullBackupContent="@xml/backup_rules"
            android:icon="@mipmap/ic_launcher"
            android:label="@string/app_name"
            android:roundIcon="@mipmap/ic_launcher_round"
            android:supportsRtl="true"
            android:theme="@style/Theme.E13Share"
            tools:targetApi="31">
        <activity
                android:name=".MainActivity"
                android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <provider
                android:name="androidx.core.content.FileProvider"
                android:authorities="com.example.e13share.fileprovider"
                android:exported="false"
                android:grantUriPermissions="true">
            <meta-data
                    android:name="android.support.FILE_PROVIDER_PATHS"
                    android:resource="@xml/file_paths" />
        </provider>
    </application>

</manifest>
```
android_logo кладём в res/drawable
xml/file_paths.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<paths xmlns:android="http://schemas.android.com/apk/res/android">
    <cache-path name="shared_images" path="images/"/>
</paths>
```

activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">
    <LinearLayout
        android:layout_height="wrap_content"
        android:layout_width="match_parent"
        android:orientation="vertical">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
    </LinearLayout>

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:srcCompat="@drawable/android_logo" />

    <Button
        android:id="@+id/button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Поделиться" />
</LinearLayout>
```
14. **Реализовать мобильное приложение в Android Studio, в котором по нажатию на кнопку (Button) будет заменяться содержимое экрана, расположенного ниже кнопки. При выполнении задания обязательно использовать фрагменты (динамическая регистрация). Содержимое экранов может быть любое.** 

MainActivity.java
```java
package com.mirea.kt.ribo.task14;  
  
import android.os.Bundle;  
import android.view.View;  
  
  
import androidx.appcompat.app.AppCompatActivity;  
import androidx.fragment.app.Fragment;  
import androidx.fragment.app.FragmentManager;  
import androidx.fragment.app.FragmentTransaction;  
  
public class MainActivity extends AppCompatActivity {  
  
  
    private Fragment firstFragment;  
    private Fragment secondFragment;  
  
    private boolean isFragment1Displayed = true;  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
  
  
        FragmentManager fragmentManager = getSupportFragmentManager();  
        firstFragment = new FirstFragment();  
        secondFragment = new SecondFragment();  
        fragmentManager.beginTransaction()  
                .replace(R.id.fragment_container_view, firstFragment, null)  
                .commit();  
    }  
  
    public void changeContent(View view) {  
        FragmentManager fragmentManager = getSupportFragmentManager();  
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();  
  
        if (isFragment1Displayed) {  
            fragmentTransaction.replace(R.id.fragment_container_view, firstFragment);  
            isFragment1Displayed = false;  
        } else {  
            fragmentTransaction.replace(R.id.fragment_container_view, secondFragment);  
            isFragment1Displayed = true;  
        }  
        fragmentTransaction.commit();  
    }  
  
}
```
activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>  
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"  
    xmlns:app="http://schemas.android.com/apk/res-auto"  
    xmlns:tools="http://schemas.android.com/tools"  
    android:id="@+id/main"  
    android:layout_width="match_parent"  
    android:layout_height="match_parent"  
    tools:context=".MainActivity">  
  
    <TextView        android:id="@+id/textView"  
        android:layout_width="wrap_content"  
        android:layout_height="wrap_content"  
        android:text="Hello World!"  
        app:layout_constraintBottom_toBottomOf="parent"  
        app:layout_constraintEnd_toEndOf="parent"  
        app:layout_constraintStart_toStartOf="parent"  
        app:layout_constraintTop_toTopOf="parent" />  
  
    <FrameLayout        android:id="@+id/fragment_container_view"  
        android:layout_width="match_parent"  
        android:layout_height="0dp"  
        app:layout_constraintBottom_toBottomOf="parent"  
        app:layout_constraintEnd_toEndOf="parent"  
        app:layout_constraintStart_toStartOf="parent"  
        app:layout_constraintTop_toBottomOf="@+id/textView" />  
  
</androidx.constraintlayout.widget.ConstraintLayout>
```
fragment_first.xml
```xml
<?xml version="1.0" encoding="utf-8"?>  
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"  
    xmlns:tools="http://schemas.android.com/tools"  
    android:layout_width="match_parent"  
    android:layout_height="match_parent"  
    tools:context=".FirstFragment">  
<Button  
    android:layout_width="wrap_content"  
    android:layout_height="wrap_content"  
    android:text="FIRST FRAGMENT"  
    android:onClick="changeContent"/>  
  
</FrameLayout>
```
first_fragment.java
```java
package com.mirea.kt.ribo.task14;  
  
import android.os.Bundle;  
  
import androidx.fragment.app.Fragment;  
  
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup;  
  
  
public class FirstFragment extends Fragment {  
  
    public FirstFragment() {  
        // Required empty public constructor  
    }  
  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
    }  
  
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
                             Bundle savedInstanceState) {  
        return inflater.inflate(R.layout.fragment_first, container, false);  
    }  
}
```
15. **Реализовать мобильное приложение в Android Studio, в котором при нажатии на кнопку (Button) создается база данных SQLite с таблицей для хранения списка сообщений (Message). Таблица должна содержать минимум 4 столбца: идентификатор сообщения (число), тело сообщения (строка), дата и время отправки сообщения (строка), флаг является ли сообщение прочитанным или нет.**
MainActivity.java
```java
package com.example.e15sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private MessageDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new MessageDatabaseHelper(this);

        Button buttonCreateDb = findViewById(R.id.button_create_db);
        buttonCreateDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Открытие базы данных (создание, если не существует)
                dbHelper.getWritableDatabase();
                Log.i("", "БД создана");

            }
        });
        Button buttonAddMessage = findViewById(R.id.button_add_message);
        buttonAddMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Добавление сообщения в базу данных
                String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                dbHelper.addMessage("Hello, World!", timeStamp, false);
            }
        });
        Button buttonShowMessages = findViewById(R.id.button_show_messages);
        buttonShowMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получение и вывод всех сообщений в логах
                Cursor cursor = dbHelper.getAllMessages();
                if (cursor.moveToFirst()) {
                    do {
                        int id = cursor.getInt(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_ID));
                        String body = cursor.getString(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_BODY));
                        String timestamp = cursor.getString(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_TIMESTAMP));
                        int isRead = cursor.getInt(cursor.getColumnIndexOrThrow(MessageDatabaseHelper.COLUMN_IS_READ));
                        Log.i("", "Message ID: " + id + ", Body: " + body + ", Timestamp: " + timestamp + ", Is Read: " + (isRead == 1));
                    } while (cursor.moveToNext());
                }
                cursor.close();
            }
        });

    }
}
```
MessageDatabaseHelper.java
```java
package com.example.e15sqlite;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class MessageDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "messages.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "messages";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BODY = "body";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_IS_READ = "is_read";

    public MessageDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BODY + " TEXT, "
                + COLUMN_TIMESTAMP + " TEXT, "
                + COLUMN_IS_READ + " INTEGER)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    // Метод для добавления сообщения
    public void addMessage(String body, String timestamp, boolean isRead) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BODY, body);
        values.put(COLUMN_TIMESTAMP, timestamp);
        values.put(COLUMN_IS_READ, isRead ? 1 : 0);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Метод для получения всех сообщений
    public Cursor getAllMessages() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
}
```
activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button_create_db"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Создать базу данных" />
    <Button
        android:id="@+id/button_add_message"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Добавить сообщение" />
    <Button
        android:id="@+id/button_show_messages"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Показать сообщения" />

</LinearLayout>
```
16. **Реализовать мобильное приложение в Android Studio, в котором значение (тип String), записанное в поле виджета EditText, сохраняется в хранилище SharedPreferces при нажатии на кнопку (Button). При нажатии на вторую кнопку, значение загружается из SharedPreferences и отображается в TextView и в лог.** 
```java 
package com.example.settingsapp;
 
import androidx.appcompat.app.AppCompatActivity;
 
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
 
public class MainActivity extends AppCompatActivity {
 
    private static final String PREFS_FILE = "Account";
    private static final String PREF_NAME = "Name";
    SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
    }
 
    public void saveName(View view) {
        // получаем введенное имя
        EditText nameBox = findViewById(R.id.nameBox);
        String name = nameBox.getText().toString();
        // сохраняем его в настройках
        SharedPreferences.Editor prefEditor = settings.edit();
        prefEditor.putString(PREF_NAME, name);
        prefEditor.apply();
    }
 
    public void getName(View view) {
        // получаем сохраненное имя
        TextView nameView = findViewById(R.id.nameView);
        String name = settings.getString(PREF_NAME,"не определено");
        nameView.setText(name);
    }
}
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >
 
    <EditText
        android:id="@+id/nameBox"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="Введите имя"
        app:layout_constraintBottom_toTopOf="@id/saveButton"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
 
    <Button
        android:id="@+id/saveButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Сохранить"
        android:onClick="saveName"
        app:layout_constraintBottom_toTopOf="@id/nameView"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toBottomOf="@id/nameBox"/>
 
    <TextView
        android:id="@+id/nameView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        app:layout_constraintBottom_toTopOf="@id/getButton"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toBottomOf="@id/saveButton"/>
    <Button
        android:id="@+id/getButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Получить имя"
        android:onClick="getName"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintTop_toBottomOf="@id/nameView"/>
 
</androidx.constraintlayout.widget.ConstraintLayout>
```
17. **Реализовать мобильное приложение в Android Studio, в котором значение, записанное в поле виджета EditText, сохраняется в текстовый файл во внутренней памяти устройства при нажатии на кнопку (Button). Имя файла задает пользователь (вводит во второй EditText). При сохранении файла необходимо использовать многопоточность (отдельный поток).**
MainActivity.java
```java
package com.example.e17saveinside;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFileName;
    private EditText editTextContent;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFileName = findViewById(R.id.editTextFileName);
        editTextContent = findViewById(R.id.editTextContent);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToFile();
            }
        });
    }

    private void saveToFile() {
        final String fileName = editTextFileName.getText().toString().trim();
        final String content = editTextContent.getText().toString().trim();

        if (fileName.isEmpty()) {
            showToast("Введите имя файла");
            return;
        }

        if (content.isEmpty()) {
            showToast("Введите текст для сохранения");
            return;
        }

        // Создаем новый поток для сохранения файла
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                saveToFileInInternalStorage(fileName, content);
                Looper.loop();
            }
        }).start();
    }

    private void saveToFileInInternalStorage(String fileName, String content) {
        FileOutputStream fos = null;
        try {
            // Получаем директорию внутреннего хранилища приложения
            File directory = getFilesDir();
            File file = new File(directory, fileName);

            fos = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(content);
            outputStreamWriter.close();

            // Показываем сообщение в основном потоке с помощью Handler
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    showToast("Файл успешно сохранен: " + fileName);
                    showToast(directory.toString());
                    Log.i("",directory.toString());
                    ///data/user/0/com.example.e17saveinside/files
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
            showToast("Ошибка при сохранении файла: " + e.getMessage());
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void showToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

```
AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.E17SaveInside"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/editTextFileName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Введите имя файла" />

    <EditText
        android:id="@+id/editTextContent"
        android:layout_below="@id/editTextFileName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Введите текст для сохранения" />
    <Button
        android:id="@+id/buttonSave"
        android:layout_below="@id/editTextContent"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Сохранить" />

</RelativeLayout>
```
18. **Реализовать мобильное приложение в Android Studio, в котором по нажатию на кнопку (Button) «Старт» будет запускаться фоновый сервис. В сервисе должен запускаться новый поток через WorkManager (код в отдельном потоке может быть любым). По нажатию на кнопку «Стоп» сервис должен быть остановлен, а задача WorkManager – отменена.** 
    `implementation` `"android.arch.work:work-runtime:1.0.0-alpha02"`
    Создаем класс worker
    ```java
    public class MyWorker extends Worker {
 
    static final String TAG = "workmng";
 
    @NonNull
    @Override
    public WorkerResult doWork() {
        Log.d(TAG, "doWork: start");
 
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
 
        Log.d(TAG, "doWork: end");
 
        return WorkerResult.SUCCESS;
    }
}
```


```java
Запуск
WorkManager.getInstance().enqueue(myWorkRequest);
Отмена 
WorkManager.getInstance().cancelWorkById(myWorkRequest.getId());
```
19. **Реализовать мобильное приложение в Android Studio, которое загружает содержимое интернет-страницы в лог по нажатию на кнопку (Button). Адрес интернет страницы вводит пользователь в EditText. Допускается использовать любой инструмент для работы с сетью.** 
MainActivity.java
```java
package com.example.e19web2log;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUrl;
    private Button buttonLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUrl = findViewById(R.id.editTextUrl);
        buttonLoad = findViewById(R.id.buttonLoad);

        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextUrl.getText().toString();
                loadPage(url);
            }
        });
    }

    private void loadPage(final String urlString) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        Log.d("Page Content", stringBuilder.toString());
                    } finally {
                        urlConnection.disconnect();
                    }
                } catch (IOException e) {
                    Log.e("Error", "Error while loading page", e);
                }
            }
        }).start();
    }
}

```
activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout  xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <EditText
        android:id="@+id/editTextUrl"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter URL"
        android:inputType="textUri"
        android:layout_margin="16dp"/>

    <Button
        android:id="@+id/buttonLoad"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/editTextUrl"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="16dp"
        android:text="Load Page"/>
</RelativeLayout >
```
AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.INTERNET" />
    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.E19Web2Log"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
20. **Реализовать мобильное приложение в Android Studio, которое загружает на сервер с помощью POST-запроса протокола HTTP текстовое сообщение. Текстовое сообщение вводит пользователь в поле виджета EditText. По нажатию на кнопку (Button) выполняется POST-запрос. Сообщение передается в поле «text» тела запроса. Ответ сервера необходимо отобразить в консоль. Допускается использовать любой инструмент для работы с сетью (адрес сервера и url запроса необходимо получить у преподавателя).**
    Реализация через Retrofit
    Create file Api
    ```kotlin
    package com.mirea.kt.ribo.notes.data  
  
import com.mirea.kt.ribo.notes.domain.Task  
import retrofit2.Call  
import retrofit2.http.FieldMap  
import retrofit2.http.FormUrlEncoded  
import retrofit2.http.POST  
  
  
interface MireaApi {  
    @FormUrlEncoded  
    @POST("/coursework/login.php")  
    fun getTask(@FieldMap params: Map<String, String>): Call<Task>  
  
}
```
in activity
```java
private val retrofit: Retrofit = Retrofit.Builder()  
    .baseUrl("https://android-for-students.ru/")  
    .addConverterFactory(GsonConverterFactory.create())  
    .build()  
  
private val mireaApi: MireaApi = retrofit.create(MireaApi::class.java)  
  
override suspend fun getTask(login: String, password: String, studentGroup: String): Task {  
  
    val params: MutableMap<String, String> = HashMap()  
    params["lgn"] = login  
    params["pwd"] = password  
    params["g"] = studentGroup  
  
    val call: Call<Task> = mireaApi.getTask(params)  
    val task = Task(emptyList(), -1, "", "", -1)  
  
    return suspendCoroutine {  
        call.enqueue(object : Callback<Task> {  
            override fun onResponse(call: Call<Task>, response: Response<Task>) {  
                if (response.isSuccessful) {  
                    Log.d("DEBUG_REQUEST", "SUCCESSFUL ${response.body()}")  
                    it.resume(response.body()!!)  
                } else {  
                    Log.d("DEBUG_REQUEST", "ERROR ${response.body()}")  
                    it.resume(task)  
                }  
            }  
  
            override fun onFailure(call: Call<Task>, t: Throwable) {
                Log.e("DEBUG_REQUEST", "Error sending after sending this data: $login $password")
                it.resume(task)
            }
        })
    }
}
```


**1. Реализовать** **Java-программу в** **Apache** **NetBeans** **IDE демонстрирующую**

**принципы ООП (наследование, инкапсуляция, полиморфизм) на примере**

**иерархии классов сущности** **Animal (в иерархии должно быть 3 уровня).** **В**

**данном задании проверяется понимание объектно-ориентированного подхода**

**в Java-разработке**

Ответ: [https://onlinegdb.com/xcScNTnJ9](https://onlinegdb.com/xcScNTnJ9)

(Примечание:  В этом примере есть иерархия классов, начинающаяся с базового класса Animal. У него есть два подкласса: Mammal (млекопитающее) и Bird (птица). Затем подкласс Mammal имеет свой подкласс Dog (собака).

Классы в этой иерархии демонстрируют следующие принципы ООП:

Наследование: Классы-наследники (Mammal, Dog, Bird) наследуют свойства и методы от базового класса (Animal). Например, класс Dog наследует метод eat() от класса Animal.

Инкапсуляция: Приватное поле name в классе Animal инкапсулируется и доступно только через публичные методы getName() и setName(). Таким образом, доступ к данным контролируется и ограничивается.

Полиморфизм: Методы eat() и giveBirth() в классе Dog могут быть вызваны как для объекта класса Dog, так и для объекта класса Mammal. То же самое относится к методам eat() и fly() в классе Bird. Это возможно благодаря полиморфизму.

Выполняя эту программу, вы увидите вывод, который показывает использование методов из разных классов в иерархии Animal.)

**2. Реализовать Java-программу в Apache NetBeans IDE, которая**

**преобразовывает введенную пользователем с клавиатуры строку (разворот**

**строки, перевод в нижний или верхний регистр, замена гласных и пр.). В**

**данном задании необходимо знать и уметь работать с методами классов String**

**и StringBuilder.**

```java
import java.util.Scanner;

public class StringTransformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input string: ");
        String input = scanner.nextLine();
        
        System.out.println("Reversed string: " + new StringBuilder(input).reverse().toString());
        System.out.println("String in Lower Case: " + input.toLowerCase());
        System.out.println("String in Upper Case: " + input.toUpperCase());
        System.out.println("Replace vovel: " + input.replaceAll("[aeiou]", "*"));
    }
}
```

**3. Реализовать Java-программу в Apache NetBeans IDE, вычисляет**

**максимальное и минимальное число из введенных пользователем с**

**клавиатуры числовых значений через запятую. Результат отображается в**

**консоли. В решении необходимо использовать цикл for. Проверки на**

**некорректные значения – обязательны!**

Ответ: [https://onlinegdb.com/5fj2MDNyw3](https://onlinegdb.com/5fj2MDNyw3)

(Примечание: В этом примере программа запрашивает у пользователя ввод чисел через запятую с клавиатуры. Затем она разделяет введенную строку на отдельные числа с помощью метода split(","), который разбивает строку на подстроки, используя запятую в качестве разделителя.

Затем программа использует цикл for для итерации по массиву чисел. В каждой итерации число преобразуется из строки в целочисленное значение с помощью метода parseInt() класса Integer. Если преобразование не удалось (например, введенное значение не является числом), будет сгенерировано исключение NumberFormatException, и программа выведет сообщение об ошибке.

Внутри цикла программа обновляет значения переменных min и max, чтобы сохранить минимальное и максимальное числа соответственно.

По завершении цикла программа выводит на экран найденные минимальное и максимальное числа.

Если введены некорректные значения, программа выведет сообщение об ошибке.)

**4. Реализовать Java-программу в Apache NetBeans IDE, выполняющую**

**вывод в консоль сортированных по возрасту сущностей типа Person, (объекты**

**хранятся в ArrayList). В решении необходимо использовать интерфейс**

**Comparable. Заполнение коллекции происходит в коде программы (минимум**

**3 элемента коллекции).**

Ответ: [https://onlinegdb.com/GBCu8em_o](https://onlinegdb.com/GBCu8em_o)

(Примечание: В этом примере программа создает класс Person, который реализует интерфейс Comparable. Класс Person имеет два поля: name (имя) и age (возраст).

В методе compareTo() класса Person реализована логика сравнения двух объектов Person по их возрасту. Метод compareTo() возвращает отрицательное число, ноль или положительное число, в зависимости от того, какой объект Person должен быть рассмотрен как меньший, равный или больший при сортировке.

В методе main() программа создает список persons, заполняет его несколькими объектами Person и затем вызывает метод Collections.sort(), чтобы отсортировать список по возрасту.

Затем программа выводит отсортированный список в консоль.

Результат выполнения программы будет отображать сущности Person, отсортированные по возрасту.)

**5. Реализовать Java-программу в Apache NetBeans IDE, выполняющую**

**вывод в консоль отсортированного по значению ключа HashMap (ключ – типа**

**String). Инициализировать HashMap допускается напрямую в коде программы**

**(минимум 5 значений).**

Ответ: [https://onlinegdb.com/B_xEay7Mo](https://onlinegdb.com/B_xEay7Mo)

(Примечание: В этом примере программа создает HashMap с типом ключа String и типом значения Integer. Затем программа напрямую в коде программы инициализирует HashMap с несколькими парами ключ-значение.

Для сортировки HashMap по значению ключа, программа сначала преобразует HashMap в список Map.Entry. Затем используется Collections.sort() для сортировки списка с помощью компаратора, который сравнивает значения ключей в каждой записи Map.Entry.

После сортировки программа выводит отсортированные записи HashMap в консоль.

Результат выполнения программы будет отображать отсортированные значения HashMap по значению ключа.)

**6. Реализовать Java-программу в Apache NetBeans IDE, сохраняющую в**

**файл строку, которую введет пользователь с клавиатуры. Путь к файлу**

**допускается задать в коде программы.**

Ответ: [https://onlinegdb.com/rBzv2fz5F](https://onlinegdb.com/rBzv2fz5F)

(Примечание: В этом примере программа запрашивает у пользователя ввод строки с клавиатуры с помощью объекта Scanner и сохраняет введенную строку в переменную input.

Затем программа задает путь к файлу, в котором будет сохранена строка. Замените "C:\\path\\to\\file.txt" на путь к желаемому файлу. Убедитесь, что у вас есть права на запись в указанную директорию.

Далее программа открывает BufferedWriter для записи данных в файл, используя FileWriter. В блоке try-with-resources строка записывается в файл с помощью метода write().

Если сохранение прошло успешно, программа выводит сообщение "Строка успешно сохранена в файле". В случае ошибки при сохранении, программа выводит сообщение об ошибке.)

**7. Реализовать Java-программу в Apache NetBeans IDE, которая загружает содержимое текстового файла, делает над ним некоторые преобразования (например, разворот строки) и выводит полученное значение в консоль. Путь к файлу вводит пользователь с клавиатуры. Проверки на некорректные значения – обязательны!**

Ответ: [https://onlinegdb.com/_C1dZQ0FI](https://onlinegdb.com/_C1dZQ0FI)

(Примечание: В этом примере программа запрашивает у пользователя ввод пути к файлу с помощью объекта Scanner и сохраняет введенный путь в переменную filePath.

Затем программа открывает BufferedReader для чтения содержимого файла, используя FileReader. В блоке try-with-resources программа читает содержимое файла построчно и сохраняет его в объекте StringBuilder.

После чтения файла, вы можете применить любые необходимые преобразования к содержимому. В этом примере мы просто разворачиваем строку, используя метод reverse() у объекта StringBuilder.

Затем программа выводит преобразованное содержимое файла в консоль.

Если чтение файла прошло успешно, программа выводит содержимое файла после преобразования. В случае ошибки при чтении файла, программа выводит сообщение об ошибке.)

**8. Реализовать Java-программу в Apache NetBeans IDE, которая сериализует в файл экземпляр класса сущности Person или Animal. Путь к файлу вводит пользователь с клавиатуры.**

Ответ: [https://onlinegdb.com/uBdwh2h_B](https://onlinegdb.com/uBdwh2h_B)

(Примечание: В этом примере программа запрашивает у пользователя ввод пути к файлу с помощью объекта Scanner и сохраняет введенный путь в переменную filePath.

Затем программа создает экземпляр класса Person или Animal (в зависимости от вашего выбора) и инициализирует его.

Затем программа открывает FileOutputStream и ObjectOutputStream для записи экземпляра класса в файл. В блоке try-with-resources программа сериализует экземпляр класса в файл с помощью метода writeObject().

Если сериализация прошла успешно, программа выводит сообщение об успешной сериализации. В случае ошибки при сериализации, программа выводит сообщение об ошибке.

Примечание: Перед запуском этой программы убедитесь, что у вас уже определен класс Person или Animal с соответствующими полями и методами. Закомментируйте лишний код, в зависимости от выбранного класса (Person или Animal).

**9. Реализовать Java-программу в Apache NetBeans IDE, которая вычисляет площадь прямоугольника в отдельном потоке и выводит результат в консоль. Создание потока должно быть реализовано с использованием интерфейса Runnable. Значения сторон вводит пользователь с клавиатуры. Проверки на некорректные значения – обязательны!**

Ответ: [https://onlinegdb.com/ldAMMq4Qe](https://onlinegdb.com/ldAMMq4Qe)

(Примечание: В этом примере программа запрашивает у пользователя ввод длины и ширины прямоугольника с помощью объекта Scanner и сохраняет введенные значения в переменные length и width.

Затем программа проверяет значения сторон прямоугольника на некорректность (отрицательные или нулевые значения). Если значения некорректны, программа выводит сообщение об ошибке и завершает выполнение.

Если значения сторон прямоугольника корректны, программа создает экземпляр RectangleAreaCalculator, передавая в конструктор введенные значения сторон прямоугольника. Затем программа создает поток Thread, передавая в конструктор экземпляр RectangleAreaCalculator. После этого поток запускается методом start().

В методе run() реализуется вычисление площади прямоугольника и вывод результата в консоль.)

**10. Реализовать Java-программу в Apache NetBeans IDE, которая вычисляет в отдельном потоке факториал введенного пользователем числа с клавиатуры и выводит полученное значение в консоль. Необходимо использовать цикл for. Создание потока должно быть реализовано с использованием наследника класса Thread. Проверки на некорректные значения – обязательны!**

Ответ: [https://onlinegdb.com/hmzVX7hpT](https://onlinegdb.com/hmzVX7hpT)

(Примечание: В этом примере программа запрашивает у пользователя ввод числа с помощью объекта Scanner и сохраняет введенное значение в переменную number.

Затем программа проверяет значение числа на некорректность (отрицательное число). Если значение некорректно, программа выводит сообщение об ошибке и завершает выполнение.

Если значение числа корректно, программа создает экземпляр FactorialCalculator, передавая в конструктор введенное значение числа. Затем программа вызывает метод start() для запуска потока.

В методе run() реализуется вычисление факториала числа с использованием цикла for и вывод результата в консоль.)

**11. Дан исходный код Java-программы. При запуске программы, возникает ошибка. Провести отладку программы (debugging), выявить в каких участках программы возникают ошибки, исправить их, запустить рабочий вариант. В данном задании проверяются знания темы обработки исключений, а также умение работы с отладчиком Apache NetBeans IDE.**

Ответ: Откройте ваш проект в Apache NetBeans IDE.

Убедитесь, что в настройках проекта включен режим отладки. Для этого перейдите в "Project Properties" (свойства проекта) и выберите "Run" (запуск). Убедитесь, что установлен флажок "Enable debugging" (включить отладку).

Откройте файл с проблемным кодом.

Разместите точки останова (breakpoints) в участках кода, где вы хотите остановить выполнение программы для анализа состояния переменных или выполнения пошаговой отладки. Чтобы разместить точку останова, щелкните на левой стороне строки кода рядом с нужной строкой. Вы увидите красную иконку точки останова.

Запустите программу в режиме отладки. Для этого выберите пункт меню "Debug" (отладка) и "Debug Project" (отладить проект). Вы также можете использовать горячие клавиши (обычно F5 или Ctrl+F5) для запуска программы в режиме отладки.

При выполнении программы она остановится на точках останова, и вы сможете анализировать состояние переменных, выполнять пошаговую отладку и следить за выполнением кода.

Используйте различные инструменты отладчика, такие как панель "Variables" (переменные), "Call Stack" (стек вызовов) и "Output" (вывод), чтобы получить полезную информацию о выполнении программы и выявить возможные ошибки.

Если вы обнаружите ошибку, исправьте соответствующий участок кода.

Повторите шаги 6-8, пока не устраните все ошибки.

Запустите программу в нормальном режиме (не отладке), чтобы убедиться, что она работает без ошибок.

**12. Реализовать мобильное приложение в Android Studio, которое складывает два целых числа, введенных пользователем в поля ввода. Результат вычисления необходимо отобразить в виджете TextView после нажатия на кнопку (Button). В макете activity разрешено использовать контейнеры только одного типа: LinearLayout. Проверки на некорректные значения – обязательны!**

Ответ: Для реализации мобильного приложения, выполняющего сложение двух целых чисел, введенных пользователем, и отображающего результат в виджете TextView, вам потребуется следовать нескольким шагам:

Шаг 1: Настройка проекта в Android Studio

Откройте Android Studio и создайте новый проект.

Укажите имя приложения, выберите минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Создайте новую активность (Activity) с пустым макетом.

Шаг 2: Разработка макета (layout)

Откройте файл макета активности (activity_main.xml) в режиме макета.

Используя LinearLayout, разместите в нем виджеты EditText для ввода чисел, Button для выполнения сложения и TextView для отображения результата.

Настройте атрибуты виджетов, такие как идентификаторы (id), ориентацию LinearLayout и другие атрибуты по вашему усмотрению.

Шаг 3: Обработка событий

В Java-коде активности (MainActivity.java) найдите ссылки на виджеты EditText, Button и TextView, объявив соответствующие переменные.

В методе onCreate() установите обработчик события нажатия на кнопку следующим образом: ![](file:///C:/Users/TECHNO~1/AppData/Local/Temp/msohtmlclip1/01/clip_image001.png) В обработчике события получите значения из EditText, выполните сложение и установите результат в TextView.

Шаг 4: Проверка на некорректные значения

Перед выполнением сложения, убедитесь, что значения, введенные пользователем, являются корректными целыми числами. Можно использовать методы, такие как parseInt() для преобразования строк в числа и try-catch блоки для обработки исключений при некорректном вводе.

Если ввод некорректен, выведите сообщение об ошибке или предупреждение.

Шаг 5: Запуск приложения

Подключите устройство Android или эмулятор и запустите ваше приложение в Android Studio.

Введите два целых числа в EditText и нажмите кнопку, чтобы выполнить сложение.

Результат сложения должен отобразиться в TextView.

**13. Реализовать мобильное приложение в Android Studio, которое перемножает три целых числа, введенных пользователем в поля ввода (EditText). Результат вычисления отобразить в лог после нажатия на кнопку (Button). В макете activity разрешено использовать контейнеры только одного типа – RelativeLayout. В приложении необходимо использовать Library Data Binding для привязки виджетов. Проверки на некорректные значения – обязательны!**

Ответ: Шаг 1: Настройка проекта в Android Studio

Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Разработка макета (layout) с использованием RelativeLayout

Откройте файл макета активности (activity_main.xml) и замените его содержимое следующим кодом:

[https://onlinegdb.com/GsRMikHUY](https://onlinegdb.com/GsRMikHUY)

Шаг 3: Настройка Library Data Binding

Откройте файл Gradle (build.gradle) для вашего модуля приложения и добавьте следующую строку внутри блока android: ![](file:///C:/Users/TECHNO~1/AppData/Local/Temp/msohtmlclip1/01/clip_image002.png)

После этого синхронизируйте проект.

Шаг 4: Создание ViewModel

Создайте новый класс Kotlin с именем MultiplyViewModel и добавьте в него следующий код:

[https://onlinegdb.com/EfS8ZLU1H](https://onlinegdb.com/EfS8ZLU1H)

Шаг 5: Обновление MainActivity

Откройте файл MainActivity.kt и обновите его следующим образом:

[https://onlinegdb.com/2LtfTjccW](https://onlinegdb.com/2LtfTjccW)

Шаг 6: Запуск и проверка приложения

После завершения всех шагов, запустите приложение на эмуляторе или реальном устройстве и проверьте его работоспособность. При вводе трех чисел и нажатии на кнопку, результат перемножения должен быть выведен в логе Android Studio.

Обратите внимание, что это общая структура реализации. Вам может потребоваться внести некоторые изменения и дополнения в зависимости от ваших конкретных требований и дизайна приложения.

**14. Реализовать мобильное приложение в Android Studio, состоящее из двух activity, таким образом, чтобы в первую activity вернулся результат какой-то операции из второй activity. Подробнее: Вторая activity запускается по нажатию на кнопку (Button) в первой activity. Во второй activity пользователь вводит какое-то значение в EditText и нажимает на кнопку (Button). После этого приложение возвращается в первую activity и отображает в поле TextView значение, введенное пользователем.**

Ответ: Шаг 1: Создание проекта в Android Studio

Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Создание макетов (layouts)

Откройте файл макета первой activity (activity_main.xml) и замените его содержимое следующим кодом:

[https://onlinegdb.com/lUFlbkSnc](https://onlinegdb.com/lUFlbkSnc)

Откройте файл макета второй activity (activity_second.xml) и замените его содержимое следующим кодом:

[https://onlinegdb.com/vTYIoUYWY](https://onlinegdb.com/vTYIoUYWY)

Шаг 3: Создание классов активностей (Activity)

Создайте новую Kotlin-класс с именем SecondActivity и добавьте в него следующий код:

[https://onlinegdb.com/aVUk4mVw5](https://onlinegdb.com/aVUk4mVw5)

Затем откройте файл MainActivity.kt и обновите его следующим образом:

[https://onlinegdb.com/XcjeXnuV1](https://onlinegdb.com/XcjeXnuV1)

Шаг 4: Запуск и проверка приложения

После завершения всех шагов, запустите приложение на эмуляторе или реальном устройстве. При нажатии на кнопку "Open Second Activity" в первой activity, откроется вторая activity, где вы сможете ввести значение в EditText. После нажатия кнопки "Return Result", приложение вернется в первую activity, и введенное значение будет отображено в TextView с префиксом "Result: ".

Обратите внимание, что это общая структура реализации. Вам может потребоваться внести некоторые изменения и дополнения в зависимости от ваших конкретных требований и дизайна приложения.

**15. Реализовать мобильное приложение в Android Studio, с помощью которого по нажатию кнопки (Button) можно поделиться текстом из виджета EditText через другое приложение (мессенджеры, смс и т.п.). В приложении необходимо использовать Library Data Binding для привязки виджетов.**

Ответ: Для реализации мобильного приложения в Android Studio, которое позволяет поделиться текстом из виджета EditText через другое приложение, и при этом использует Library Data Binding, выполните следующие шаги:

Шаг 1: Создание проекта в Android Studio

Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Добавление зависимости для Data Binding

Откройте файл build.gradle (Module: app) и убедитесь, что следующая зависимость присутствует в блоке dependencies:

 ![](file:///C:/Users/TECHNO~1/AppData/Local/Temp/msohtmlclip1/01/clip_image003.png)

Шаг 3: Создание макета (layout)

Откройте файл макета (activity_main.xml) и замените его содержимое следующим кодом:

[https://onlinegdb.com/_dfKFPKbBs](https://onlinegdb.com/_dfKFPKbBs)

Шаг 4: Создание класса ViewModel

Создайте новый Kotlin-класс с именем MainViewModel и добавьте в него следующий код:

[https://onlinegdb.com/a7FvdhQ4GH](https://onlinegdb.com/a7FvdhQ4GH)

Шаг 5: Обновление MainActivity

Откройте файл MainActivity.kt и обновите его следующим образом:

[https://onlinegdb.com/tdD2zyexs](https://onlinegdb.com/tdD2zyexs)

Шаг 6: Запуск и проверка приложения

После завершения всех шагов, запустите приложение на эмуляторе или реальном устройстве. Вы увидите макет с EditText и кнопкой Share. При вводе текста в EditText и нажатии на кнопку Share, приложение откроет системное диалоговое окно выбора приложений для отправки текста.

Обратите внимание, что это общая структура реализации. Вам может потребоваться внести некоторые изменения и дополнения в зависимости от ваших конкретных требований и дизайна приложения.

**16. Реализовать мобильное приложение в Android Studio, в котором по нажатию на кнопку (Button) будет заменяться содержимое экрана, расположенного ниже кнопки (см. лекцию 2.7, слайд 38). При выполнении задания обязательно использовать фрагменты (динамическая регистрация). Содержимое экранов может быть любое.**

Ответ: Шаг 1: Создание проекта в Android Studio

Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Создание макета (layout) для активности

Откройте файл макета (activity_main.xml) и разместите на нем кнопку и контейнер для отображения фрагментов. Ниже приведен пример кода для макета:

[https://onlinegdb.com/7BK2DPPuq](https://onlinegdb.com/7BK2DPPuq)

Шаг 3: Создание фрагментов

Создайте классы фрагментов, которые будут отображаться при замене содержимого. Например, создайте два фрагмента с именами Fragment1 и Fragment2. Каждый фрагмент должен иметь свой макет (layout).

[https://onlinegdb.com/QlRX25W_T](https://onlinegdb.com/QlRX25W_T)

Шаг 4: Обновление MainActivity

Откройте файл MainActivity.kt и обновите его следующим образом:

[https://onlinegdb.com/wWSoAj1Qv](https://onlinegdb.com/wWSoAj1Qv)

Шаг 5: Создание макетов для фрагментов

Создайте макеты (layout) для каждого фрагмента (fragment1.xml и fragment2.xml) и добавьте на них содержимое, которое вы хотите отобразить.

Шаг 6: Запуск приложения

Соберите и запустите приложение на эмуляторе или реальном устройстве. После нажатия на кнопку "Change Content" будет заменяться содержимое экрана ниже кнопки.

Обратите внимание, что в коде используется динамическая регистрация фрагментов с помощью FragmentManager и FragmentTransaction. Когда пользователь нажимает кнопку, мы проверяем, какой фрагмент отображается в данный момент, и заменяем его на другой фрагмент.

**17. Реализовать мобильное приложение в Android Studio, содержащее в ActionBar activity меню из нескольких пунктов. По нажатию на пункт меню на экран должно выводиться всплывающее сообщение. Иконки для пунктов меню можно загружать здесь:** [**https://romannurik.github.io/AndroidAssetStudio/index.html**](https://romannurik.github.io/AndroidAssetStudio/index.html)**.**

Шаг 1: Создание проекта в Android Studio Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Создание меню Создайте новый ресурс для меню, открыв файл **res/menu/main_menu.xml** и добавив следующий код:

[https://onlinegdb.com/d0VGkCs4P](https://onlinegdb.com/d0VGkCs4P)

Замените **@drawable/ic_menu_item1**, **@drawable/ic_menu_item2** и **@drawable/ic_menu_item3** на реальные пути к иконкам, которые вы загрузили с помощью Android Asset Studio.

Шаг 3: Обновление ActionBar activity Откройте файл **MainActivity.kt** (или **MainActivity.java**) и обновите его следующим образом:

[https://onlinegdb.com/uxxTauIjH](https://onlinegdb.com/uxxTauIjH)

Шаг 4: Запуск приложения

Соберите и запустите приложение на эмуляторе или реальном устройстве. В ActionBar должно отображаться меню с иконками и пунктами. При нажатии на каждый пункт будет выводиться соответствующее всплывающее сообщение.

Обратите внимание, что в коде используется метод onCreateOptionsMenu для создания меню и onOptionsItemSelected для обработки нажатий на пункты меню. Функция showToast используется для вывода всплывающего сообщения с помощью Toast.makeText.

**18. Реализовать мобильное приложение в Android Studio, в котором при нажатии на кнопку (Button) создается база данных SQLite с таблицей для хранения списка студентов (имя, фамилия, номер группы, возраст).**

Ответ: Шаг 1: Создание проекта в Android Studio

Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Добавление зависимости SQLite в build.gradle

Откройте файл build.gradle (Module: app) и убедитесь, что в разделе dependencies добавлена зависимость для SQLite:![](file:///C:/Users/TECHNO~1/AppData/Local/Temp/msohtmlclip1/01/clip_image004.png)

Шаг 3: Создание модели данных студента Создайте новый Kotlin-класс (или Java-класс) с именем **Student** и определите поля для имени, фамилии, номера группы и возраста студента. Например:

![](file:///C:/Users/TECHNO~1/AppData/Local/Temp/msohtmlclip1/01/clip_image005.png)

Шаг 4: Создание класса для работы с базой данных

Создайте новый Kotlin-класс (или Java-класс) с именем DatabaseHelper, который будет отвечать за создание и управление базой данных. В этом классе вы можете определить методы для создания таблицы, добавления студентов, получения списка студентов и т.д. Вот пример реализации:

[https://onlinegdb.com/p_BLObDBO](https://onlinegdb.com/p_BLObDBO)

Шаг 5: Добавление пользовательского интерфейса

Откройте файл макета для вашей activity и добавьте на него кнопку (Button) с помощью XML-разметки. Например:

[https://onlinegdb.com/HWTh_0wuk](https://onlinegdb.com/HWTh_0wuk)

Шаг 6: Обработка нажатия на кнопку

Откройте файл Kotlin-класса (или Java-класса) для вашей activity и добавьте метод addStudent, который будет вызываться при нажатии на кнопку. В этом методе вы можете создать экземпляр класса DatabaseHelper и использовать его для добавления нового студента в базу данных. Вот пример реализации:

[https://onlinegdb.com/g4yarZMWA](https://onlinegdb.com/g4yarZMWA)

После завершения этих шагов у вас будет мобильное приложение, которое создает базу данных SQLite и добавляет студента при нажатии на кнопку "Add Student". Вы можете добавить другие функции, такие как отображение списка студентов или редактирование данных, в соответствии с вашими потребностями.

**19. Реализовать мобильное приложение в Android Studio, в котором значение, записанное в поле виджета EditText, сохраняется в хранилище SharedPreferces при нажатии на кнопку (Button). При нажатии на вторую кнопку, значение загружается из SharedPreferences и отображается в лог (или любым другим образом).**

Ответ: Шаг 1: Создание проекта в Android Studio

Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Добавление элементов пользовательского интерфейса

Откройте файл макета для вашей activity и добавьте на него две кнопки (Button) и одно поле ввода (EditText) с помощью XML-разметки. Например:

[https://onlinegdb.com/pDYAhjFw9s](https://onlinegdb.com/pDYAhjFw9s)

Шаг 3: Обработка нажатия на кнопки Откройте файл Kotlin-класса (или Java-класса) для вашей activity и добавьте два метода: **saveValue** и **loadValue**. Метод **saveValue** будет вызываться при нажатии на кнопку "Save" и будет сохранять значение из поля EditText в SharedPreferences. Метод **loadValue** будет вызываться при нажатии на кнопку "Load" и будет загружать значение из SharedPreferences и выводить его в лог или в другом месте. Вот пример реализации:

[https://onlinegdb.com/Oj7c9y_6zP](https://onlinegdb.com/Oj7c9y_6zP)

В методе saveValue мы получаем значение из поля EditText, создаем экземпляр редактора SharedPreferences, сохраняем значение под ключом "saved_value" и применяем изменения. В методе loadValue мы загружаем значение из SharedPreferences, используя ключ "saved_value", и выводим его в лог с помощью Log.d.

После завершения этих шагов у вас будет мобильное приложение, которое сохраняет значение из поля EditText в хранилище SharedPreferences при нажатии на кнопку "Save" и загружает его при нажатии на кнопку "Load". Вы можете изменить обработку загруженного значения в соответствии с вашими потребностями.

**20. Реализовать мобильное приложение в Android Studio, в котором значение, записанное в поле виджета EditText, сохраняется в файл во внутренней памяти устройства при нажатии на кнопку (Button). Имя файла задает пользователь (вводит во второй EditText).**

Ответ: Шаг 1: Создание проекта в Android Studio

Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Добавление элементов пользовательского интерфейса

Откройте файл макета для вашей activity и добавьте на него два виджета EditText для ввода значения и имени файла, а также кнопку (Button) для сохранения. Например:

[https://onlinegdb.com/kL-R9C7rQ](https://onlinegdb.com/kL-R9C7rQ)

Шаг 3: Обработка нажатия на кнопку

Откройте файл Kotlin-класса (или Java-класса) для вашей activity и добавьте метод saveToFile, который будет вызываться при нажатии на кнопку "Save" и будет сохранять значение из поля EditText в файл во внутренней памяти устройства с заданным именем файла. Вот пример реализации:

[https://onlinegdb.com/xElWplrA6](https://onlinegdb.com/xElWplrA6)

В методе **saveToFile** мы получаем значения из полей EditText, создаем экземпляр класса File для указанного имени файла во внутренней памяти устройства (**filesDir**), открываем **FileOutputStream**, записываем значение в файл в виде байтов и закрываем **FileOutputStream**.

После завершения этих шагов у вас будет мобильное приложение, которое сохраняет значение из поля EditText в файл во внутренней памяти устройства при нажатии на кнопку "Save".

**21. Реализовать мобильное приложение в Android Studio, в котором по нажатию на первую кнопку (Button) будет запускаться фоновый сервис. По нажатию на вторую кнопку сервис должен быть остановлен. Вызовы методов жизненного цикла activity и сервиса должны логироваться.**

Ответ: Шаг 1: Создание проекта в Android Studio Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Добавление элементов пользовательского интерфейса Откройте файл макета для вашей activity и добавьте две кнопки (Button) - одну для запуска сервиса и другую для остановки. Например:

[https://onlinegdb.com/DkiWNZsAAv](https://onlinegdb.com/DkiWNZsAAv)

Шаг 3: Создание класса сервиса Создайте новый класс для вашего фонового сервиса, который будет расширять класс Service. В этом классе вы можете реализовать необходимую логику и методы жизненного цикла сервиса. Например:

[https://onlinegdb.com/_pZhe8Qgze](https://onlinegdb.com/_pZhe8Qgze)

В этом примере мы переопределили методы onCreate, onStartCommand и onDestroy для логирования их вызовов.

Шаг 4: Добавление кода в Activity

Откройте файл Kotlin-класса (или Java-класса) для вашей activity и добавьте методы startService и stopService, которые будут вызываться при нажатии на соответствующие кнопки и будут запускать и останавливать фоновый сервис. Вот пример реализации:

[https://onlinegdb.com/6Fxo168gly](https://onlinegdb.com/6Fxo168gly)

В методе **startService** мы создаем интент для запуска сервиса и вызываем метод **startService**, а в методе **stopService** мы создаем интент для остановки сервиса и вызываем метод **stopService**. При каждом вызове этих методов мы также логируем информацию.

После завершения этих шагов у вас будет мобильное приложение, которое может запускать фоновый сервис по нажатию на первую кнопку и останавливать его по нажатию на вторую кнопку, и при этом логировать вызовы методов жизненного цикла activity и сервиса.

**22. Реализовать мобильное приложение в Android Studio, которое при смене языка на устройстве выводит всплывающее сообщение (Toast) на экран и пишет эту информацию в лог (или в текстовый файл на устройстве)**

Ответ: Шаг 1: Создание проекта в Android Studio Создайте новый проект в Android Studio и укажите имя приложения, минимальную поддерживаемую версию Android и другие настройки по вашему усмотрению.

Шаг 2: Добавление кода в MainActivity Откройте файл Kotlin-класса (или Java-класса) для вашей MainActivity. В этом классе вы будете обрабатывать событие смены языка. Добавьте следующий код в метод **onCreate**:

[https://onlinegdb.com/Uem9eWKyC](https://onlinegdb.com/Uem9eWKyC)

Мы переопределили метод **onConfigurationChanged**, который будет вызываться при смене конфигурации, включая смену языка. В этом методе мы получаем новый язык из объекта **Configuration**, формируем сообщение, вызываем метод **showToast** для вывода сообщения в виде всплывающего Toast и метод **writeToLog** для записи сообщения в лог или в текстовый файл на устройстве.

При необходимости вы можете раскомментировать соответствующие строки в методе **writeToLog**, чтобы выбрать, куда записывать информацию (лог или текстовый файл).

Обратите внимание, что для записи в текстовый файл на устройстве вам потребуется разрешение **WRITE_EXTERNAL_STORAGE** в файле манифеста.( <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" /> )

**23. Реализовать мобильное приложение в Android Studio, которое при разблокировке ("android.intent.action.USER_PRESENT") устройства выводит всплывающее сообщение на экран (Toast) и пишет эту информацию в лог.**

Ответ: Вот пример реализации такого приложения в Android Studio:

1. Создайте новый проект в Android Studio.
2. В файле манифеста (**AndroidManifest.xml**) добавьте следующие разрешения и объявления:

[https://onlinegdb.com/0kttNJqAG](https://onlinegdb.com/0kttNJqAG)

3.      Создайте новый Java-класс с именем MyBroadcastReceiver, который будет наследоваться от BroadcastReceiver:

[https://onlinegdb.com/yH1PFcFO7](https://onlinegdb.com/yH1PFcFO7)

Теперь, когда устройство будет разблокировано, всплывающее сообщение Toast будет отображаться, а информация будет записана в лог.

Обратите внимание, что для того чтобы ваш BroadcastReceiver работал после перезагрузки устройства, в манифесте мы добавили <action android:name="android.intent.action.BOOT_COMPLETED" />. Это позволяет приложению получать системное событие после перезагрузки устройства и затем реагировать на событие разблокировки.

Также не забудьте добавить необходимые разрешения в манифесте, в данном случае RECEIVE_BOOT_COMPLETED, чтобы приложение могло получать уведомления о перезагрузке устройства.

**24. Реализовать мобильное приложение в Android Studio, которое загружает содержимое интернет-страницы (по сути, выполняет GET-запрос) в лог по нажатию на кнопку (Button). Адрес интернет страницы вводит пользователь в EditText. Допускается использовать любой инструмент для работы с сетью.**

Ответ: Для реализации загрузки содержимого интернет-страницы в мобильном приложении Android Studio и вывода его в лог при нажатии на кнопку, вы можете использовать класс **HttpURLConnection** для выполнения GET-запроса. Ниже приведен пример кода, который выполняет такую задачу:

1. Откройте файл макета (**activity_main.xml**) и добавьте **EditText** для ввода адреса страницы и **Button** для выполнения запроса:

[https://onlinegdb.com/hksvSgQ_G](https://onlinegdb.com/hksvSgQ_G)

2.      Откройте файл активности (MainActivity.java) и добавьте следующий код:

[https://onlinegdb.com/unik3ljoK](https://onlinegdb.com/unik3ljoK)

В этом примере при нажатии на кнопку **loadButton** будет выполнен GET-запрос по введенному адресу страницы из **urlEditText**. Полученное содержимое страницы будет выведено в лог с помощью **Log.d()**. Обратите внимание, что в данном примере кода выполняется запрос в главном потоке, но для реального приложения рекомендуется выполнять сетевые операции в фоновом потоке, чтобы не блокировать пользовательский интерфейс.

**25. Дан исходный код Android-приложения. При запуске приложения (или после нажатия на кнопку) возникает ошибка. Провести отладку программы (debugging), выявить в каких участках программы возникает ошибка, исправить ее, запустить рабочий вариант. В данном задании проверяются знания темы обработки исключений, а также умение работы с отладчиком Android Studio.**

1. Ответ: Откройте проект в Android Studio: Откройте свой проект в Android Studio, убедитесь, что вы находитесь в режиме отладки (Debug mode).
2. Установите точки останова (Breakpoints): Выберите место в коде, где вы хотите остановить выполнение программы. Щелкните слева от нужной строки кода, чтобы установить точку останова. Точка останова обозначается красным кружком.
3. Запустите отладку: Нажмите кнопку "Debug" или выберите в меню "Run" -> "Debug" для запуска приложения в режиме отладки.
4. Используйте отладчик: Когда приложение достигает точки останова, выполнение приостанавливается, и вы можете использовать отладчик для анализа состояния программы. В окне отладчика вы можете просмотреть значения переменных, выполнить шаги по коду (Step Into, Step Over, Step Out), анализировать стек вызовов и многое другое.
5. Исправление ошибок: Когда вы обнаружите ошибку, используйте отладчик для идентификации проблемного кода и исправления ошибок. Вы можете изменять значения переменных, пропускать ненужные шаги, устанавливать условия остановки и т.д.
6. Продолжайте выполнение программы: После исправления ошибки и проверки работоспособности программы вы можете продолжить выполнение приложения, нажав кнопку "Resume" в окне отладчика.
7. Анализируйте результаты: После выполнения программы приступайте к анализу результатов, проверьте правильность работы и убедитесь, что ошибки были исправлены.

Процесс отладки может варьироваться в зависимости от конкретных сценариев и проблем, с которыми вы сталкиваетесь. Однако, общий подход, описанный выше, поможет вам начать отладку вашего Android-приложения в Android Studio.




Теория
1. Типы данных в Java. Циклы, операторы ветвления.
   boolean: логический тип данных, принимающий значение true или false.
   int: целое число размером 4 байта (32 бита), диапазон от -2^31 до 2^31-1.
   float: число с плавающей точкой одинарной точности размером 4 байта (32 бита).
   char: одиночный символ, размером 2 байта (16 бит), представленный в кодировке Unicode.
   String в Java предназначен для работы со строками в Java. Все строковые литералы, определенные в Java программе (например, "abc") — это экземпляры класса String.
   Цикл for
   Используется для повторного выполнения блока кода фиксированное количество раз.
   Цикл while
   Выполняет блок кода, пока условие истинно.
   Цикл do-while
   Выполняет блок кода хотя бы один раз, а затем продолжает выполнение, пока условие истинно.
   Цикл for-each
   Используется для перебора элементов коллекций (например, массивов, списков)..
   Оператор if-else
   Выполняет один блок кода, если условие истинно, и другой, если ложно.
   Оператор switch
   Позволяет выбрать один из нескольких блоков кода для выполнения.x
2. Понятие ООП. Класс. Переменные и методы класса. Конструкторы. Ключевое слово super.
   Объектно-ориентированное программирование (ООП) представляет собой подход, который рассматривает программу в качестве набора объектов, взаимодействующих между собой. Каждый из этих объектов имеет свои характеристики и поведение. ООП помогает ускорить процесс написания кода и сделать его более читаемым.
1. Класс
   Класс — это шаблон или чертёж для создания объектов. Он определяет атрибуты (переменные) и поведение (методы), которые будут присущи объектам данного класса.
2. Переменные класса
   Переменные класса — это переменные, которые принадлежат классу, а не конкретному объекту. Они делятся на два вида:
   Атрибуты класса (class attributes): общие для всех экземпляров класса.
   Атрибуты экземпляра (instance attributes): уникальные для каждого экземпляра класса.
3. Методы класса
   Методы класса — это функции, которые определены внутри класса и работают с его атрибутами. Они позволяют объектам взаимодействовать с данными и выполнять действия.
4. Конструкторы
   Конструктор — это специальный метод класса, который вызывается автоматически при создании нового экземпляра класса.
   Ключевое слово super
   Ключевое слово super используется для вызова методов базового класса из производного класса. Это полезно, когда необходимо расширить или модифицировать поведение метода базового класса.


3. Принципы ООП. Какие, как и для чего?
   Принципы ООП:
1. Инкапсуляция
   Инкапсуляция — это механизм скрытия внутренней реализации объекта и предоставление доступа к нему только через публичные методы. Это позволяет защитить данные объекта от некорректного использования и изменения.
2. Наследование
   Наследование позволяет создавать новый класс на основе существующего класса. Новый класс (производный или дочерний) наследует атрибуты и методы базового (родительского) класса, что позволяет использовать повторно код и расширять функциональность.
3. Полиморфизм
   Полиморфизм позволяет использовать один интерфейс для разных типов данных. Это означает, что один и тот же метод может работать по-разному в зависимости от того, на каком объекте он вызывается.
4. Абстракция
   Абстракция — это принцип ООП, согласно которому при проектировании классов и создании объектов необходимо выделять только главные свойства сущности, и отбрасывать второстепенные. Абстрактный класс — это класс, который не может быть создан как объект, и часто содержит один или несколько абстрактных методов, которые должны быть реализованы в дочерних классах.
4. Интерфейсы и абстрактные классы. Отличия. Как создавать и использовать?
   Абстрактные классы
   Абстрактный класс в Java - это класс, который не может быть инстанцирован и может содержать абстрактные методы (без реализации), а также методы с реализацией. Классы, которые наследуют абстрактный класс, должны реализовать все его абстрактные методы.
   Интерфейсы
   Интерфейс в Java - это контракт, который класс должен соблюдать. Интерфейс определяет набор методов без реализации. Класс, который реализует интерфейс, должен реализовать все его методы. Начиная с Java 8, интерфейсы могут содержать методы с реализацией (default и static методы).
   Отличия между абстрактными классами и интерфейсами
   Реализация методов:
   Абстрактные классы: могут содержать как абстрактные методы (без реализации), так и методы с реализацией.
   Интерфейсы: до Java 8 могли содержать только абстрактные методы, с Java 8 могут также содержать методы с реализацией (default и static методы).
   Наследование:
   Абстрактные классы: класс может наследовать только один абстрактный класс из-за ограничения на единственное наследование в Java.
   Интерфейсы: класс может реализовывать множество интерфейсов, что позволяет множественное наследование типов.
   Использование полей:
   Абстрактные классы: могут содержать поля (переменные) и методы, работающие с этими полями.
   Интерфейсы: могут содержать только константы (static final переменные).


5. Иерархия коллекций в Java. Интерфейсы Iterable и Iterator. Особенности различных коллекций: списки и множества.
   Коллекциями/контейнерами в Java принято называть классы, основная цель которых – хранить набор других элементов.

Иерархия коллекций в Java
Основные интерфейсы коллекций:
Iterable<T>
Collection<T>
List<T>
ArrayList<T>
LinkedList<T>
Set<T>
HashSet<T>
LinkedHashSet<T>
TreeSet<T>
Queue<T>
PriorityQueue<T>
LinkedList<T>
Map<K, V>
HashMap<K, V>
LinkedHashMap<K, V>
TreeMap<K, V>
Iterable — это интерфейс, который позволяет использовать объекты в усовершенствованном цикле "for-each". Метод iterator() возвращает Iterator, способный перемещаться по элементам с помощью методов hasNext() и next(), и, к тому же, предлагающий возможность удалять элементы с помощью метода remove().


Интерфейс Iterator
Интерфейс Iterator предоставляет методы для последовательного доступа к элементам коллекции:

Особенности различных коллекций: списки и множества
Списки (List)
Список — это упорядоченная коллекция, которая позволяет дублирование элементов. Основные реализации List:
ArrayList: основан на массиве, обеспечивает быстрый доступ по индексу, но медленные операции вставки и удаления из середины.
LinkedList: основан на двусвязном списке, обеспечивает быструю вставку и удаление, но медленный доступ по индексу.
Множества (Set)
Множество — это коллекция, которая не допускает дублирования элементов. Основные реализации Set:
HashSet: использует хеш-таблицу для хранения элементов, обеспечивает быстрое добавление, удаление и проверку наличия элементов, но не гарантирует порядка элементов.
LinkedHashSet: сохраняет порядок добавления элементов, основан на хеш-таблице и связном списке.
TreeSet: хранит элементы в отсортированном порядке, основан на красно-чёрном дереве.

6. Сортировка в коллекциях. Компаратор.
   Сортировка в коллекциях
   Java предоставляет несколько способов сортировки коллекций, включая использование интерфейсов Comparable и Comparator. Вот основные методы сортировки:
   Сортировка с использованием Comparable: Классы, реализующие интерфейс Comparable, могут быть отсортированы по естественному порядку. Метод compareTo определяет, как объекты должны быть сравнены.
   Сортировка с использованием Comparator: Интерфейс Comparator позволяет определять несколько стратегий сортировки для класса. Метод compare определяет, как объекты должны быть сравнены.
   Comparable используется для определения естественного порядка объектов, а Comparator — для определения различных стратегий сортировки.

7. Как работать с HashMap.
   HashMap в Java является одной из самых часто используемых реализаций интерфейса Map, который предоставляет структуру данных для хранения пар "ключ-значение". Она реализована на основе хеш-таблицы и обеспечивает быстрый доступ к значениям по ключам. В HashMap ключи не могут дублироваться, но значения могут быть одинаковыми. HashMap не гарантирует порядка элементов. Добавление нового элемента с существующим ключом меняет его значение.
8. Обработка исключений. Виды исключений. Проброс исключений.
   Исключения в Java представляют собой механизм, позволяющий управлять ошибками и другими исключительными ситуациями, которые могут возникнуть во время выполнения программы. Этот механизм позволяет отделить код обработки ошибок от основного кода и упрощает управление ошибками.
   Виды исключений
   Исключения в Java делятся на три основные категории:
   Checked exceptions (Проверяемые исключения): Эти исключения проверяются компилятором на этапе компиляции. Если метод может выбросить проверяемое исключение, то он должен либо обработать его внутри блока try-catch, либо объявить его в секции throws метода.
   Примеры: IOException, SQLException.
   Unchecked exceptions (Непроверяемые исключения): Эти исключения являются потомками RuntimeException. Они не проверяются компилятором на этапе компиляции, и разработчик не обязан явно обрабатывать их или объявлять в секции throws метода.
   Примеры: NullPointerException, ArrayIndexOutOfBoundsException.
   Errors (Ошибки): Ошибки представляют собой исключения, которые указывают на серьезные проблемы, обычно связанные с выполнением JVM, такие как нехватка памяти (OutOfMemoryError). Обычно их не следует обрабатывать в приложениях.
   Примеры: OutOfMemoryError, StackOverflowError.
   В Java для обработки исключений используются блоки try, catch, finally и ключевое слово throws.
   Блок try-catch: Блок try используется для оборачивания кода, который может выбросить исключение. Блок catch используется для обработки этого исключения.

Блок finally: Блок finally содержит код, который будет выполнен в любом случае, независимо от того, было выброшено исключение или нет. Он часто используется для освобождения ресурсов.

Проброс исключений
Иногда необходимо пробросить исключение из метода, чтобы его обработали на более высоком уровне. Для этого используется ключевое слово throw и throws.
Ключевое слово throws: Ключевое слово throws используется в объявлении метода для указания, какие исключения этот метод может выбросить.


9. Работа с файлами. Потоки ввода/вывода.
   Основные классы для работы с файлами
   Java предоставляет множество классов для работы с файлами и потоками ввода/вывода, в том числе:
   File
   FileInputStream и FileOutputStream
   FileReader и FileWriter
   BufferedReader и BufferedWriter
   PrintWriter
1. Класс File
   Класс File представляет файл или директорию в файловой системе. Он предоставляет методы для работы с атрибутами файла и выполнения операций над файлами и директориями.
2. Классы FileInputStream и FileOutputStream
   Эти классы используются для работы с байтовыми потоками ввода и вывода. FileInputStream позволяет читать байты из файла, а FileOutputStream — записывать байты в файл.
3. Классы FileReader и FileWriter
   Эти классы используются для работы с символьными потоками ввода и вывода. FileReader позволяет читать символы из файла, а FileWriter — записывать символы в файл.
4. Классы BufferedReader и BufferedWriter
   Эти классы используются для повышения эффективности ввода и вывода за счет использования буферов. Они оборачивают потоки Reader и Writer для обеспечения более эффективного чтения и записи.
5. Класс PrintWriter
   Класс PrintWriter предоставляет удобные методы для записи отформатированных данных в текстовый файл.


10. Сериализация данных. Интерфейсы Serializable и Externalizable.
    Сериализация в Java — это процесс преобразования объекта в поток байтов, который может быть сохранен в файл или передан по сети. Десериализация — это обратный процесс, при котором поток байтов преобразуется обратно в объект. Сериализация полезна для сохранения состояния объекта, передачи объектов между различными компонентами системы или передаче объектов по сети.
    Интерфейс Serializable
    Интерфейс Serializable — это маркерный интерфейс, который не содержит методов. Класс, который реализует этот интерфейс, становится сериализуемым, то есть его объекты могут быть преобразованы в поток байтов.
    Интерфейс Externalizable
    Интерфейс Externalizable предоставляет более гибкий механизм сериализации. Он требует реализации двух методов: writeExternal и readExternal. Это позволяет полностью контролировать процесс сериализации и десериализации.
    Отличия между Serializable и Externalizable
    Контроль над процессом сериализации:
    Serializable: Автоматически сериализует все не transient и не static поля класса. Разработчик может переопределить методы writeObject и readObject для дополнительного контроля.
    Externalizable: Требует реализации методов writeExternal и readExternal, предоставляя полный контроль над процессом сериализации и десериализации.
    Производительность:
    Serializable: Процесс автоматический, но может быть медленнее из-за необходимости сериализовать все поля и обработки дополнительных метаданных.
    Externalizable: Может быть быстрее, так как разработчик может оптимизировать процесс, сериализуя только необходимые данные.
    Простота использования:
    Serializable: Легче использовать, так как не требует реализации дополнительных методов.
    Externalizable: Требует больше кода и внимания к деталям, но позволяет оптимизировать сериализацию.

11. Процессы и потоки (отличия). Создание потоков в Java. Thread и Runnable.
    В операционной системе процесс является исполняемой программой, которая находится в состоянии выполнения. Каждый процесс обладает своим собственным адресным пространством, которое включает код программы, данные и ресурсы, необходимые для выполнения программы.
    Потоки же представляют собой более легкие и меньшие единицы исполнения внутри процесса. В одном процессе может быть запущено несколько потоков, которые могут выполняться параллельно или конкурентно, используя общие ресурсы и память процесса. Основные отличия между процессами и потоками:
    Процессы:
    Каждый процесс имеет своё собственное адресное пространство.
    Процессы обычно независимы друг от друга и не могут напрямую взаимодействовать без использования механизмов межпроцессного взаимодействия (IPC).
    Процессы являются более тяжеловесными по сравнению с потоками, так как требуют выделения отдельных ресурсов операционной системой.
    Потоки:
    Потоки существуют в рамках процесса и используют его общие ресурсы и память.
    Потоки могут выполняться параллельно или конкурентно, что позволяет эффективнее использовать многопроцессорные системы.
    Потоки могут легко взаимодействовать друг с другом через общие данные и переменные.
    Создание потоков в Java
    В Java потоки могут быть созданы двумя основными способами: с использованием класса Thread и с использованием интерфейса Runnable.
    Общие замечания по созданию и использованию потоков
    При использовании класса Thread, вы не можете наследовать другие классы, так как Java поддерживает только одиночное наследование. В то время как при использовании Runnable вы можете реализовать интерфейс и расширить другие классы.
    Использование интерфейса Runnable обычно считается предпочтительным подходом, так как он обеспечивает лучшую модульность и расширяемость.
    Для выполнения конкретной работы в потоке, вы должны переопределить метод run(), который будет выполняться в отдельном потоке при вызове start().
    Потоки в Java могут быть остановлены с использованием метода interrupt() или путем естественного завершения выполнения метода run().

12. Синхронизация потоков. Использование synchronized. Semaphore.
    В Java синхронизация потоков является важным аспектом многопоточного программирования, который позволяет обеспечить правильное взаимодействие между потоками при доступе к общим ресурсам или при выполнении критических секций кода. В этом контексте используются ключевое слово synchronized и классы из пакета java.util.concurrent, такие как Semaphore.
    Использование synchronized
    Ключевое слово synchronized используется для определения критических секций кода, которые могут быть выполнены только одним потоком одновременно. Это позволяет избежать состояний гонки и обеспечить корректное состояние общих ресурсов.
    Использование Semaphore
    Semaphore — это класс из пакета java.util.concurrent, который позволяет контролировать доступ к общему ресурсу через указанное количество разрешений (пермитов).

13. Внутренние классы. Анонимные классы. Функциональный интерфейс. Lambda-выражения.
    Внутренние классы
    Внутренний класс в Java — это класс, определенный внутри другого класса. Внутренние классы могут быть статическими или нестатическими.
    Нестатические внутренние классы
    Нестатический внутренний класс имеет доступ ко всем членам внешнего класса, включая его приватные члены.
    Статические внутренние классы
    Статический внутренний класс не имеет доступа к нестатическим членам внешнего класса и может быть использован без создания экземпляра внешнего класса.

Анонимные классы
Анонимный класс — это класс без имени, который определяется и создается одновременно внутри метода или другого выражения. Он может быть полезен для реализации интерфейсов или абстрактных классов на лету.

Функциональные интерфейсы
Функциональный интерфейс — это интерфейс, который содержит только один абстрактный метод. Функциональные интерфейсы часто используются вместе с lambda-выражениями.
Lambda-выражения
Lambda-выражения представляют собой компактный способ представления анонимных функций (функций без имени). Они могут быть использованы вместо анонимных классов, когда интерфейс содержит только один абстрактный метод (функциональный интерфейс).

14. Java Stream API.
    Stream API – это инструмент языка Java, который позволяет использовать
    функциональный стиль при работе с разными структурами данных и
    упрощать операции: фильтрации, сортировки и другие манипуляции.
    Вся основная функциональность данного API сосредоточена в пакете
    java.util.stream.
    Ключевым понятием в Stream API является поток данных.
    Промежуточные и терминальные операции
    Примеры промежуточных операций:
    filter(Predicate) - фильтрация элементов по заданному условию.
    map(Function) - преобразование каждого элемента в другой объект.
    sorted() - сортировка элементов.
    Примеры терминальных операций:
    forEach(Consumer) - применение операции к каждому элементу.
    collect(Collectors) - сбор элементов потока в коллекцию или другую структуру данных.
    reduce(BinaryOperator) - выполнение агрегатных операций (например, суммирование, нахождение максимума).


15. Структура Android-приложения. Ресурсы приложения. Permissions. Зачем нужен Gradle?
    Структура Android-приложения включает в себя несколько ключевых компонентов и ресурсов, которые важны для разработки и сборки приложения:
    Манифест файл (AndroidManifest.xml):
    Этот файл содержит основную информацию о приложении, такую как имя пакета приложения, версия, разрешения, список компонентов приложения (Activity, Service, BroadcastReceiver), а также другие настройки, необходимые для работы приложения на устройстве Android.
    Java и Kotlin исходные файлы:
    Код приложения написан на языках программирования Java или Kotlin. Основные компоненты приложения, такие как Activity, Service, BroadcastReceiver, и Fragment, определяются и реализуются в этих файлах.
    Ресурсы (res):
    В директории res хранятся все ресурсы, необходимые для приложения, такие как макеты экранов (layout), изображения, строки, стили, цвета, анимации и т.д.
    Ресурсы упрощают локализацию, масштабирование и изменение внешнего вида приложения без изменения кода.
    Assets:
    Директория assets используется для хранения файлов, доступ к которым осуществляется через API. Например, это могут быть текстовые файлы, звуки, видео и другие необработанные ресурсы.
    Gradle файлы (build.gradle):
    Файлы build.gradle содержат инструкции по сборке проекта с использованием системы сборки Gradle. Они определяют зависимости проекта, конфигурации сборки, плагины и другие параметры проекта.
    Ресурсы приложения
    Ресурсы Android-приложения включают в себя все файлы, используемые для отображения пользовательского интерфейса, локализации текста, управления изображениями и другими элементами в приложении. Они хранятся в директории res и разделены на различные подкаталоги:
    layout: XML-файлы, описывающие макеты экранов пользовательского интерфейса.
    drawable: Различные изображения (PNG, JPEG, SVG), которые используются в приложении для отображения и фонов.
    values: Ресурсы для хранения строк, стилей, цветов и размеров, которые могут использоваться в различных частях приложения.
    Permissions (Разрешения)
    В Android каждое приложение работает в изолированной среде без доступа к данным других приложений по умолчанию. Разрешения (Permissions) позволяют приложениям получить доступ к определенным ресурсам и функциям устройства. Например, доступ к камере, контактам, местоположению, файловой системе и т.д. Запрос разрешений обычно выполняется в манифесте приложения (AndroidManifest.xml) и требует согласия пользователя при первом запуске приложения.
    Зачем нужен Gradle?
    Gradle — это мощная система сборки проектов, используемая в разработке Android-приложений. Вот основные задачи, которые выполняет Gradle:
    Управление зависимостями: Gradle позволяет легко добавлять и управлять зависимостями, такими как библиотеки и внешние модули, необходимые для проекта.
    Конфигурация проекта: С помощью Gradle можно настроить различные аспекты сборки проекта, включая версии компиляторов, пути к ресурсам, настройки проекта и другие параметры.
    Автоматизация сборки: Gradle обеспечивает автоматизацию процесса сборки, что позволяет ускорить разработку, упростить тестирование и развертывание приложений.
    Поддержка многомодульных проектов: Gradle позволяет эффективно управлять проектами с несколькими модулями и библиотеками, обеспечивая легкость сопровождения и развития проекта.
    Интеграция с Android Studio: Gradle интегрирован в среду разработки Android Studio и используется по умолчанию для сборки проектов, что обеспечивает единый и удобный рабочий процесс для разработчиков.

16. Компонент Activity и его жизненный цикл. Методы класса Activity.
    Компонент Activity является одним из основных строительных блоков приложений на платформе Android. Activity представляет собой экран с пользовательским интерфейсом, с которым пользователь может взаимодействовать. Каждая Activity представляет собой один экран приложения, и они работают вместе для создания полноценного пользовательского интерфейса приложения.
    Жизненный цикл Activity
    Жизненный цикл Activity состоит из различных состояний и методов, которые позволяют управлять поведением и состоянием Activity в различные моменты времени. Важно понимать, что каждое состояние жизненного цикла имеет соответствующие методы, которые можно переопределить для выполнения дополнительных действий в нужный момент.
    Основные состояния и методы жизненного цикла Activity:
    Создание (onCreate()):
    Метод onCreate() вызывается при создании новой Activity.
    Здесь обычно выполняется начальная настройка Activity, загрузка ресурсов и установка пользовательского интерфейса.
    Запуск (onStart()):
    Метод onStart() вызывается, когда Activity становится видимой для пользователя.
    Здесь можно выполнять операции, которые должны происходить, когда Activity отображается на экране.
    Возобновление (onResume()):
    Метод onResume() вызывается, когда Activity возвращается к активному состоянию после приостановки или возвращения из другой Activity.
    В этом методе можно восстанавливать ресурсы, начинать анимации или запускать потоки.
    Приостановка (onPause()):
    Метод onPause() вызывается, когда Activity теряет фокус, но остается видимой.
    Здесь обычно выполняются операции по сохранению данных или приостановке операций, которые не должны продолжаться в фоновом режиме.
    Остановка (onStop()):
    Метод onStop() вызывается, когда Activity больше не видима пользователю.
    Здесь обычно освобождаются ресурсы или сохраняются данные, которые могут быть утеряны.
    Уничтожение (onDestroy()):
    Метод onDestroy() вызывается, когда Activity уничтожается.
    В этом методе обычно освобождаются все ресурсы и завершаются необходимые операции.
    Дополнительные методы жизненного цикла:
    onRestart(): Вызывается, когда Activity была остановлена, а затем запущена снова перед возобновлением.
    onSaveInstanceState(Bundle outState) и onRestoreInstanceState(Bundle savedInstanceState): Используются для сохранения и восстановления состояния Activity при изменении конфигурации устройства или временной приостановки.
    Методы класса Activity
    Класс Activity предоставляет множество методов, которые можно переопределить для управления его поведением и интерфейсом. Некоторые из наиболее часто используемых методов включают:
    setContentView(int layoutResID): Устанавливает макет (layout) для Activity.
    findViewById(int id): Находит и возвращает представление (View) по его идентификатору.
    startActivity(Intent intent) и startActivityForResult(Intent intent, int requestCode): Запускают новую Activity или ожидают результата от запущенной Activity.
    finish(): Завершает текущую Activity и возвращает управление вызывающей Activity или системе.
    onBackPressed(): Вызывается при нажатии кнопки "назад" на устройстве, обычно используется для управления навигацией.

17. Обработка событий. Слушатели событий.
    Обработка событий в Java часто включает использование слушателей событий (event listeners), которые позволяют приложению реагировать на действия пользователя или изменения в системе. Давайте рассмотрим основные концепции и примеры использования слушателей событий в Java.
    Концепция слушателей событий
    Слушатель событий (event listener) в Java является интерфейсом, который содержит один или несколько методов, предназначенных для обработки определенного типа событий. Объект, реализующий слушатель, добавляется в качестве обработчика событий к компоненту или источнику событий. Когда происходит событие, соответствующий метод слушателя вызывается, что позволяет приложению реагировать на это событие.
    Объяснение примера
    Создание окна и кнопки: Создаем графическое окно (JFrame) и кнопку (JButton) в методе main.
    Создание слушателя событий: Создаем объект класса, реализующего интерфейс ActionListener, который определяет метод actionPerformed(ActionEvent e). В данном примере используется анонимный класс для реализации интерфейса.
    Добавление слушателя к кнопке: Метод addActionListener() используется для добавления созданного слушателя к кнопке. Этот метод гарантирует, что слушатель будет уведомлен при каждом клике на кнопку.
    Обработка события: В методе actionPerformed() указывается, какие действия должны выполняться при каждом клике на кнопку. В данном случае выводится диалоговое окно с сообщением "Button Clicked!".

18. Объект Intent. Явные и неявные намерения. Как используются и для чего?
    Объект Intent является ключевым элементом в Android для взаимодействия между компонентами приложения, а также для взаимодействия с компонентами других приложений. Он используется для передачи данных, запуска компонентов (таких как Activity, Service, BroadcastReceiver) и выполнения различных операций в Android-приложениях.
    Явные и неявные намерения (Intents)
    Явные намерения (Explicit Intents):
    Явные намерения используются для запуска компонента приложения по его имени (пакету) или классу.
    Такой тип намерения явно указывает на целевой компонент, с которым нужно взаимодействовать.
    Пример использования явного намерения для запуска новой Activity:
    Неявные намерения (Implicit Intents):
    Неявные намерения используются для запуска компонента приложения, который может обрабатывать определенный тип действия или иметь определенный набор данных.
    Неявное намерение может быть обработано несколькими компонентами, что дает пользователю выбор, какое приложение использовать для выполнения действия.
    Пример использования неявного намерения для отправки текстового сообщения:
    Как используются и для чего?
    Передача данных между компонентами: Intent используется для передачи данных между различными компонентами приложения, такими как Activity, Service, BroadcastReceiver.
    Запуск новых экранов (Activity): Intent используется для запуска новых экранов пользовательского интерфейса (Activity), как явных, так и неявных.
    Выполнение действий вне приложения: Неявные намерения позволяют запускать действия, которые могут быть выполнены различными приложениями на устройстве, такими как отправка сообщений, открытие URL-адресов, воспроизведение медиафайлов и т.д.
    Интеграция с системными службами и функциями: Intent позволяет интегрироваться с системными службами, такими как камера, контакты, календарь, что упрощает доступ к функциональности устройства.

19. Особенности создания фрагментов. Где используются? Способы обмена данными между Activity и Fragment.
    Фрагменты (fragments) – это UI-модули, используемые для разделения
    интерфейса пользователя на отдельные части, которые могут быть
    использованы в одной или разных activities.
    Жизненный цикл: Фрагменты имеют свой собственный жизненный цикл, который включает методы, аналогичные методам жизненного цикла Activity (например, onCreate(), onStart(), onResume(), и т.д.).
    Макеты и UI: Фрагменты могут иметь свои собственные макеты (layout) и пользовательский интерфейс, аналогично Activity. Они могут содержать в себе другие фрагменты или быть частью макета Activity.
    Гибкость и повторное использование: Фрагменты предоставляют гибкость в управлении множественными экранами и их взаимодействием. Они могут использоваться повторно в различных Activity или в одном Activity.
    Динамическое добавление и управление: Фрагменты могут быть добавлены или удалены динамически во время выполнения (runtime), что позволяет адаптировать пользовательский интерфейс к различным условиям и устройствам.
    Где используются фрагменты?
    Фрагменты часто используются в следующих случаях:
    Многопанельные интерфейсы: Например, на планшетных устройствах можно использовать фрагменты для отображения различных частей интерфейса одновременно на одном экране.
    Динамические пользовательские интерфейсы: Фрагменты позволяют создавать сложные и динамические пользовательские интерфейсы, которые могут меняться в зависимости от действий пользователя или условий экрана.
    Переиспользование компонентов: Фрагменты могут быть использованы для создания повторно используемых компонентов интерфейса, что упрощает разработку и поддержку приложения.
    Способы обмена данными между Activity и Fragment
    Обмен данными между Activity и Fragment может происходить различными способами, в зависимости от конкретных требований приложения:
    Аргументы фрагмента: Фрагменты могут получать данные через аргументы (Bundle), которые передаются при создании фрагмента. Это подходит для передачи статических данных при создании фрагмента.
    Методы фрагмента: Фрагмент может содержать методы, через которые Activity может передавать данные или вызывать операции над фрагментом.
    Интерфейсы обратного вызова (Callback Interfaces): Activity может реализовать интерфейс, определенный в фрагменте, что позволяет фрагменту обратиться к Activity и передать данные или уведомить об изменениях.


20. ActionBar и Toolbar. Как создается меню в приложениях?
    В Android для создания пользовательского интерфейса верхнего меню (action bar) можно использовать как классический ActionBar, так и более гибкий Toolbar. Давайте рассмотрим оба подхода и процесс создания меню в приложениях.
    ActionBar
    ActionBar был стандартным способом добавления верхнего меню в Android до версии 5.0 (API уровень 21). Он представляет собой полосу действий в верхней части экрана, где могут располагаться элементы управления и меню.
    Toolbar
    Toolbar был представлен в Material Design и представляет собой более гибкий и настраиваемый способ добавления верхнего меню в Android. Он заменил ActionBar как рекомендованный инструмент для создания верхнего меню начиная с версии 5.0 (API уровень 21).


21. Зачем используются адаптеры. RecyclerView.Adapter. Паттерн ViewHolder.
    Адаптеры и паттерн ViewHolder являются основными компонентами для работы с RecyclerView в Android. Давайте рассмотрим их подробнее:
    Адаптеры в RecyclerView
    RecyclerView.Adapter - это класс, который связывает данные с RecyclerView, отвечая за создание новых элементов, наполнение их данными и обеспечение взаимодействия с пользователем. Вот основные задачи адаптера:
    Создание новых View: Адаптер создает новые представления (виджеты) для элементов списка.
    Привязка данных к View: Адаптер берет данные из источника данных и привязывает их к соответствующим представлениям.
    Обработка взаимодействия: Адаптер может обрабатывать пользовательские взаимодействия, такие как нажатия на элементы списка.
    Паттерн ViewHolder
    ViewHolder - это паттерн, используемый для оптимизации производительности RecyclerView. Он представляет собой класс, который хранит ссылки на виджеты, составляющие элемент списка. Использование ViewHolder позволяет избежать многократного поиска виджетов в дереве представлений, что ускоряет работу RecyclerView.
    Основные задачи ViewHolder:
    Хранение представлений: ViewHolder хранит ссылки на виджеты, составляющие элемент списка (например, TextView, ImageView и т.д.).
    Повторное использование представлений: Вместо создания новых представлений для каждого элемента списка, RecyclerView повторно использует существующие представления, уменьшая нагрузку на систему.
    Как это работает вместе
    Создание ViewHolder:
    Когда RecyclerView требуется новое представление для элемента, он вызывает метод onCreateViewHolder() у адаптера.
    Адаптер создает новое представление и оборачивает его в объект ViewHolder.
    Привязка данных:
    Когда RecyclerView нужно заполнить элемент данными, он вызывает метод onBindViewHolder() у адаптера.
    Адаптер берет данные из своего источника и привязывает их к виджетам, хранящимся в ViewHolder.
    Повторное использование:
    RecyclerView повторно использует ViewHolder для различных элементов списка, вызывая onBindViewHolder() с новыми данными.
    Пример:

В этом примере:
MyViewHolder хранит ссылку на TextView.
onCreateViewHolder() создает новое представление для элемента списка.
onBindViewHolder() привязывает данные к представлению.
getItemCount() возвращает количество элементов в источнике данных.
Использование адаптеров и паттерна ViewHolder позволяет эффективно управлять списками данных в Android-приложениях, обеспечивая высокую производительность и гибкость.
22. Особенности работы с файловой системой в Android для разных версий операционной системы. External и Internal Storage.
    Internal Storage представляет собой внутреннее хранилище информации, которое есть на каждом телефоне независимо от поддержки карт памяти. Эта область памяти располагается в системном разделе /data и является защищенной.
    External Storage представляет собой внешнее хранилище информации, которое (как правило) есть на каждом телефоне в виде sd-карты или физической не извлекаемой памяти.
    Работа с файловой системой в Android
    Internal Storage
    Доступ: Только ваше приложение.
    Удаление: При удалении приложения.
    Применение: Хранение конфиденциальных данных.
    External Storage
    Доступ: Все приложения (при наличии разрешений).
    Удаление: Пользователь может удалить вручную.
    Применение: Хранение мультимедиа, данных, общих для всех приложений.
    Версии ОС и особенности
    Android 10 и выше (Scoped Storage)
    Особенности: Приложения имеют изолированное хранилище на External Storage.
    Доступ: К общим файлам нужен специальный доступ (разрешения).
    MediaStore API: Для доступа к медиафайлам.
    Android 9 и ниже
    Особенности: Приложения имеют полный доступ к External Storage (с разрешениями).
    Разрешения: READ_EXTERNAL_STORAGE и WRITE_EXTERNAL_STORAGE требуются для чтения/записи.
    Примеры использования:
    Internal Storage:

External Storage:


23. База данных SQLite. Особенности, как создать и использовать. Методы класса SQLiteDatabase.
    SQLite в Android
    SQLite – встраиваемая реляционная база данных
    Хранит все таблицы (данные) в одном файле
    Допускает чтение данных из разных потоков (запись – только из одного)
    Особенности
    Локальная база данных: Хранение данных внутри приложения.
    Не требует серверной части: Всё хранится на устройстве.
    Поддержка SQL: Стандартные SQL-запросы.
    Легковесная: Оптимизирована для мобильных устройств.
    Создание и использование SQLite
    Шаги создания и использования базы данных SQLite в Android:
    Создание и управление базой данных:
    Использование класса SQLiteOpenHelper.
    Открытие базы данных:
    Методы класса SQLiteDatabase.
    Выполнение операций (CRUD):
    Вставка, обновление, удаление и чтение данных.
    Пример создания базы данных
    Создание класса, наследующего SQLiteOpenHelper:

2. Использование базы данных в активности:

Методы класса SQLiteDatabase
openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory): Открывает или создает базу данных.
execSQL(String sql): Выполняет SQL-запрос, не возвращающий данные (CREATE, INSERT и т.д.).
insert(String table, String nullColumnHack, ContentValues values): Вставляет строку в таблицу.
update(String table, ContentValues values, String whereClause, String[] whereArgs): Обновляет строки в таблице.
delete(String table, String whereClause, String[] whereArgs): Удаляет строки из таблицы.
query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy): Запрашивает строки из таблицы.
rawQuery(String sql, String[] selectionArgs): Выполняет SQL-запрос, возвращающий данные (SELECT).
24. База данных Realm. Особенности, как создать и использовать. Какие преимущества?
    Realm в Android
    Realm – это нативная кроссплатформенная noSQL база данных от MongoDB
    В 10 раз быстрее SQLite (наверное )
    Требует отдельного подключения через Gradle и JDK не ниже 11 версии
    Поддерживает синхронные и асинхронные методы работы с данными
    Особенности
    Легковесная и быстрая: Realm предлагает высокую производительность и низкую задержку для операций с данными.
    Объектно-ориентированная: Использует объекты вместо строковых SQL-запросов.
    Реактивность: Изменения в данных могут автоматически обновлять UI.
    Многопоточность: Поддерживает работу с данными из разных потоков.
    Легкость миграций: Упрощает управление изменениями в структуре данных.
    Преимущества Realm
    Простота использования: Работа с объектами Java/Kotlin вместо SQL-запросов.
    Высокая производительность: Быстрее SQLite для большинства операций.
    Автоматические обновления: Реактивные объекты, обновляющие UI при изменении данных.
    Кроссплатформенность: Поддержка Android и iOS.
    Создание и использование Realm
    Шаги создания и использования базы данных Realm:
    Добавление зависимости:
    В build.gradle:

Инициализация Realm:

3. Создание модели данных:

4. Работа с базой данных:

25. Хранилище Shared Preferences. Для чего используется. Какие типы данных можно хранить. Как сохранять и загружать данные.
    Назначение
    Shared Preferences используется для хранения простых данных в виде пар ключ-значение. Это удобный способ сохранять настройки приложения и другую небольшую информацию, которая должна быть доступна между запусками приложения.
    Типы данных
    Shared Preferences поддерживает хранение следующих типов данных:
    boolean
    float
    int
    long
    String
    Set<String>
    Как сохранять и загружать данные
    Сохранение данных
    Для сохранения данных необходимо получить объект SharedPreferences.Editor и использовать методы для вставки данных, затем вызвать apply() или commit() для сохранения изменений.
    Пример:

Загрузка данных
Для загрузки данных необходимо получить объект SharedPreferences и использовать методы для получения значений по ключам.
Пример:

Примечания
apply() vs commit(): apply() сохраняет изменения асинхронно, а commit() синхронно. apply() предпочтительнее для большинства случаев, так как он быстрее.
Чтение значений: Если ключ не существует, возвращается значение по умолчанию, указанное в методах получения.
26. Компоненты приложения. Services. Виды сервисов. Особенности запуска сервиса для разных версий Android.
    Сервисы (Services) - это компоненты приложения, предназначенные для выполнения длительных операций в фоновом режиме. Сервисы не имеют пользовательского интерфейса и продолжают работать даже при переключении между приложениями.
    Виды сервисов
    Foreground Service (Передний план)
    Описание: Сервисы, которые выполняют операции, о которых пользователь должен знать. Например, воспроизведение музыки.
    Уведомление: Требуют отображения уведомления.
    Пример: Медиаплеер, который продолжает воспроизводить музыку, даже когда приложение не активно.
    Background Service (Фоновые)
    Описание: Сервисы, выполняющие задачи в фоне. В Android 8.0 (API 26) и выше их использование ограничено для повышения производительности и экономии заряда батареи.
    Пример: Загрузка файлов.
    Bound Service (Связанные)
    Описание: Сервисы, которые предоставляют клиентам интерфейс для взаимодействия. Клиенты могут привязываться к сервису и вызывать его методы.
    Пример: Сервисы, которые предоставляют данные или выполняют вычисления по запросу.
    Особенности запуска сервиса для разных версий Android
    Android 8.0 (API 26) и выше
    Ограничения на фоновую работу: Фоновые сервисы могут работать только ограниченное время, если приложение не активно.
    Foreground Service: Чтобы избежать ограничений, сервисы должны быть переведены в передний план с помощью метода startForeground().
    JobScheduler и WorkManager: Для выполнения фоновых задач рекомендуется использовать JobScheduler или WorkManager.
    Android 7.1 (API 25) и ниже
    Меньше ограничений: Фоновые сервисы могут выполняться без ограничений, если приложение находится в фоне.
    Уведомления для длительных операций: Рекомендуется использовать уведомления для длительных операций, но это не обязательно.
    onCreate(): Вызывается при создании сервиса.
    onStartCommand(Intent intent, int flags, int startId): Вызывается при каждом запуске сервиса с помощью startService().
    onBind(Intent intent): Вызывается при привязке клиента к сервису с помощью bindService().
    onDestroy(): Вызывается при завершении работы сервиса.
27. Компоненты приложения. Broadcast Receivers. Особенности регистрации «слушателей» (статический и динамический способ).
    Назначение
    Broadcast Receivers (Приёмники широковещательных сообщений) — это компоненты приложения, которые позволяют приложению получать уведомления о событиях, происходящих на устройстве или в системе. Примеры событий включают низкий заряд батареи, изменение состояния сети, получение SMS и другие.
    Особенности регистрации «слушателей»
    Broadcast Receivers могут быть зарегистрированы двумя способами: статическим и динамическим.
    Статическая регистрация
    Статическая регистрация выполняется в файле AndroidManifest.xml. Приёмник, зарегистрированный таким образом, может получать широковещательные сообщения, даже если приложение не запущено.
    Пример:

Преимущества:
Приёмник работает, даже если приложение не запущено.
Не требуется дополнительного кода для регистрации.
Недостатки:
Более ограниченный доступ к ресурсам.
Не все широковещательные сообщения могут быть зарегистрированы статически из-за изменений в Android 8.0 (API 26) и выше.
Динамическая регистрация
Динамическая регистрация выполняется программно в коде активности или сервиса. Обычно это делается в методе onCreate() и удаляется в onDestroy().
Преимущества:
Полный контроль над жизненным циклом приёмника.
Могут использоваться с любыми широковещательными сообщениями.
Недостатки:
Приёмник работает только, когда приложение активно.
Требуется больше кода для регистрации и удаления.
Пример Broadcast Receiver:

Изменения в Android 8.0 (API 26) и выше
В Android 8.0 и выше введены ограничения на статическую регистрацию широковещательных сообщений для повышения производительности и экономии батареи. Многие системные широковещательные сообщения больше не могут быть зарегистрированы в AndroidManifest.xml и должны регистрироваться динамически.
Примеры таких сообщений:
ACTION_BOOT_COMPLETED
ACTION_BATTERY_LOW
ACTION_POWER_CONNECTED
и другие.
28. Главный поток. Инструменты многопоточности в Android-приложениях.
    Главный поток (Main Thread), также известный как UI-поток, отвечает за обработку пользовательского интерфейса и взаимодействие с пользователем в Android-приложениях. Все изменения интерфейса, а также реакции на пользовательские действия должны происходить в главном потоке.
    Проблемы
    Блокировка главного потока: Если на главном потоке выполняются длительные операции (например, сетевые запросы, работа с базой данных), это может привести к "подвисанию" интерфейса и плохому пользовательскому опыту.
    Выбрасывание ANR (Application Not Responding): Если главный поток заблокирован более чем на 5 секунд, система может выдать ошибку ANR.
    Инструменты многопоточности в Android
1. AsyncTask
   Класс AsyncTask предлагает простой механизм для переноса трудоёмких операций в фоновый поток. Позволяет обеспечить асинхронное обновление элементов пользовательского интерфейса входе выполнения задачи, а также для вывода результатов после ее завершения.AsyncTask – это абстрактный класс, для его использования необходимо создавать класс-наследник.

Использование: Выполнение фоновых задач с возможностью обновления интерфейса.
onPreExecute(): Выполняется перед началом фоновой задачи.
doInBackground(Params...): Выполняется в фоновом потоке.
onProgressUpdate(Progress...): Выполняется на главном потоке для обновления прогресса.
onPostExecute(Result): Выполняется на главном потоке после завершения фоновой задачи.
Пример:

2. Handler и HandlerThread
   Использование: Отправка и обработка сообщений и Runnable объектов на других потоках.
   Handler: Связывается с конкретным Looper объектом и позволяет отправлять и обрабатывать сообщения и Runnable объекты.
   HandlerThread: Поток с собственным Looper, который можно использовать для фоновых задач.
   Пример:

3. Executor и ExecutorService
   Использование: Управление пулом потоков для выполнения задач.
   Executors.newSingleThreadExecutor(): Исполнитель с одним потоком.
   Executors.newFixedThreadPool(int nThreads): Исполнитель с фиксированным числом потоков.
   Executors.newCachedThreadPool(): Исполнитель с динамически изменяемым числом потоков.
   Пример:

4. AsyncTaskLoader и Loader
   Использование: Выполнение длительных операций в фоне и управление их жизненным циклом.
   LoaderManager: Управляет жизненным циклом загрузчиков и автоматической переинициализацией при изменении данных.
   Пример:

5. WorkManager
   Использование: Планирование и выполнение задач, требующих гарантированного выполнения, таких как фоновые синхронизации и загрузки.
   WorkManager: Рекомендуемый способ выполнения отложенных фоновых задач, которые должны гарантированно выполняться.
   Пример:




10. **Реализовать Java-программу в Apache NetBeans IDE, которая сохраняет в файл содержимое веб-страницы, адрес которой вводит пользователь с клавиатуры. Использование многопоточности – обязательно.**
    ```java
    package org.example;  

import java.io.*;  
import java.net.MalformedURLException;  
import java.net.URL;  
import java.util.*;  
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;  
  
