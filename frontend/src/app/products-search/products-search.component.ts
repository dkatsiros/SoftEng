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
  start: number;
  count: number;
  total: number;
  data: any = {};

  constructor(private apis: ApiProductsService) { }

  ngOnInit() {
    this.apis.getProducts().subscribe(response => {
      console.log(response);
        this.data=response;
        var str = JSON.stringify(this.data,null,"    ");
        this.products=this.data.prices;
      }
    )
  }

}
