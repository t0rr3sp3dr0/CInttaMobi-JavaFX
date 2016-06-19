package systems.singularity.cinttamobi.exceptions;

/**
 * Created by lvrma on 19/06/16.
 */
public class RepositorioInvalidoException extends Exception{

    public RepositorioInvalidoException(){
        super("Repositorio da config.txt inválido.");
    }

}
