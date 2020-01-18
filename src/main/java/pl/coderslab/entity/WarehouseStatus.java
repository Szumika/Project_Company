package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WarehouseStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WarehouseStatus(String status ) {
        this.status = status;
    }

    public WarehouseStatus() {
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
