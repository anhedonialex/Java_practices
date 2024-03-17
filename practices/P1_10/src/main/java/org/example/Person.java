package org.example;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    private int budget;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Person(){

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
        return  String.format("Person(firstName = %s, lastName = %s, age = %d", getFirstName(), getLastName(), getAge());
    }
    @Override
    public int compareTo(Person o){
        return lastName.compareTo(o.getLastName());
    }
}
