package com.abdulreal.buildingRestFulAPIs.controller;

import java.util.List;

import com.abdulreal.buildingRestFulAPIs.errorHandling.EmployeeNotFoundException;
import com.abdulreal.buildingRestFulAPIs.model.Employee;
import com.abdulreal.buildingRestFulAPIs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp) {

        return new ResponseEntity<>(empService.createEmployee(emp), HttpStatus.CREATED);
    }

    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public ResponseEntity<List<Employee>> readEmployees() {

        return ResponseEntity.ok(empService.getEmployees());
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
        return new ResponseEntity<>(empService.updateEmployee(id, empDetails), HttpStatus.CREATED);
    }

    @RequestMapping(value="/employees/{empId}", method=RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        empService.deleteEmployee(id);
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "empId") Long id)throws EmployeeNotFoundException {
        return ResponseEntity.ok(empService.getEmployee(id));
    }





}

