package com.company.employeemanagement.service.impl;

import com.company.employeemanagement.dto.EmployeeDto;
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
        Employee employee = new Employee(employeeDto.getId(),employeeDto.getName(),employeeDto.getAge());
        inMemoryEmployee.add(employee);
        log.info("Employee List updated - {}",inMemoryEmployee);
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
        /* ToDo 1. Search for employee if he exists
         *      2. if exists return dto object of the same employee
         *      3. else return null
        * */
        for(Employee employee : inMemoryEmployee){
            if(employee.getName().equalsIgnoreCase(name)){
                EmployeeDto employeeDto=new EmployeeDto();
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
        for(Employee employee : inMemoryEmployee){
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(employee.getId());
            employeeDto.setName(employee.getName());
            employeeDto.setAge(employee.getAge());
            employeeDtoList.add(employeeDto);
        }
        return employeeDtoList;
    }
}
