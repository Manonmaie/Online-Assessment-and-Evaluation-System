import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamdriveMarksComponent } from './examdrive-marks.component';

describe('ExamdriveMarksComponent', () => {
  let component: ExamdriveMarksComponent;
  let fixture: ComponentFixture<ExamdriveMarksComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamdriveMarksComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamdriveMarksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
