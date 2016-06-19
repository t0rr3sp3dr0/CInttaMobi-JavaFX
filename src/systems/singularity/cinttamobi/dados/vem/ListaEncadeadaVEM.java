package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;

/**
 * Created by lvrma on 19/06/16.
 */
public class ListaEncadeadaVEM {

    private VEM value;
    private ListaEncadeadaVEM next;

    public ListaEncadeadaVEM(VEM value) {
        this.value = value;
    }

    public VEM getValue() {
        return value;
    }

    public void setValue(VEM value) {
        this.value = value;
    }

    public ListaEncadeadaVEM getNext() {
        return next;
    }

    public void setNext(ListaEncadeadaVEM next) {
        this.next = next;
    }

}
