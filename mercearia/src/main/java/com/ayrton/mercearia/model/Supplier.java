package com.ayrton.mercearia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "supplier")
@Data
public class Supplier {
    @Id
    private String id;
    private String name;
    private String telephone;
    private String category;
    private String address;
}
