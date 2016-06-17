package systems.singularity.cinttamobi.util;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.SaldoInsuficienteException;
import systems.singularity.cinttamobi.exceptions.ValorInvalidoException;

/**
 * Created by phts on 16/06/16.
 */
public class VEMComum extends VEM {
    public VEMComum(String number) {
        super(number, null);
    }


    @Override
    public void credit(double value) throws ValorInvalidoException {
        if (value <= 0)
            throw new ValorInvalidoException();
        this.balance += value;
    }

    @Override
    public void debit(double value) throws SaldoInsuficienteException, ValorInvalidoException {
        if (value <= 0)
        {
            throw new ValorInvalidoException();
        } else if (this.balance < value)
        {
            throw new SaldoInsuficienteException();
        }
    }


}
