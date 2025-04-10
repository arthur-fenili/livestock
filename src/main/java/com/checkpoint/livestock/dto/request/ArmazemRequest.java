package com.checkpoint.livestock.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArmazemRequest {
    private String nomeArmazem;
    private String endereco;
    private String telefone;
    private String nomeResponsavel;
}
