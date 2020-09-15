import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamdriveComponent } from './examdrive.component';

describe('ExamdriveComponent', () => {
  let component: ExamdriveComponent;
  let fixture: ComponentFixture<ExamdriveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamdriveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamdriveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
