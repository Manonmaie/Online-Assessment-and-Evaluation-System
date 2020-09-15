import { TestBed } from '@angular/core/testing';

import { ExamdriveService } from './examdrive.service';

describe('ExamdriveService', () => {
  let service: ExamdriveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExamdriveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
