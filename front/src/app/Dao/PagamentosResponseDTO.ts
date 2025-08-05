export interface PagamentosResponseDTO {
  idPagamento: number;
  cpfCnpj: string;
  metodoPagamento: 'BOLETO' | 'CARTAO_CREDITO' | 'CARTAO_DEBITO' | 'PIX';
  numeroCartao?: string;
  valor: number;
  status: 'PENDENTE_PROCESSAMENTO' | 'PROCESSADO_SUCESSO' | 'PROCESSADO_FALHA';
  ativo: boolean;
}
