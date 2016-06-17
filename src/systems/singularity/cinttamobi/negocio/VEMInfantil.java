package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.abstracts.VEM;

/**
 * Created by phts on 17/06/16.
 */
public class VEMInfantil extends VEM {
    public VEMInfantil(String number, Pessoa person) {
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
