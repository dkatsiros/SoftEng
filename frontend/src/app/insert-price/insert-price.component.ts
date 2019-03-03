import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { AlertService } from '../services/alert.service';
import {ApiProductsService} from '../api-products.service' ;
import {AuthenticationService} from '../services/authentication.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-insert-price',
  templateUrl: './insert-price.component.html',
  styleUrls: ['./insert-price.component.css']
})
export class InsertPriceComponent implements OnInit {
  insertForm: FormGroup;
  loading = false;
  submitted = false;
  
  constructor(private formBuilder: FormBuilder, private router: Router,
    private authenticationService: AuthenticationService,
    private productService: ApiProductsService,
    private alertService: AlertService) {}

  ngOnInit() {
    this.insertForm = this.formBuilder.group({
      price:['',[Validators.required]],
      dateFrom:[],
      dateTo:[],
      productId:['',[Validators.required]],
      shopId:['',[Validators.required]],
    })
  }
   // convenience getter for easy access to form fields
  get f() { return this.insertForm.controls; }

  onSubmit(){

    this.submitted = true;
    if (this.insertForm.valid){
      this.loading = true;
      this.productService.createProducts(this.insertForm.value)
      .pipe(first())
      .subscribe(
          data => {
              this.alertService.success('Product creation successful', true);
              this.router.navigate(['/insert']);
          },
          error => {
              this.alertService.error(error);
              this.loading = false;
          });
    }
    else{
      alert('Product values Invalid');
    }

    console.log("Create Submited");
  }
}

  
