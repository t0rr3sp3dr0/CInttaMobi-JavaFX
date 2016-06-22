package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.interfaces.RepositoriosVEM;

import java.util.ArrayList;

/**
 * Created by Lucas Valença on 19/06/16.
 * © 2016 Singularity Systems
 */
public class RepositorioVEMLista implements RepositoriosVEM {

    private LinkVEM root;

    public RepositorioVEMLista() {
        root = null;
    }

    @Override
    public VEM search(String id) {
        //procura um VEM na lista encadeada
        LinkVEM aux = root;
        while (aux != null) {
            if (aux.getValue().getNumber().equals(id))
                return aux.getValue();
            else
                aux = aux.getNext();
        }
        return null;
    }

    @Override
    public ArrayList toList() {
        //converte a lista encadeada para ArrayList
        //Uso exclusivo na GUI
        ArrayList<VEM> VEMs = new ArrayList<>();
        LinkVEM aux = root;

        while(aux != null){
            VEMs.add(aux.getValue());
            aux = aux.getNext();
        }

        return VEMs;
    }

    @Override
    public void insert(VEM value) {
        //Insere um novo VEM na lista encadeada
        if (root == null) {
            root = new LinkVEM(value);
            root.setNext(null);
            return;
        }
        LinkVEM link = new LinkVEM(value);
        link.setNext(root);
        root = link;
    }

    @Override
    public void update(VEM object) {
        //Edita um VEM na lista encadeada
        LinkVEM aux = root;
        while (aux != null) {
            if (aux.getValue().getNumber().equals(object.getNumber())) {
                aux.setValue(object);
                return;
            }
            else
                aux = aux.getNext();
        }
    }

    @Override
    public void remove(VEM value) {
        //remove um VEM da lista encadeada
        if (root.getValue().getNumber().equals(value.getNumber()))
            root = root.getNext();
        else {
            LinkVEM previous = root;
            LinkVEM aux = root.getNext();
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
        //verifica se existe um VEM na lista encadeada com o determinado número
        return search(value) != null;
    }

}
