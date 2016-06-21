package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.enums.Linhas;

/**
 * Created by phts on 17/06/16.
 */
public class Onibus {
    private String number;
    private Linhas line;

    public Onibus(String number, Linhas line) {
        this.number = number;
        this.line = line;
    }

    public String getNumber() {
        return number;
    }

    public Linhas getLine() {
        return line;
    }
}
