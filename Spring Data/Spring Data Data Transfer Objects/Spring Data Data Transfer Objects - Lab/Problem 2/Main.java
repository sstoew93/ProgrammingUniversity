package bg.softuni;

import bg.softuni.entities.Employee;
import bg.softuni.entities.dtos.ManagerDTO;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ModelMapper modelMapper = new ModelMapper();

        Employee employeeOne = new Employee("First", "Name", BigDecimal.valueOf(1000));
        Employee employeeTwo = new Employee("First2", "Name2", BigDecimal.valueOf(2000));
        Employee employeeThree = new Employee("First3", "Name3", BigDecimal.valueOf(3000));
        Employee employeeFour = new Employee("First4", "Name4", BigDecimal.valueOf(4000));
        Employee employeeFive = new Employee("First5", "Name5", BigDecimal.valueOf(5000));

        Employee managerOne =  new Employee("First", "Manager", BigDecimal.valueOf(1000), List.of(employeeOne, employeeTwo, employeeThree));
        Employee managerTwo =  new Employee("Second", "Manager", BigDecimal.valueOf(2000), List.of(employeeFour, employeeFive));

        ManagerDTO map = modelMapper.map(managerOne, ManagerDTO.class);
        System.out.println(map);

        ManagerDTO map2 = modelMapper.map(managerTwo, ManagerDTO.class);
        System.out.println(map2);
    }
}