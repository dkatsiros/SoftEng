import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Products } from './products';


@Injectable({
  providedIn: 'root'
})
export class ApiProductsService {
  
  apiURL: string = 'https://localhost:8765/observatory/api/';
  
  constructor(private httpClient: HttpClient) {};
  
  public createProducts(product: Products){
    return this.httpClient.post(`${this.apiURL}products/`,product);

  };
  public updateProducts(product: Products){
    return this.httpClient.put(`${this.apiURL}products/${product.id}`,product);

  };

public patchProdcuts(product: Products){ // ELEGXOS TO PATCH PREPEI NA STELNOUME ENA MONO PEDIO  
    return this.httpClient.patch(`${this.apiURL}products/${product.id}`,product);

  };

  public deleteProducts(id: number){
    return this.httpClient.delete(`${this.apiURL}products/${id}`);

  };
  public getProductsById(id: number){
    return this.httpClient.get(`${this.apiURL}/products/${id}`);

  };

  public getProducts(url?: string){
    return this.httpClient.get<Products[]>(`${this.apiURL}products?start=0&count=20`);

  };

  public firstPage: string = "";
  public prevPage: string = "";
  public nextPage: string = "";
  public lastPage: string = "";


}