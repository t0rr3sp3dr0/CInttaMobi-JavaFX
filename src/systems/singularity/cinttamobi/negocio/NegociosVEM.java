package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.dados.vem.RepositorioVEMArray;
import systems.singularity.cinttamobi.dados.vem.RepositorioVEMLista;
import systems.singularity.cinttamobi.exceptions.RepositorioInvalidoException;
import systems.singularity.cinttamobi.exceptions.VEMInexistenteException;
import systems.singularity.cinttamobi.interfaces.RepositoriosVEM;

import java.util.prefs.Preferences;

/**
 * Created by lvrma on 19/06/16.
 */
public class NegociosVEM {

    private RepositoriosVEM repositorio;

    public NegociosVEM(String tipo) throws RepositorioInvalidoException {
        if (tipo.equals("array"))
            repositorio = new RepositorioVEMArray();
        else if (tipo.equals("lista"))
            repositorio = new RepositorioVEMLista();
        else
            throw new RepositorioInvalidoException();
    }

    public boolean exists(String id) {
        return repositorio.exists(id);
    }


    public void insert(VEM object) throws VEMInexistenteException {

        if (exists(object.getNumber())) {
            repositorio.insert(object);
        } else
            throw new VEMInexistenteException();
    }

    public void update(VEM object) throws VEMInexistenteException {

        if (exists(object.getNumber())) {
            repositorio.update(object);
        } else throw new VEMInexistenteException();
    }

    public void remove(VEM object) throws VEMInexistenteException {

        if (exists(object.getNumber())) {
            repositorio.remove(object);
        } else throw new VEMInexistenteException();
    }

    public Object search(String id) throws RepositorioInvalidoException, VEMInexistenteException {
        if (exists(id)) {
            return repositorio.search(id);

        }
        else
            throw new VEMInexistenteException();
    }

}
