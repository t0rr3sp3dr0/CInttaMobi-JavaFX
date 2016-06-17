package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.OperacaoInvalidaException;
import systems.singularity.cinttamobi.exceptions.SaldoInsuficienteException;
import systems.singularity.cinttamobi.exceptions.ValorInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by phts on 17/06/16.
 */
public class VEMInfantil extends VEM {
    public VEMInfantil(String number, Pessoa person) {
        super(number, person);
    }

    @Override
    public void credit(double value) throws OperacaoInvalidaException {
        throw new OperacaoInvalidaException();
    }

    @Override
    public void debit(double value){

    }


}
