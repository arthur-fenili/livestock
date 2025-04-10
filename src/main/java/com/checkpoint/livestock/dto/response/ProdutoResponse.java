package com.checkpoint.livestock.dto.response;

import com.checkpoint.livestock.model.Categoria;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoResponse {
    private Long id;
    private String nomeProduto;
    private Integer quantidade;
    private BigDecimal precoCusto;
    private Categoria categoria;
    private String nomeArmazem;
}
