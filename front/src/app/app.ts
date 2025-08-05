import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PagamentosComponent } from './pagamentos/pagamentos.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, PagamentosComponent],
  template: '<app-pagamentos />',
  styleUrls: ['./app.css']
})
export class App {
  protected readonly title = signal('pagamento');
}
