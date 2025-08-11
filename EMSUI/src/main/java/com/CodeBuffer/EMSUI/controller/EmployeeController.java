package com.CodeBuffer.EMSUI.controller;

import com.CodeBuffer.EMSUI.model.Employee;
import com.CodeBuffer.EMSUI.service.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:5173/")
@RestController
@RequestMapping("/EMS")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return  service.getAllEmployees();
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted=false;
        deleted=service.deleteEmployee(id);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",deleted);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = null;
        employee = service.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/employee/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        employee=service.updateEmplotee(id,employee);
        return ResponseEntity.ok(employee);

}
}

