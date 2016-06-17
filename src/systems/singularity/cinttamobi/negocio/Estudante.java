package systems.singularity.cinttamobi.negocio;

import java.util.Date;

/**
 * Created by lvrma on 16/06/16.
 */

public class Estudante extends Pessoa {

    private String studentID;

    public Estudante(String name, Date birth, String cpf, String studentID) {
        super(name, birth, cpf);
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

}
