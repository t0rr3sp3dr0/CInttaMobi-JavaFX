package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.enums.Linhas;

/**
 * Created by phts on 17/06/16.
 */
public class Onibus {
    private String id;
    private Linhas linha;

    public Onibus(String id, Linhas linha) {
        this.id = id;
        this.linha = linha;
    }

    public String getId() {
        return id;
    }

    public Linhas getLinha() {
        return linha;
    }
}
