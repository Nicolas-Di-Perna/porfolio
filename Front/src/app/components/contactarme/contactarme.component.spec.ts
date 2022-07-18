import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactarmeComponent } from './contactarme.component';

describe('ContactarmeComponent', () => {
  let component: ContactarmeComponent;
  let fixture: ComponentFixture<ContactarmeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContactarmeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactarmeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
