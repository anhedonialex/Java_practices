package org.example;

import java.io.*;

public class Person implements Comparable<Person>, Externalizable {
    private String firstName;
    private String lastName;
    private int age;
    private transient int budget;
    private static final long serialVersionUID = 4170021497912936843L;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Person(){
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException{
        out.writeObject(this.getFirstName());
        out.writeObject(this.getLastName());
        out.writeObject(this.getAge());
        out.writeObject(this.getBudget());
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        this.firstName = (String)in.readObject();
        this.lastName = (String)in.readObject();
        this.age = (Integer)in.readObject();
        this.budget = (Integer)in.readObject();
    }
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public Person(String firstName, String lastName, int age, int budget){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.budget = budget;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 150){
            this.age = 18;
        }else{
            this.age = age;
        }
    }

    public Person(String firstName, int age){
        this.firstName = firstName;
        this.age = age;
    }
    public void doSleep(int hours){
        System.out.println("Person sleep " + hours + " hours");
    }
    public void doEat(String[] foods){
        for (String food : foods){
            System.out.println("Person ate " + food);
        }
    }
    public void talk(){
        System.out.println("Hello! I'm an ordinary person");
    }
    @Override
    public String toString(){
        return  String.format("Person(firstName = %s, lastName = %s, age = %d, budget = %d", getFirstName(), getLastName(), getAge(), getBudget());
    }
    @Override
    public int compareTo(Person o){
        return lastName.compareTo(o.getLastName());
    }
}
