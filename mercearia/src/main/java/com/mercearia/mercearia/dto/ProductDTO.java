package com.mercearia.mercearia.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductDTO {

    private String id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    private String price;

    @NotBlank
    private String category;
}
