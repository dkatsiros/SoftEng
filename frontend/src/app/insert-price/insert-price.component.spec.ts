import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertPriceComponent } from './insert-price.component';

describe('InsertPriceComponent', () => {
  let component: InsertPriceComponent;
  let fixture: ComponentFixture<InsertPriceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertPriceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertPriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
