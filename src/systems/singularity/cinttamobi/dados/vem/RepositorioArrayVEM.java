package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.interfaces.Repositorios;
import systems.singularity.cinttamobi.negocio.ControladorVEM;

/**
 * Created by lvrma on 19/06/16.
 */
public class RepositorioArrayVEM implements Repositorios {

    private VEM[] array = new VEM[0];

    @Override
    public boolean exists(String object) {
        if (search(object) != null)
            return true;
        return false;
    }

    @Override
    public void insert(Object objectTemp) {
        VEM object = (VEM) objectTemp;
        VEM[] temp = new VEM[array.length + 1];

        for (int i = 0; i < array.length; i++)
            temp[i] = array[i];

        temp[array.length] = object;
        array = temp;
    }

    @Override
    public void update(Object objectTemp) {
        VEM object = (VEM) objectTemp;
        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber().equals(object.getNumber()))
                array[i] = object;
    }

    @Override
    public void remove(Object objectTemp) {
        VEM object = (VEM) objectTemp;
        VEM[] temp = new VEM[array.length - 1];

        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber().equals(object.getNumber()))
                array[i] = array[array.length - 1];

        for (int i = 0; i < array.length - 1; i++)
            temp[i] = array[i];

        this.array = temp;
    }

    @Override
    public Object search(String object) {
        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber().equals(object))
                return array[i];
        return null;
    }
}
