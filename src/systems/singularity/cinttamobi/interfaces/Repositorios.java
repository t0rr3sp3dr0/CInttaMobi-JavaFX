package systems.singularity.cinttamobi.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lvrma on 02/05/16.
 * © 2016 Singularity Systems
 */
public interface Repositorios {

    boolean exists(String object);

    void insert(Object object);

    void update(Object object);

    void remove(Object object);

    Object search(String object);

}
