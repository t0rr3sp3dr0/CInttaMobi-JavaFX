package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.enums.Linhas;
import systems.singularity.cinttamobi.exceptions.ParametroNuloException;

/**
 * Created by phts on 17/06/16.
 * © 2016 Singularity Systems
 */
public class Onibus {
    private String number;
    private Linhas line;

    public Onibus(String number, Linhas line) throws ParametroNuloException {
        if(number == null || line == null)
        {
            throw new ParametroNuloException();
        }
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
