package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Exercise2 {
    public static void main(String[] args){
        HashMap<Integer,Person> personsMap = new HashMap<>();
        personsMap.put(123456, new Person("Ivan","Ivanov",20));
        personsMap.put(223344, new Person("Masha","Rasputina",19));
        personsMap.put(334455, new Person("John","Wick",40));

        Person personMasha = personsMap.get(223344);


        System.out.println("Masha age: " + personMasha.getAge());
        TreeMap<Integer,Person> sortedPersonsMap = new TreeMap<>(personsMap);
        for (Map.Entry<Integer,Person> entr : sortedPersonsMap.entrySet()){
            int passportId = entr.getKey();
            String fName = entr.getValue().getFirstName();
            String lName = entr.getValue().getLastName();
            System.out.println(fName + " " + lName + ", passportId: " + passportId);
        }


    }
}
