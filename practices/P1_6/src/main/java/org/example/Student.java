package org.example;

public class Student extends Person{
    private String group;
    private int number;
    boolean isFullTime;
    public Student(String group, int number, boolean isFullTime, String name, String surname){
        super(name, surname);
        this.group = group;
        this.number = number;
        this.isFullTime = isFullTime;

    }
    public  void goToUniversity(String univerName){
        System.out.println("Student go to " + univerName);
    }
    @Override
    public String toString(){
        return  String.format("Student(firstName = %s, lastName = %s, age = %d, group = %s, number = %d, isFullTime = %b", getFirstName(), getLastName(), getAge(), this.group, this.number, this.isFullTime);
    }
    @Override
    public  void talk(){
        System.out.println("Hello! I am not an ordinary person! I'm a student!");
    }

}
