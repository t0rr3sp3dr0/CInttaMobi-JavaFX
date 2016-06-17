package systems.singularity.cinttamobi.negocio.pessoas;

import systems.singularity.cinttamobi.exceptions.CarteiraEstudanteInvalidaException;

import java.util.Date;

/**
 * Created by lvrma on 16/06/16.
 * Edited by esvm on 16/06/2016
 *
 */

public class Estudante extends Pessoa {

    private String studentID;

    public Estudante(String name, Date birth, String cpf, String studentID) throws CarteiraEstudanteInvalidaException {
        // Verify if student ID exists
        super(name, birth, cpf);
        if (studentID == null)
            throw new CarteiraEstudanteInvalidaException();
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

}
