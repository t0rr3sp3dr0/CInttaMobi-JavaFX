package systems.singularity.cinttamobi.dados.onibus;

import systems.singularity.cinttamobi.interfaces.Repositorios;
import systems.singularity.cinttamobi.negocio.Onibus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phts on 19/06/16.
 */
public final class RepositorioOnibusLista implements Repositorios {
    public RepositorioOnibusLista node;
    public RepositorioOnibusLista parent;
    public Onibus value;

    public RepositorioOnibusLista() {
    }

    private RepositorioOnibusLista(Onibus value) {
        this.value = value;
    }

    @Override
    public boolean exists(String id) {
        if (this.value.getId().equals(id))
            return true;
        else if (this.node == null)
            return false;
        else
            return this.node.exists(id);
    }

    @Override
    public void insert(Object object) {
        Onibus value = (Onibus) object;
        if (this.value == null)
            this.value = value;
        else if (this.node == null) {
            this.node = new RepositorioOnibusLista(value);
            this.node.parent = this;
        } else
            this.node.insert(value);
    }

    @Override
    public void update(Object object) {
        Onibus onibus = (Onibus) object;
        if (this.value.getId().equals(onibus.getId()))
            this.value = onibus;
        else if (this.node != null)
            this.node.update(onibus);
    }

    @Override
    public void remove(Object object) {
        Onibus onibus = (Onibus) object;
        if (this.value.getId().equals(onibus.getId())) {
            if (this.parent == null) {
                this.value = this.node.value;
                this.node = this.node.node;
            } else
                this.parent.node = this.node;
        } else
            this.node.remove(onibus);
    }

    @Override
    public Object search(String id) {
        if (this.value.getId().equals(id))
            return this;
        else if (this.node != null)
            return this.node.search(id);
        else
            return null;
    }


    @Override
    public ArrayList toList() {
        ArrayList<Onibus> onibusList = new ArrayList<>();
        if(this.value != null){
            onibusList.add(this.value);
            onibusList = this.node.toList();
        }
        return onibusList;
    }
}
