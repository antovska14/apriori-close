import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IpUserComponent } from './ip-user.component';

describe('IpUserComponent', () => {
  let component: IpUserComponent;
  let fixture: ComponentFixture<IpUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IpUserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IpUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
