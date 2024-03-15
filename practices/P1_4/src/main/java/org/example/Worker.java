package org.example;

public class Worker extends Person{
    private String spec;
    private String workPlace;
    public Worker(String spec, String workPlace, String name){
        super(name);
        this.spec = spec;
        this.workPlace = workPlace;
    }
    public  String work(String[] todoList){
        return "Какой-то результат";
    }
}
