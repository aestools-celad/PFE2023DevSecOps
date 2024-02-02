import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChargeLocationComponent } from './charge-location.component';

describe('ChargeLocatonComponent', () => {
  let component: ChargeLocationComponent;
  let fixture: ComponentFixture<ChargeLocationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChargeLocationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChargeLocationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
