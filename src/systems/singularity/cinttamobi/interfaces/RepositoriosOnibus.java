package systems.singularity.cinttamobi.interfaces;

import systems.singularity.cinttamobi.negocio.Onibus;

import java.util.ArrayList;

/**
 * Created by esvm on 20/06/16.
 */
public interface RepositoriosOnibus {

    boolean exists(String id);

    void insert(Onibus object);

    void update(Onibus object);

    void remove(Onibus object);

    Onibus search(String id);

    ArrayList toList();
}
