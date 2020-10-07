import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamdriveAddComponent } from './examdrive-add.component';

describe('ExamdriveAddComponent', () => {
  let component: ExamdriveAddComponent;
  let fixture: ComponentFixture<ExamdriveAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamdriveAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamdriveAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
