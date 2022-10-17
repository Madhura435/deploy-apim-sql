package com.azure.deployapimmysql.controller;

import com.azure.deployapimmysql.model.Employee;
import com.azure.deployapimmysql.repository.EmployeeRepository;
import com.nimbusds.oauth2.sdk.http.HTTPRequest;
import com.sun.net.httpserver.HttpContext;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String envStr = System.getenv("SQLCONNSTR_connectionstring");
        return "ayyyo"+ envStr;
    }


    // https://learn.microsoft.com/en-us/azure/app-service/configure-authentication-user-identities implementation here
    @GetMapping("/group-claim")
    private Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }

        return map;
    }

}
