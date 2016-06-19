package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.dados.vem.RepositorioArrayVEM;
import systems.singularity.cinttamobi.dados.vem.RepositorioListaVEM;
import systems.singularity.cinttamobi.interfaces.Repositorios;

/**
 * Created by lvrma on 19/06/16.
 */
public final class ControladorVEM{

    private static String tipo = "lista";

    private static RepositorioListaVEM repositorioLista = new RepositorioListaVEM();
    private static RepositorioArrayVEM repositorioArray = new RepositorioArrayVEM();

    private ControladorVEM(){
    }

    public boolean exists(Object object) {
        return false;
    }

    public void insert(Object object) {

    }

    public void update(Object object) {

    }

    public void remove(Object object) {

    }
    public static Object search(Object object){
        if(tipo.equals("array"))
           return repositorioArray.search(object);
        else if (tipo.equals("lista"))
            return repositorioLista.search(object);
        return null;
    }



}
