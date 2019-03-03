import { Component, OnInit } from '@angular/core';
import { Shops } from '../shops';
import { ApiShopsService } from '../api-shops.service';

@Component({
  selector: 'app-shops-search',
  templateUrl: './shops-search.component.html',
  styleUrls: ['./shops-search.component.css']
})
export class ShopsSearchComponent implements OnInit {
  shops: Shops[];
  start: number;
  count: number;
  total: number;
  data: any = {};
data2: any={};
  constructor(private apis: ApiShopsService) { }

  ngOnInit() {
   
    this.apis.getShops().subscribe(response => {
      console.log(response);
        this.data=response;
        var str = JSON.stringify(this.data,null,"    ");
        this.shops=this.data.shops;
      }
    )

     
  }
  //(data: Shops[]) => {this.shops = data ;}

}
