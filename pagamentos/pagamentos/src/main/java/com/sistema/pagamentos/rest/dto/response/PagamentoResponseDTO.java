package com.sistema.pagamentos.rest.dto.response;

import com.sistema.pagamentos.entity.enums.MetodoPagamentoEnum;
import com.sistema.pagamentos.entity.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PagamentoResponseDTO {

    private Long idPagamento;
    private String cpfCnpj;
    private MetodoPagamentoEnum metodoPagamento;
    private String numeroCartao;
    private BigDecimal valor;
    private StatusEnum status;
    private Boolean ativo;

}
