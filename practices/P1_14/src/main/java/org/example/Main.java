package org.example;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(12345678L, 1000);
        Runnable rn = new ClientRunnable(account);
        Thread client1 = new Thread(rn, "Клиент 1");
        Thread client2 = new Thread(rn, "Клиент 2");
        client1.start();
        client2.start();
        try{
            client1.join();
            client2.join();
        }catch (InterruptedException ex){

        }
        System.out.println("Баланс после покупок: " + account.getBalance());
    }
}