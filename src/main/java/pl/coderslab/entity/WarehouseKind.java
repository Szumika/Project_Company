package pl.coderslab.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WarehouseKind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WarehouseKind(String name) {
        this.name = name;
    }

    public WarehouseKind() {
    }

    @Override
    public String toString() {
        return "WarehouseKind{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
