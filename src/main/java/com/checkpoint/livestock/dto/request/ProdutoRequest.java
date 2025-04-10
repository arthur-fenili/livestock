package com.checkpoint.livestock.dto.request;

import com.checkpoint.livestock.model.Categoria;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoRequest {
    private String nomeProduto;
    private String descricao;
    private Integer quantidade;
    private BigDecimal precoCusto;
    private Categoria categoria;
    private Long idArmazem;
}
