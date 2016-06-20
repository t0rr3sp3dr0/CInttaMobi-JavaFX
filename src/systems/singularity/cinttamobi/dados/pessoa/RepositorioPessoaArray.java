package systems.singularity.cinttamobi.dados.pessoa;

import systems.singularity.cinttamobi.interfaces.RepositoriosPessoa;
import systems.singularity.cinttamobi.interfaces.RepositoriosVEM;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.util.ArrayList;

/**
 * Created by caesa on 19/06/2016.
 */
public class RepositorioPessoaArray implements RepositoriosPessoa {

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
    public void insert(Pessoa object) {

        Pessoa[] aux = new Pessoa[this.pessoas.length + 1];

        for (int i = 0; i < this.pessoas.length; i++) {
            aux[i] = this.pessoas[i];
        }

        aux[this.pessoas.length] = (Pessoa) object;
        this.pessoas = aux;

    }

    @Override
    public void update(Pessoa object) {

        for (int i = 0; i < this.pessoas.length; i++) {
            if(object.getCpf().equals(this.pessoas[i].getCpf()))
            {
                this.pessoas[i] = object;
                return;
            }
        }
    }

    @Override
    public void remove(Pessoa object) {

        Pessoa[] aux = new Pessoa[this.pessoas.length - 1];

        for (int i = 0; i < this.pessoas.length; i++) {
            if(object.getCpf().equals(this.pessoas[i].getCpf()))
                this.pessoas[i] = this.pessoas[this.pessoas.length - 1];
        }

        for (int i = 0; i < aux.length; i++) {
            aux[i] = this.pessoas[i];
        }

        this.pessoas = aux;

    }

    @Override
    public Pessoa search(String id) {

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
    public ArrayList toList() {
        ArrayList<Pessoa> pessoasLista = new ArrayList<>();
        for (int i = 0; i < this.pessoas.length; i++) {
            pessoasLista.add(this.pessoas[i]);
        }

        return pessoasLista;
    }
}
