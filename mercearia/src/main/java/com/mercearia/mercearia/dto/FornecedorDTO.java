package com.mercearia.mercearia.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FornecedorDTO {

    private String id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String nome;

    @NotBlank
    @Size(min = 1, max = 50)
    private String telefone;

    @NotBlank
    @Size(min = 1, max = 50)
    private String categoria;

    @NotBlank
    @Size(min = 1, max = 200)
    private String endereco;


}
