package com.aht.security.repository;

import com.aht.security.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findById(int id);
    List<Employee> findBySex(int sex);
    List<Employee> findByDepartmentId(int departmentId);

    List<Employee> findByType(int type);
}