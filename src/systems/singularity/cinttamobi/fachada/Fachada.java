package systems.singularity.cinttamobi.fachada;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.*;
import systems.singularity.cinttamobi.negocio.NegociosOnibus;
import systems.singularity.cinttamobi.negocio.NegociosPessoa;
import systems.singularity.cinttamobi.negocio.NegociosVEM;

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

    public void cadastrarOnibus()
    {

    }

    public void creditarVEM()
    {

    }

    public void debitarVEM()
    {

    }










}
