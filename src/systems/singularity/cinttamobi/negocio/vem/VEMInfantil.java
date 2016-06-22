package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.OperacaoInvalidaException;
import systems.singularity.cinttamobi.exceptions.TipoVEMInvalidoException;
import systems.singularity.cinttamobi.exceptions.VEMInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.Crianca;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by phts on 17/06/16.
 * © 2016 Singularity Systems
 */
public class VEMInfantil extends VEM {

    public VEMInfantil(String number, Pessoa person) throws TipoVEMInvalidoException, VEMInvalidoException {
        // Checa se o objeto recebido realmente é criança,
        // que, assim como idoso, só se permite instanciar a partir de certa idade.
        super(number, person);
        if(!(person instanceof Crianca))
            throw new TipoVEMInvalidoException();
    }

    @Override
    public void credit(double value) throws OperacaoInvalidaException {
        // Assim como idoso, VEM Infantil tem "saldo infinito"
        throw new OperacaoInvalidaException();
    }

    @Override
    public void debit(double value){
        // Assim como idoso, VEM Infantil tem "saldo infinito"
    }


}
