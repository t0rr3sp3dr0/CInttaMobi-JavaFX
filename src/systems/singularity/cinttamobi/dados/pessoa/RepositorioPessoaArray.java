package systems.singularity.cinttamobi.dados.pessoa;

import systems.singularity.cinttamobi.interfaces.Repositorios;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by caesa on 19/06/2016.
 */
public class RepositorioPessoaArray implements Repositorios {

    private Pessoa[] pessoas = new Pessoa[0];

    @Override
    public boolean exists(String id) {
        if(search(id) != null)
            return true;

        return false;

    }

    @Override
    public void insert(Object object) {

        Pessoa[] aux = new Pessoa[pessoas.length + 1];

        for (int i = 0; i < pessoas.length; i++) {
            aux[i] = pessoas[i];
        }

        aux[pessoas.length] = (Pessoa) object;
        this.pessoas = aux;

    }

    @Override
    public void update(Object object) {

        Pessoa pessoa = (Pessoa) object;
        for (int i = 0; i < pessoas.length; i++) {
            if(pessoa.getCpf().equals(pessoas[i].getCpf()))
            {
                pessoas[i] = pessoa;
                return;
            }
        }
    }

    @Override
    public void remove(Object object) {
        Pessoa pessoa = (Pessoa) object;

        Pessoa[] aux = new Pessoa[pessoas.length - 1];

        for (int i = 0; i < pessoas.length; i++) {
            if(pessoa.getCpf().equals(pessoas[i].getCpf()))
                pessoas[i] = pessoas[pessoas.length - 1];
        }

        for (int i = 0; i < aux.length; i++) {
            aux[i] = pessoas[i];
        }

        this.pessoas = aux;

    }

    @Override
    public Object search(String id) {

        for (int i = 0; i < pessoas.length; i++) {
            if(id.equals(pessoas[i].getCpf()))
                return pessoas[i];
        }

        return null;
    }
}
