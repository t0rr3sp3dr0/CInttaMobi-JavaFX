package systems.singularity.cinttamobi.negocio.vem;

import systems.singularity.cinttamobi.abstracts.VEM;
import systems.singularity.cinttamobi.negocio.pessoas.Pessoa;
import systems.singularity.cinttamobi.negocio.pessoas.Trabalhador;

/**
 * Created by esvm on 17/06/16.
 */
public class VEMTrabalhador extends VEM {

    public VEMTrabalhador(String number, Pessoa person) {
        super(number, person);
        if(!(person instanceof Trabalhador))
            throw new RuntimeException("Não é trabalhador! Vagabundo! CFSH!");
    }

    @Override
    public void credit(double value) {
        if (value <= 0)
            throw new RuntimeException("Valor inválido");
        this.balance += value;
    }

    @Override
    public void debit(double value) {
        if (value <= 0)
            throw new RuntimeException("Valor inválido");
        else if (value > this.getBalance())
            throw new RuntimeException("Saldo insuficiente");
        this.balance -= value;
    }
}
