package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Market {
    private String title;
    private HashMap<String, Integer> catalog;
    private int openingHour;
    private int closingHour;
    public Market(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public HashMap<String, Integer> getCatalog() {
        return catalog;
    }

    public void setCatalog(HashMap<String, Integer> catalog) {
        this.catalog = catalog;
    }

    public int getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(int openingHour) {
        this.openingHour = openingHour;
    }

    public int getClosingHour() {
        return closingHour;
    }

    public void setClosingHour(int closingHour) {
        this.closingHour = closingHour;
    }
    public ArrayList<String> sale(Person p, ArrayList<String> bucket) throws MarketException {
        ArrayList<String> purchases = new ArrayList<>();
        int wallet = p.getBudget();
        LocalTime local = LocalTime.now();
        int nowTime = local.getHour();
        if (!(nowTime < this.openingHour || nowTime > this.closingHour)){
        for (String product : bucket){
            wallet = wallet - this.catalog.get(product);
            if (wallet < 0){
                throw new MarketException("Nedostatochno sredstv");
            }
            if (p.getAge()<18){
                if(product.contains("Pivo")||product.contains("Vino")||product.contains("Shampanskoe")){
                    throw new MarketException("Nedostotochno prav dlya pokupki");
                }
            }
            purchases.add(product);
            p.setBudget(wallet);
        }
        return purchases;
        } else{
            throw new MarketException("Vi prishli v nerabochee vremya");
        }
    }
}
