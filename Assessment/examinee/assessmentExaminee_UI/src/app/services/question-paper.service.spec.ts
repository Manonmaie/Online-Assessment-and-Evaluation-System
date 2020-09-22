import { TestBed } from '@angular/core/testing';

import { QuestionPaperService } from './question-paper.service';

describe('QuestionPaperService', () => {
  let service: QuestionPaperService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QuestionPaperService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
