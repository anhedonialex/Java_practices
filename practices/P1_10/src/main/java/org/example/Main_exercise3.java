package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main_exercise3 {
    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanov", 17);
        person.setBudget(1000);
        Market myMarket = new Market("4etverochka");
        myMarket.setOpeningHour(11);
        myMarket.setClosingHour(23);
        HashMap<String, Integer> ctlg =new HashMap<>();
        ctlg.put("Hleb borodinskiy",50);
        ctlg.put("Kolbasa moskovskaya",50);
        ctlg.put("Konfeti studencheskie",50);
        ctlg.put("Sok yablochniq Zloy",50);
        ctlg.put("Shampanskoe Rossiqskoe",50);

        myMarket.setCatalog(ctlg);
        ArrayList<String> bucket = new ArrayList<>();
        bucket.add("Konfeti studencheskie");
        bucket.add("Shampanskoe Rossiqskoe");
        try{
            myMarket.sale(person, bucket);
        } catch (MarketException ex){
            System.out.println("Oshibka pri pokupke");
            System.out.println(ex.getMessage());
        }
    }
}
