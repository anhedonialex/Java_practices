package individual;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bondarew RIBO-03-22 variant 2");
        Semaphore table = new Semaphore(2); // Создаем семафор для двух студентов

        // Создаем студентов
        Thread[] students = new Thread[7];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Thread(new Student("Student" + (i + 1), table));
        }

        // Запускаем студентов
        for (Thread student : students) {
            student.start();
        }

        // Ожидаем завершения обеда всех студентов
        for (Thread student : students) {
            try {
                student.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
