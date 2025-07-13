package com.mercearia.mercearia.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "vendas")
@Data
public class Venda {
    @Id
    private String id;
    private Produto itemVendido;
    private String funcionario;
    private int quantidadeVendida;
    private LocalDateTime dataVenda;
}
