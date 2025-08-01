package com.ayrton.mercearia.controller;


import com.ayrton.mercearia.dto.EmployeeDTO;
import com.ayrton.mercearia.model.Employee;
import com.ayrton.mercearia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDTO dto){
        Employee employee = employeeService.createEmployee(dto);
        return  new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Employee>> getByName(@RequestParam String name){
        List<Employee> employees = employeeService.getByNomeContainingIgnoreCase(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/telephone")
    public ResponseEntity<List<Employee>> getByTelephone(@RequestParam String telephone){
        List<Employee> employees = employeeService.getByTelephone(telephone);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Employee>> getByAddress(@RequestParam String address){
        List<Employee> employees = employeeService.getByAddress(address);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<List<Employee>> getByEmail(@RequestParam String email){
        List<Employee> employees = employeeService.getByEmail(email);
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PutMapping("/name")
    public ResponseEntity<List<Employee>> updateEmployee(@RequestParam String name, @RequestBody EmployeeDTO dto){
        List<Employee> updatedList = employeeService.updateEmployee(name, dto);

        if (updatedList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(updatedList);
    }

    @DeleteMapping("/name")
    public ResponseEntity<Void> deleteEmployeeByNome(@RequestParam String name){
        if(employeeService.deleteEmployee(name)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
