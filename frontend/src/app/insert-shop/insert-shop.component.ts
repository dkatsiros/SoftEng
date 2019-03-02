import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { AlertService } from '../services/alert.service';
import {UserService} from '../services/user.service' ;
import {AuthenticationService} from '../services/authentication.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiShopsService } from '../api-shops.service';




@Component({
  selector: 'app-insert-shop',
  templateUrl: './insert-shop.component.html',
  styleUrls: ['./insert-shop.component.css']
})
export class InsertShopComponent implements OnInit {
  insertForm: FormGroup;
  loading = false;
  submitted = false;
  
  constructor(private formBuilder: FormBuilder, private router: Router,
    private authenticationService: AuthenticationService,
    private shopService: ApiShopsService,
    private alertService: AlertService) 
    {} 
     



  ngOnInit() {

    this.insertForm = this.formBuilder.group({
      name:['',[Validators.required]],
      address:['',[Validators.required]],
      lng:['',[Validators.required]],
      lat:['',[Validators.required]],
      tags:['',[Validators.required]]

    })
  }
   // convenience getter for easy access to form fields
  get f() { return this.insertForm.controls; }

  onSubmit(){

    this.submitted = true;
    if (this.insertForm.valid){
      this.loading = true;
      this.shopService.createShops(this.insertForm.value)
      .pipe(first())
      .subscribe(
          data => {
              this.alertService.success('Shop insertion successful', true);
              this.router.navigate(['/insert']);
          },
          error => {
              this.alertService.error(error);
              this.loading = false;
          });
    }
    else{
      alert('Insert Shop Invalid');
    }

    console.log("Submited");
  }

}
