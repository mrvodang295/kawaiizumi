import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IncubationManagementComponent } from './incubation-management.component';

describe('IncubationManagementComponent', () => {
  let component: IncubationManagementComponent;
  let fixture: ComponentFixture<IncubationManagementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IncubationManagementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncubationManagementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
