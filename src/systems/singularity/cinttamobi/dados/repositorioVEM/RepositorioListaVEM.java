package systems.singularity.cinttamobi.dados.repositorioVEM;

/**
 * Created by lvrma on 19/06/16.
 */
public class RepositorioListaVEM {

    private RepositorioListaVEMLink root;

    public RepositorioListaVEM() {
        root = null;
    }

    public RepositorioListaVEM(Object value) {
        root = new RepositorioListaVEMLink(value);
        root.setNext(null);
    }

    public void insert(Object value) {
        if (root == null) {
            root = new RepositorioListaVEMLink(value);
            root.setNext(null);
            return;
        }
        RepositorioListaVEMLink link = new RepositorioListaVEMLink(value);
        link.setNext(root);
        root = link;
    }

    public void remove(Object value) {
        if (root.getValue().equals(value))
            root = root.getNext();
        else {
            RepositorioListaVEMLink previous = root;
            RepositorioListaVEMLink aux = root.getNext();
            while (aux != null) {
                if (aux.getValue().equals(value)) {
                    previous.setNext(aux.getNext());
                    return;
                }
                previous = aux;
                aux = aux.getNext();
            }
        }
    }

    public void remove(RepositorioListaVEMLink link) {
        if (root.equals(link))
            root = root.getNext();
        else {
            RepositorioListaVEMLink previous = root;
            RepositorioListaVEMLink aux = root.getNext();
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

    public void invert() {
        RepositorioListaVEMLink aux = root;
        RepositorioListaVEM invert = new RepositorioListaVEM(aux.getValue());
        this.remove(aux);

        while (root != null) {
            aux = root;
            invert.insert(aux.getValue());
            this.remove(aux);
        }
        this.root = invert.root;
    }

    public boolean contains(Object value) {
        RepositorioListaVEMLink aux = root;
        while (aux != null) {
            if (aux.getValue().equals(value))
                return true;
            else
                aux = aux.getNext();
        }
        return false;
    }

    public int getSize() {
        RepositorioListaVEMLink aux = root;
        int cont = 0;
        while (aux != null) {
            cont++;
            aux = aux.getNext();
        }
        return cont;
    }

}
