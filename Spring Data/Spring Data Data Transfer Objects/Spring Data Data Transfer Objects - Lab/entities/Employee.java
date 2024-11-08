package bg.softuni.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Address address;

    public Employee() {
    }

    public Employee(String firstName, String lastName, BigDecimal salary, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.address = address;
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
}
