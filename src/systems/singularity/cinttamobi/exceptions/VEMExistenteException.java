package systems.singularity.cinttamobi.exceptions;

/**
 * Created by Pedro Tôrres on 20/06/16.
 * © 2016 Singularity Systems
 */
public class VEMExistenteException extends Exception {
    public VEMExistenteException() {
        super("VEM já existe!");
    }
}
