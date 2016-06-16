package systems.singularity.cinttamobi.util;

/**
 * Created by phts on 16/06/16.
 */
public abstract class VEM {
    private String number;
    private Person person;

    public VEM(String number, Person person) {
        // TO-DO
        // Verify if number or person already exists
        // Verify if number is not null
        this.number = number;
        this.person = person;
    }

    public String getNumber() {
        return number;
    }

    public Person getPerson() {
        return person;
    }

    public abstract void credit(int value);

    public abstract void debit(int value);
}
