package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.dados.onibus.RepositorioOnibusArray;
import systems.singularity.cinttamobi.dados.onibus.RepositorioOnibusLista;
import systems.singularity.cinttamobi.exceptions.OnibusExistenteException;
import systems.singularity.cinttamobi.exceptions.OnibusInexistenteException;
import systems.singularity.cinttamobi.exceptions.RepositorioInvalidoException;
import systems.singularity.cinttamobi.interfaces.RepositoriosOnibus;
import systems.singularity.cinttamobi.negocio.Onibus;

import java.util.List;
import java.util.prefs.Preferences;

/**
 * Created by phts on 19/06/16.
 */
public class NegociosOnibus {
    private RepositoriosOnibus repositorio;

    public NegociosOnibus(String tipo) throws RepositorioInvalidoException {
        if (tipo.equals("array"))
            repositorio = new RepositorioOnibusArray();
        else if (tipo.equals("lista"))
            repositorio = new RepositorioOnibusLista();
        else
            throw new RepositorioInvalidoException();
    }

    public boolean exists(String id) {
        return repositorio.exists(id);
    }


    public void insert(Onibus object) throws OnibusExistenteException {
        if (!exists(object.getId())) {
            repositorio.insert(object);
        } else
            throw new OnibusExistenteException();
    }

    public void update(Onibus object) throws OnibusInexistenteException {

        if (exists(object.getId())) {
            repositorio.update(object);
        } else throw new OnibusInexistenteException();
    }

    public void remove(Onibus object) throws OnibusInexistenteException {

        if (exists(object.getId())) {
            repositorio.remove(object);
        } else throw new OnibusInexistenteException();
    }

    public Onibus search(String id) throws RepositorioInvalidoException, OnibusInexistenteException {
        if (exists(id)) {
            return repositorio.search(id);

        }
        else
            throw new OnibusInexistenteException();
    }

    public List toList() {
        return repositorio.toList();
    }
}
