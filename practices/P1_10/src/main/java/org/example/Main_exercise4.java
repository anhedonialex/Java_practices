package org.example;

import java.io.IOException;

public class Main_exercise4 {
    public static void main(String[] args){
        boolean isExistWorkDir = FileUtils.checkWorkDirectory("C:\\", "Bondarew");
        System.out.println("Exist work directory: " + isExistWorkDir);
        if (isExistWorkDir){
            String data = "Example string";
            try {
                FileUtils.writeStringToFile("C:\\Bondarew\\test.txt", data);
            } catch (IOException ex){
                System.out.println(ex.toString());
            }
        }
        try {
            byte[] array = FileUtils.readBytesFromFile("C:\\Bondarew\\test.txt");
            System.out.println("Array len: " + array.length);
            for(int i = 0;i < array.length;i++){
                array[i] = (byte)(array[i] ^ 0x1A);
            }
            FileUtils.writeBytesToFile("C:\\Bondarew\\crypted_str.txt", array);
        } catch (IOException ex){
            System.out.println("Pri chtenii iz faila voznikla oshibka: " + ex.toString());
        }
    }
}
