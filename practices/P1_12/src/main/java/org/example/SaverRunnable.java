package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaverRunnable implements Runnable{
    private Person person;
    private String path;
    public SaverRunnable(Person person, String path){
        this.person = person;
        this.path = path;
    }

    @Override
    public void run(){
        if (this.path != null && person != null){
            FileOutputStream fos;
            try{
                fos = new FileOutputStream(this.path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(person);
                oos.close();
                System.out.println("Success serialization obj person");
            } catch (IOException ex){
                System.out.println("Error saving object to path: " + this.path);
            }
        }
    }
}
