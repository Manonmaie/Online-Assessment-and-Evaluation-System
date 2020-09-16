import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DriveCenterComponent } from './drive-center.component';

describe('DriveCenterComponent', () => {
  let component: DriveCenterComponent;
  let fixture: ComponentFixture<DriveCenterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DriveCenterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DriveCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
