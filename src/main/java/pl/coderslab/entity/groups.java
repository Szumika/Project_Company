package pl.coderslab.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class groups {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String groupName;
//@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//List<Employee> employees = new ArrayList<>();

    public groups() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "groups{" +
                "groupName='" + groupName + '\'' +
                '}';
    }

    //
//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }
}
//    INSERT INTO `endproject`.`groups` (`groupName`) VALUES ('Brygada 1 ');
//        INSERT INTO `endproject`.`groups` (`groupName`) VALUES ('Brygada 2');
//        INSERT INTO `endproject`.`groups` (`groupName`) VALUES ('Brygada 3');