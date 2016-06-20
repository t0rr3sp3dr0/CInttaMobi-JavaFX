package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.interfaces.RepositoriosVEM;

import java.util.ArrayList;

/**
 * Created by lvrma on 19/06/16.
 */
public class RepositorioVEMArray implements RepositoriosVEM {

    private VEM[] array = new VEM[0];

    @Override
    public boolean exists(String object) {
        if (search(object) != null)
            return true;
        return false;
    }

    @Override
    public void insert(VEM object) {

        VEM[] temp = new VEM[array.length + 1];

        for (int i = 0; i < array.length; i++)
            temp[i] = array[i];

        temp[array.length] = object;
        array = temp;
    }

    @Override
    public void update(VEM object) {

        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber().equals(object.getNumber())) {
                array[i] = object;
                return;
            }
    }

    @Override
    public void remove(VEM object) {

        VEM[] temp = new VEM[array.length - 1];

        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber().equals(object.getNumber()))
                array[i] = array[array.length - 1];

        for (int i = 0; i < array.length - 1; i++)
            temp[i] = array[i];

        this.array = temp;
    }

    @Override
    public VEM search(String object) {
        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber().equals(object))
                return array[i];
        return null;
    }

    @Override
    public ArrayList toList() {

        ArrayList<VEM> VEMs = new ArrayList<>();
        for (int i = 0; i < array.length; i++)
            VEMs.add(array[i]);

        return VEMs;
    }
}
