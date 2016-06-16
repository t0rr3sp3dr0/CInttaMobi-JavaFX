package systems.singularity.cinttamobi.util;

import java.util.Date;

/**
 * Created by pedro on 5/2/16.
 * © 2016 Singularity Systems
 */
public class Person {
    private String name;
    private String nickname;
    private Date birth;
    private String cpf;
    private String rg;
    private Address address;

    public Person() {
        this.address = new Address();
    }

    public Person(String name, String nickname, Date birth, String cpf, String rg, Address address) {
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.cpf = cpf;
        this.rg = rg;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
