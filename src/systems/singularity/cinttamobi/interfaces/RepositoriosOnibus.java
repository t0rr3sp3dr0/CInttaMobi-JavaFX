package systems.singularity.cinttamobi.interfaces;

import systems.singularity.cinttamobi.negocio.Onibus;

import java.util.ArrayList;

/**
 * Created by esvm on 20/06/16.
 * © 2016 Singularity Systems
 */
public interface RepositoriosOnibus {
    //Interface de Repositorio de Onibus
    boolean exists(String id);
    void insert(Onibus object);
    void update(Onibus object);
    void remove(Onibus object);
    Onibus search(String id);
    ArrayList toList();
}
