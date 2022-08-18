import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditproyectoComponent } from './editproyecto.component';

describe('EditproyectoComponent', () => {
  let component: EditproyectoComponent;
  let fixture: ComponentFixture<EditproyectoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditproyectoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditproyectoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
