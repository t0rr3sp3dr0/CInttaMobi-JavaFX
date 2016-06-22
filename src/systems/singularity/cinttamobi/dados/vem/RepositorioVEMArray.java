package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.interfaces.RepositoriosVEM;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Lucas Valença on 19/06/16.
 * © 2016 Singularity Systems
 */
public class RepositorioVEMArray implements RepositoriosVEM {

    private VEM[] array = new VEM[0];

    @Override
    public boolean exists(String object)
    {
        //verifica se existe um VEM no array com o determinado número
        return search(object) != null;
    }

    @Override
    public void insert(VEM object) {
        //insere um VEM no array
        //tamanho do array aumenta de forma dinâmica
        VEM[] temp = new VEM[array.length + 1];

        for (int i = 0; i < array.length; i++)
            temp[i] = array[i];

        temp[array.length] = object;
        array = temp;
    }

    @Override
    public void update(VEM object) {
        //atualiza um VEM no array
        for (int i = 0; i < array.length; i++)
            if (array[i].getNumber().equals(object.getNumber())) {
                array[i] = object;
                return;
            }
    }

    @Override
    public void remove(VEM object) {
        //remove um VEM do array
        //array diminui de tamanho de forma dinâmica
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
        //procura um VEM no array a partir do número do VEM
        for (VEM anArray : array)
            if (anArray.getNumber().equals(object))
                return anArray;
        return null;
    }

    // Usado apenas na GUI
    @Override
    public ArrayList toList() {
        //converte o array para ArrayList para usar na GUI
        //Uso exclusivo na GUI
        ArrayList<VEM> VEMs = new ArrayList<>();
        Collections.addAll(VEMs, array);
        return VEMs;
    }
}
