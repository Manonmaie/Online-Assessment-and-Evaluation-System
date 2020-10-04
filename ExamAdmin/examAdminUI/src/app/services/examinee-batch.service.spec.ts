import { TestBed } from '@angular/core/testing';

import { ExamineeBatchService } from './examinee-batch.service';

describe('ExamineeBatchService', () => {
  let service: ExamineeBatchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamineeBatchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
