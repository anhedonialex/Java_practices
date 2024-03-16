package org.example;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isMobile() {
        return isMobile;
    }

    public void setMobile(boolean mobile) {
        isMobile = mobile;
    }

    private String model;
    private String serial;
    private String color;
    private boolean isMobile;
    public Telephone(String model, String serial, String color, boolean isMobile){
        this.model = model;
        this.serial = serial;
        this.color = color;
        this.isMobile = isMobile;
    }
}
