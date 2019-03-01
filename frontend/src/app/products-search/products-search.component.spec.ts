import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductsSearchComponent } from './products-search.component';

describe('ProductsSearchComponent', () => {
  let component: ProductsSearchComponent;
  let fixture: ComponentFixture<ProductsSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductsSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductsSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
