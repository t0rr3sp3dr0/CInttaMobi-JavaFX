package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.interfaces.RepositoriosVEM;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by lvrma on 19/06/16.
 * © 2016 Singularity Systems
 */
public class RepositorioVEMArray implements RepositoriosVEM {

    private VEM[] array = new VEM[0];

    @Override
    public boolean exists(String object) {
        return search(object) != null;
    }

    @Override
    public void insert(VEM object) {

        VEM[] temp = new VEM[array.length + 1];

        System.arraycopy(array, 0, temp, 0, array.length);

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

        System.arraycopy(array, 0, temp, 0, array.length - 1);

        this.array = temp;
    }

    @Override
    public VEM search(String object) {
        for (VEM anArray : array)
            if (anArray.getNumber().equals(object))
                return anArray;
        return null;
    }

    // Usado apenas na GUI
    @Override
    public ArrayList toList() {
        ArrayList<VEM> VEMs = new ArrayList<>();
        Collections.addAll(VEMs, array);
        return VEMs;
    }
}
