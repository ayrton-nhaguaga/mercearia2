package com.mercearia.mercearia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProdutoDTO {

    private String id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nome;

    @NotBlank
    private String preco;

    @NotBlank
    private String categoria;
}
