package systems.singularity.cinttamobi.negocio.controladores;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.dados.pessoa.RepositorioPessoaArray;
import systems.singularity.cinttamobi.dados.pessoa.RepositorioPessoaLista;
import systems.singularity.cinttamobi.exceptions.PessoaInexistenteException;
import systems.singularity.cinttamobi.exceptions.RepositorioInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.util.prefs.Preferences;

/**
 * Created by caesa on 19/06/2016.
 */
public final class ControladorPessoa {

    private static String tipo;

    private static RepositorioPessoaLista repositorioLista = new RepositorioPessoaLista();
    private static RepositorioPessoaArray repositorioArray = new RepositorioPessoaArray();


    public ControladorPessoa() {
    }

    static {
        Preferences prefs = Preferences.userNodeForPackage(Programa.class);
        tipo = prefs.get("repo", null);
    }


    public static boolean exists(String object) {
        if (tipo.equals("array"))
            return repositorioArray.exists(object);
        else if (tipo.equals("lista"))
            return repositorioLista.exists(object);


        return false;
    }

    public static void insert(Object objectTemp) throws PessoaInexistenteException {
        Pessoa object = (Pessoa) objectTemp;
        if (exists(object.getCpf())) {
            if (tipo.equals("array"))
                repositorioArray.insert(object);
            else if (tipo.equals("lista"))
                repositorioLista.insert(object);
        }
        else
            throw new PessoaInexistenteException();
    }

    public static void update(Object objectTemp) throws PessoaInexistenteException {
        Pessoa object = (Pessoa) objectTemp;
        if (exists(object.getCpf())) {
            if (tipo.equals("array"))
                repositorioArray.update(object);
            else if (tipo.equals("lista"))
                repositorioLista.update(object);
        }
        else
            throw new PessoaInexistenteException();
    }

    public static void remove(Object objectTemp) throws PessoaInexistenteException {
        Pessoa object = (Pessoa) objectTemp;
        if (exists(object.getCpf())) {
            if (tipo.equals("array"))
                repositorioArray.remove(object);
            else if (tipo.equals("lista"))
                repositorioLista.remove(object);
        }
        else
            throw new PessoaInexistenteException();
    }

    public static Object search(String object) throws RepositorioInvalidoException, PessoaInexistenteException {
        if (exists(object)) {
            if (tipo.equals("array"))
            {
                return repositorioArray.search(object);
            }
            else if (tipo.equals("lista"))
            {
                return repositorioLista.search(object);
            }
            else
            {
                throw new RepositorioInvalidoException();
            }
        }
        else
            throw new PessoaInexistenteException();
    }
}
