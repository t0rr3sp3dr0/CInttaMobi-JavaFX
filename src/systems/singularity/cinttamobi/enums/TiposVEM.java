package systems.singularity.cinttamobi.enums;

import systems.singularity.cinttamobi.negocio.vem.*;

/**
 * Created by phts on 19/06/16.
 */
public enum TiposVEM {
    _null(null),
    Comum(VEMComum.class),
    Estudante(VEMEstudante.class),
    Idoso(VEMIdoso.class),
    Infantil(VEMInfantil.class),
    Trabalhador(VEMTrabalhador.class);

    private Class aClass;

    TiposVEM(Class aClass) {
        this.aClass = aClass;
    }

    public Class getaClass() {
        return aClass;
    }

    @Override
    public String toString() {
        return super.toString().replace("_null", "");
    }
}
