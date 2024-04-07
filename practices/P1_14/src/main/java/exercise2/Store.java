package exercise2;

public class Store {
    private int product = 0;
    public synchronized void put(){
        while (product >= 3){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров в магазине: " + product);
        notify();
    }
    public synchronized void get(){
        while (product < 1){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров в магазине: " + product);
        notify();

    }
}
