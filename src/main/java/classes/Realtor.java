package classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="realtor")

public class Realtor {
    @Id
    int id;
    String name;
    String surname;
    int phoneNumber;
    int commission;

    public Realtor() {
        id = 0;
        name = "";
        surname = "";
        phoneNumber = 0;
        commission = 0;
    }

    public Realtor(int id, String name, String surname, int phoneNumber, int commission) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.commission = commission;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCommission(int comission) {
        this.commission = comission;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getCommission() {
        return commission;
    }
}
