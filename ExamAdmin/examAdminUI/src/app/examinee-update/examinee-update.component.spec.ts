import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamineeUpdateComponent } from './examinee-update.component';

describe('ExamineeUpdateComponent', () => {
  let component: ExamineeUpdateComponent;
  let fixture: ComponentFixture<ExamineeUpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamineeUpdateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamineeUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
