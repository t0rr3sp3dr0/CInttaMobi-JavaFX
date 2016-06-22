package systems.singularity.cinttamobi.negocio.pessoas;

import systems.singularity.cinttamobi.exceptions.*;

import java.util.Date;

/**
 * Created by esvm on 17/06/16.
 * © 2016 Singularity Systems
 */
public class Trabalhador extends Pessoa {
    private String nis;

    public Trabalhador(String name, Date birth, String cpf, String nis) throws IdadeInvalidaException, CPFInvalidoException, NISInvalidoException, ParametroNuloException, NomeInvalidoException {
        //tenta criar um novo trabalhador
        super(name, birth, cpf);

        if (nis != null) {
            nis = nis.replaceAll("\\D+", ""); //pega só os números do NIS
            if(nis.length() != 11) //Verifica se possui a quantidade de números correta
                throw new NISInvalidoException();
        } else
            throw new NISInvalidoException();

        this.nis = nis;
    }

    public String getNIS() {
        return this.nis;
    }
}
