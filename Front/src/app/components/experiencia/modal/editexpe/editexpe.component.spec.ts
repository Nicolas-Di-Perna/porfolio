import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditexpeComponent } from './editexpe.component';

describe('EditexpeComponent', () => {
  let component: EditexpeComponent;
  let fixture: ComponentFixture<EditexpeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditexpeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditexpeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
