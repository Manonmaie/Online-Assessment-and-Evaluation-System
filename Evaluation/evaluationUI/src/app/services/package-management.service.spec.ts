import { TestBed } from '@angular/core/testing';

import { PackageManagementService } from './package-management.service';

describe('PackageManagementService', () => {
  let service: PackageManagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PackageManagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
