package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.dados.pessoa.RepositorioPessoaArray;
import systems.singularity.cinttamobi.dados.pessoa.RepositorioPessoaLista;
import systems.singularity.cinttamobi.exceptions.*;
import systems.singularity.cinttamobi.interfaces.RepositoriosPessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Estudante;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Trabalhador;

/**
 * Created by caesa on 19/06/2016.
 * © 2016 Singularity Systems
 */
public class NegociosPessoa {

    private RepositoriosPessoa repositorio;

    public NegociosPessoa(String tipo) throws RepositorioInvalidoException {
        switch (tipo) {
            case "array":
                repositorio = new RepositorioPessoaArray();
                break;
            case "lista":
                repositorio = new RepositorioPessoaLista();
                break;
            default:
                throw new RepositorioInvalidoException();
        }
    }

    public boolean exists(String id) {
        return repositorio.exists(id);
    }

    public boolean existsID(String id) {
        return repositorio.existsID(id);
    }

    public boolean existsNIS(String id) {
        return repositorio.existsNIS(id);
    }


    public void insert(Pessoa object) throws PessoaExistenteException, CarteiraEstudanteInvalidaException, NISInvalidoException {
        if (!exists(object.getCPF())) {
            if(object instanceof Estudante)
            {
                Estudante estudante = (Estudante) object;
                if(!existsID(estudante.getStudentID()))
                    repositorio.insert(object);
                else
                    throw new CarteiraEstudanteInvalidaException();
            }
            else if(object instanceof Trabalhador)
            {
                Trabalhador trabalhador = (Trabalhador) object;
                if(!existsNIS(trabalhador.getNIS()))
                    repositorio.insert(object);
                else
                    throw new NISInvalidoException();
            }
            else
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
}
