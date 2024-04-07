package com.example.p2_14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilesUtils {
    public static  void saveTextToFile(File file, String text) throws IOException{
        FileWriter fw = new FileWriter(file, false);
        fw.write(text);
        fw.close();
    }
    public static String loadTextFromFile(File file) throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine())!=null){
            sb.append(line);
        }
        return sb.toString();
    }
}
