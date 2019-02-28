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
    
  ],
  imports: [
    BrowserModule,
    MatButtonModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
