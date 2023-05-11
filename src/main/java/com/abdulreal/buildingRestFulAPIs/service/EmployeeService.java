package com.abdulreal.buildingRestFulAPIs.service;

import com.abdulreal.buildingRestFulAPIs.errorHandling.EmployeeNotFoundException;
import com.abdulreal.buildingRestFulAPIs.model.Employee;
import com.abdulreal.buildingRestFulAPIs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepository;

    // CREATE
    public Employee createEmployee(Employee emp) {
        return empRepository.save(emp);
    }

    // READ
    public List<Employee> getEmployees() {
        return empRepository.findAll();
    }

    public Employee getEmployee(Long id) throws EmployeeNotFoundException{
        Employee emp = empRepository.findByEmpId(id);
        if(emp != null)
            return emp;
        else
            throw new EmployeeNotFoundException("User not found with id: " + id);
    }

    // DELETE
    public void deleteEmployee(Long empId) {
        empRepository.deleteById(empId);
    }

    // UPDATE
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = empRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());

        return empRepository.save(emp);
    }


}

