import { TestBed } from '@angular/core/testing';

import { ItemFilterServiceService } from './item-filter-service.service';

describe('ItemFilterServiceService', () => {
  let service: ItemFilterServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemFilterServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
