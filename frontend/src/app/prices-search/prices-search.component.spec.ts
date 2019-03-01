import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PricesSearchComponent } from './prices-search.component';

describe('PricesSearchComponent', () => {
  let component: PricesSearchComponent;
  let fixture: ComponentFixture<PricesSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PricesSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PricesSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
