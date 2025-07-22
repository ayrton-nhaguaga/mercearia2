package com.ayrton.mercearia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stock")
@Data
public class Stock {
    @Id
    private String id;
    private Product product;
    private int quantity;
}
