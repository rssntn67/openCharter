import { TestBed } from '@angular/core/testing';

import { MyboatserviceService } from './myboatservice.service';

describe('MyboatserviceService', () => {
  let service: MyboatserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MyboatserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
