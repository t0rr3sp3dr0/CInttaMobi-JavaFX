package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.dados.onibus.RepositorioOnibusArray;
import systems.singularity.cinttamobi.dados.onibus.RepositorioOnibusLista;
import systems.singularity.cinttamobi.exceptions.OnibusExistenteException;
import systems.singularity.cinttamobi.exceptions.OnibusInexistenteException;
import systems.singularity.cinttamobi.exceptions.RepositorioInvalidoException;
import systems.singularity.cinttamobi.interfaces.RepositoriosOnibus;

import java.util.List;

/**
 * Created by phts on 19/06/16.
 * © 2016 Singularity Systems
 */
public class NegociosOnibus {
    private RepositoriosOnibus repositorio;

    public NegociosOnibus(String tipo) throws RepositorioInvalidoException {
        switch (tipo) {
            case "array":
                repositorio = new RepositorioOnibusArray();
                break;
            case "lista":
                repositorio = new RepositorioOnibusLista();
                break;
            default:
                throw new RepositorioInvalidoException();
        }
    }

    private boolean exists(String id) {
        return repositorio.exists(id);
    }


    public void insert(Onibus object) throws OnibusExistenteException {
        if (!exists(object.getNumber())) {
            repositorio.insert(object);
        } else
            throw new OnibusExistenteException();
    }

    public void update(Onibus object) throws OnibusInexistenteException {

        if (exists(object.getNumber())) {
            repositorio.update(object);
        } else throw new OnibusInexistenteException();
    }

    public void remove(Onibus object) throws OnibusInexistenteException {

        if (exists(object.getNumber())) {
            repositorio.remove(object);
        } else throw new OnibusInexistenteException();
    }

    public List toList() {
        return repositorio.toList();
    }
}
