package bg.softuni;

import bg.softuni.entities.Address;
import bg.softuni.entities.Employee;
import bg.softuni.entities.dto.EmployeeDto;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Sofia");
        Employee employee = new Employee("firstName", "lastName", BigDecimal.valueOf(2000), address);
        ModelMapper mapper = new ModelMapper();

        EmployeeDto map = mapper.map(employee, EmployeeDto.class);

        System.out.println(map);


    }
}