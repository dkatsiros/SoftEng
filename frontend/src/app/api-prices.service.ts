import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Prices } from './prices';

@Injectable({
  providedIn: 'root'
})
export class ApiPricesService {

 
  apiURL: string = 'https://localhost:8765/observatory/api/';
  
  constructor(private httpClient: HttpClient) {};
  
  public createPrices(price: Prices){
    return this.httpClient.post(`${this.apiURL}/prices/`,price);

  };

  public getPrices(url?: string){
    return this.httpClient.get<Prices[]>(`${this.apiURL}/prices`);

  };

  public firstPage: string = "";
  public prevPage: string = "";
  public nextPage: string = "";
  public lastPage: string = "";


}