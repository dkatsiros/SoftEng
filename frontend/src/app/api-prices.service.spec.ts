import { TestBed } from '@angular/core/testing';

import { ApiPricesService } from './api-prices.service';

describe('ApiPricesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiPricesService = TestBed.get(ApiPricesService);
    expect(service).toBeTruthy();
  });
});
