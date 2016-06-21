package systems.singularity.cinttamobi.dados.onibus;

import systems.singularity.cinttamobi.interfaces.RepositoriosOnibus;
import systems.singularity.cinttamobi.negocio.Onibus;

import java.util.ArrayList;

/**
 * Created by phts on 19/06/16.
 */
public class RepositorioOnibusArray implements RepositoriosOnibus {
    private Onibus[] onibus = {};

    public RepositorioOnibusArray() {
    }

    @Override
    public boolean exists(String id) {
        for (int i = 0; i < onibus.length; i++)
            if (onibus[i].getNumber().equals(id))
                return true;
        return false;
    }

    @Override
    public void insert(Onibus object) {
        Onibus[] onibus = new Onibus[this.onibus.length + 1];
        for (int i = 0; i < this.onibus.length; i++)
            onibus[i] = this.onibus[i];
        onibus[this.onibus.length] = (Onibus) object;
        this.onibus = onibus;
    }

    @Override
    public void update(Onibus object) {

        for (int i = 0; i < this.onibus.length; i++)
            if (this.onibus[i].getNumber().equals(object.getNumber())) {
                this.onibus[i] = object;
                return;
            }
    }

    @Override
    public void remove(Onibus object) {
        Onibus[] onibus = new Onibus[this.onibus.length - 1];
        for (int i = 0, j = 0; i < this.onibus.length; i++)
            if (!this.onibus[i].getNumber().equals(((Onibus) object).getNumber())) {
                onibus[j] = this.onibus[i];
                j++;
            }
        this.onibus = onibus;
    }

    @Override
    public Onibus search(String id) {
        for (Onibus onibus : this.onibus)
            if (onibus.getNumber().equals(id))
                return onibus;
        return null;
    }

    @Override
    public ArrayList toList() {
        ArrayList<Onibus> onibusList = new ArrayList<>();
        for (Onibus item: this.onibus)
            onibusList.add(item);

        return onibusList;
    }
}
