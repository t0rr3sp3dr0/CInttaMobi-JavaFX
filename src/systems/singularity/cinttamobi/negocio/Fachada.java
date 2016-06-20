package systems.singularity.cinttamobi.negocio;

/**
 * Created by esvm on 20/06/16.
 */
public class Fachada {
    private static Fachada ourInstance = new Fachada();

    public static Fachada getInstance() {
        return ourInstance;
    }

    private Fachada() {

    }
}
