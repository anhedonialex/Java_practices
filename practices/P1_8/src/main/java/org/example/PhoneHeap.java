package org.example;

import java.util.List;
import java.util.TreeMap;

public class PhoneHeap {
    private TreeMap<String, Telephone> heap;
    public PhoneHeap(){
        this.heap = new TreeMap<>();
    }
    public void addPhone(Telephone telephone){
        if (this.heap.containsKey(telephone.getSerial())){
            System.out.println(String.format("This serial number (%s) already exists", telephone.getSerial()));
            return;
        }
        this.heap.put(telephone.getSerial(), telephone);
    }
    public void delPhone(String serial){
        this.heap.remove(serial);
    }
    public void clear(){
        this.heap.clear();
    }
    @Override
    public String toString(){
        StringBuilder retStr = new StringBuilder();
        this.heap.forEach((key, value) -> {
            retStr.append(String.format(
                    "---------\n" +
                    "Telephone: %s\n" +
                    "Serial: %s\n" +
                    "Color: %s\n" +
                    "isMobile:%b\n",
                    value.getModel(),
                    value.getSerial(),
                    value.getColor(),
                    value.isMobile()));
        });
        if (retStr.toString().equals("")){
            return "PhoneHeap is empty";
        }
        return retStr.toString();
    }
}
