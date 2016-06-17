package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.SaldoInsuficienteException;
import systems.singularity.cinttamobi.exceptions.ValorInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.Estudante;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by Lucas Valença on 16/06/16.
 */
public class VEMEstudante extends VEM {

    public VEMEstudante(String number, Pessoa person) {
        super(number, person);
        if(!(person instanceof Estudante))
            throw new RuntimeException("Não é estudante! Vagabundo! CFSH!");
    }

    @Override
    public void credit(double value) throws ValorInvalidoException {
        if (value <= 0)
            throw new ValorInvalidoException();
        this.balance += value;
    }

    @Override
    public void debit(double value) throws ValorInvalidoException, SaldoInsuficienteException {
        if (value <= 0)
            throw new ValorInvalidoException();
        else if (value/2 > this.getBalance())
            throw new SaldoInsuficienteException();
        this.balance -= value/2;
    }
}
