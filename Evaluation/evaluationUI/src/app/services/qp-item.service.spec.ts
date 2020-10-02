import { TestBed } from '@angular/core/testing';

import { QpItemService } from './qp-item.service';

describe('QpItemService', () => {
  let service: QpItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QpItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
