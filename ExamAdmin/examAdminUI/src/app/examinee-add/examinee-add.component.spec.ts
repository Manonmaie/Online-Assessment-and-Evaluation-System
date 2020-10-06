import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamineeAddComponent } from './examinee-add.component';

describe('ExamineeAddComponent', () => {
  let component: ExamineeAddComponent;
  let fixture: ComponentFixture<ExamineeAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamineeAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamineeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
