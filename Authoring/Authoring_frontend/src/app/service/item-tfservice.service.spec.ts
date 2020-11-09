import { TestBed } from '@angular/core/testing';

import { ItemServiceService } from './itemService.service';

describe('ItemServiceService', () => {
  let service: ItemServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
