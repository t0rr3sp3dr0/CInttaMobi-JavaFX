package systems.singularity.cinttamobi.dados.pessoa;

import systems.singularity.cinttamobi.interfaces.RepositoriosPessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by caesa on 19/06/2016.
 * © 2016 Singularity Systems
 */
public class RepositorioPessoaArray implements RepositoriosPessoa {

    private Pessoa[] pessoas = new Pessoa[0];

    @Override
    public boolean exists(String id) {
        for (Pessoa item: this.pessoas)
        {
            if(item.getCPF().equals(id))
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

        aux[this.pessoas.length] = object;
        this.pessoas = aux;

    }

    @Override
    public void update(Pessoa object) {

        for (int i = 0; i < this.pessoas.length; i++) {
            if(object.getCPF().equals(this.pessoas[i].getCPF()))
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
            if(object.getCPF().equals(this.pessoas[i].getCPF()))
                this.pessoas[i] = this.pessoas[this.pessoas.length - 1];
        }

        System.arraycopy(this.pessoas, 0, aux, 0, aux.length);

        this.pessoas = aux;

    }

    @Override
    public Pessoa search(String id) {

        for(Pessoa item: this.pessoas)
        {
            if(item.getCPF().equals(id))
            {
                return item;
            }
        }

        return null;
    }

    // Uso feito exclusivamente pela GUI
    @Override
    public ArrayList toList() {
        ArrayList<Pessoa> pessoasLista = new ArrayList<>();
        Collections.addAll(pessoasLista, this.pessoas);
        return pessoasLista;
    }
}
