package org.example;

import java.io.*;

public class LoaderRunnable implements Runnable{
    private String path;
    public LoaderRunnable(String path){
        this.path = path;
    }
    @Override
    public void run(){
        FileInputStream fis;
        if (this.path != null && new File(this.path).exists()){
            try{
                fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Person person = (Person)ois.readObject();
                System.out.println(person);
                ois.close();
            } catch (IOException| ClassNotFoundException e) {
                System.out.println("Error loading object from path: " + this.path);
                System.out.println(e.getMessage());
            }
        }
    }

}
