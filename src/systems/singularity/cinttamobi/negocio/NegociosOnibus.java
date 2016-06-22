package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.dados.onibus.RepositorioOnibusArray;
import systems.singularity.cinttamobi.dados.onibus.RepositorioOnibusLista;
import systems.singularity.cinttamobi.exceptions.OnibusExistenteException;
import systems.singularity.cinttamobi.exceptions.OnibusInexistenteException;
import systems.singularity.cinttamobi.exceptions.RepositorioInvalidoException;
import systems.singularity.cinttamobi.interfaces.RepositoriosOnibus;

import java.util.List;

/**
 * Created by phts on 19/06/16.
 * © 2016 Singularity Systems
 */
public class NegociosOnibus {

    // Objeto a partir da interface, não inicializado
    private RepositoriosOnibus repositorio;

    public NegociosOnibus(String tipo) throws RepositorioInvalidoException {
        // Construtor recebe a string que define o tipo de repositório
        // o mesmo é então inicializado.
        switch (tipo) {
            case "array":
                repositorio = new RepositorioOnibusArray();
                break;
            case "lista":
                repositorio = new RepositorioOnibusLista();
                break;
            default:
                throw new RepositorioInvalidoException();
        }
    }

    // Checa se o onibus existe pelo número
    private boolean exists(String id) {
        return repositorio.exists(id);
    }

    // Insere um onibus caso ele não exista no banco de dados
    public void insert(Onibus object) throws OnibusExistenteException {
        if (!exists(object.getNumber())) {
            repositorio.insert(object);
        } else
            throw new OnibusExistenteException();
    }

    // Atualiza o onibus caso ele exista
    public void update(Onibus object) throws OnibusInexistenteException {

        if (exists(object.getNumber())) {
            repositorio.update(object);
        } else throw new OnibusInexistenteException();
    }

    // Remove o onibus caso ele exista
    public void remove(Onibus object) throws OnibusInexistenteException {

        if (exists(object.getNumber())) {
            repositorio.remove(object);
        } else throw new OnibusInexistenteException();
    }


    // Metodo utilizado com foco na GUI do JavaFX, para listar os objetos do repositorio.
    public List toList() {
        return repositorio.toList();
    }
}
