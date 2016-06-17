package systems.singularity.cinttamobi.negocio.pessoas;

import java.util.Date;

/**
 * Created by pedro on 5/2/16.
 * © 2016 Singularity Systems
 */
public class Pessoa {
    private String name;
    private Date birth;
    private String cpf;

    public Pessoa(String name, Date birth, String cpf) {
        // Verify if CPF already exists
        if(cpf == null)
            throw new RuntimeException("CPF inválido");
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
