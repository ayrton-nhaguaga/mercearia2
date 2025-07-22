package com.ayrton.mercearia.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CategoryDTO {
    private String id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String category;

}
