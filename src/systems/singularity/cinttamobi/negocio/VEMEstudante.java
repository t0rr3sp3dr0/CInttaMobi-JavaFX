package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.abstracts.VEM;

/**
 * Created by Lucas Valença on 16/06/16.
 */
public class VEMEstudante extends VEM {

    public VEMEstudante(String number, Pessoa person, String studentID) {
      // Verify if student ID exists
        super(number, person);
    }

    @Override
    public void credit(double value) {
        if (value <= 0)
            throw new RuntimeException("Valor inválido");
        this.balance += value;
    }

    @Override
    public void debit(double value) {
        if (value <= 0)
            throw new RuntimeException("Valor inválido");
        else if (value/2 > this.getBalance())
            throw new RuntimeException("Saldo insuficiente");
        this.balance -= value/2;
    }
}
