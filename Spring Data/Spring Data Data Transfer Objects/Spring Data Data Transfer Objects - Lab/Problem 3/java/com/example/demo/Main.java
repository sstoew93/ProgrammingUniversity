package com.example.demo;

import com.example.demo.entities.Employee;
import com.example.demo.entities.dtos.EmployeeDTO;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public Main(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        List<EmployeeDTO> output= employeeService.findEmployeesBornBefore(input);

        System.out.println(output);

        Employee employee = new Employee();

        this.employeeRepository.save(employee);
    }
}
