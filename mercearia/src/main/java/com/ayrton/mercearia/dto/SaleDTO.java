package com.ayrton.mercearia.dto;

import com.ayrton.mercearia.model.Product;
import com.ayrton.mercearia.model.Supplier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SaleDTO {

    private String id;

    @NotBlank
    private Product itemSold;

    @NotBlank
    @Size(min = 1, max = 50)
    private String supplier;

    @NotBlank
    private String quantitySold;

    private LocalDateTime saleDate;
}
