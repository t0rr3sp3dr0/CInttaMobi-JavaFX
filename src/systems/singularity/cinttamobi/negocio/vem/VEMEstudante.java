package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.exceptions.SaldoInsuficienteException;
import systems.singularity.cinttamobi.exceptions.TipoVEMInvalidoException;
import systems.singularity.cinttamobi.exceptions.VEMInvalidoException;
import systems.singularity.cinttamobi.exceptions.ValorInvalidoException;
import systems.singularity.cinttamobi.negocio.pessoas.Estudante;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;

/**
 * Created by Lucas Valença on 16/06/16.
 * © 2016 Singularity Systems
 */
public class VEMEstudante extends VEM {

    public VEMEstudante(String number, Pessoa person) throws TipoVEMInvalidoException, VEMInvalidoException {
        // Chama o construtor de VEM, e checa se o dono é realmente um estudante
        // A filtragem para checar se o estudante é válido (por carteira de estudante) é feita na classe estudante
        // O VEM apenas checa o tipo da pessoa recebida
        super(number, person);
        if(!(person instanceof Estudante))
            throw new TipoVEMInvalidoException();
    }

    @Override
    public void credit(double value) throws ValorInvalidoException {
        // Creditar normal, como em VEM Comum
        if (value <= 0)
            throw new ValorInvalidoException();
        this.balance += value;
    }

    @Override
    public void debit(double value) throws ValorInvalidoException, SaldoInsuficienteException {
        // VEM de estudante debita metade do valor
        if (value <= 0)
            throw new ValorInvalidoException();
        else if (value/2 > this.getBalance())
            throw new SaldoInsuficienteException();
        this.balance -= value/2;
    }
}
