package systems.singularity.cinttamobi.enums;

/**
 * Created by Lucas Valença on 19/06/16.
 * © 2016 Singularity Systems
 */
public enum TiposVEM {

    //ENUM com todos os tipos de VEM no grande recife
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
