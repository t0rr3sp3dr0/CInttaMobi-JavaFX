package systems.singularity.cinttamobi.dados.onibus;

import systems.singularity.cinttamobi.interfaces.Repositorios;
import systems.singularity.cinttamobi.negocio.Onibus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phts on 19/06/16.
 */
public class RepositorioOnibusArray implements Repositorios {
    private Onibus[] onibus = {};

    public RepositorioOnibusArray() {
    }

    @Override
    public boolean exists(String id) {
        for (int i = 0; i < onibus.length; i++)
            if (onibus[i].getId().equals(id))
                return true;
        return false;
    }

    @Override
    public void insert(Object object) {
        Onibus[] onibus = new Onibus[this.onibus.length + 1];
        for (int i = 0; i < this.onibus.length; i++)
            onibus[i] = this.onibus[i];
        onibus[this.onibus.length] = (Onibus) object;
        this.onibus = onibus;
    }

    @Override
    public void update(Object object) {
        Onibus onibus = (Onibus) object;
        for (int i = 0; i < this.onibus.length; i++)
            if (this.onibus[i].getId().equals(onibus.getId())) {
                this.onibus[i] = onibus;
                return;
            }
    }

    @Override
    public void remove(Object object) {
        Onibus[] onibus = new Onibus[this.onibus.length - 1];
        for (int i = 0, j = 0; i < this.onibus.length; i++)
            if (!this.onibus[i].getId().equals(((Onibus) object).getId())) {
                onibus[j] = this.onibus[i];
                j++;
            }
        this.onibus = onibus;
    }

    @Override
    public Object search(String id) {
        for (Onibus onibus : this.onibus)
            if (onibus.getId().equals(id))
                return onibus;
        return null;
    }

    @Override
    public List toList() {
        ArrayList<Onibus> onibusList = new ArrayList<>();
        for (Onibus onibus: this.onibus)
            onibusList.add(onibus);

        return onibusList;
    }
}
