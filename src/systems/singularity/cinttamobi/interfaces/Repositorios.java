package systems.singularity.cinttamobi.interfaces;

/**
 * Created by lvrma on 02/05/16.
 * © 2016 Singularity Systems
 */
public interface Repositorios {

    boolean exists(String id);

    void insert(Object object);

    void update(Object object);

    void remove(Object object);

    Object search(String id);

}
