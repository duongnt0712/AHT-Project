package com.aht.webservice.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private static List<Employee> employees;

    static {
        initEmployees();
    }

    private static void initEmployees() {
        employees = new ArrayList<Employee>();
        Employee emp1 = new Employee("1", "Dung");
        Employee emp2 = new Employee("2", "Toan");
        Employee emp3 = new Employee("3", "Cau");

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
    }

    // GET = READ
    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployee(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    // POST = CREATE
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // PUT = UPDATE
    public void updateEmployee(Employee emp, String id) {
        deleteEmployee(emp.getId());
        employees.add(new Employee(id, emp.getName()));
    }

    // DELETE
    public void deleteEmployee(String id) {
        for (Employee emp : employees) {
            if (emp.getId().equals(id)) {
                employees.remove(emp);
                return;
            }
        }
    }
}
