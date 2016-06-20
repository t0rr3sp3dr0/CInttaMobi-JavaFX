package systems.singularity.cinttamobi.interfaces;

import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.util.ArrayList;

/**
 * Created by esvm on 20/06/16.
 */
public interface RepositoriosPessoa {

    boolean exists(String id);

    void insert(Pessoa object);

    void update(Pessoa object);

    void remove(Pessoa object);

    Pessoa search(String id);

    ArrayList toList();


}
