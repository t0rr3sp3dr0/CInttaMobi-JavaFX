package systems.singularity.cinttamobi.util;

import java.util.Date;

/**
 * Created by lvrma on 16/06/16.
 */

public class Student extends Person {

    private String studentID;

    public Student(String name, Date birth, String cpf, String studentID) {
        super(name, birth, cpf);
        this.studentID = studentID;
    }

}
