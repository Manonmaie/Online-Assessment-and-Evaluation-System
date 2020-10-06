import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamineeAddHeaderComponent } from './examinee-add-header.component';

describe('ExamineeAddHeaderComponent', () => {
  let component: ExamineeAddHeaderComponent;
  let fixture: ComponentFixture<ExamineeAddHeaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamineeAddHeaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamineeAddHeaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
