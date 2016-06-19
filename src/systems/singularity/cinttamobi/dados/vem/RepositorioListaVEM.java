package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.interfaces.Repositorios;

/**
 * Created by lvrma on 19/06/16.
 */
public class RepositorioListaVEM implements Repositorios{

    private ListaEncadeadaVEM root;

    public RepositorioListaVEM() {
        root = null;
    }

    public RepositorioListaVEM(VEM value) {
        root = new ListaEncadeadaVEM(value);
        root.setNext(null);
    }

    @Override
    public VEM search(Object id) {
        return null;
    }

    @Override
    public void insert(Object valueTemp) {
        VEM value = (VEM) valueTemp;
        if (root == null) {
            root = new ListaEncadeadaVEM(value);
            root.setNext(null);
            return;
        }
        ListaEncadeadaVEM link = new ListaEncadeadaVEM(value);
        link.setNext(root);
        root = link;
    }

    @Override
    public void update(Object objectTemp) {
        VEM object = (VEM) objectTemp;
    }

    @Override
    public void remove(Object valueTemp) {
        VEM value = (VEM) valueTemp;
        if (root.getValue().getNumber().equals(value.getNumber()))
            root = root.getNext();
        else {
            ListaEncadeadaVEM previous = root;
            ListaEncadeadaVEM aux = root.getNext();
            while (aux != null) {
                if (aux.getValue().getNumber().equals(value.getNumber())) {
                    previous.setNext(aux.getNext());
                    return;
                }
                previous = aux;
                aux = aux.getNext();
            }
        }
    }

    public void remove(ListaEncadeadaVEM link) {
        if (root.equals(link))
            root = root.getNext();
        else {
            ListaEncadeadaVEM previous = root;
            ListaEncadeadaVEM aux = root.getNext();
            while (aux != null) {
                if (aux.equals(link)) {
                    previous.setNext(aux.getNext());
                    return;
                }
                previous = aux;
                aux = aux.getNext();
            }
        }
    }

    @Override
    public boolean exists(Object value) {
        ListaEncadeadaVEM aux = root;
        while (aux != null) {
            if (aux.getValue().getNumber().equals(value))
                return true;
            else
                aux = aux.getNext();
        }
        return false;
    }

    public void invert() {
        ListaEncadeadaVEM aux = root;
        RepositorioListaVEM invert = new RepositorioListaVEM(aux.getValue());
        this.remove(aux);

        while (root != null) {
            aux = root;
            invert.insert(aux.getValue());
            this.remove(aux);
        }
        this.root = invert.root;
    }

    public int getSize() {
        ListaEncadeadaVEM aux = root;
        int cont = 0;
        while (aux != null) {
            cont++;
            aux = aux.getNext();
        }
        return cont;
    }

}
