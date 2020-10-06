import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamineeViewComponent } from './examinee-view.component';

describe('ExamineeViewComponent', () => {
  let component: ExamineeViewComponent;
  let fixture: ComponentFixture<ExamineeViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamineeViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamineeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
