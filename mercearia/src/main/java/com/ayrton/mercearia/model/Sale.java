package com.ayrton.mercearia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "vendas")
@Data
public class Sale {
    @Id
    private String id;
    private Product itemSold;
    private String supplier;
    private int quantitySold;
    private LocalDateTime saleDate;
}
