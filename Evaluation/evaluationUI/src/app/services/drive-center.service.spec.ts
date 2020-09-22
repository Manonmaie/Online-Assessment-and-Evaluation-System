import { TestBed } from '@angular/core/testing';

import { DriveCenterService } from './drive-center.service';

describe('DriveCenterService', () => {
  let service: DriveCenterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DriveCenterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
