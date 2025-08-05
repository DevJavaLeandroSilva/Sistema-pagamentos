package com.sistema.pagamentos.entity;

import com.sistema.pagamentos.entity.enums.MetodoPagamentoEnum;
import com.sistema.pagamentos.entity.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_pagamento")
    private Long idPagamento;

    @Column(name = "cpfCnpj", nullable = false, length = 14)
    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pagamento")
    private MetodoPagamentoEnum metodoPagamento;

    @Column(name = "numero_cartao", nullable = true, length = 16)
    private String numeroCartao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;

    @Column(name = "ativo")
    private Boolean ativo = true;
}
