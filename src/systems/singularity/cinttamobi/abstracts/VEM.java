package systems.singularity.cinttamobi.abstracts;

import systems.singularity.cinttamobi.enums.TiposVEM;
import systems.singularity.cinttamobi.exceptions.OperacaoInvalidaException;
import systems.singularity.cinttamobi.exceptions.SaldoInsuficienteException;
import systems.singularity.cinttamobi.exceptions.VEMInvalidoException;
import systems.singularity.cinttamobi.exceptions.ValorInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.*;

/**
 * Created by phts on 16/06/16.
 * © 2016 Singularity Systems
 */
public abstract class VEM {
    protected double balance;
    private String number;
    private Pessoa person;

    protected VEM(String number, Pessoa person) throws VEMInvalidoException {

        number = number.replaceAll("\\D+", ""); //Pega apenas os números que estão na String
        if (number == null || number.length() != 13) //Se não tiver 13 números, número do VEM é inválido
            throw new VEMInvalidoException();
        this.number = number;
        this.person = person;
        this.balance = 0;
    }

    public String getNumber() {
        return number;
    }

    public Pessoa getPerson() {
        return person;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void credit(double value) throws ValorInvalidoException, OperacaoInvalidaException;

    public abstract void debit(double value) throws ValorInvalidoException, SaldoInsuficienteException;

    // Os metodos abaixo são utilizados única e exclusivamente
    // para popular a TableView no JavaFX

    public TiposVEM getT() {

        //Retorna o tipo do VEM (Infantil, Estudante, Idoso, Trabalhador ou Comum)
        if (person instanceof Crianca)
            return TiposVEM.Infantil;
        else if (person instanceof Estudante)
            return TiposVEM.Estudante;
        else if (person instanceof Idoso)
            return TiposVEM.Idoso;
        else if (person instanceof Trabalhador)
            return TiposVEM.Trabalhador;
        else
            return TiposVEM.Comum;
    }

    public String getN() {
        //Pega o nome da pessoa registrada com o determinado VEM
        if (person != null)
            return person.getName();
        else //Caso seja vem Comum, não possui pessoa
            return "Não se Aplica";
    }

    public String getC() {
        //Pega o CPF da pessoa registrada com o determinado VEM
        if (person != null)
            return person.getCPF();
        else //Caso seja vem Comum, não possui pessoa
            return "Não se Aplica";
    }
}
