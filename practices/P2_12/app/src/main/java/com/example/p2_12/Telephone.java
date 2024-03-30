package com.example.p2_12;

public class Telephone {
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }



    private String model;
    private String serial;
    private int price;

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Telephone(String model, String serial, int price){
        this.model = model;
        this.serial = serial;
        this.price = price;
    }
}
