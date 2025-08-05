package com.sistema.pagamentos.entity.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {
    PENDENTE_PROCESSAMENTO("Pendente"),
    PROCESSADO_SUCESSO("Processado com sucesso"),
    PROCESSADO_FALHA("Falha no processamento");

    private String label;

    private StatusEnum(String label) {
        this.label = label;
    }
}
