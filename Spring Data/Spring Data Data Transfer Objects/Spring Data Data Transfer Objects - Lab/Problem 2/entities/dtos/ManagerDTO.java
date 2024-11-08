package bg.softuni.entities.dtos;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerDTO {
    private String firstName;
    private String lastName;
    private double salary;
    private List<EmployeeDTO> staff;

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<EmployeeDTO> getStaff() {
        return staff;
    }

    public void setStaff(List<EmployeeDTO> staff) {
        this.staff = staff;
    }

    @Override
    public String toString() {
        String collect = getStaff()
                .stream()
                .map(s -> s.toString())
                .collect(Collectors.joining("\n"));

        return ("%s %s | Employees: %d%n" +
                "%s")
                .formatted(this.getFirstName(), this.getLastName(), this.getStaff().size(), collect);
    }
}
