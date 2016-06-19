package systems.singularity.cinttamobi.dados.repositorioVEM;

/**
 * Created by lvrma on 19/06/16.
 */
public class RepositorioListaVEMLink {

    private Object value;
    private RepositorioListaVEMLink next;

    public RepositorioListaVEMLink(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public RepositorioListaVEMLink getNext() {
        return next;
    }

    public void setNext(RepositorioListaVEMLink next) {
        this.next = next;
    }

}
