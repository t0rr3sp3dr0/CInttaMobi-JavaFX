package systems.singularity.cinttamobi.dados.pessoa;

import systems.singularity.cinttamobi.interfaces.Repositorios;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by caesa on 19/06/2016.
 */
public class RepositorioPessoaLista implements Repositorios{

    private NodePessoa root;


    @Override
    public boolean exists(String id) {
        if(search(id) != null)
            return true;
        return false;
    }

    @Override
    public void insert(Object object) {
        if(this.root.getValue() == null)
        {
            this.root.setValue((Pessoa) object);
        }
        else
        {
            NodePessoa aux = root;
            while(aux.getNext() != null)
            {
                aux = aux.getNext();
            }
            aux.setNext(new NodePessoa((Pessoa) object));
        }
    }

    @Override
    public void update(Object object) {
        Pessoa pessoa = (Pessoa) object;
        NodePessoa aux = root;
        while (aux != null) {
            if (aux.getValue().getCpf().equals(pessoa.getCpf()))
                aux.setValue(pessoa);
            else
                aux = aux.getNext();
        }


    }

    @Override
    public void remove(Object object) {
        Pessoa pessoa = (Pessoa) object;
        if (root.getValue().getCpf().equals(pessoa.getCpf()))
            root = root.getNext();
        else {
            NodePessoa previous = root;
            NodePessoa aux = root.getNext();
            while (aux != null) {
                if (aux.getValue().getCpf().equals(pessoa.getCpf())) {
                    previous.setNext(aux.getNext());
                    return;
                }
                previous = aux;
                aux = aux.getNext();
            }
        }
    }

    @Override
    public Object search(String id) {
        NodePessoa aux = root;
        while(aux != null)
        {
            if(aux.getValue().getCpf().equals(id))
            {
                return aux;
            }
            aux = aux.getNext();
        }
        return null;

    }
}
