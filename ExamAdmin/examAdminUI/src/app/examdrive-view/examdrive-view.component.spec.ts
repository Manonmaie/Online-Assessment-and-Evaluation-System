import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamdriveViewComponent } from './examdrive-view.component';

describe('ExamdriveViewComponent', () => {
  let component: ExamdriveViewComponent;
  let fixture: ComponentFixture<ExamdriveViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamdriveViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamdriveViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
