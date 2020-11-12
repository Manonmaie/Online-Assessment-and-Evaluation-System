import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QpPreviewComponent } from './qp-preview.component';

describe('QpPreviewComponent', () => {
  let component: QpPreviewComponent;
  let fixture: ComponentFixture<QpPreviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QpPreviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QpPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
