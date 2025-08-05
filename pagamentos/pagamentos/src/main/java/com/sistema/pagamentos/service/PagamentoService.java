package com.sistema.pagamentos.service;

import com.sistema.pagamentos.entity.Pagamento;
import com.sistema.pagamentos.entity.enums.StatusEnum;
import com.sistema.pagamentos.repository.PagamentoRepository;
import com.sistema.pagamentos.rest.dto.response.PagamentoResponseDTO;
import com.sistema.pagamentos.rest.factory.PagamentoRestFactory;
import com.sistema.pagamentos.service.interfaces.IPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService implements IPagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    // @Autowired
    // private KafkaTemplate<String, PagamentoResponseDTO> kafkaTemplate;

    public Pagamento salvar(Pagamento pagamento) {
        pagamento.setStatus(StatusEnum.PENDENTE_PROCESSAMENTO);
        Pagamento salvo = pagamentoRepository.save(pagamento);
        PagamentoResponseDTO dto = PagamentoRestFactory.toResponseDTO(salvo);

        return salvo;
    }

    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public List<Pagamento> filtrar(String cpfCnpj, StatusEnum status) {
        return pagamentoRepository.findByCpfCnpjContainingAndStatus(cpfCnpj, status);
    }

    public List<Pagamento> filtrarPorCpfCnpj(String cpfCnpj) {
        return pagamentoRepository.findByCpfCnpjContaining(cpfCnpj);
    }

    public List<Pagamento> filtrarPorStatus(StatusEnum status) {
        return pagamentoRepository.findByStatus(status);
    }

    public void excluir(Long id) {
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow();
        if (StatusEnum.PENDENTE_PROCESSAMENTO.equals(pagamento.getStatus())) {
            pagamento.setAtivo(false);
            pagamentoRepository.save(pagamento);
        }
    }

//     public void enviarKafka(PagamentoResponseDTO pagamento) {
//         kafkaTemplate.send("pagamento-topico", pagamento);
//     }

     public Pagamento atualizarStatus(Pagamento pagamento) {
         return pagamentoRepository.save(pagamento);
     }
}
