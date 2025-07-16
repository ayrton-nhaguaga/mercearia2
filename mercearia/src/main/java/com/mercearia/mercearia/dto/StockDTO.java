package com.mercearia.mercearia.dto;

import com.mercearia.mercearia.model.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StockDTO {
    private String id;

    @NotBlank
    private Product product;

    @NotBlank
    private int quantity;
}
