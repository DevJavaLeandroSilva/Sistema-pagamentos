import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PagamentosRequestDTO } from '../Dao/PagamentosRequestDTO';
import { PagamentosResponseDTO } from '../Dao/PagamentosResponseDTO';
import { HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class Pagamentos {
  private readonly API = 'http://localhost:8080/pagamentos';

  constructor(private http: HttpClient) {}

  listarPagamentos() {
    return this.http.get<PagamentosResponseDTO[]>(`${this.API}/lista`);
  }

  filtrar(cpfCnpj: string, status: string) {
    let params = new HttpParams();

    if (cpfCnpj.trim()) {
      params = params.set('cpfCnpj', cpfCnpj.trim());
    }

    if (status.trim()) {
      params = params.set('status', status.trim());
    }

    return this.http.get<PagamentosResponseDTO[]>(`${this.API}/filtro`, {
      params,
    });
  }

  salvar(dto: PagamentosRequestDTO) {
    return this.http.post<PagamentosResponseDTO>(this.API, dto);
  }

  excluir(idPagamento: number) {
    return this.http.delete(`${this.API}/pagamentos/${idPagamento}`);
  }
}
