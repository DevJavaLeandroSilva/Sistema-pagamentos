package com.sistema.pagamentos.entity.enums;

public enum MetodoPagamentoEnum {
    BOLETO("Boleto"),
    CARTAO_CREDITO("Cartão de credito"),
    CARTAO_DEBITO("Cartão de débito"),
    PIX("Pix");

    private String label;

    MetodoPagamentoEnum(String label) {
        this.label = label;
    }
}
