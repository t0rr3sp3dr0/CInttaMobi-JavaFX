package systems.singularity.cinttamobi.dados.pessoa;

import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by caesa on 19/06/2016.
 * © 2016 Singularity Systems
 */
public class NodePessoa {

    private Pessoa value;
    private NodePessoa next;

    public NodePessoa(Pessoa value) {
        this.value = value;
        this.next = null;
    }

    public Pessoa getValue() {
        return value;
    }

    public void setValue(Pessoa value) {
        this.value = value;
    }

    public NodePessoa getNext() {
        return next;
    }

    public void setNext(NodePessoa next) {
        this.next = next;
    }
}
