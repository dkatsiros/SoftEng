import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { AlertService } from '../services/alert.service';
import {UserService} from '../services/user.service' ;
import {AuthenticationService} from '../services/authentication.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';




@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  loading = false;
  submitted = false;
  
  constructor(private formBuilder: FormBuilder, private router: Router,
    private authenticationService: AuthenticationService,
    private userService: UserService,
    private alertService: AlertService) 
    { 
      // redirect to home if already logged in
      if (this.authenticationService.currentUserValue) { 
          this.router.navigate(['/']);
      }
  }



  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      username:['',[Validators.required]],
      name:['',[Validators.required]],
      email:['',[Validators.required]],
      password:['',[Validators.required]]

    })
  }
   // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit(){

    this.submitted = true;
    if (this.registerForm.valid){
      this.loading = true;
      console.log(this.f.name);
      this.userService.register(this.registerForm.value)
      .pipe(first())
      .subscribe(
          data => {
              this.alertService.success('Registration successful', true);
              this.router.navigate(['/login']);
          },
          error => {
              this.alertService.error(error);
              this.loading = false;
          });
    }
    else{
      alert('User form Invalid');
    }

    console.log("Submited");
  }

}
