package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.dados.vem.RepositorioVEMArray;
import systems.singularity.cinttamobi.dados.vem.RepositorioVEMLista;
import systems.singularity.cinttamobi.exceptions.RepositorioInvalidoException;
import systems.singularity.cinttamobi.exceptions.VEMInexistenteException;

import java.util.prefs.Preferences;

/**
 * Created by lvrma on 19/06/16.
 */
public final class ControladorVEM {
    private static String tipo;

    private static RepositorioVEMLista repositorioLista = new RepositorioVEMLista();
    private static RepositorioVEMArray repositorioArray = new RepositorioVEMArray();

    private ControladorVEM() {
    }

    static {
        Preferences prefs = Preferences.userNodeForPackage(Programa.class);
        tipo = prefs.get("repo", null);
    }

    public static void setTipo(String tipo) {
        ControladorVEM.tipo = tipo;
    }

    public static boolean exists(String object) {
        if (tipo.equals("array"))
            return repositorioArray.exists(object);
        else if (tipo.equals("lista"))
            return repositorioLista.exists(object);
        return false;
    }

    public static void insert(Object objectTemp) throws VEMInexistenteException {
        VEM object = (VEM) objectTemp;
        if (exists(object.getNumber())) {
            if (tipo.equals("array"))
                repositorioArray.insert(object);
            else if (tipo.equals("lista"))
                repositorioLista.insert(object);
        } else throw new VEMInexistenteException();
    }

    public static void update(Object objectTemp) throws VEMInexistenteException {
        VEM object = (VEM) objectTemp;
        if (exists(object.getNumber())) {
            if (tipo.equals("array"))
                repositorioArray.update(object);
            else if (tipo.equals("lista"))
                repositorioLista.update(object);
        } else throw new VEMInexistenteException();
    }

    public static void remove(Object objectTemp) throws VEMInexistenteException {
        VEM object = (VEM) objectTemp;
        if (exists(object.getNumber())) {
            if (tipo.equals("array"))
                repositorioArray.remove(object);
            else if (tipo.equals("lista"))
                repositorioLista.remove(object);
        } else throw new VEMInexistenteException();
    }

    public static Object search(String object) throws RepositorioInvalidoException, VEMInexistenteException {
        if (exists(object)) {
            if (tipo.equals("array"))
                return repositorioArray.search(object);
            else if (tipo.equals("lista"))
                return repositorioLista.search(object);
            else throw new RepositorioInvalidoException();
        } else throw new VEMInexistenteException();
    }


}
