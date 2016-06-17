package systems.singularity.cinttamobi.abstracts;

import systems.singularity.cinttamobi.negocio.Pessoa;

/**
 * Created by phts on 16/06/16.
 */
public abstract class VEM {
    protected double balance;
    private String number;
    private Pessoa person;

    public VEM(String number, Pessoa person) {
        // TO-DO
        // Verify if number or person already exists
        if (number == null)
            throw new RuntimeException("Número Inválido");
        this.number = number;
        this.person = person;
        this.balance = 0;
    }

    public String getNumber() {
        return number;
    }

    public Pessoa getPerson() {
        return person;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void credit(double value);

    public abstract void debit(double value);
}
