package com.mercearia.mercearia.controller;


import com.mercearia.mercearia.dto.EmployeeDTO;
import com.mercearia.mercearia.model.Employee;
import com.mercearia.mercearia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
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
        List<Employee> funcionarios = employeeService.getAllEmployees();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Employee>> getByName(@RequestParam String name){
        List<Employee> funcionarios = employeeService.getByNomeContainingIgnoreCase(name);
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/telephone")
    public ResponseEntity<List<Employee>> getByTelephone(@RequestParam String telephone){
        List<Employee> funcionarios = employeeService.getByTelephone(telephone);
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<List<Employee>> getByAddress(@RequestParam String address){
        List<Employee> funcionarios = employeeService.getByAddress(address);
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<List<Employee>> getByEmail(@RequestParam String email){
        List<Employee> funcionarios = employeeService.getByEmail(email);
        return  new ResponseEntity<>(funcionarios, HttpStatus.OK);
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
