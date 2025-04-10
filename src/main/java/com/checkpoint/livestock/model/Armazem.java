package com.checkpoint.livestock.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ARMAZENS_CP2")
public class Armazem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ARMAZEM", nullable = false)
    private Long id;

    @Column(name = "NOME_ARMAZEM", length = 255)
    private String nomeArmazem;

    @Column(name = "ENDERECO", length = 255)
    private String endereco;

    @Column(name = "TELEFONE", length = 255)
    private String telefone;

    @Column(name = "NOME_RESPONSAVEL", length = 255)
    private String nomeResponsavel;


}
