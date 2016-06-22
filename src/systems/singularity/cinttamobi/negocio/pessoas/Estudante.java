package systems.singularity.cinttamobi.negocio.pessoas;

import systems.singularity.cinttamobi.exceptions.*;

import java.util.Date;

/**
 * Created by lvrma on 16/06/16.
 * Edited by esvm on 16/06/2016
 * © 2016 Singularity Systems
 */

public class Estudante extends Pessoa {

    private String studentID;

    public Estudante(String name, Date birth, String cpf, String studentID) throws CPFInvalidoException, CarteiraEstudanteInvalidaException, IdadeInvalidaException, ParametroNuloException, NomeInvalidoException {
        //tenta criar um novo estudante
        super(name, birth, cpf);


        studentID = studentID.replaceAll("\\D+", ""); //pega apenas os números da carteira de estudante
        if (studentID == null || studentID.length() < 7 || studentID.length() > 8) //se a numeração não tiver 7 ou 8 dígitos
            // (baseado em duas carteiras de estudante diferentes), então é uma carteira inválida

            throw new CarteiraEstudanteInvalidaException();
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

}
