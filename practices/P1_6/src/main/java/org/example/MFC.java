package org.example;

public class MFC {
    private String location;
    private int operatorsCount;

    public MFC(String location) {
        this.location = location;
    }

    public void setOperatorsCount(int operatorsCount) {
        if (operatorsCount <= 0) {
            this.operatorsCount = 1;
        } else {
            this.operatorsCount = operatorsCount;
        }
    }
    public int getOperatorsCount() {
        return this.operatorsCount;
    }
    public void changePersonParams (Person person) {
        if (person != null && this.operatorsCount>0){
            person.talk();
            String fName = person.getFirstName();
            fName = fName.toUpperCase();
            String lName = person.getLastName();
            lName = lName + "-Shedrin";
            lName = lName.toUpperCase();
            person.setFirstName(fName);
            person.setLastName(lName);
        }
    }

}