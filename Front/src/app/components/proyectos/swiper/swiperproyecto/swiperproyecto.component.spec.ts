import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SwiperproyectoComponent } from './swiperproyecto.component';

describe('SwiperproyectoComponent', () => {
  let component: SwiperproyectoComponent;
  let fixture: ComponentFixture<SwiperproyectoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SwiperproyectoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SwiperproyectoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
