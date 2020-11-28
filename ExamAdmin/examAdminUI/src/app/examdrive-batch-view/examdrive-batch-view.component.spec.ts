import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamdriveBatchViewComponent } from './examdrive-batch-view.component';

describe('ExamdriveBatchViewComponent', () => {
  let component: ExamdriveBatchViewComponent;
  let fixture: ComponentFixture<ExamdriveBatchViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamdriveBatchViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamdriveBatchViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
