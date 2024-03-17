package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! I am " + Thread.currentThread().getName());
        /*Thread th = new MyThread();
        th.setDaemon(true); //код выводит не 10 строк по причине того, что main поток завершает свою работу
        th.start(); //раньше чем демон, а JVM прибивает осиротевшего демона
        */
        MyRunnable rn = new MyRunnable();
        Thread th = new Thread(rn);
        th.start();
        try{
            Thread.sleep(4000);
        } catch (InterruptedException ex){

        }
        th.interrupt();
        System.out.println("Bye! I am " + Thread.currentThread().getName());
    }
}