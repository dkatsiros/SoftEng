import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ContactFormComponent } from './contact-form/contact-form.component';
import { HttpClient } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

// our apis
import { MatButtonModule } from '@angular/material/button';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { PageComponent } from './page/page.component';
import { NavComponent } from './nav/nav.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { AppRoutingModule } from './app-routing.module';
import { MiddlePageComponent } from './middle-page/middle-page.component';
import { FooterComponent } from './footer/footer.component';
import { RegisterComponent } from './register/register.component';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './search/search.component';
import { ProductsSearchComponent } from './products-search/products-search.component';
import { ShopsSearchComponent } from './shops-search/shops-search.component';
import { JwtModule } from '@auth0/angular-jwt';

import { InsertComponent } from './insert/insert.component';
import { InsertProductComponent } from './insert-product/insert-product.component';
import { InsertShopComponent } from './insert-shop/insert-shop.component';

import { PricesSearchComponent } from './prices-search/prices-search.component';
import { AlertComponent } from './alert/alert.component';
import { InsertPriceComponent } from './insert-price/insert-price.component';
import { getToken } from '@angular/router/src/utils/preactivation';


@NgModule({
  declarations: [
    AppComponent,
    ContactFormComponent,
    PageComponent,
    NavComponent,
    HomeComponent,
    AboutComponent,
    LoginComponent,
    MiddlePageComponent,
    FooterComponent,
    RegisterComponent,
    SearchComponent,
    ProductsSearchComponent,
    ShopsSearchComponent,
    InsertComponent,
    InsertProductComponent,
    InsertShopComponent,
    
    PricesSearchComponent,

    AlertComponent,

    InsertPriceComponent,


  ],
  imports: [
    BrowserModule,
    MatButtonModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: function  tokenGetter() {
             return     localStorage.getItem('access_token');},
        whitelistedDomains: ['localhost:8765'],
        blacklistedRoutes: ['https://localhost:8765/observatory/api/login']
      }
    })

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
