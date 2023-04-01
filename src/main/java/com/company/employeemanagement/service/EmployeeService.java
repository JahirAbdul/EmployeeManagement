package com.company.employeemanagement.service;

import com.company.employeemanagement.dto.EmployeeDto;
import com.company.employeemanagement.dto.EmployeeUpdateDto;
import com.company.employeemanagement.model.Employee;

import java.util.ArrayList;
import java.util.List;


public interface EmployeeService {

    List<Employee> inMemoryEmployee = new ArrayList<>();

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto findEmployee(String name);

    EmployeeUpdateDto updateEmployee(int id, EmployeeUpdateDto employeeUpdateDto);

    Employee deleteEmployee(int id);

    boolean validation(EmployeeDto employeeDto);
}
