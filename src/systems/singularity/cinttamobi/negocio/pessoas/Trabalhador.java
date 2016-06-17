package systems.singularity.cinttamobi.negocio.pessoas;

import java.util.Date;

/**
 * Created by esvm on 17/06/16.
 */
public class Trabalhador extends Pessoa {

    private String nis;

    public Trabalhador(String name, Date birth, String cpf, String nis) {
        // Verify if NIS exists
        super(name, birth, cpf);
        if (nis==null)
            throw new RuntimeException("NIS invalido");
        this.nis = nis;
    }

    public String getNis() {
        return nis;
    }

}
