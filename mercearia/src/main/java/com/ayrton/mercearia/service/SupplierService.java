package com.ayrton.mercearia.service;

import com.ayrton.mercearia.dto.SupplierDTO;
import com.ayrton.mercearia.model.Supplier;
import com.ayrton.mercearia.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;

    public Supplier createSupplier(SupplierDTO dto){
        Supplier service = new Supplier();
        service.setName(dto.getName());
        service.setCategory(dto.getCategory());
        service.setAddress(dto.getAddress());
        service.setTelephone(dto.getTelephone());
        return repository.save(service);
    }

    public List<Supplier> getAll(){
        return repository.findAll();
    }

    public List<Supplier> getByNameIgnoreCase(String name){
        return repository.findByNameIgnoreCase(name);
    }

    public List<Supplier> getByAddress(String address){
        return repository.findByAddressIgnoreCase(address);
    }

    public List<Supplier> getByTelephone(String telephone){
        return repository.findByTelephoneIgnoreCase(telephone);
    }

    public List<Supplier> getByCategory(String category){
        return repository.findByCategoryIgnoreCase(category);
    }

    public List<Supplier> updateSupplier(String name, SupplierDTO dto){
        List<Supplier> suppliers = repository.findByNameIgnoreCase(name);
        for (Supplier f : suppliers){
            f.setName(dto.getName());
            f.setTelephone(dto.getTelephone());
            f.setAddress(dto.getAddress());
            f.setCategory(dto.getCategory());
            repository.save(f);
        }
        return  suppliers;
    }

    public boolean deleteSupplier (String name){
        List<Supplier> suppliers = repository.findByNameIgnoreCase(name);
        if (!suppliers.isEmpty()){
            repository.deleteAll();
            return true;
        }
        return  false;
    }
}
