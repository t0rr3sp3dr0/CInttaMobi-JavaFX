package systems.singularity.cinttamobi.dados.pessoa;

import systems.singularity.cinttamobi.interfaces.Repositorios;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by caesa on 19/06/2016.
 */
public class RepositorioPessoaArray implements Repositorios {

    private Pessoa[] pessoas = new Pessoa[0];

    @Override
    public boolean exists(String id) {
        for (Pessoa item: this.pessoas)
        {
            if(item.getCpf().equals(id))
            {
                return true;
            }
        }
        return false;

    }

    @Override
    public void insert(Object object) {

        Pessoa[] aux = new Pessoa[this.pessoas.length + 1];

        for (int i = 0; i < this.pessoas.length; i++) {
            aux[i] = this.pessoas[i];
        }

        aux[this.pessoas.length] = (Pessoa) object;
        this.pessoas = aux;

    }

    @Override
    public void update(Object object) {

        Pessoa pessoa = (Pessoa) object;
        for (int i = 0; i < this.pessoas.length; i++) {
            if(pessoa.getCpf().equals(this.pessoas[i].getCpf()))
            {
                this.pessoas[i] = pessoa;
                return;
            }
        }
    }

    @Override
    public void remove(Object object) {
        Pessoa pessoa = (Pessoa) object;

        Pessoa[] aux = new Pessoa[this.pessoas.length - 1];

        for (int i = 0; i < this.pessoas.length; i++) {
            if(pessoa.getCpf().equals(this.pessoas[i].getCpf()))
                this.pessoas[i] = this.pessoas[this.pessoas.length - 1];
        }

        for (int i = 0; i < aux.length; i++) {
            aux[i] = this.pessoas[i];
        }

        this.pessoas = aux;

    }

    @Override
    public Object search(String id) {

        for(Pessoa item: this.pessoas)
        {
            if(item.getCpf().equals(id))
            {
                return item;
            }
        }

        return null;
    }

    @Override
    public List toList() {
        ArrayList<Pessoa> pessoasLista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.length; i++) {
            pessoasLista.add(this.pessoas[i]);
        }



        return pessoasLista;
    }
}
