package com.azure.deployapimmysql.controller;

import com.azure.deployapimmysql.model.Employee;
import com.azure.deployapimmysql.repository.EmployeeRepository;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    @GetMapping(value = "employees",produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Employee> getAllEmployees1() {
        return employeeRepository.findAll();
    }

    @ApiOperation(value = "to return employee by id")
    @GetMapping(value = "employee",produces = MediaType.APPLICATION_JSON_VALUE)
    private Employee getByEmployeeId(@RequestParam("eid") String eid) {
        return employeeRepository.findById(eid).get();
    }

    @ApiOperation(value = "save employee")
    @PostMapping(value = "employee",consumes =MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }

    @GetMapping(value = "text")
    private String getByEmployeeId() {
        return "waste fellow madhura waste wasteeeee";
    }


}
