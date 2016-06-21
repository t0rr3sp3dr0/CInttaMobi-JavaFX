package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.dados.pessoa.RepositorioPessoaArray;
import systems.singularity.cinttamobi.dados.pessoa.RepositorioPessoaLista;
import systems.singularity.cinttamobi.exceptions.PessoaExistenteException;
import systems.singularity.cinttamobi.exceptions.PessoaInexistenteException;
import systems.singularity.cinttamobi.exceptions.RepositorioInvalidoException;
import systems.singularity.cinttamobi.interfaces.RepositoriosPessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.util.List;

/**
 * Created by caesa on 19/06/2016.
 */
public class NegociosPessoa {

    private RepositoriosPessoa repositorio;

    public NegociosPessoa(String tipo) throws RepositorioInvalidoException {
        if (tipo.equals("array"))
            repositorio = new RepositorioPessoaArray();
        else if (tipo.equals("lista"))
            repositorio = new RepositorioPessoaLista();
        else
            throw new RepositorioInvalidoException();
    }

    public boolean exists(String id) {
        return repositorio.exists(id);
    }


    public void insert(Pessoa object) throws PessoaExistenteException {
        if (!exists(object.getCPF())) {
            repositorio.insert(object);
        } else
            throw new PessoaExistenteException();
    }

    public void update(Pessoa object) throws PessoaInexistenteException {

        if (exists(object.getCPF())) {
            repositorio.update(object);
        } else throw new PessoaInexistenteException();
    }

    public void remove(Pessoa object) throws PessoaInexistenteException {

        if (exists(object.getCPF())) {
            repositorio.remove(object);
        } else throw new PessoaInexistenteException();
    }

    public Pessoa search(String id) throws RepositorioInvalidoException, PessoaInexistenteException {
        if (exists(id)) {
            return repositorio.search(id);

        }
        else
            throw new PessoaInexistenteException();
    }

    public List toList() {
        return repositorio.toList();
    }
}
