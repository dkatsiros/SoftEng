import { Component, OnInit } from '@angular/core';
import { Prices } from '../prices';
import { ApiPricesService } from '../api-prices.service';

@Component({
  selector: 'app-prices-search',
  templateUrl: './prices-search.component.html',
  styleUrls: ['./prices-search.component.css']
})
export class PricesSearchComponent implements OnInit {
  prices: Prices[];
  start: number;
  count: number;
  total: number;
  data: any = {};

  constructor(private apis: ApiPricesService) { }

  ngOnInit() {
    this.apis.getPrices().subscribe(response => {
      console.log(response);
        this.data=response;
        var str = JSON.stringify(this.data,null,"    ");
        this.prices=this.data.prices;
      }
    )
  }

}

