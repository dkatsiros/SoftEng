import { BrowserModule } from '@angular/platform-browser';
import { PageComponent } from './page/page.component';
import { AboutComponent } from './about/about.component';
import { HomeComponent } from './home/home.component';
import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule} from '@angular/router'
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';
import { ProductsSearchComponent } from './products-search/products-search.component';
import { ShopsSearchComponent } from './shops-search/shops-search.component';
import {PricesSearchComponent}  from './prices-search/prices-search.component';
import { InsertComponent } from './insert/insert.component';
import {InsertPriceComponent} from './insert-price/insert-price.component';
import {InsertProductComponent} from './insert-product/insert-product.component';
import {InsertShopComponent}  from './insert-shop/insert-shop.component';
import {MapComponent} from './map/map.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {
    path: 'search', component: SearchComponent,
    children:[
      {path: 'product-search', component: ProductsSearchComponent },
      {path: 'shops-search', component: ShopsSearchComponent},
      {path: 'prices-search', component: PricesSearchComponent}
    ]
  },
  {
    
    path: 'insert' , component : InsertComponent,
    children:[
      {path: 'insert-price',component: InsertPriceComponent},
      {path: 'insert-product',component: InsertProductComponent},
      {path: 'insert-shop',component: InsertShopComponent}
    ]
  },
  {path: 'about', component: AboutComponent },
  {path: 'login', component: LoginComponent},
  {path: 'register',component: RegisterComponent},
  {path: 'map',component: MapComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
