import { TestBed } from '@angular/core/testing';

import { ItemTFServiceService } from './item-tfservice.service';

describe('ItemTFServiceService', () => {
  let service: ItemTFServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemTFServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
