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
  {path: 'about', component: AboutComponent },
  {path: 'login', component: LoginComponent},
  {path: 'register',component: RegisterComponent}
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
