import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SetCookieExampleComponent } from './set-cookie-example.component';

describe('SetCookieExampleComponent', () => {
  let component: SetCookieExampleComponent;
  let fixture: ComponentFixture<SetCookieExampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SetCookieExampleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SetCookieExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
