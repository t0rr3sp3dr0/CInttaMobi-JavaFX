package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.OperacaoInvalidaException;
import systems.singularity.cinttamobi.exceptions.TipoVEMInvalidoException;
import systems.singularity.cinttamobi.exceptions.VEMInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.Idoso;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by phts on 17/06/16.
 * © 2016 Singularity Systems
 */
public class VEMIdoso extends VEM {
    public VEMIdoso(String number, Pessoa person) throws TipoVEMInvalidoException, VEMInvalidoException {
        // Checa se a pessoa passada é de fato idoso.
        // Lembrando que o objeto idoso só se permite instanciar a partir de certa idade
        super(number, person);
        if(!(person instanceof Idoso))
            throw new TipoVEMInvalidoException();
    }

    @Override
    public void credit(double value) throws OperacaoInvalidaException {
        // VEM de idoso tem "saldo infinito"
        throw new OperacaoInvalidaException();
    }

    @Override
    public void debit(double value){
        // VEM de idoso tem "saldo infinito"
    }


}
