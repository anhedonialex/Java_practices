package org.example;

import java.io.*;

public class FileUtils {
    public  static boolean checkWorkDirectory(String path, String dirName){
        File workDir = new File(path + "/" + dirName);
        if(workDir.exists()){
            return true;
        }else {
            return workDir.mkdir();
        }
    }
    public static void writeStringToFile(String path, String str) throws IOException {
        FileWriter fw = new FileWriter(path);
        fw.write(str);
        fw.close();
    }
    public static byte[] readBytesFromFile(String path) throws FileNotFoundException, IOException{
        File file = new File(path);
        if(file.exists()){
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fis.close();
            return data;
        }else {
            return new byte[]{};
        }
    }
    public static void writeBytesToFile(String path, byte[] bytes) throws IOException{
        FileOutputStream fout = new FileOutputStream(path,true);
        fout.write(bytes);
        fout.close();
    }
}
