import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QpItemComponent } from './qp-item.component';

describe('QpItemComponent', () => {
  let component: QpItemComponent;
  let fixture: ComponentFixture<QpItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QpItemComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QpItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
