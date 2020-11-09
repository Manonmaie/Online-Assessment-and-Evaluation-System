import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PackageManagementComponent } from './package-management.component';

describe('PackageManagementComponent', () => {
  let component: PackageManagementComponent;
  let fixture: ComponentFixture<PackageManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PackageManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PackageManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
