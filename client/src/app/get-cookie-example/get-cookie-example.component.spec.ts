import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetCookieExampleComponent } from './get-cookie-example.component';

describe('GetCookieExampleComponent', () => {
  let component: GetCookieExampleComponent;
  let fixture: ComponentFixture<GetCookieExampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetCookieExampleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetCookieExampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
