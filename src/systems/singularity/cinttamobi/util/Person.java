package systems.singularity.cinttamobi.util;

import java.util.Date;

/**
 * Created by pedro on 5/2/16.
 * © 2016 Singularity Systems
 */
public class Person {
    private String name;
    private Date birth;
    private String cpf;

    public Person(String name, Date birth, String cpf) {
        this.name = name;
        this.birth = birth;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    public String getCpf() {
        return cpf;
    }
}
