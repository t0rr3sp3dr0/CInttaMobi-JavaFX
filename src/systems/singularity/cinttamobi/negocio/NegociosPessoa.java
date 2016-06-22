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

    // Objeto a partir da interface, não inicializado
    private RepositoriosPessoa repositorio;

    public NegociosPessoa(String tipo) throws RepositorioInvalidoException {
        // Construtor recebe a string que define o tipo de repositório
        // o mesmo é então inicializado.
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

    // Checa se a pessoa existe baseado no CPF
    public boolean exists(String id) {
        return repositorio.exists(id);
    }

    // Checa se o estudante existe baseado na carteira de estudante
    public boolean existsID(String id) {
        return repositorio.existsID(id);
    }

    // Checa se o trabalhador existe baseado no NIS
    public boolean existsNIS(String id) {
        return repositorio.existsNIS(id);
    }

    // Checa se o objeto pessoa (ou estudante/trabalhador) já existe baseado no CPF e Carteira de Estudante ou NIS
    // Utilizando os métodos acima, e em seguida insere
    public void insert(Pessoa object) throws PessoaExistenteException, CarteiraEstudanteInvalidaException, NISInvalidoException {
        if (!exists(object.getCPF())) {
            // Caso estudante..
            if(object instanceof Estudante)
            {
                Estudante estudante = (Estudante) object;
                if(!existsID(estudante.getStudentID()))
                    repositorio.insert(object);
                else
                    throw new CarteiraEstudanteInvalidaException();
            }
            // Caso trabalhador..
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

    // Atualiza a pessoa caso ela exista
    public void update(Pessoa object) throws PessoaInexistenteException {

        if (exists(object.getCPF())) {
            repositorio.update(object);
        } else throw new PessoaInexistenteException();
    }

    // Remove a pessoa caso ela exista
    public void remove(Pessoa object) throws PessoaInexistenteException {

        if (exists(object.getCPF())) {
            repositorio.remove(object);
        } else throw new PessoaInexistenteException();
    }
}
