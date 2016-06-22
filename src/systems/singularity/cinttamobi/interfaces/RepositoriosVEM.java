package systems.singularity.cinttamobi.interfaces;

import systems.singularity.cinttamobi.abstracts.VEM;

import java.util.ArrayList;

/**
 * Created by lvrma on 02/05/16.
 * © 2016 Singularity Systems
 */
public interface RepositoriosVEM {
    //Interface de Repositorio de VEM
    boolean exists(String id);
    void insert(VEM object);
    void update(VEM object);
    void remove(VEM object);
    VEM search(String id);
    ArrayList toList();
}
