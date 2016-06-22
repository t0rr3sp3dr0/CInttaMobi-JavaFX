package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;

/**
 * Created by Lucas Valença on 19/06/16.
 * © 2016 Singularity Systems
 */
public class LinkVEM {
    //classe para a lista encadeada de VEM
    private VEM value;
    private LinkVEM next;

    public LinkVEM(VEM value) {
        this.value = value;
    }

    public VEM getValue() {
        return value;
    }

    public void setValue(VEM value) {
        this.value = value;
    }

    public LinkVEM getNext() {
        return next;
    }

    public void setNext(LinkVEM next) {
        this.next = next;
    }

}
