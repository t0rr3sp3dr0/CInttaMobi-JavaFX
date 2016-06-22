package systems.singularity.cinttamobi.dados.pessoa;

import systems.singularity.cinttamobi.interfaces.RepositoriosPessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Estudante;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Trabalhador;

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
        //verifica se existe uma pessoa no array com o determinado CPF
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
    public boolean existsID(String id) {
        //verifica se existe um estudante no array com o determinado número da carteira de estudante
        for (Pessoa item: this.pessoas)
        {
            if(item instanceof Estudante)
            {
                Estudante estudante = (Estudante) item;
                if(estudante.getStudentID().equals(id))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean existsNIS(String id) {
        //verifica se existe um trabalhador no array com o determinado NIS
        for (Pessoa item: this.pessoas)
        {
            if(item instanceof Trabalhador)
            {
                Trabalhador trabalhador = (Trabalhador) item;
                if(trabalhador.getNIS().equals(id))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void insert(Pessoa object) {
        //insere uma pessoa no array
        //tamanho do array aumenta de forma dinâmica
        Pessoa[] aux = new Pessoa[this.pessoas.length + 1];

        for (int i = 0; i < this.pessoas.length; i++) {
            aux[i] = this.pessoas[i];
        }

        aux[this.pessoas.length] = object;
        this.pessoas = aux;

    }

    @Override
    public void update(Pessoa object) {
        //atualiza uma pessoa no array
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
        //remove uma pessoa do array
        //array diminui de tamanho de forma dinâmica
        Pessoa[] aux = new Pessoa[this.pessoas.length - 1];

        for (int i = 0; i < this.pessoas.length; i++) {
            if(object.getCPF().equals(this.pessoas[i].getCPF()))
                this.pessoas[i] = this.pessoas[this.pessoas.length - 1];
        }

        for (int i = 0; i < aux.length; i++) {
            aux[i] = this.pessoas[i];
        }

        this.pessoas = aux;

    }

    @Override
    public Pessoa search(String id) {
        //procura uma pessoa no array a partir do CPF
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
        //converte o array para ArrayList para usar na GUI
        //Uso exclusivo na GUI
        ArrayList<Pessoa> pessoasLista = new ArrayList<>();
        Collections.addAll(pessoasLista, this.pessoas);
        return pessoasLista;
    }
}
