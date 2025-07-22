package com.ayrton.mercearia.service;

import com.ayrton.mercearia.dto.EmployeeDTO;
import com.ayrton.mercearia.model.Employee;
import com.ayrton.mercearia.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee createEmployee(EmployeeDTO dto){
        Employee service = new Employee();
        service.setName(dto.getName());
        service.setAddress(dto.getAddress());
        service.setTelephone(dto.getTelephone());
        service.setEmail(dto.getEmail());
        return repository.save(service);
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public List<Employee> getByNomeContainingIgnoreCase(String name){
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Employee> getByTelephone(String telephone){
        return repository.findByTelephone(telephone);
    }

    public List<Employee> getByAddress(String address){
        return repository.findByAddress(address);
    }

    public List<Employee> getByEmail(String email){
        return repository.findByEmail(email);
    }

    public List<Employee> updateEmployee(String name, EmployeeDTO dto){
        List<Employee> employees = repository.findByNameContainingIgnoreCase(name);
        for (Employee e : employees){
            e.setName(dto.getName());
            e.setTelephone(dto.getTelephone());
            e.setAddress(dto.getAddress());
            e.setEmail(dto.getEmail());
            repository.save(e);
        }
        return employees;
    }

    public boolean deleteEmployee(String name){
        List<Employee> employees = repository.findByNameContainingIgnoreCase(name);
        if (!employees.isEmpty()){
            repository.deleteAll();
            return true;
        }
        return false;
    }
}
