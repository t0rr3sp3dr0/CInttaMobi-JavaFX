package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by phts on 17/06/16.
 */
public class VEMIdoso extends VEM {
    public VEMIdoso(String number, Pessoa person) {
        super(number, person);
    }

    @Override
    public void credit(double value) {
        throw new RuntimeException("Operação Inválida");
    }

    @Override
    public void debit(double value) {

    }
}