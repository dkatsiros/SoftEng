import { Component, OnInit } from '@angular/core';
import { Products } from '../products';
import {ApiProductsService} from '../api-products.service';



@Component({
  selector: 'app-products-search',
  templateUrl: './products-search.component.html',
  styleUrls: ['./products-search.component.css']
})
export class ProductsSearchComponent implements OnInit {
  products: Products[];
  
  constructor(private apis: ApiProductsService) { }
  ngOnInit() {
    this.apis.getProducts().subscribe((data: Products[]) => {
      this.products= data;
    });
   }

}
