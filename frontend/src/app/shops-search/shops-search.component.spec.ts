import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShopsSearchComponent } from './shops-search.component';

describe('ShopsSearchComponent', () => {
  let component: ShopsSearchComponent;
  let fixture: ComponentFixture<ShopsSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShopsSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShopsSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
