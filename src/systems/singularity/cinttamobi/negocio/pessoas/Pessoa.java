package systems.singularity.cinttamobi.negocio.pessoas;

import systems.singularity.cinttamobi.exceptions.CPFInvalidoException;
import systems.singularity.cinttamobi.exceptions.IdadeInvalidaException;
import systems.singularity.cinttamobi.exceptions.NomeInvalidoException;
import systems.singularity.cinttamobi.exceptions.ParametroNuloException;

import java.util.Date;

/**
 * Created by Edjan Michiles on 5/2/16.
 * © 2016 Singularity Systems
 */
public class Pessoa {
    private String name;
    private Date birth;
    private String cpf;

    public Pessoa(String name, Date birth, String cpf) throws CPFInvalidoException, IdadeInvalidaException, ParametroNuloException, NomeInvalidoException {
        //se inseriu algum parâmetro nulo
        if(name == null || birth == null || cpf == null)
        {
            throw new ParametroNuloException();
        }
        //se passou o nome como uma string vazia
        if(name.isEmpty())
        {
            throw new NomeInvalidoException();
        }

        //se a pessoa ainda não nasceu
        if (birth.getTime() > System.currentTimeMillis())
            throw new IdadeInvalidaException();

        cpf = cpf.replaceAll("\\D+", ""); //pega só os números do CPF
        if (cpf.length() != 11) //se é um CPF válido
            throw new CPFInvalidoException();

        name = name.replaceAll("[^A-Za-z]+", ""); //pega só as letras da String de nome
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
