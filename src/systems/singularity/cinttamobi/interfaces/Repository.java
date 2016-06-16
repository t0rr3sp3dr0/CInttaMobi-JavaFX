package systems.singularity.cinttamobi.interfaces;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lvrma on 02/05/16.
 * © 2016 Singularity Systems
 */
public interface Repository {
    boolean exists(Object object) throws SQLException, ClassNotFoundException;

    void insert(Object object) throws SQLException, ClassNotFoundException;

    void update(Object object) throws SQLException, ClassNotFoundException;

    void remove(Object object) throws SQLException, ClassNotFoundException;

    List getAll() throws SQLException, ClassNotFoundException;

    Object search(Object object) throws SQLException, ClassNotFoundException;
}
