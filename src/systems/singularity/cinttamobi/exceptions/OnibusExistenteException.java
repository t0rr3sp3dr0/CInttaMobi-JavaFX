package systems.singularity.cinttamobi.exceptions;

/**
 * Created by Pedro Tôrres on 20/06/16.
 * © 2016 Singularity Systems
 */
public class OnibusExistenteException extends Exception {
    public OnibusExistenteException() {
        super("Ônibus já existe!");
    }
}
