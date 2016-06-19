package systems.singularity.cinttamobi.negocio.controladores;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.dados.onibus.RepositorioOnibusArray;
import systems.singularity.cinttamobi.dados.onibus.RepositorioOnibusLista;
import systems.singularity.cinttamobi.exceptions.OnibusInexistenteException;
import systems.singularity.cinttamobi.exceptions.RepositorioInvalidoException;
import systems.singularity.cinttamobi.negocio.Onibus;

import java.util.prefs.Preferences;

/**
 * Created by phts on 19/06/16.
 */
public final class ControladorOnibus {
    private static String tipo;

    private static RepositorioOnibusArray repositorioLista = new RepositorioOnibusArray();
    private static RepositorioOnibusLista repositorioArray = new RepositorioOnibusLista();

    static {
        Preferences prefs = Preferences.userNodeForPackage(Programa.class);
        tipo = prefs.get("repo", null);
    }

    private ControladorOnibus() {
    }

    public static boolean exists(String object) {
        if (tipo.equals("array"))
            return repositorioArray.exists(object);
        else if (tipo.equals("lista"))
            return repositorioLista.exists(object);
        return false;
    }

    public static void insert(Object objectTemp) throws OnibusInexistenteException {
        Onibus object = (Onibus) objectTemp;
        if (exists(object.getId())) {
            if (tipo.equals("array"))
                repositorioArray.insert(object);
            else if (tipo.equals("lista"))
                repositorioLista.insert(object);
        } else throw new OnibusInexistenteException();
    }

    public static void update(Object objectTemp) throws OnibusInexistenteException {
        Onibus object = (Onibus) objectTemp;
        if (exists(object.getId())) {
            if (tipo.equals("array"))
                repositorioArray.update(object);
            else if (tipo.equals("lista"))
                repositorioLista.update(object);
        } else throw new OnibusInexistenteException();
    }

    public static void remove(Object objectTemp) throws OnibusInexistenteException {
        Onibus object = (Onibus) objectTemp;
        if (exists(object.getId())) {
            if (tipo.equals("array"))
                repositorioArray.remove(object);
            else if (tipo.equals("lista"))
                repositorioLista.remove(object);
        } else throw new OnibusInexistenteException();
    }

    public static Object search(String object) throws RepositorioInvalidoException, OnibusInexistenteException {
        if (exists(object)) {
            if (tipo.equals("array"))
                return repositorioArray.search(object);
            else if (tipo.equals("lista"))
                return repositorioLista.search(object);
            else throw new RepositorioInvalidoException();
        } else throw new OnibusInexistenteException();
    }
}
