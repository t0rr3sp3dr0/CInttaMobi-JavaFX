package systems.singularity.cinttamobi.fachada;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.*;
import systems.singularity.cinttamobi.negocio.NegociosOnibus;
import systems.singularity.cinttamobi.negocio.NegociosPessoa;
import systems.singularity.cinttamobi.negocio.NegociosVEM;
import systems.singularity.cinttamobi.negocio.Onibus;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by esvm on 20/06/16.
 */
public class Fachada {
    private String tipo = "";
    private static Fachada ourInstance = new Fachada();

    public static Fachada getInstance() {
        return ourInstance;
    }

    private NegociosOnibus negociosOnibus;
    private NegociosPessoa negociosPessoa;
    private NegociosVEM negociosVEM;

    private Fachada() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(Programa.class.getResource("config.txt").getPath()));
            String tipo = in.readLine();
            negociosOnibus = new NegociosOnibus(tipo);
            negociosPessoa = new NegociosPessoa(tipo);
            negociosVEM = new NegociosVEM(tipo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RepositorioInvalidoException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarVEM(VEM vem) throws PessoaExistenteException, VEMExistenteException {
        negociosPessoa.insert(vem.getPerson());
        negociosVEM.insert(vem);
    }

    public void removerVEM(VEM vem) throws PessoaInexistenteException, VEMInexistenteException {
        negociosPessoa.remove(vem.getPerson());
        negociosVEM.remove(vem);
    }

    public void cadastrarOnibus(Onibus onibus) throws OnibusExistenteException {
        negociosOnibus.insert(onibus);
    }

    public void removeOnibus(Onibus onibus) throws OnibusInexistenteException {
        negociosOnibus.remove(onibus);
    }

    public void creditarVEM(String id, double value) throws RepositorioInvalidoException, VEMInexistenteException, OperacaoInvalidaException, ValorInvalidoException {
        VEM vem = negociosVEM.search(id);
        vem.credit(value);
        negociosVEM.update(vem);
    }

    public void debitarVEM(String id, double value) throws RepositorioInvalidoException, VEMInexistenteException, ValorInvalidoException, SaldoInsuficienteException {
        VEM vem = negociosVEM.search(id);
        vem.debit(value);
        negociosVEM.update(vem);
    }
}
