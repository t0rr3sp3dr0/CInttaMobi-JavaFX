package systems.singularity.cinttamobi.abstracts;

import systems.singularity.cinttamobi.enums.TiposVEM;
import systems.singularity.cinttamobi.exceptions.OperacaoInvalidaException;
import systems.singularity.cinttamobi.exceptions.SaldoInsuficienteException;
import systems.singularity.cinttamobi.exceptions.VEMInvalidoException;
import systems.singularity.cinttamobi.exceptions.ValorInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.*;

/**
 * Created by phts on 16/06/16.
 */
public abstract class VEM {
    protected double balance;
    private String number;
    private Pessoa person;

    public VEM(String number, Pessoa person) throws VEMInvalidoException {
        // TO-DO
        // Verify if number or person already exists
        if (number == null || number.replaceAll("\\D+", "").length() != 13)
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
        if (person != null)
            return person.getName();
        else
            return "Não se Aplica";
    }

    public String getC() {
        if (person != null)
            return person.getCPF();
        else
            return "Não se Aplica";
    }
}
