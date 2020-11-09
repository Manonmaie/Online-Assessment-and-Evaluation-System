import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamdriveUpdateCenterAddComponent } from './examdrive-update-center-add.component';

describe('ExamdriveUpdateCenterAddComponent', () => {
  let component: ExamdriveUpdateCenterAddComponent;
  let fixture: ComponentFixture<ExamdriveUpdateCenterAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamdriveUpdateCenterAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamdriveUpdateCenterAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
