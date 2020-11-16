import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamineeItemMarksComponent } from './examinee-item-marks.component';

describe('ExamineeItemMarksComponent', () => {
  let component: ExamineeItemMarksComponent;
  let fixture: ComponentFixture<ExamineeItemMarksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamineeItemMarksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamineeItemMarksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
