import { TestBed } from '@angular/core/testing';

import { ExcelServicesService } from './excel-services.service';

describe('ExcelServicesService', () => {
  let service: ExcelServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExcelServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
