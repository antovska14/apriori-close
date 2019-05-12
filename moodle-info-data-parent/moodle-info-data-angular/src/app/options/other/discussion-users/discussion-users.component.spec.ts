import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiscussionUsersComponent } from './discussion-users.component';

describe('DiscussionUsersComponent', () => {
  let component: DiscussionUsersComponent;
  let fixture: ComponentFixture<DiscussionUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiscussionUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiscussionUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
