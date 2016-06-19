package systems.singularity.cinttamobi.dados.onibus;

import systems.singularity.cinttamobi.interfaces.Repositorios;
import systems.singularity.cinttamobi.negocio.Onibus;

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
    public boolean exists(String object) {
        return false;
    }

    @Override
    public void insert(Object object) {

    }

    @Override
    public void update(Object object) {

    }

    @Override
    public void remove(Object object) {

    }

    @Override
    public Object search(String object) {
        return null;
    }

    public void add(Onibus value) {
        if (this.value == null)
            this.value = value;
        else if (this.node == null) {
            this.node = new RepositorioOnibusLista(value);
            this.node.parent = this;
        } else
            this.node.add(value);
    }

    public Onibus get(int index) {
        if (index == 0)
            return this.value;
        else
            return this.node.get(--index);
    }

    public void remove(Onibus value) {
        if (this.value.equals(value)) {
            if (this.parent == null) {
                this.value = this.node.value;
                this.node = this.node.node;
            } else
                this.parent.node = this.node;
        } else
            this.node.remove(value);
    }

    public RepositorioOnibusLista firstNode() {
        return this;
    }

    public RepositorioOnibusLista lastNode() {
        if (this.node == null)
            return this;
        else
            return this.node.lastNode();
    }

    public int size() {
        if (this.node == null)
            return 1;
        else
            return 1 + this.node.size();
    }

    public RepositorioOnibusLista invertedList() {
        RepositorioOnibusLista node = this.lastNode();
        RepositorioOnibusLista invertedLinkedList = new RepositorioOnibusLista(this.lastNode().value);
        for (int i = 0; i < this.size() - 1; i++) {
            node = node.parent;
            invertedLinkedList.add(node.value);
        }
        return invertedLinkedList;
    }

    public void invert() {
        RepositorioOnibusLista invertedLinkedList = this.invertedList();
        this.value = invertedLinkedList.value;
        this.node = invertedLinkedList.node;
    }

    public boolean contains(String value) {
        if (this.value.getId().equals(value))
            return true;
        else if (this.node == null)
            return false;
        else
            return this.node.contains(value);
    }

    public boolean contains(Onibus value) {
        if (this.value.equals(value))
            return true;
        else if (this.node == null)
            return false;
        else
            return this.node.contains(value);
    }

    public int indexOf(Onibus value) {
        for (int i = 0; i < this.size(); i++)
            if (this.get(i).equals(value))
                return i;
        return -1;
    }

    public int lastIndexOf(Onibus value) {
        RepositorioOnibusLista invertedLinkedList = this.invertedList();
        for (int i = 0; i < invertedLinkedList.size(); i++)
            if (invertedLinkedList.get(i).equals(value))
                return i;
        return -1;
    }
}
