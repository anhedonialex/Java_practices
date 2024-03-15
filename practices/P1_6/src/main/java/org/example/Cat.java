package org.example;

public class Cat extends Animal implements SausageLover{
    private String breed;

    public Cat(String breed, String title) {
        super(title);
        this.breed = breed;
    }

    public void scratch(){
        //some code
    }
    @Override
    public void doSound() {
        System.out.println("Meow");
    }
    @Override
    public  void eatSausage(int count){
        System.out.println("Cat eats " + count + " sausages");
        //some code
    }
}
