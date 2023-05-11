package com.abdulreal.buildingRestFulAPIs.repository;

import com.abdulreal.buildingRestFulAPIs.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmpId(long id);
}

