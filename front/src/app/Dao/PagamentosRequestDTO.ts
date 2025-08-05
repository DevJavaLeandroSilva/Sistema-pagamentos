export interface PagamentosRequestDTO {
  idPagamento: number;
  cpfCnpj: string;
  metodoPagamento: string;
  numeroCartao?: string;
  valor: number;
  status: string;
  ativo: boolean;
}
