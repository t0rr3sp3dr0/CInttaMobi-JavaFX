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
        super(name, birth, cpf);

        if (nis != null) {
            nis = nis.replaceAll("\\D+", "");
            if(nis.length() != 11)
                throw new NISInvalidoException();
        } else
            throw new NISInvalidoException();

        this.nis = nis;
    }

    public String getNIS() {
        return this.nis;
    }
}
