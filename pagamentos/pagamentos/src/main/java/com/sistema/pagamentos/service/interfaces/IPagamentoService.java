package com.sistema.pagamentos.service.interfaces;

import com.sistema.pagamentos.entity.Pagamento;
import com.sistema.pagamentos.entity.enums.StatusEnum;

import java.util.List;

public interface IPagamentoService {
    Pagamento salvar(Pagamento pagamento);

    List<Pagamento> listarPagamentos();

    List<Pagamento> filtrar(String cpfCnpj, StatusEnum status);

    public void excluir(Long id);

    List<Pagamento> filtrarPorCpfCnpj(String cpfCnpj);

    List<Pagamento> filtrarPorStatus(StatusEnum status);

    Pagamento atualizarStatus(Pagamento pagamento);
}
