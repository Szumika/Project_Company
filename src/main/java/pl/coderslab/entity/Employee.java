package pl.coderslab.entity;

import pl.coderslab.entity.security.User;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private double hoursPerMonth;
    private double salaryPerHouer;
    private double salary;
    @ManyToOne(fetch = FetchType.EAGER)
    private groups group;
    @OneToOne
    private User user;
    public groups getGroup() {
        return group;
    }

    public void setGroup(groups group) {
        this.group = group;
    }

    public Employee() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getHoursPerMonth() {
        return hoursPerMonth;
    }

    public void setHoursPerMonth(double hoursPerMonth) {
        this.hoursPerMonth = hoursPerMonth;
    }

    public double getSalaryPerHouer() {
        return salaryPerHouer;
    }

    public void setSalaryPerHouer(double salaryPerHouer) {
        this.salaryPerHouer = salaryPerHouer;
    }

    @Override
    public String toString() {
        return "Pracownik " +
                ", Imie : " + firstname + "<br>\n" +
                ", Nazwisko :'" + lastname + "<br>\n" +
                ", Brygada :" + group + "<br>\n";
    }
}
//    INSERT INTO `endproject`.`Employee` (`firstname`, `hoursPerMonth`, `lastname`, `salaryPerHouer`) VALUES ('Janek', '120', 'Janek', '13.90');
//        INSERT INTO `endproject`.`Employee` (`firstname`, `hoursPerMonth`, `lastname`, `salaryPerHouer`) VALUES ('Kowal', '140', 'Kowal', '12.60');
//        INSERT INTO `endproject`.`Employee` (`firstname`, `hoursPerMonth`, `lastname`, `salaryPerHouer`) VALUES ('Janina', '150', 'Jawna', '14.50');
//        INSERT INTO `endproject`.`Employee` (`firstname`, `hoursPerMonth`, `lastname`, `salaryPerHouer`) VALUES ('Anrzej', '180', 'walicto', '17.40');
