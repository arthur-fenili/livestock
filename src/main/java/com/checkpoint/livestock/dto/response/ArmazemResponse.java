package com.checkpoint.livestock.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArmazemResponse {
    private Long id;
    private String nomeArmazem;
    private String endereco;
    private String telefone;
    private String nomeResponsavel;
}
