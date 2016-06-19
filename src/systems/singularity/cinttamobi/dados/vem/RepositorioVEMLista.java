package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.interfaces.Repositorios;

/**
 * Created by lvrma on 19/06/16.
 */
public class RepositorioVEMLista implements Repositorios{

    private ListaEncadeadaVEM root;

    public RepositorioVEMLista() {
        root = null;
    }

    public RepositorioVEMLista(VEM value) {
        root = new ListaEncadeadaVEM(value);
        root.setNext(null);
    }

    @Override
    public VEM search(String id) {
        ListaEncadeadaVEM aux = root;
        while (aux != null) {
            if (aux.getValue().getNumber().equals(id))
                return aux.getValue();
            else
                aux = aux.getNext();
        }
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
        ListaEncadeadaVEM aux = root;
        while (aux != null) {
            if (aux.getValue().getNumber().equals(object.getNumber()))
                aux.setValue(object);
            else
                aux = aux.getNext();
        }
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

    @Override
    public boolean exists(String value) {
        if (search(value) != null)
            return true;
        return false;
    }

}