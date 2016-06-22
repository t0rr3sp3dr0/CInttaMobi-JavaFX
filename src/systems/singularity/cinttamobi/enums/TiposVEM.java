package systems.singularity.cinttamobi.enums;

/**
 * Created by phts on 19/06/16.
 * © 2016 Singularity Systems
 */
public enum TiposVEM {
    _null,
    Comum,
    Estudante,
    Idoso,
    Infantil,
    Trabalhador;

    @Override
    public String toString() {
        return super.toString().replace("_null", "");
    }
}
