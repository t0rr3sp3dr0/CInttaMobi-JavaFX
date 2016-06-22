package systems.singularity.cinttamobi.exceptions;

/**
 * Created by Pedro Tôrres on 19/06/16.
 * © 2016 Singularity Systems
 */
public class RepositorioInvalidoException extends Exception{
    public RepositorioInvalidoException(){
        super("Repositorio da config.txt inválido.");
    }
}
