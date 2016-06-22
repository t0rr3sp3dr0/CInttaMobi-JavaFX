package systems.singularity.cinttamobi.dados.onibus;

import systems.singularity.cinttamobi.interfaces.RepositoriosOnibus;
import systems.singularity.cinttamobi.negocio.Onibus;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Pedro Tôrres on 19/06/16.
 * © 2016 Singularity Systems
 */
public class RepositorioOnibusArray implements RepositoriosOnibus {
    private Onibus[] onibus = {};

    public RepositorioOnibusArray() {
    }

    @Override
    public boolean exists(String id) {
        //verifica no array se já existe algum ônibus com aquela numeração
        for (Onibus onibus : this.onibus)
            if (onibus.getNumber().equals(id))
                return true;
        return false;
    }

    @Override
    public void insert(Onibus object) {
        //Insere um novo ônibus no array
        //O tamanho do array é dinâmico, aumenta a medida que se vai inserindo objetos

        Onibus[] onibus = new Onibus[this.onibus.length + 1];
        for (int i = 0; i < this.onibus.length; i++)
            onibus[i] = this.onibus[i];
        onibus[this.onibus.length] = object;
        this.onibus = onibus;
    }

    @Override
    public void update(Onibus object) {
        //atualiza um ônibus

        for (int i = 0; i < this.onibus.length; i++)
            if (this.onibus[i].getNumber().equals(object.getNumber())) {
                this.onibus[i] = object;
                return;
            }
    }

    @Override
    public void remove(Onibus object) {

        //remove um ônibus e diminui o tamanho do array
        Onibus[] onibus = new Onibus[this.onibus.length - 1];
        for (int i = 0, j = 0; i < this.onibus.length; i++)
            if (!this.onibus[i].getNumber().equals((object.getNumber()))) {
                onibus[j] = this.onibus[i];
                j++;
            }
        this.onibus = onibus;
    }

    @Override
    public Onibus search(String id) {

        //Procura um ônibus e retorna ele
        for (Onibus onibus : this.onibus)
            if (onibus.getNumber().equals(id))
                return onibus;
        return null;
    }

    // Uso exclusivo na implementação da GUI
    @Override
    public ArrayList toList() {
        //converte o array para ArrayList para ser utilizado na GUI. Exclusivamente na GUI
        ArrayList<Onibus> onibusList = new ArrayList<>();
        Collections.addAll(onibusList, this.onibus);
        return onibusList;
    }
}
