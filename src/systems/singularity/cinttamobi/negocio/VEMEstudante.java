package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.SaldoInsuficienteException;
import systems.singularity.cinttamobi.exceptions.ValorInvalidoException;

/**
 * Created by Lucas Valença on 16/06/16.
 */
public class VEMEstudante extends VEM {

    public VEMEstudante(String number, Pessoa person, String studentID) {
      // Verify if student ID exists
        super(number, person);
    }

    @Override
    public void credit(double value) throws ValorInvalidoException {
        if (value <= 0)
            throw new ValorInvalidoException();
        this.balance += value;
    }

    @Override
    public void debit(double value) throws ValorInvalidoException, SaldoInsuficienteException {
        if (value <= 0)
            throw new ValorInvalidoException();
        else if (value/2 > this.getBalance())
            throw new SaldoInsuficienteException();
        this.balance -= value/2;
    }
}
