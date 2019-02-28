import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Shops } from './shops';


@Injectable({
  providedIn: 'root'
})
export class ApiShopsService {
 
  apiURL: string = 'https://localhost:8765/observatory/api/';
  
  constructor(private httpClient: HttpClient) {};
  
  public createShops(shop: Shops){
    return this.httpClient.post(`${this.apiURL}/shops`,shop);

  };
  public updateShops(shop: Shops){
    return this.httpClient.put(`${this.apiURL}/shops/${shop.id}`,shop);

  };

public patchShops(shop: Shops){ // ELEGXOS TO PATCH PREPEI NA STELNOUME ENA MONO PEDIO  
    return this.httpClient.patch(`${this.apiURL}/shops/${shop.id}`,shop);

  };

  public deleteShops(id: number){
    return this.httpClient.delete(`${this.apiURL}/shops/${id}`);

  };
  public getShopsById(id: number){
    return this.httpClient.get(`${this.apiURL}/shops/${id}`);

  };

  public getShops(url?: string){
    return this.httpClient.get<Shops[]>(`${this.apiURL}/shops`);

  };

  public firstPage: string = "";
  public prevPage: string = "";
  public nextPage: string = "";
  public lastPage: string = "";


}