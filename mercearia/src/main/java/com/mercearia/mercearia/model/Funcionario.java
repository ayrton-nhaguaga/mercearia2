package com.mercearia.mercearia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "funcionarios")
@Data
public class Funcionario {
    @Id
    private String id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
}
