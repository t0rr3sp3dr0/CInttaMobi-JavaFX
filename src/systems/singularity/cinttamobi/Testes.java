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
 */
public class Testes {
    public static void main(String[] args) {

        Fachada fachada = Fachada.getInstance();
        if(!fachada.repInvalido) {
            try {
                fachada.cadastrarOnibus(new Onibus("123", Linhas._1));
            } catch (OnibusExistenteException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarOnibus(new Onibus("123", Linhas._10));
            } catch (OnibusExistenteException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.removeOnibus(new Onibus("123243", Linhas._10));
            } catch (OnibusInexistenteException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarOnibus(new Onibus("4325", Linhas._20));
            } catch (OnibusExistenteException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarOnibus(new Onibus(null, null));
            } catch (OnibusExistenteException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarOnibus(new Onibus(null, Linhas._1));
            } catch (OnibusExistenteException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            }

            System.out.println(fachada.listOnibus().toString());



            try {
                fachada.cadastrarVEM(new VEMComum(randNumber(13)));
            } catch (PessoaExistenteException e) {
                e.printStackTrace();
            } catch (VEMExistenteException e) {
                e.printStackTrace();
            } catch (VEMInvalidoException e) {
                e.printStackTrace();
            }

            Pessoa[] pessoas = new Pessoa[32];

            try {
                pessoas[0] = new Pessoa("Hi", new Date(), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[1] = new Pessoa("Hi", new Date(), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[2] = new Pessoa("Oi", new Date(), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[3] = new Pessoa("Oi", new Date(), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[4] = new Pessoa("Oi", new Date(), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[5] = new Pessoa("Oi", new Date(new Date().getTime() + 100000000), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[6] = new Estudante("twert", new Date(), randNumber(11), randNumber(8));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (CarteiraEstudanteInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[7] = new Estudante("dgfhf", new Date(), randNumber(11), randNumber(9));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (CarteiraEstudanteInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[8] = new Estudante("fgh", new Date(), randNumber(11), randNumber(8));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (CarteiraEstudanteInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[9] = new Estudante("gfhgf", new Date(), "", randNumber(8));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (CarteiraEstudanteInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[10] = new Trabalhador("gfhgf", new Date(), randNumber(11), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (NISInvalidoException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[11] = new Trabalhador("gfhgf", new Date(), "", randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (NISInvalidoException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[12] = new Trabalhador("gfhgf", new Date(), randNumber(11), randNumber(10));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (NISInvalidoException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[12] = new Trabalhador("gfhgf", new Date(), randNumber(11), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (NISInvalidoException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[13] = new Crianca("gfhgf", new Date(), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[14] = new Crianca("gfhgf", new Date(), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[15] = new Crianca("gfhgf", new Date(), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[16] = new Idoso("OLD", new Date(new Date().getTime() - 10000000000000l), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[16] = new Idoso("OLD", new Date(new Date().getTime() - 10000000000000l), randNumber(10));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[17] = new Idoso("gfhgf", new Date(), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[18] = new Idoso("gfhgf", new Date(1990, 10, 12), randNumber(11));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                pessoas[19] = new Idoso("", new Date(1972, 10, 12), randNumber(13));
            } catch (CPFInvalidoException e) {
                e.printStackTrace();
            } catch (IdadeInvalidaException e) {
                e.printStackTrace();
            } catch (ParametroNuloException e) {
                e.printStackTrace();
            } catch (NomeInvalidoException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarVEM(new VEMComum(randNumber(13)));
            } catch (PessoaExistenteException e) {
                e.printStackTrace();
            } catch (VEMExistenteException e) {
                e.printStackTrace();
            } catch (VEMInvalidoException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarVEM(new VEMComum(randNumber(13)));
            } catch (PessoaExistenteException e) {
                e.printStackTrace();
            } catch (VEMExistenteException e) {
                e.printStackTrace();
            } catch (VEMInvalidoException e) {
                e.printStackTrace();
            }

            try {
                fachada.cadastrarVEM(new VEMComum(randNumber(12)));
            } catch (PessoaExistenteException e) {
                e.printStackTrace();
            } catch (VEMExistenteException e) {
                e.printStackTrace();
            } catch (VEMInvalidoException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < pessoas.length; i++) {
                try {
                    fachada.cadastrarVEM(new VEMEstudante(randNumber(13), pessoas[i]));
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
                    fachada.cadastrarVEM(new VEMIdoso(randNumber(13), pessoas[i]));
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
                    fachada.cadastrarVEM(new VEMInfantil(randNumber(13), pessoas[i]));
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
                    fachada.cadastrarVEM(new VEMTrabalhador(randNumber(13), pessoas[i]));
                } catch (PessoaExistenteException e) {
                    e.printStackTrace();
                } catch (VEMExistenteException e) {
                    e.printStackTrace();
                } catch (VEMInvalidoException e) {
                    e.printStackTrace();
                } catch (TipoVEMInvalidoException e) {
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
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (OperacaoInvalidaException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }

                try {
                    fachada.debitarVEM(vem.getNumber(), fachada.listOnibus().get(0));
                } catch (RepositorioInvalidoException e) {
                    e.printStackTrace();
                } catch (VEMInexistenteException e) {
                    e.printStackTrace();
                } catch (ValorInvalidoException e) {
                    e.printStackTrace();
                } catch (SaldoInsuficienteException e) {
                    e.printStackTrace();
                }
            }

            try {
                fachada.creditarVEM("dgfdsgdsg", 5.00);
            } catch (RepositorioInvalidoException e) {
                e.printStackTrace();
            } catch (ValorInvalidoException e) {
                e.printStackTrace();
            } catch (OperacaoInvalidaException e) {
                e.printStackTrace();
            } catch (VEMInexistenteException e) {
                e.printStackTrace();
            }


            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException e) {
                e.printStackTrace();
            } catch (VEMInexistenteException e) {
                e.printStackTrace();
            } catch (ValorInvalidoException e) {
                e.printStackTrace();
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException e) {
                e.printStackTrace();
            } catch (VEMInexistenteException e) {
                e.printStackTrace();
            } catch (ValorInvalidoException e) {
                e.printStackTrace();
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException e) {
                e.printStackTrace();
            } catch (VEMInexistenteException e) {
                e.printStackTrace();
            } catch (ValorInvalidoException e) {
                e.printStackTrace();
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException e) {
                e.printStackTrace();
            } catch (VEMInexistenteException e) {
                e.printStackTrace();
            } catch (ValorInvalidoException e) {
                e.printStackTrace();
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException e) {
                e.printStackTrace();
            } catch (VEMInexistenteException e) {
                e.printStackTrace();
            } catch (ValorInvalidoException e) {
                e.printStackTrace();
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException e) {
                e.printStackTrace();
            } catch (VEMInexistenteException e) {
                e.printStackTrace();
            } catch (ValorInvalidoException e) {
                e.printStackTrace();
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }

            try {
                fachada.debitarVEM("321", fachada.listOnibus().get(0));
            } catch (RepositorioInvalidoException e) {
                e.printStackTrace();
            } catch (VEMInexistenteException e) {
                e.printStackTrace();
            } catch (ValorInvalidoException e) {
                e.printStackTrace();
            } catch (SaldoInsuficienteException e) {
                e.printStackTrace();
            }
        }
    }

    private static String randNumber(int length) {
        return String.valueOf(Math.random()).substring(2).substring(0, length);
    }
}
