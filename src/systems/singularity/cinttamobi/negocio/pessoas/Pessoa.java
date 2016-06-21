package systems.singularity.cinttamobi.negocio.pessoas;

import systems.singularity.cinttamobi.exceptions.CPFInvalidoException;
import systems.singularity.cinttamobi.exceptions.IdadeInvalidaException;
import systems.singularity.cinttamobi.exceptions.NomeInvalidoException;
import systems.singularity.cinttamobi.exceptions.ParametroNuloException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by pedro on 5/2/16.
 * © 2016 Singularity Systems
 */
public class Pessoa {
    private String name;
    private Date birth;
    private String cpf;

    public Pessoa(String name, Date birth, String cpf) throws CPFInvalidoException, IdadeInvalidaException, ParametroNuloException, NomeInvalidoException {
        if(name == null || birth == null || cpf == null)
        {
            throw new ParametroNuloException();
        }

        if(name.isEmpty())
        {
            throw new NomeInvalidoException();
        }


        if (birth.getTime() > System.currentTimeMillis())
            throw new IdadeInvalidaException();

        if (cpf != null) {
            cpf = cpf.replaceAll("\\D+", "");
            if(cpf.length() != 11)
                throw new CPFInvalidoException();
        } else
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

    public String getCPF() {
        return cpf;
    }
}
