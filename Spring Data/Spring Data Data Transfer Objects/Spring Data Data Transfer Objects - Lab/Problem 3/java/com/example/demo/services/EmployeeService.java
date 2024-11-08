package com.example.demo.services;

import com.example.demo.entities.Employee;
import com.example.demo.entities.dtos.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findEmployeesBornBefore(int input);
}
