package systems.singularity.cinttamobi.dados.pessoa;

import systems.singularity.cinttamobi.interfaces.RepositoriosPessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Estudante;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Trabalhador;

import java.util.ArrayList;

/**
 * Created by Edjan Michiles on 19/06/2016.
 * © 2016 Singularity Systems
 */
public class RepositorioPessoaLista implements RepositoriosPessoa {

    private NodePessoa root;


    @Override
    public boolean exists(String id)
    {
        //verifica se existe uma pessoa na lista encadeada com o determinado CPF
        return search(id) != null;
    }

    @Override
    public boolean existsID(String id) {
        //verifica se existe um estudante na lista encadeada com a determinada carteira de estudante
        NodePessoa aux = root;
        while(aux != null)
        {
            if(aux.getValue() instanceof Estudante)
            {
                Estudante estudante = (Estudante) aux.getValue();
                if(estudante.getStudentID().equals(id))
                    return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    @Override
    public boolean existsNIS(String id) {
        //verifica se existe um trabalhador na lista encadeada com o determinado NIS
        NodePessoa aux = root;
        while(aux != null)
        {
            if(aux.getValue() instanceof Trabalhador)
            {
                Trabalhador trabalhador = (Trabalhador) aux.getValue();
                if(trabalhador.getNIS().equals(id))
                    return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    @Override
    public void insert(Pessoa object) {
        //Insere uma nova pessoa na lista encadeada
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
        //Edita uma pessoa na lista encadeada
        NodePessoa aux = root;
        while (aux != null) {
            if (aux.getValue().getCPF().equals(object.getCPF()))
                aux.setValue(object);
            else
                aux = aux.getNext();
        }


    }

    @Override
    public void remove(Pessoa object) {
        //remove uma pessoa da lista encadeada
        if (root.getValue().getCPF().equals(object.getCPF()))
            root = root.getNext();
        else {
            NodePessoa previous = root;
            NodePessoa aux = root.getNext();
            while (aux != null) {
                if (aux.getValue().getCPF().equals(object.getCPF())) {
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
        //procura uma pessoa na lista encadeada
        NodePessoa aux = root;
        while(aux != null)
        {
            if(aux.getValue().getCPF().equals(id))
            {
                return aux.getValue();
            }
            aux = aux.getNext();
        }
        return null;

    }

    @Override
    public ArrayList toList() {
        //converte a lista encadeada para ArrayList
        //Uso exclusivo na GUI
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
