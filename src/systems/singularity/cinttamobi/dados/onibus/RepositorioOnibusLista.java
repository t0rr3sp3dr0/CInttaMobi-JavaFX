package systems.singularity.cinttamobi.dados.onibus;

import systems.singularity.cinttamobi.interfaces.RepositoriosOnibus;
import systems.singularity.cinttamobi.interfaces.RepositoriosVEM;
import systems.singularity.cinttamobi.negocio.Onibus;

import java.util.ArrayList;

/**
 * Created by phts on 19/06/16.
 */
public final class RepositorioOnibusLista implements RepositoriosOnibus {
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
    public void insert(Onibus object) {

        if (this.value == null)
            this.value = value;
        else if (this.node == null) {
            this.node = new RepositorioOnibusLista(value);
            this.node.parent = this;
        } else
            this.node.insert(value);
    }

    @Override
    public void update(Onibus object) {

        if (this.value.getId().equals(object.getId()))
            this.value = object;
        else if (this.node != null)
            this.node.update(object);
    }

    @Override
    public void remove(Onibus object) {

        if (this.value.getId().equals(object.getId())) {
            if (this.parent == null) {
                this.value = this.node.value;
                this.node = this.node.node;
            } else
                this.parent.node = this.node;
        } else
            this.node.remove(object);
    }

    @Override
    public Onibus search(String id) {
        if (this.value.getId().equals(id))
            return this.value;
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
