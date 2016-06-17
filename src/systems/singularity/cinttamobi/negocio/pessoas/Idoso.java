package systems.singularity.cinttamobi.negocio.pessoas;

import systems.singularity.cinttamobi.exceptions.CPFInvalidoException;
import systems.singularity.cinttamobi.exceptions.IdadeInvalidaException;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by lvrma on 17/06/16.
 */
public class Idoso extends Pessoa {

    public Idoso(String name, Date birth, String cpf) throws CPFInvalidoException, IdadeInvalidaException{
        super(name, birth, cpf);
        double years = Math.abs(System.currentTimeMillis() - birth.getTime())
                / (365.25 * 24 * 60 * 60 * 1000);
        // Milisegundos atual - Milisegundos do nascimento
        // dividido por dias * horas * segundos * milisegundos

        if(65 > years)
            throw new IdadeInvalidaException();
    }
}
