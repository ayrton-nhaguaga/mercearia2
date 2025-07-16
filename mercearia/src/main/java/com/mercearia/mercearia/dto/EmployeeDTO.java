package com.mercearia.mercearia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeDTO {

    private String id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    @Size(min = 1, max = 50)
    private String telephone;

    @NotBlank
    @Size(min = 1, max = 200)
    private String email;

    @NotBlank
    @Size(min = 1, max = 200)
    private String address;
}
