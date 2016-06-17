package systems.singularity.cinttamobi.negocio.pessoas;

import systems.singularity.cinttamobi.exceptions.CPFInvalidoException;
import systems.singularity.cinttamobi.exceptions.IdadeInvalidaException;
import systems.singularity.cinttamobi.exceptions.NISInvalidoException;

import java.util.Date;

/**
 * Created by esvm on 17/06/16.
 */
public class Trabalhador extends Pessoa {

    private String nis;

    public Trabalhador(String name, Date birth, String cpf, String nis) throws CPFInvalidoException, IdadeInvalidaException, NISInvalidoException {
        super(name, birth, cpf);
        if (nis==null)
            throw new NISInvalidoException();
        this.nis = nis;
    }


    public String getNis() {
        return this.nis;
    }

}
