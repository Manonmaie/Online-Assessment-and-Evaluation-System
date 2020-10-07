import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamdriveUpdateComponent } from './examdrive-update.component';

describe('ExamdriveUpdateComponent', () => {
  let component: ExamdriveUpdateComponent;
  let fixture: ComponentFixture<ExamdriveUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamdriveUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamdriveUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
