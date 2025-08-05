import { TestBed } from '@angular/core/testing';

import { Pagamentos } from './_service/pagamentos.service';

describe('Pagamentos', () => {
  let service: Pagamentos;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Pagamentos);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
