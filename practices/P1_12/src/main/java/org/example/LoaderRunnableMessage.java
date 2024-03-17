package org.example;

import com.mirea.kt.example.Message;

import java.io.*;

public class LoaderRunnableMessage implements Runnable{
    private String path;
    public LoaderRunnableMessage(String path){
        this.path = path;
    }
    @Override
    public void run(){
        FileInputStream fis;
        if (this.path != null && new File(this.path).exists()){
            try{
                fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                Message person = (Message)ois.readObject();
                System.out.println(person.getBody());
                ois.close();
            } catch (IOException| ClassNotFoundException e) {
                System.out.println("Error loading object from path: " + this.path);
                System.out.println(e.getMessage());
            }
        }
    }

}
