package com.CodeBuffer.EMSUI.service;

import com.CodeBuffer.EMSUI.model.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee createEmployee(Employee employee);
    public List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    Employee updateEmplotee(Long id, Employee employee);
}
