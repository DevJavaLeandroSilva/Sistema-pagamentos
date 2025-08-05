import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'status',
  standalone: true,
})
export class StatusPipe implements PipeTransform {
  private labels: Record<string, string> = {
    PENDENTE_PROCESSAMENTO: 'Pendente',
    PROCESSADO_SUCESSO: 'Processado com sucesso',
    PROCESSADO_FALHA: 'Falha no processamento',
  };

  transform(status: string): string {
    return this.labels[status] || status;
  }
}
