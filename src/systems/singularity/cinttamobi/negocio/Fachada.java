package systems.singularity.cinttamobi.negocio;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.enums.TiposVEM;
import systems.singularity.cinttamobi.exceptions.*;
import systems.singularity.cinttamobi.negocio.pessoas.*;
import systems.singularity.cinttamobi.negocio.vem.*;

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

    public void cadastrarVEM(String numero, Pessoa pessoa, TiposVEM tiposVEM) throws TipoVEMInvalidoException, VEMInvalidoException, VEMExistenteException, PessoaExistenteException {
        VEM vem = null;

        if(pessoa instanceof Crianca && tiposVEM == TiposVEM.Infantil)
        {
            vem = new VEMInfantil(numero, pessoa);
        }
        else if(pessoa instanceof Idoso && tiposVEM == TiposVEM.Idoso)
        {
            vem = new VEMIdoso(numero, pessoa);
        }
        else if(pessoa instanceof Trabalhador && tiposVEM == TiposVEM.Trabalhador)
        {
            vem = new VEMTrabalhador(numero, pessoa);
        }
        else if(pessoa instanceof Estudante && tiposVEM == TiposVEM.Estudante)
        {
            vem = new VEMEstudante(numero, pessoa);
        }
        else if(tiposVEM == TiposVEM.Comum)
        {
            vem = new VEMInfantil(numero, null);
        }
        else
        {
            throw new TipoVEMInvalidoException();
        }
        negociosPessoa.insert(pessoa);
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
