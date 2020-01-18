package pl.coderslab.dto;

import pl.coderslab.entity.Employee;

public class EmployeeDTO {
    private long id;
    private String firstname;
    private String lastname;
    private double hoursPerMonth;
    private double salaryPerHouer;
    private double salary;
    private String email;
    private String groupName;


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.firstname = employee.getFirstname();
        this.lastname = employee.getLastname();
        this.hoursPerMonth = employee.getHoursPerMonth();
        this.salaryPerHouer = employee.getSalaryPerHouer();
        this.salary = employee.getSalary();
        this.email = employee.getUser().getEmail();
        this.groupName = employee.getGroup().getGroupName();
    }
}
