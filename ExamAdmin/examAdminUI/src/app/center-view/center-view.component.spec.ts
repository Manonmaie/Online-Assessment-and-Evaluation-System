import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CenterViewComponent } from './center-view.component';

describe('CenterViewComponent', () => {
  let component: CenterViewComponent;
  let fixture: ComponentFixture<CenterViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CenterViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CenterViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
