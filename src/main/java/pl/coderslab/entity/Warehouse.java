package pl.coderslab.entity;

import javax.persistence.*;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    private int ilosc;
    @ManyToOne(fetch = FetchType.EAGER)
    private WarehouseStatus warehouseStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;
    @ManyToOne(fetch = FetchType.EAGER)
    private WarehouseKind warehouseKind;

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

    public WarehouseStatus getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(WarehouseStatus warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
    }

    public WarehouseKind getWarehouseKind() {
        return warehouseKind;
    }

    public void setWarehouseKind(WarehouseKind warehouseKind) {
        this.warehouseKind = warehouseKind;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public Warehouse(String name, int ilosc, WarehouseStatus warehouseStatus, Employee employee, WarehouseKind warehouseKind) {
        this.name = name;
        this.ilosc = ilosc;
        this.warehouseStatus = warehouseStatus;
        this.employee = employee;
        this.warehouseKind = warehouseKind;
    }

    public Warehouse() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ilosc=" + ilosc +
                '}';
    }
}
