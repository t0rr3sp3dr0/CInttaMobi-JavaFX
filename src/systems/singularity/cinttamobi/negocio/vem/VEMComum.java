package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.SaldoInsuficienteException;
import systems.singularity.cinttamobi.exceptions.VEMInvalidoException;
import systems.singularity.cinttamobi.exceptions.ValorInvalidoException;

/**
 * Created by Pedro Tôrres on 16/06/16.
 * © 2016 Singularity Systems
 */
public class VEMComum extends VEM {
    public VEMComum(String number) throws VEMInvalidoException {
        // Cria um VEM comum, que não possui dono fixo (pela definição no site do Grande Recife)
        super(number, null);
    }

    @Override
    public void credit(double value) throws ValorInvalidoException {
        // Credita o valor, caso este seja positivo
        if (value <= 0)
            throw new ValorInvalidoException();
        this.balance += value;
    }

    @Override
    public void debit(double value) throws SaldoInsuficienteException, ValorInvalidoException {
        // Debita o valor caso haja saldo e o valor a debitar seja positivo
        if (value <= 0)
        {
            throw new ValorInvalidoException();
        } else if (this.balance < value)
        {
            throw new SaldoInsuficienteException();
        }
        this.balance -= value;
    }


}
