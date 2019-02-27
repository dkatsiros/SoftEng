import { Component } from '@angular/core';
import { ApiProductsService } from './api-products.service';
import { Products } from './products';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  
  title = 'frontend';
  constructor(private apiproductsService: ApiProductsService) {}

  ngOnInit(){
    this.apiproductsService.getProducts().subscribe((res)=>{
        console.log(res.values);
      }); 
      
    }
    


}
