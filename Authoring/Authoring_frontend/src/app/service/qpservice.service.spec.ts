import { TestBed } from '@angular/core/testing';

import { QPServiceService } from './qpservice.service';

describe('QPServiceService', () => {
  let service: QPServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QPServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
