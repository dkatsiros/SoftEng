import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertProductComponent } from './insert-product.component';

describe('InsertProductComponent', () => {
  let component: InsertProductComponent;
  let fixture: ComponentFixture<InsertProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
