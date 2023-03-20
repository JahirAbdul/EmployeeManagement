package com.company.employeemanagement.service;

import com.company.employeemanagement.dto.EmployeeDto;
import com.company.employeemanagement.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public interface EmployeeService {

    List<Employee> inMemoryEmployee = new ArrayList<>();
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto findEmployee(String name);
}
