package com.company.employeemanagement.controller;

import com.company.employeemanagement.dto.EmployeeDto;
import com.company.employeemanagement.dto.EmployeeUpdateDto;
import com.company.employeemanagement.model.Employee;
import com.company.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/createEmployee")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        log.info("Request received with data - {}", employeeDto);
        employeeService.createEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/getEmployee")
    public ResponseEntity<Object> getEmployee(@RequestParam("name") String name) {
        EmployeeDto employee = employeeService.findEmployee(name);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Employee not Found", HttpStatus.CONFLICT);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeUpdateDto> updateEmployee(@PathVariable int id , @RequestBody EmployeeUpdateDto employeeUpdateDto) {
        log.info("Request received with data - {}", employeeUpdateDto);
        log.info("Request received with data - {}", id);
        employeeService.updateEmployee(id, employeeUpdateDto);
        return new ResponseEntity<>(employeeUpdateDto, HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<Object> deleteEmployee(@RequestParam("id") int id) {
        Employee employee = employeeService.deleteEmployee(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("Employee not Found", HttpStatus.CONFLICT);
    }

}
