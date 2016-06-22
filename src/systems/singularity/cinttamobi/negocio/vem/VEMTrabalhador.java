package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.SaldoInsuficienteException;
import systems.singularity.cinttamobi.exceptions.TipoVEMInvalidoException;
import systems.singularity.cinttamobi.exceptions.VEMInvalidoException;
import systems.singularity.cinttamobi.exceptions.ValorInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Trabalhador;

/**
 * Created by Edjan Michiles on 17/06/16.
 * © 2016 Singularity Systems
 */
public class VEMTrabalhador extends VEM {

    public VEMTrabalhador(String number, Pessoa person) throws TipoVEMInvalidoException, VEMInvalidoException {
        // Assim como nos outros VEMs, checa se o tipo de pessoa é correto.
        // Não requer filtragem adicional pelo próprio objeto Trabalhador já a fazer, assim como os outros
        // objetos dos outros VEM.
        super(number, person);
        if(!(person instanceof Trabalhador))
            throw new TipoVEMInvalidoException();
    }

    @Override
    public void credit(double value) throws ValorInvalidoException {
        // Creditar normal, como em VEM Comum
        if (value <= 0)
            throw new ValorInvalidoException();
        this.balance += value;
    }

    @Override
    public void debit(double value) throws ValorInvalidoException, SaldoInsuficienteException {
        // Debitar normal, como em VEM Comum
        if (value <= 0)
            throw new ValorInvalidoException();
        else if (value > this.getBalance())
            throw new SaldoInsuficienteException();
        this.balance -= value;
    }
}
