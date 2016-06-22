package systems.singularity.cinttamobi.interfaces;

import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.util.ArrayList;

/**
 * Created by Edjan Michiles on 20/06/16.
 * © 2016 Singularity Systems
 */
public interface RepositoriosPessoa {
    //Interface de Repositorio de Pessoa
    boolean exists(String id);
    boolean existsID(String id);
    boolean existsNIS(String id);
    void insert(Pessoa object);
    void update(Pessoa object);
    void remove(Pessoa object);
    Pessoa search(String id);
    ArrayList toList();
}
