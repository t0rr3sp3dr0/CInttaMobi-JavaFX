package systems.singularity.cinttamobi.dados.vem;

import systems.singularity.cinttamobi.abstracts.VEM;

/**
 * Created by lvrma on 19/06/16.
 */
public class LinkVEM {

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
