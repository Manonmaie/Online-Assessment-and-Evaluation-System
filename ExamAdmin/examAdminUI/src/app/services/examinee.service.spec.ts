import { TestBed } from '@angular/core/testing';

import { ExamineeService } from './examinee.service';

describe('ExamineeService', () => {
  let service: ExamineeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamineeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
