package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.exceptions.RepositorioInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.prefs.Preferences;

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

    public void cadastrarVEM(String numero, Pessoa pessoa)
    {



    }

    public void cadastrarPessoa()
    {

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
