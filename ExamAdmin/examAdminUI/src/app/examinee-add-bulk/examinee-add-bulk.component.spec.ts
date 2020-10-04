import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamineeAddBulkComponent } from './examinee-add-bulk.component';

describe('ExamineeAddBulkComponent', () => {
  let component: ExamineeAddBulkComponent;
  let fixture: ComponentFixture<ExamineeAddBulkComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamineeAddBulkComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamineeAddBulkComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
