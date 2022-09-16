package com.azure.deployapimmysql.controller;

import com.azure.deployapimmysql.model.Employee;
import com.azure.deployapimmysql.repository.EmployeeRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/madhura/alone")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @ApiOperation(value = "to return list of employees")
    @GetMapping(value = "employees")
    private List<Employee> getAllEmployees1() {
        return employeeRepository.findAll();
    }

    @ApiOperation(value = "to return employee by id")
    @GetMapping(value = "employee")
    private Employee getByEmployeeId(@RequestParam("eid") String eid) {
        return employeeRepository.findById(eid).get();
    }

    @ApiOperation(value = "save employee")
    @PostMapping(value = "employee")
    private ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @GetMapping(value = "employee")
    private String getByEmployeeId() {
        return "waste fellow madhura waste wasteee";
    }


}
