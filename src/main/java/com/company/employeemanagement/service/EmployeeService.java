package com.company.employeemanagement.service;

import com.company.employeemanagement.dto.EmployeeDto;
import com.company.employeemanagement.model.Employee;

import java.util.ArrayList;
import java.util.List;


public interface EmployeeService {

    List<Employee> inMemoryEmployee = new ArrayList<>();

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto findEmployee(String name);

    Employee deleteEmployee(int id);

}
