package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.dados.vem.RepositorioArrayVEM;
import systems.singularity.cinttamobi.dados.vem.RepositorioListaVEM;
import systems.singularity.cinttamobi.interfaces.Repositorios;

import java.util.prefs.Preferences;

/**
 * Created by lvrma on 19/06/16.
 */
public final class ControladorVEM{
    private static String tipo;

    private static RepositorioListaVEM repositorioLista = new RepositorioListaVEM();
    private static RepositorioArrayVEM repositorioArray = new RepositorioArrayVEM();

    private ControladorVEM(){}

    static {
        Preferences prefs = Preferences.userNodeForPackage(Programa.class);
        tipo = prefs.get("repo", null);
    }

    public static void setTipo(String tipo) {
        ControladorVEM.tipo = tipo;
    }

    public static boolean exists(String object) {
        if(tipo.equals("array"))
            return repositorioArray.exists(object);
        else if (tipo.equals("lista"))
            return repositorioLista.exists(object);
        return false;
    }

    public static void insert(Object object) {
        if(tipo.equals("array"))
            repositorioArray.insert(object);
        else if (tipo.equals("lista"))
            repositorioLista.insert(object);
    }

    public static void update(Object object) {
        if(tipo.equals("array"))
            repositorioArray.update(object);
        else if (tipo.equals("lista"))
            repositorioLista.update(object);
    }

    public static void remove(Object object) {
        if(tipo.equals("array"))
            repositorioArray.remove(object);
        else if (tipo.equals("lista"))
            repositorioLista.remove(object);
    }
    public static Object search(String object){
        if(tipo.equals("array"))
           return repositorioArray.search(object);
        else if (tipo.equals("lista"))
            return repositorioLista.search(object);
        return null;
    }



}
