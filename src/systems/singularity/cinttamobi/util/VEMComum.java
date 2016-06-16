package systems.singularity.cinttamobi.util;

import systems.singularity.cinttamobi.util.abstracts.VEM;

/**
 * Created by phts on 16/06/16.
 */
public class VEMComum extends VEM {
    public VEMComum(String number) {
        super(number, null);
    }

    @Override
    public void credit(int value) {
        if (value <= 0)
            throw new RuntimeException("Valor inválido");
        this.balance += value;
    }

    @Override
    public void debit(int value) {
        if (value <= 0)
            throw new RuntimeException("Valor inválido");
        else if (value > this.getBalance())
            throw new RuntimeException("Saldo insuficiente");
        this.balance -= value;
    }
}
