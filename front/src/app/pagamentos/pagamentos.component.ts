import { Component, OnInit } from '@angular/core';
import { Pagamentos } from '../_service/pagamentos.service';
import { PagamentosResponseDTO } from '../Dao/PagamentosResponseDTO';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CurrencyPipe, CommonModule } from '@angular/common';
import { StatusPipe } from '../_pipes/status.pipe';

@Component({
  selector: 'app-pagamentos',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    HttpClientModule,
    CurrencyPipe,
    StatusPipe,
  ],
  templateUrl: './pagamentos.component.html',
  styleUrls: ['./pagamentos.component.css'],
})
export class PagamentosComponent implements OnInit {
  pagamentos: PagamentosResponseDTO[] = [];
  cpfCnpj: string = '';
  status: string = '';

  constructor(private pagamentosService: Pagamentos) {}

  ngOnInit(): void {
    this.listarTodos();
  }

  listarTodos(): void {
    this.pagamentosService.filtrar('', '').subscribe({
      next: (dados) => (this.pagamentos = dados),
      error: (err) => console.error('Erro ao listar todos:', err),
    });
  }

  filtrar(): void {
    const cpfFiltro = this.cpfCnpj.trim();
    const statusFiltro = this.status.trim();
    const filtroPorCpf = !!cpfFiltro;
    const filtroPorStatus = !!statusFiltro;

    if (!filtroPorCpf && !filtroPorStatus) {
      this.listarTodos();
      return;
    }

    this.pagamentosService.filtrar(cpfFiltro, statusFiltro).subscribe({
      next: (dados) => (this.pagamentos = dados),
      error: (err) => console.error('Erro ao filtrar:', err),
    });
  }

  excluir(idPagamento: number): void {
    this.pagamentosService.excluir(idPagamento).subscribe({
      next: () => {
        this.pagamentos = this.pagamentos.filter((p) => p.idPagamento !== idPagamento);
      },
      error: (err) => { console.error('Erro ao excluir:', err);
        alert('Não foi possível excluir. Verifique o status do pagamento.');
      },
    });
  }
}
