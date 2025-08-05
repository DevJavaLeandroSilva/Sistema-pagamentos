package com.sistema.pagamentos.rest.dto.request;

import com.sistema.pagamentos.entity.enums.MetodoPagamentoEnum;
import com.sistema.pagamentos.entity.enums.StatusEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PagamentoRequestDTO {

    private Long idPagamento;
    @NotNull
    @Size(min = 11, max = 14)
    private String cpfCnpj;
    private MetodoPagamentoEnum metodoPagamento;
    private String numeroCartao;
    private BigDecimal valor;
    private StatusEnum status;
    private Boolean ativo;

}
