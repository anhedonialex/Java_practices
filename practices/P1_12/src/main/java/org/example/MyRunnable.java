package org.example;

public class MyRunnable implements Runnable{
    @Override
    public void run(){
        for(int i = 0; i < 10 && !Thread.currentThread().isInterrupted(); i++ ){
            System.out.println("Hello! I am " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Potok bil prervan");
                Thread.currentThread().interrupt();
            }
        }
    }
}
