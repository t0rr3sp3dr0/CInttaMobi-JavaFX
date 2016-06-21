package systems.singularity.cinttamobi.fachada;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.*;
import systems.singularity.cinttamobi.negocio.NegociosOnibus;
import systems.singularity.cinttamobi.negocio.NegociosPessoa;
import systems.singularity.cinttamobi.negocio.NegociosVEM;
import systems.singularity.cinttamobi.negocio.Onibus;
import systems.singularity.cinttamobi.negocio.vem.VEMComum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by esvm on 20/06/16.
 */
public class Fachada {
    private static Fachada ourInstance = new Fachada();
    private String tipo = "";
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

    public static Fachada getInstance() {
        return ourInstance;
    }

    public void cadastrarVEM(VEM vem) throws PessoaExistenteException, VEMExistenteException {
        if (!(vem instanceof VEMComum))
            negociosPessoa.insert(vem.getPerson());
        negociosVEM.insert(vem);
    }

    public void removerVEM(VEM vem) throws PessoaInexistenteException, VEMInexistenteException {
        negociosPessoa.remove(vem.getPerson());
        negociosVEM.remove(vem);
    }

    public List<VEM> listVEM() {
        return negociosVEM.toList();
    }

    public void cadastrarOnibus(Onibus onibus) throws OnibusExistenteException {
        negociosOnibus.insert(onibus);
    }

    public void removeOnibus(Onibus onibus) throws OnibusInexistenteException {
        negociosOnibus.remove(onibus);
    }

    public List<Onibus> listOnibus() {
        return negociosOnibus.toList();
    }

    public void creditarVEM(String id, double value) throws RepositorioInvalidoException, VEMInexistenteException, OperacaoInvalidaException, ValorInvalidoException {
        VEM vem = negociosVEM.search(id);
        vem.credit(value);
        negociosVEM.update(vem);
    }

    public void debitarVEM(String id, Onibus onibus) throws RepositorioInvalidoException, VEMInexistenteException, ValorInvalidoException, SaldoInsuficienteException {
        VEM vem = negociosVEM.search(id);
        vem.debit(onibus.getLine().getRing().getPrice());
        negociosVEM.update(vem);
    }
}
