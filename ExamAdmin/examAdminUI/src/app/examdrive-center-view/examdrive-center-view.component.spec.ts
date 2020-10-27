import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamdriveCenterViewComponent } from './examdrive-center-view.component';

describe('ExamdriveCenterViewComponent', () => {
  let component: ExamdriveCenterViewComponent;
  let fixture: ComponentFixture<ExamdriveCenterViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExamdriveCenterViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamdriveCenterViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
