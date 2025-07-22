package com.ayrton.mercearia.repository;

import com.ayrton.mercearia.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{
    @Override
    Optional<Employee> findById(String id);

    @Override
    List<Employee> findAll();

    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByTelephone(String telephone);

    List<Employee> findByEmail(String email);

    List<Employee> findByAddress(String address);

}
