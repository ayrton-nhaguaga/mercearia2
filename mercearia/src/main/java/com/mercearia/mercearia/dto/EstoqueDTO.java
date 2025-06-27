package com.mercearia.mercearia.dto;

import com.mercearia.mercearia.model.Produto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EstoqueDTO {
    private String id;

    @NotBlank
    private Produto produto;

    @NotBlank
    private int quantidade;
}
