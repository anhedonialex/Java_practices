package org.example;

public class Student extends Person{
    private String group;
    private int number;
    boolean isFullTime;
    public Student(String group, int number, boolean isFullTime, String name){
        super(name);
        this.group = group;
        this.number = number;
        this.isFullTime = isFullTime;

    }
    public  void goToUniversity(String univerName){
        System.out.println("Student go to " + univerName);
    }

}
