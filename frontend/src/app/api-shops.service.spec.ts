import { TestBed } from '@angular/core/testing';

import { ApiShopsService } from './api-shops.service';

describe('ApiShopsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiShopsService = TestBed.get(ApiShopsService);
    expect(service).toBeTruthy();
  });
});
