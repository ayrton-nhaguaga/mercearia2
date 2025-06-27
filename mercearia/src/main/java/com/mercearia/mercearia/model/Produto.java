package com.mercearia.mercearia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
@Data
public class Produto {
    @Id
    private String id;
    private String nome;
    private double preco;
    private Categoria categoria;
}
