package com.sistema.pagamentos.rest.factory;

import com.sistema.pagamentos.entity.Pagamento;
import com.sistema.pagamentos.rest.dto.request.PagamentoRequestDTO;
import com.sistema.pagamentos.rest.dto.response.PagamentoResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PagamentoRestFactory {

    public static Pagamento toEntity(PagamentoRequestDTO dto) {
        if (dto == null) return null;

        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(dto.getIdPagamento());
        pagamento.setCpfCnpj(dto.getCpfCnpj());
        pagamento.setMetodoPagamento(dto.getMetodoPagamento());
        pagamento.setNumeroCartao(dto.getNumeroCartao());
        pagamento.setValor(dto.getValor());
        pagamento.setStatus(dto.getStatus());
        pagamento.setAtivo(dto.getAtivo());

        return pagamento;
    }

    public static PagamentoResponseDTO toResponseDTO(Pagamento pagamento) {
        if (pagamento == null) return null;

        PagamentoResponseDTO dto = new PagamentoResponseDTO();
        dto.setIdPagamento(pagamento.getIdPagamento());
        dto.setCpfCnpj(pagamento.getCpfCnpj());
        dto.setMetodoPagamento(pagamento.getMetodoPagamento());
        dto.setNumeroCartao(pagamento.getNumeroCartao());
        dto.setValor(pagamento.getValor());
        dto.setStatus(pagamento.getStatus());
        dto.setAtivo(pagamento.getAtivo());

        return dto;
    }

    public static List<PagamentoResponseDTO> toResponseDTOList(List<Pagamento> pagamentos) {
        return pagamentos.stream()
                .map(PagamentoRestFactory::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static Pagamento fromResponseDTO(PagamentoResponseDTO dto) {
        if (dto == null) return null;

        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(dto.getIdPagamento());
        pagamento.setCpfCnpj(dto.getCpfCnpj());
        pagamento.setMetodoPagamento(dto.getMetodoPagamento());
        pagamento.setNumeroCartao(dto.getNumeroCartao());
        pagamento.setValor(dto.getValor());
        pagamento.setStatus(dto.getStatus());
        pagamento.setAtivo(dto.getAtivo());

        return pagamento;
    }
}