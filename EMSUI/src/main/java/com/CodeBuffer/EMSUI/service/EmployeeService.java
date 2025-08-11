package com.CodeBuffer.EMSUI.service;

import com.CodeBuffer.EMSUI.entity.EmployeeEntity;
import com.CodeBuffer.EMSUI.model.Employee;
import com.CodeBuffer.EMSUI.repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    private EmployeeRepo repo;

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        repo.save(employeeEntity);
        return employee;

    }

        @Override
        public List<Employee> getAllEmployees() {
            List<EmployeeEntity> employeeEntities =repo.findAll();

            List<Employee> employees = employeeEntities
                    .stream()
                    .map(emp -> new Employee(
                            emp.getId(),
                            emp.getFirstName(),
                            emp.getLastName(),
                            emp.getEmail()))
                    .collect(Collectors.toList());

            return employees;
        }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee=repo.findById(id).get();
        repo.delete(employee);
        return true;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity entity=repo.findById(id).get();
        Employee employee=new Employee();
        BeanUtils.copyProperties(entity,employee);
        return employee;
    }

    @Override
    public Employee updateEmplotee(Long id, Employee employee) {
        EmployeeEntity emp=repo.findById(id).get();
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmail(employee.getEmail());
        repo.save(emp);
        return employee;
    }

}
