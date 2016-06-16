package systems.singularity.cinttamobi.util.abstracts;

import systems.singularity.cinttamobi.util.Person;

/**
 * Created by phts on 16/06/16.
 */
public abstract class VEM {
    protected double balance;
    private String number;
    private Person person;

    public VEM(String number, Person person) {
        // TO-DO
        // Verify if number or person already exists
        // Verify if number is not null
        this.number = number;
        this.person = person;
        this.balance = 0;
    }

    public String getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void credit(int value);

    public abstract void debit(int value);
}
