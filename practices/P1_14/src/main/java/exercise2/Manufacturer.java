package exercise2;

public class Manufacturer implements Runnable{
    private Store store;
    public Manufacturer(Store store){
        this.store = store;
    }
    @Override
    public void run() {
        for (int i = 1; i < 10;i++){
            store.put();
        }
    }
}
