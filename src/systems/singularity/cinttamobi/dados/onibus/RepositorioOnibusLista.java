package systems.singularity.cinttamobi.dados.onibus;

import systems.singularity.cinttamobi.interfaces.RepositoriosOnibus;
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
        if (this.value == null)
            return false;
        else if (this.value.getNumber().equals(id))
            return true;
        else if (this.node == null)
            return false;
        else
            return this.node.exists(id);
    }

    @Override
    public void insert(Onibus object) {

        if (this.value == null)
            this.value = object;
        else if (this.node == null) {
            this.node = new RepositorioOnibusLista(object);
            this.node.parent = this;
        } else
            this.node.insert(object);
    }

    @Override
    public void update(Onibus object) {

        if (this.value.getNumber().equals(object.getNumber()))
            this.value = object;
        else if (this.node != null)
            this.node.update(object);
    }

    @Override
    public void remove(Onibus object) {

        if (this.value.getNumber().equals(object.getNumber())) {
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
        if (this.value.getNumber().equals(id))
            return this.value;
        else if (this.node != null)
            return this.node.search(id);
        else
            return null;
    }

    public Onibus get(int index) {
        if (index == 0)
            return this.value;
        else
            return this.node.get(--index);
    }

    public int size() {
        if (this.node == null)
            return 1;
        else
            return 1 + this.node.size();
    }


    @Override
    public ArrayList toList() {
        ArrayList<Onibus> list = new ArrayList<>();
        int size = size();
        for (int i = 0; i < size; i++)
            list.add(get(i));
        return list;
    }
}
