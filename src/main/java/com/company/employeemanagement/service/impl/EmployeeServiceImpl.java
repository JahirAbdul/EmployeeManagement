package com.company.employeemanagement.service.impl;

import com.company.employeemanagement.dto.EmployeeDto;
import com.company.employeemanagement.dto.EmployeeUpdateDto;
import com.company.employeemanagement.model.Employee;
import com.company.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getName(), employeeDto.getAge());
        inMemoryEmployee.add(employee);
        log.info("Employee List updated - {}", inMemoryEmployee);
        EmployeeDto responseDto = new EmployeeDto();
        responseDto.setId(employee.getId());
        responseDto.setName(employee.getName());
        responseDto.setAge(employee.getAge());
        return responseDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return getEmployeeDtoList();
    }

    @Override
    public EmployeeDto findEmployee(String name) {
        for (Employee employee : inMemoryEmployee) {
            if (employee.getName().equalsIgnoreCase(name)) {
                EmployeeDto employeeDto = new EmployeeDto();
                employeeDto.setId(employee.getId());
                employeeDto.setName(employee.getName());
                employeeDto.setAge(employee.getAge());
                return employeeDto;
            }
        }
        return null;
    }

    private List<EmployeeDto> getEmployeeDtoList() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        for (Employee employee : inMemoryEmployee) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setAge(employee.getAge());
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }

    public EmployeeUpdateDto updateEmployee(int id, EmployeeUpdateDto employeeUpdateDto) {
        for (Employee employee : inMemoryEmployee) {
            if (employee.getId() == id) {
                int index = inMemoryEmployee.indexOf(employee);
                inMemoryEmployee.set(index, employee);
                employee.setName(employeeUpdateDto.getName());
                employee.setAge(employeeUpdateDto.getAge());
                return employeeUpdateDto;
            }

        }
        return null;
    }
    
    public Employee deleteEmployee(int id) {
        for (Employee employee : inMemoryEmployee) {
            if (employee.getId() == id) {
                int index = inMemoryEmployee.indexOf(employee);
                return inMemoryEmployee.remove(index);
            }
        }
        return null;
    }

}
