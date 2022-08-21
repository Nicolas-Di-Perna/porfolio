import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditestudioComponent } from './editestudio.component';

describe('EditestudioComponent', () => {
  let component: EditestudioComponent;
  let fixture: ComponentFixture<EditestudioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditestudioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditestudioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
