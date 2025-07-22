package com.ayrton.mercearia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private Category category;
}
