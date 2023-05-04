import { TestBed } from '@angular/core/testing';

import { RstService } from './rst.service';

describe('RstService', () => {
  let service: RstService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RstService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
