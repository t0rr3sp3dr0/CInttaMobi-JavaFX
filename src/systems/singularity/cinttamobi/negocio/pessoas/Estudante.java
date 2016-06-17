package systems.singularity.cinttamobi.negocio.pessoas;

import java.util.Date;

/**
 * Created by lvrma on 16/06/16.
 */

public class Estudante extends Pessoa {

    private String studentID;

    public Estudante(String name, Date birth, String cpf, String studentID) {
        // Verify if student ID exists
        super(name, birth, cpf);
        if (studentID == null)
            throw new RuntimeException("ID inválido");
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

}
