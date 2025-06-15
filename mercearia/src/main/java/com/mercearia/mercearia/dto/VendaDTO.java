package com.mercearia.mercearia.dto;

import com.mercearia.mercearia.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VendaDTO {

    private String id;

    @NotBlank
    private Produto itemVendido;

    @NotBlank
    @Size(min = 1, max = 50)
    private String funcionario;

    @NotBlank
    private String quantidade;

    private LocalDateTime data;
}
