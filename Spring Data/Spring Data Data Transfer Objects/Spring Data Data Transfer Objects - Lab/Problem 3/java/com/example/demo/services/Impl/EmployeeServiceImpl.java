package com.example.demo.services.Impl;

import com.example.demo.entities.Employee;
import com.example.demo.entities.dtos.EmployeeDTO;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeDTO> findEmployeesBornBefore(int input) {
        List<Employee> employees = this.employeeRepository.findByBirthdayYearBefore(input);

        ModelMapper modelMapper = new ModelMapper();

        return employees
                .stream()
                .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                .toList();

    }

}
