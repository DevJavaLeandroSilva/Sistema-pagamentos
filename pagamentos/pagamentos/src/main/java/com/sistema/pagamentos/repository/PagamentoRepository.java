package com.sistema.pagamentos.repository;

import com.sistema.pagamentos.entity.Pagamento;
import com.sistema.pagamentos.entity.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByCpfCnpjContainingAndStatus(String cpfCnpj, StatusEnum status);

    List<Pagamento> findByCpfCnpjContaining(String cpfCnpj);

    List<Pagamento> findByStatus(StatusEnum status);
}
