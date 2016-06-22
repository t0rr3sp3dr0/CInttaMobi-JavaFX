package systems.singularity.cinttamobi.fachada;

import systems.singularity.cinttamobi.Programa;
import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.*;
import systems.singularity.cinttamobi.negocio.NegociosOnibus;
import systems.singularity.cinttamobi.negocio.NegociosPessoa;
import systems.singularity.cinttamobi.negocio.NegociosVEM;
import systems.singularity.cinttamobi.negocio.Onibus;
import systems.singularity.cinttamobi.negocio.pessoas.Estudante;
import systems.singularity.cinttamobi.negocio.pessoas.Trabalhador;
import systems.singularity.cinttamobi.negocio.vem.VEMComum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by esvm on 20/06/16.
 * © 2016 Singularity Systems
 */
public class Fachada {
    //Singleton da classe fachada
    private static final Fachada ourInstance = new Fachada();
    public  boolean repInvalido = false; //Verifica se o repositório é válido

    private NegociosOnibus negociosOnibus;
    private NegociosPessoa negociosPessoa;
    private NegociosVEM negociosVEM;

    private Fachada() {
        try {

            //Carrega o arquivo de texto
            BufferedReader in = new BufferedReader(new FileReader(Programa.class.getResource("config.txt").getPath()));
            String tipo = in.readLine();
            //implementa o repositório de acordo com o que tem no texto
            negociosOnibus = new NegociosOnibus(tipo);
            negociosPessoa = new NegociosPessoa(tipo);
            negociosVEM = new NegociosVEM(tipo);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (RepositorioInvalidoException e) {
            e.printStackTrace();
            repInvalido = true; //repositório inválido
        }
    }
    //acessar o singleton
    public static Fachada getInstance() {
        return ourInstance;
    }

    public void cadastrarVEM(VEM vem) throws PessoaExistenteException, VEMExistenteException, CarteiraEstudanteInvalidaException, NISInvalidoException {
        //tenta cadastrar um VEM
        if(vem != null) {
            if (!(vem instanceof VEMComum)) {
                //verificar se a pessoa já existe
                if (!negociosPessoa.exists(vem.getPerson().getCPF())) {
                    //Verificar se já tem um estudante com aquela carteira, caso seja um estudante
                    if(vem.getPerson() instanceof Estudante)
                    {
                        Estudante estudante = (Estudante) vem.getPerson();
                        if(!negociosPessoa.existsID(estudante.getStudentID()))
                        {
                            negociosVEM.insert(vem);
                            negociosPessoa.insert(vem.getPerson());
                        }
                        else
                            throw new CarteiraEstudanteInvalidaException();
                    }
                    //caso seja um trabalhador, verificar se não existe algum com aquele NIS
                    else if(vem.getPerson() instanceof Trabalhador)
                    {
                        Trabalhador trabalhador = (Trabalhador) vem.getPerson();
                        if(!negociosPessoa.existsNIS(trabalhador.getNIS()))
                        {
                            negociosVEM.insert(vem);
                            negociosPessoa.insert(vem.getPerson());
                        }
                        else
                            throw new NISInvalidoException();
                    }
                    //se não é estudante, não é trabalhador e a pessoa ainda não existe, então tenta inserir
                    else
                    {
                        negociosVEM.insert(vem);
                        negociosPessoa.insert(vem.getPerson());
                    }
                 } else
                    throw new PessoaExistenteException();
            } else
                negociosVEM.insert(vem); //Vem comum não precisa inserir pessoa
        }
    }

    public void atualizarVEM(VEM vem) throws PessoaInexistenteException, VEMInexistenteException {
        //tenta atualizar os dados de um vem, inclusive a pessoa relacionada
        if (vem.getPerson() != null)
            negociosPessoa.update(vem.getPerson());
        negociosVEM.update(vem);
    }

    public void removerVEM(VEM vem) throws PessoaInexistenteException, VEMInexistenteException {
        //tenta remover um vem e a pessoa relacionada
        negociosPessoa.remove(vem.getPerson());
        negociosVEM.remove(vem);
    }

    public List<VEM> listVEM() {
        return negociosVEM.toList();
    } //converte o array ou a lista encadeada para ArrayList para fazer uso na GUI

    public void cadastrarOnibus(Onibus onibus) throws OnibusExistenteException {
        //tenta cadastrar um novo ônibus
        negociosOnibus.insert(onibus);
    }

    public void atualizarOnibus(Onibus onibus) throws OnibusInexistenteException {
        //tenta atualizar um ônibus
        negociosOnibus.update(onibus);
    }

    public void removeOnibus(Onibus onibus) throws OnibusInexistenteException {
        //tenta remover um ônibus
        negociosOnibus.remove(onibus);
    }

    public List<Onibus> listOnibus() {
        return negociosOnibus.toList();
    } //converte o array ou a lista encadeada de ônibus para arrayList para ser usado na GUI

    public void creditarVEM(String id, double value) throws RepositorioInvalidoException, VEMInexistenteException, OperacaoInvalidaException, ValorInvalidoException {
        //tenta creditar um valor no VEM
        VEM vem = negociosVEM.search(id);
        vem.credit(value);
        negociosVEM.update(vem);
    }

    public void debitarVEM(String id, Onibus onibus) throws RepositorioInvalidoException, VEMInexistenteException, ValorInvalidoException, SaldoInsuficienteException {
        //tenta debitar um valor no VEM
        VEM vem = negociosVEM.search(id);
        vem.debit(onibus.getLine().getRing().getPrice());
        negociosVEM.update(vem);
    }
}
