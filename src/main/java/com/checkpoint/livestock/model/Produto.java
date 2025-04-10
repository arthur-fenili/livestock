package com.checkpoint.livestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUTOS_CP2")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO", nullable = false)
    private Long id;

    @Column(name = "CATEGORIA", length = 255)
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "NOME_PRODUTO", length = 255)
    private String nomeProduto;

    @Column(name = "DESCRICAO", length = 255)
    private String descricao;

    @Column(name = "QUANTIDADE", length = 255)
    private Integer quantidade;

    @Column(name = "PRECO_CUSTO", length = 255)
    private BigDecimal precoCusto;

    @ManyToOne
    @JoinColumn(name = "ID_ARMAZEM")
    private Armazem armazem;

}
