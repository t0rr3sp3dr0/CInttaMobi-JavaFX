package systems.singularity.cinttamobi.negocio.pessoas;

import systems.singularity.cinttamobi.exceptions.CPFInvalidoException;

import java.util.Date;

/**
 * Created by pedro on 5/2/16.
 * © 2016 Singularity Systems
 */
public class Pessoa {
    private String name;
    private Date birth;
    private String cpf;

    public Pessoa(String name, Date birth, String cpf) throws CPFInvalidoException {
        // Verify if CPF already exists
        if (System.currentTimeMillis() - birth.getTime() < 0)
            throw new RuntimeException("Você não nasceu ainda. Certeza que se sente bem?");
        if(cpf == null)
            throw new CPFInvalidoException();
        this.name = name;
        this.birth = birth;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    public String getCpf() {
        return cpf;
    }
}
