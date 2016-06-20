package systems.singularity.cinttamobi.dados.pessoa;

import systems.singularity.cinttamobi.interfaces.RepositoriosPessoa;
import systems.singularity.cinttamobi.interfaces.RepositoriosVEM;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.util.ArrayList;

/**
 * Created by caesa on 19/06/2016.
 */
public class RepositorioPessoaLista implements RepositoriosPessoa {

    private NodePessoa root;


    @Override
    public boolean exists(String id) {
        if(search(id) != null)
            return true;
        return false;
    }

    @Override
    public void insert(Pessoa object) {
        if(this.root == null)
        {
            this.root = new NodePessoa(object);
        }
        else
        {
            NodePessoa aux = root;
            while(aux.getNext() != null)
            {
                aux = aux.getNext();
            }
            aux.setNext(new NodePessoa(object));
        }
    }

    @Override
    public void update(Pessoa object) {

        NodePessoa aux = root;
        while (aux != null) {
            if (aux.getValue().getCpf().equals(object.getCpf()))
                aux.setValue(object);
            else
                aux = aux.getNext();
        }


    }

    @Override
    public void remove(Pessoa object) {

        if (root.getValue().getCpf().equals(object.getCpf()))
            root = root.getNext();
        else {
            NodePessoa previous = root;
            NodePessoa aux = root.getNext();
            while (aux != null) {
                if (aux.getValue().getCpf().equals(object.getCpf())) {
                    previous.setNext(aux.getNext());
                    return;
                }
                previous = aux;
                aux = aux.getNext();
            }
        }
    }

    @Override
    public Pessoa search(String id) {
        NodePessoa aux = root;
        while(aux != null)
        {
            if(aux.getValue().getCpf().equals(id))
            {
                return aux.getValue();
            }
            aux = aux.getNext();
        }
        return null;

    }

    @Override
    public ArrayList toList() {
        ArrayList<Pessoa> pessoasLista = new ArrayList<>();

        NodePessoa aux = root;
        while(aux != null)
        {
            pessoasLista.add(aux.getValue());
            aux = aux.getNext();
        }

        return  pessoasLista;
    }
}
