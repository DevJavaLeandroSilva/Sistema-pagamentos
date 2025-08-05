package com.sistema.pagamentos.rest;

import com.sistema.pagamentos.entity.Pagamento;
import com.sistema.pagamentos.entity.enums.StatusEnum;
import com.sistema.pagamentos.rest.dto.request.PagamentoRequestDTO;
import com.sistema.pagamentos.rest.dto.response.PagamentoResponseDTO;
import com.sistema.pagamentos.rest.factory.PagamentoRestFactory;
import com.sistema.pagamentos.service.interfaces.IPagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoRest {
    @Autowired
    private IPagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<PagamentoResponseDTO> salvar(@RequestBody @Valid PagamentoRequestDTO requestDTO){
        Pagamento pagamento = PagamentoRestFactory.toEntity(requestDTO);
        Pagamento salvo = pagamentoService.salvar(pagamento);
        return ResponseEntity.ok(PagamentoRestFactory.toResponseDTO(salvo));
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PagamentoResponseDTO>> listar(){
        List<Pagamento> lista = pagamentoService.listarPagamentos();
        List<PagamentoResponseDTO> resposta = PagamentoRestFactory.toResponseDTOList(lista);
        return ResponseEntity.ok(resposta);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filtro")
    public ResponseEntity<List<PagamentoResponseDTO>> filtrar(
            @RequestParam(required = false) String cpfCnpj,
            @RequestParam(required = false) StatusEnum status
    ) {
        String filtroCpf = cpfCnpj != null ? cpfCnpj : "";

        List<Pagamento> resultado;

        if (cpfCnpj != null && status != null) {
            resultado = pagamentoService.filtrar(filtroCpf, status);
        } else if (cpfCnpj != null) {
            resultado = pagamentoService.filtrarPorCpfCnpj(filtroCpf);
        } else if (status != null) {
            resultado = pagamentoService.filtrarPorStatus(status);
        } else {
            resultado = pagamentoService.listarPagamentos();
        }

        return ResponseEntity.ok(PagamentoRestFactory.toResponseDTOList(resultado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pagamentoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    // @KafkaListener(topics = "pagamento-consumer", groupId = "pagamento-consumer")
    // public void consumir(PagamentoResponseDTO dto) {
    //     dto.setStatus(StatusEnum.PROCESSADO_SUCESSO);

    //     Pagamento pagamento = PagamentoRestFactory.fromResponseDTO(dto);
    //     pagamentoService.atualizarStatus(pagamento);
    // }
}
