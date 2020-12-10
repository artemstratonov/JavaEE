package classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="apartments")

public class Apartment {
    @Id
    int id;
    @NotNull(message = "address cannot be null")
    String address;
    //@Size(min = 1, max = 8)
    int countOfRooms;
    int price;

    public Apartment(){
        id = 0;
        address = "";
        countOfRooms = 0;
        price = 0;
    }

    public Apartment(int id, String address, int countOfRooms, int price) {
        this.id = id;
        this.address = address;
        this.countOfRooms = countOfRooms;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public int getCountOfRooms() {
        return countOfRooms;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountOfRooms(int countOfRooms) {
        this.countOfRooms = countOfRooms;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
