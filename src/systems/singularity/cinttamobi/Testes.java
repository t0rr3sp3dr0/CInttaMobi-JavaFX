package systems.singularity.cinttamobi;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.enums.Linhas;
import systems.singularity.cinttamobi.exceptions.*;
import systems.singularity.cinttamobi.fachada.Fachada;
import systems.singularity.cinttamobi.negocio.Onibus;
import systems.singularity.cinttamobi.negocio.pessoas.*;
import systems.singularity.cinttamobi.negocio.vem.*;

import java.util.Date;

/**
 * Created by phts on 20/06/16.
 * © 2016 Singularity Systems
 */
public class Testes {
    public static void main(String[] args) {

        Fachada fachada = Fachada.getInstance();
        if(!fachada.repInvalido) {
            try {
                fachada.cadastrarOnibus(new Onibus("123", Linhas._1));
            } catch (OnibusExistenteException | ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarOnibus(new Onibus("123", Linhas._10));
            } catch (OnibusExistenteException | ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.removeOnibus(new Onibus("123243", Linhas._10));
            } catch (OnibusInexistenteException | ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarOnibus(new Onibus("4325", Linhas._20));
            } catch (OnibusExistenteException | ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarOnibus(new Onibus(null, null));
            } catch (OnibusExistenteException | ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarOnibus(new Onibus(null, Linhas._1));
            } catch (OnibusExistenteException | ParametroNuloException e) {
                e.printStackTrace();
            }

            System.out.println(fachada.listOnibus().toString());



            try {
                fachada.cadastrarVEM(new VEMComum(randNumber(13)));
            } catch (PessoaExistenteException | VEMInvalidoException | VEMExistenteException e) {
                e.printStackTrace();
            }

            Pessoa[] pessoas = new Pessoa[32];

            try {
                pessoas[0] = new Pessoa("Fermentum Ornare Cursus", new Date(), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[1] = new Pessoa("Vestibulum Magna Mattis Sit", new Date(), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[2] = new Pessoa("Sollicitudin Lorem", new Date(), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[3] = new Pessoa("Consectetur Bibendum Ullamcorper", new Date(), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[4] = new Pessoa("Inceptos Pharetra Ullamcorper", new Date(), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[5] = new Pessoa("Dapibus Fermentum Euismod Risus", new Date(new Date().getTime() + 100000000), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[6] = new Estudante("Ipsum Nullam Cras", new Date(), randNumber(11), randNumber(8));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | CarteiraEstudanteInvalidaException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[7] = new Estudante("Etiam Lorem Ridiculus", new Date(), randNumber(11), randNumber(9));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | CarteiraEstudanteInvalidaException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[8] = new Estudante("Dapibus Bibendum Vestibulum Venenatis", new Date(), randNumber(11), randNumber(8));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | CarteiraEstudanteInvalidaException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[9] = new Estudante("Tellus Tortor Cursus", new Date(), "", randNumber(8));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | CarteiraEstudanteInvalidaException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[10] = new Trabalhador("Consectetur Vulputate Quam Inceptos", new Date(), randNumber(11), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | NISInvalidoException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[11] = new Trabalhador("Risus Adipiscing Cras Mattis", new Date(), "", randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | NISInvalidoException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[12] = new Trabalhador("Tristique Mattis Vehicula Ligula", new Date(), randNumber(11), randNumber(10));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | NISInvalidoException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[12] = new Trabalhador("Justo Fermentum", new Date(), randNumber(11), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | NISInvalidoException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[13] = new Crianca("Condimentum Porta Fermentum Aenean", new Date(), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[14] = new Crianca("Lorem Tortor Quam", new Date(), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[15] = new Crianca("Sollicitudin Nullam Euismod Malesuada", new Date(), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[16] = new Idoso("Tellus Ornare", new Date(new Date().getTime() - 10000000000000L), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[16] = new Idoso("Fusce Tristique Nibh", new Date(new Date().getTime() - 10000000000000L), randNumber(10));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[17] = new Idoso("Pharetra Elit Adipiscing", new Date(), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[18] = new Idoso("Tellus Magna Inceptos", new Date(1990, 10, 12), randNumber(11));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                pessoas[19] = new Idoso("", new Date(1972, 10, 12), randNumber(13));
            } catch (CPFInvalidoException | NomeInvalidoException | ParametroNuloException | IdadeInvalidaException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarVEM(new VEMComum(randNumber(13)));
            } catch (PessoaExistenteException | VEMInvalidoException | VEMExistenteException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarVEM(new VEMComum(randNumber(13)));
            } catch (PessoaExistenteException | VEMInvalidoException | VEMExistenteException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarVEM(new VEMComum(randNumber(12)));
            } catch (PessoaExistenteException | VEMInvalidoException | VEMExistenteException e) {
                e.printStackTrace();
            }

            for (Pessoa pessoa : pessoas) {
                try {
                    fachada.cadastrarVEM(new VEMEstudante(randNumber(13), pessoa));
                } catch (PessoaExistenteException e) {
                    e.printStackTrace();
                } catch (VEMExistenteException e) {
                    e.printStackTrace();
                } catch (VEMInvalidoException e) {
                    e.printStackTrace();
                } catch (TipoVEMInvalidoException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.cadastrarVEM(new VEMIdoso(randNumber(13), pessoa));
                } catch (PessoaExistenteException e) {
                    e.printStackTrace();
                } catch (VEMExistenteException e) {
                    e.printStackTrace();
                } catch (VEMInvalidoException e) {
                    e.printStackTrace();
                } catch (TipoVEMInvalidoException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.cadastrarVEM(new VEMInfantil(randNumber(13), pessoa));
                } catch (PessoaExistenteException e) {
                    e.printStackTrace();
                } catch (VEMExistenteException e) {
                    e.printStackTrace();
                } catch (VEMInvalidoException e) {
                    e.printStackTrace();
                } catch (TipoVEMInvalidoException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.cadastrarVEM(new VEMTrabalhador(randNumber(13), pessoa));
                } catch (PessoaExistenteException | TipoVEMInvalidoException | VEMInvalidoException | VEMExistenteException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(fachada.listVEM().toString());

            for (int i = 0; i < fachada.listVEM().size(); i++) {
                System.out.println(i);
                VEM vem = fachada.listVEM().get(i);
                System.out.println(vem);

                try {
                    fachada.creditarVEM(vem.getNumber(), -5);
                } catch (RepositorioInvalidoException | ValorInvalidoException | OperacaoInvalidaException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                    e.printStackTrace();
                }
            }

            try {
                fachada.creditarVEM("dgfdsgdsg", 5.00);
            } catch (RepositorioInvalidoException | VEMInexistenteException | OperacaoInvalidaException | ValorInvalidoException e) {
                e.printStackTrace();
            }


            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException | SaldoInsuficienteException | ValorInvalidoException | VEMInexistenteException e) {
                e.printStackTrace();
            }
        }
    }

    private static String randNumber(int length) {
        try {
            return String.valueOf(Math.random()).substring(2).substring(0, length);
        } catch (Exception e) {
            return randNumber(length);
        }
    }
}
