package systems.singularity.cinttamobi.exceptions;

/**
 * Created by Edjan Michiles on 20/06/16.
 * © 2016 Singularity Systems
 */
public class PessoaExistenteException extends Exception {
    public PessoaExistenteException() {
        super("Pessoa já existe!");
    }
}
