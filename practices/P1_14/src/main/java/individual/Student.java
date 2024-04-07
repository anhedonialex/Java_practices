package individual;
import java.util.concurrent.Semaphore;
public class Student implements Runnable {
    private final String name;
    private final Semaphore table;

    public Student(String name, Semaphore table) {
        this.name = name;
        this.table = table;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waiting");
            table.acquire(); // Студент занимает столик
            System.out.println(name + " eating");
            Thread.sleep(3000); // Студент обедает
            System.out.println(name + " exit");
            table.release(); // Студент освобождает столик
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
