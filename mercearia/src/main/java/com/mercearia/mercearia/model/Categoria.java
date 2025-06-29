package com.mercearia.mercearia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
@Data
public class Categoria {
    @Id
    private  String id;
    private String categoria;
}
