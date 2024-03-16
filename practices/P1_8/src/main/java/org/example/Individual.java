package org.example;

public class Individual {
    public static void main(String[] args) {
        System.out.println("Bondarew Alexey Petrovich RIBO-03-22, variant 2");
        PhoneHeap myHeap = new PhoneHeap();
        myHeap.addPhone(new Telephone("Panasonic", "X35235ZMD", "white", false));
        myHeap.addPhone(new Telephone("Panasonic", "X35235ZMD", "white", false));
        myHeap.addPhone(new Telephone("Samsung S10", "XYZ123456789", "black", true));
        myHeap.addPhone(new Telephone("Iphone X", "ASIOS77777QWERTY", "black", true));
        System.out.println(myHeap);

        System.out.println("Deleting Panasonic");
        myHeap.delPhone("X35235ZMD");
        System.out.println(myHeap);

        System.out.println("Cleaning...");
        myHeap.clear();
        System.out.println(myHeap);
    }
}
