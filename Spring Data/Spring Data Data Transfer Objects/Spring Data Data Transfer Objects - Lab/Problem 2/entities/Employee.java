package bg.softuni.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Employee {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private BigDecimal salary;
    private Address address;
    private Employee manager;
    private List<Employee> staff;

    public Employee() {}

    public Employee(String firstName, String lastName, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, BigDecimal salary, List<Employee> staff) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.staff = staff;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public void setStaff(List<Employee> staff) {
        this.staff = staff;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "    - %s %s %.2f".formatted(firstName, lastName, salary);
    }
}
