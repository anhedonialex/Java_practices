package org.example;

public abstract class Animal {
    private String title;
    public Animal(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public abstract void doSound();
}
