package systems.singularity.cinttamobi.Repositories.VEM;

import systems.singularity.cinttamobi.interfaces.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by esvm on 17/06/16.
 */
public class RepositorioVEMLista implements Repository {
    @Override
    public boolean exists(Object object) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void insert(Object object) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void update(Object object) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void remove(Object object) throws SQLException, ClassNotFoundException {

    }

    @Override
    public List getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public Object search(Object object) throws SQLException, ClassNotFoundException {
        return null;
    }
}
