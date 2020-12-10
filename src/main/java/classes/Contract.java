package classes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contract")

public class Contract {
    @Id
    int id;
    int apartmentid;
    int realtorid;

    public Contract() {
        id = 0;
        apartmentid = 0;
        realtorid = 0;
    }

    public Contract(int id, int apartmentid, int realtorid) {
        this.id = id;
        this.apartmentid = apartmentid;
        this.realtorid = realtorid;
    }

    public int getId() {
        return id;
    }

    public int getApartmentid() {
        return apartmentid;
    }

    public int getRealtorid() {
        return realtorid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setApartmentid(int apartmentid) {
        this.apartmentid = apartmentid;
    }

    public void setRealtorid(int realtorid) {
        this.realtorid = realtorid;
    }
}
