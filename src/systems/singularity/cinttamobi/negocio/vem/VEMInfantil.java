package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.enums.TiposVEM;
import systems.singularity.cinttamobi.exceptions.*;
import systems.singularity.cinttamobi.negocio.pessoas.Crianca;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by phts on 17/06/16.
 */
public class VEMInfantil extends VEM {

    public VEMInfantil(String number, Pessoa person) throws TipoVEMInvalidoException, VEMInvalidoException {
        super(number, person);
        if(!(person instanceof Crianca))
            throw new TipoVEMInvalidoException();
    }

    @Override
    public void credit(double value) throws OperacaoInvalidaException {
        throw new OperacaoInvalidaException();
    }

    @Override
    public void debit(double value){
    }


}
